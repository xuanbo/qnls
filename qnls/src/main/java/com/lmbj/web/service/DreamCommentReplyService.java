package com.lmbj.web.service;

import com.lmbj.web.entity.DreamCommentReply;
import org.springframework.data.domain.Page;

/**
 * @author xuanbo
 * @Package com.lmbj.web.service
 * @Description
 * @date 2016/4/10.
 */
public interface DreamCommentReplyService extends BaseService<DreamCommentReply, Integer> {

    /**
     * 根据parentDreamCommentId分页获取评论回复
     * @param parentDreamCommentId
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<DreamCommentReply> findAllByParentDreamCommentId(Integer parentDreamCommentId, int pageNumber, int pageSize);
}
