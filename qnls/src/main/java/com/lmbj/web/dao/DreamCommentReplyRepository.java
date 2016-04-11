package com.lmbj.web.dao;

import com.lmbj.web.entity.DreamCommentReply;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author xuanbo
 * @Package com.lmbj.web.dao
 * @Description
 * @date 2016/4/10.
 */
public interface DreamCommentReplyRepository extends JpaRepository<DreamCommentReply, Integer>,
        JpaSpecificationExecutor<DreamCommentReply> {

    /**
     * 根据parentDreamCommentId获取所有的评论回复
     *
     * @param parentDreamCommentId
     * @return
     */
    List<DreamCommentReply> findAllByParentDreamCommentId(Integer parentDreamCommentId);
}
