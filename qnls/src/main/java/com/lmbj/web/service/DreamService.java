package com.lmbj.web.service;

import com.lmbj.web.entity.Dream;
import org.springframework.data.domain.Page;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/10.
 */
public interface DreamService extends BaseService<Dream, Integer> {

    /**
     * 根据id降序分页查询
     */
    Page<Dream> findByPageSortByIdDesc(int pageNumber, int pageSize);
}
