package com.lmbj.web.service.impl;

import com.lmbj.web.entity.Dream;
import com.lmbj.web.service.DreamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 16:03
 */
@Service("dreamService")
public class DreamServiceImpl extends BaseServiceImpl<Dream, Integer> implements DreamService {

    @Override
    public Page<Dream> findByPageSortByIdDesc(int pageNumber, int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNumber -1, pageSize, Sort.Direction.DESC, "id");
        return super.findByPage(pageRequest);
    }
}
