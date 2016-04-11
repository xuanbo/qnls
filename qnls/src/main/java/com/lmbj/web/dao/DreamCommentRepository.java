package com.lmbj.web.dao;

import com.lmbj.web.entity.DreamComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 19:15
 */
public interface DreamCommentRepository extends JpaRepository<DreamComment, Integer>, JpaSpecificationExecutor<DreamComment> {

    /**
     * 根据dreamId获取所有的评论
     *
     * @param dreamId
     * @return
     */
    List<DreamComment> findByDreamId(Integer dreamId);

}
