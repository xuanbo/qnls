package com.lmbj.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/10.
 */
public interface BaseService<T, ID extends Serializable> {

    void save(T t);

    /**
     * 根据id查询
     */
    T findOne(ID id);

    /**
     * 根据id升序分页查询
     */
    Page<T> findByPageSortByIdASC(int pageNumber, int pageSize);

    /**
     * 根据PageRequest分页查询
     *
     * @param pageRequest
     * @return
     */
    Page<T> findByPage(PageRequest pageRequest);

}
