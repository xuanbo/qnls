package com.lmbj.web.controller;

import com.lmbj.web.entity.Dream;
import com.lmbj.web.entity.DreamComment;
import com.lmbj.web.entity.DreamCommentReply;
import com.lmbj.web.entity.User;
import com.lmbj.web.service.DreamCommentReplyService;
import com.lmbj.web.service.DreamCommentService;
import com.lmbj.web.service.DreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xuanbo
 * @version 1.0
 * @date 2016/4/10 15:10
 */
@Controller
@RequestMapping("/dream")
@PreAuthorize("hasAuthority('USER')")
public class DreamController {

    @Autowired
    private DreamService dreamService;

    @Autowired
    private DreamCommentService dreamCommentService;

    @Autowired
    private DreamCommentReplyService dreamCommentReplyService;

    /**
     * 梦想list
     *
     * @param pageNumber
     * @param pageSize
     * @param map
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(
            @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            ModelMap map
    ) {
        Page<Dream> page = dreamService.findByPageSortByIdDesc(pageNumber, pageSize);

        int current = page.getNumber() + 1;
        int totalPages = page.getTotalPages();

        map.addAttribute("page", page);
        map.addAttribute("current", current);
        map.addAttribute("totalPages", totalPages);
        map.addAttribute("size", pageSize);
        return "dream/list";
    }

    /**
     * 根据id查看某个dream的dreamComment
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public String dreamComment(
            @PathVariable Integer id,
            @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(required = false, defaultValue = "2") Integer pageSize,
            ModelMap map) {
        Page<DreamComment> page = dreamCommentService.findByDreamId(id, pageNumber, pageSize);
        if (page.getContent() == null || page.getContent().size() == 0){
            map.put("Data", null);
            return "dream/dream";
        }

        /*
            将每一个梦想评论和它的前五条回复封装成一个map
         */
        List<Map<String, Object>> list = new ArrayList<>();
        for (DreamComment dc : page.getContent()) {
            Map<String, Object> commentAndReply = new HashMap<>();
            commentAndReply.put("COMMENT", dc);
            Page<DreamCommentReply> replys = dreamCommentReplyService.findAllByParentDreamCommentId(dc.getId(), 1, 5);
            if (replys.getContent() == null || replys.getContent().size() == 0) {
                commentAndReply.put("REPLY", null);
                list.add(commentAndReply);
                continue;
            }
            commentAndReply.put("REPLY", replys.getContent());
            list.add(commentAndReply);
        }
        map.put("Data", list);

        /*
            分页信息
         */
        int current = page.getNumber() + 1;
        int totalPages = page.getTotalPages();
        map.addAttribute("current", current);
        map.addAttribute("totalPages", totalPages);
        map.addAttribute("size", pageSize);

        return "dream/dream";
    }


    /**
     * 新增Dream
     *
     * @param dream
     * @param session
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addDream(@RequestBody Dream dream, HttpSession session) {
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            return false;
        }
        Dream d = new Dream();
        d.setUsername(user.getName());
        d.setTitle(dream.getTitle());
        d.setContent(dream.getContent());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        d.setTime(sf.format(new Date()));

        dreamService.save(d);

        return true;
    }

    /**
     * 新增DreamComment
     *
     * @param id
     * @param dreamComment
     * @param session
     * @return
     */
    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    @ResponseBody
    public boolean addDreamComment(@PathVariable Integer id, @RequestBody DreamComment dreamComment, HttpSession session) {
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            return false;
        }
        DreamComment dc = new DreamComment();
        dc.setUsername(user.getName());
        dc.setDreamId(id);
        dc.setComment(dreamComment.getComment());
        dc.setReplyCount(0);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dc.setCommentTime(sf.format(new Date()));

        dreamCommentService.save(dc);
        return true;
    }


    /**
     * 新增DreamCommentReply
     *
     * @param dreamId
     * @param commentId
     * @param dreamCommentReply
     * @param session
     * @return
     */
    @RequestMapping(value = "/{dreamId}/comment/{commentId}/reply", method = RequestMethod.POST)
    @ResponseBody
    public boolean addDreamCommentReply(
            @PathVariable Integer dreamId, @PathVariable Integer commentId,
            @RequestBody DreamCommentReply dreamCommentReply, HttpSession session) {
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            return false;
        }
        DreamCommentReply dcr = new DreamCommentReply();
        dcr.setUsername(user.getName());
        dcr.setReplyUsername(dreamCommentReply.getReplyUsername());
        dcr.setParentDreamCommentId(commentId);
        dcr.setReplyContent(dreamCommentReply.getReplyContent());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dcr.setReplyTime(sf.format(new Date()));

        dreamCommentReplyService.save(dcr);
        return true;
    }


    /**
     * 查看某条Dream下面的某条DreamComment的回复
     *
     * @param commentId
     * @param pageNumber
     * @param pageSize
     * @param map
     * @return
     */
    @RequestMapping(value = "/{dreamId}/comment/{commentId}/replys", method = RequestMethod.GET)
    public String dreamCommentReplyList(@PathVariable Integer dreamId,
                                        @PathVariable Integer commentId,
                                        @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                        @RequestParam(required = false, defaultValue = "50") Integer pageSize,
                                        ModelMap map){
        Page<DreamCommentReply> page = dreamCommentReplyService.findAllByParentDreamCommentId(commentId, pageNumber, pageSize);
        map.addAttribute("page", page);
        /*
            分页信息
         */
        int current = page.getNumber() + 1;
        int totalPages = page.getTotalPages();
        map.addAttribute("current", current);
        map.addAttribute("totalPages", totalPages);
        map.addAttribute("size", pageSize);

        return "dream/reply";
    }
}
