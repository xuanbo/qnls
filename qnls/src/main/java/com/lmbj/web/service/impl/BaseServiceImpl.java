package com.lmbj.web.service.impl;

import com.lmbj.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 15:30
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> jpaRepository;
    @Override
    public void save(T t) {
        jpaRepository.save(t);
    }

    @Override
    public T findOne(ID id) {
        return jpaRepository.findOne(id);
    }

    @Override
    public Page<T> findByPageSortByIdASC(int pageNumber, int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        return jpaRepository.findAll(pageRequest);
    }

    @Override
    public Page<T> findByPage(PageRequest pageRequest) {
        return jpaRepository.findAll(pageRequest);
    }
}