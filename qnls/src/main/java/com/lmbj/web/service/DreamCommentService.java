package com.lmbj.web.service;

import com.lmbj.web.entity.DreamComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 19:17
 */
public interface DreamCommentService extends BaseService<DreamComment, Integer> {

    /**
     * 根据dreamId分页查询评论
     *
     * @param dreamId
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<DreamComment> findByDreamId(Integer dreamId, Integer pageNumber, Integer pageSize);

    int updateDreamCommentById(Integer id);
}
