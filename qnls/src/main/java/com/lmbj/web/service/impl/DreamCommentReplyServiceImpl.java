package com.lmbj.web.service.impl;

import com.lmbj.web.dao.DreamCommentReplyRepository;
import com.lmbj.web.entity.DreamCommentReply;
import com.lmbj.web.service.DreamCommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 22:05
 */
@Service("dreamCommentReplyService")
public class DreamCommentReplyServiceImpl extends BaseServiceImpl<DreamCommentReply, Integer> implements DreamCommentReplyService {

    @Autowired
    private DreamCommentReplyRepository dreamCommentReplyRepository;

    @Override
    public Page<DreamCommentReply> findAllByParentDreamCommentId(Integer parentDreamCommentId, int pageNumber, int pageSize) {
        Specification<DreamCommentReply> specification = new Specification<DreamCommentReply>() {
            @Override
            public Predicate toPredicate(Root<DreamCommentReply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> $parentDreamCommentId = root.get("parentDreamCommentId");
                Predicate _parentDreamCommentId = cb.equal($parentDreamCommentId, parentDreamCommentId);
                return cb.and(_parentDreamCommentId);
            }
        };
        PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        return dreamCommentReplyRepository.findAll(specification, pageRequest);
    }
}
