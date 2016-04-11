package com.lmbj.web.service.impl;

import com.lmbj.web.dao.DreamCommentRepository;
import com.lmbj.web.entity.DreamComment;
import com.lmbj.web.service.DreamCommentService;
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
 * @date 2016/4/10 19:18
 */
@Service("dreamCommentService")
public class DreamCommentServiceImpl extends BaseServiceImpl<DreamComment, Integer> implements DreamCommentService {

    @Autowired
    private DreamCommentRepository dreamCommentRepository;

    @Override
    public Page<DreamComment> findByDreamId(Integer dreamId, Integer pageNumber, Integer pageSize) {
        Specification<DreamComment> specification = new Specification<DreamComment>() {
            @Override
            public Predicate toPredicate(Root<DreamComment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Integer> $dreamId = root.get("dreamId");
                Predicate _dreamId = cb.equal($dreamId, dreamId);
                return cb.and(_dreamId);
            }
        };
        PageRequest pageRequest = new PageRequest(pageNumber -1, pageSize, Sort.Direction.ASC, "id");
        return dreamCommentRepository.findAll(specification, pageRequest);
    }
}
