;(function ($) {

    $(function () {

        //获取分页的参数
        var page = $('#page');
        var currentPage = page.data("current");
        var numberOfPages = page.data("pagesize");
        var totalPages = page.data("totalpages");

        var options = {
            currentPage: currentPage,
            totalPages: totalPages,
            numberOfPages: numberOfPages,

            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "尾页";
                    case "page":
                        return page;
                }
            },

            pageUrl: function (type, page, current) {
                return "comments?pageNumber=" + page;
            }
        };
        page.bootstrapPaginator(options);


        // 点击评论按钮
        $('#addDreamComment').on('click', function () {
            var comment = $('#dreamCommentInput').val();
            if (comment == '' || comment.length > 140) {
                $('#dreamCommentInput').css({
                    'border': "2px solid #ff0000"
                });
                return false;
            }
            else {
                $('#dreamCommentInput').css({
                    'border': "1px solid #20B2AA"
                });

                var data = {
                    comment: comment
                }
                data = JSON.stringify(data);
                $.ajax({
                    type: "POST",
                    contentType: "application/json",//必须有
                    dataType: "json",//返回值，不必须
                    url: "comment",
                    data: data,
                    success: function (msg) {
                        if (msg) {
                            var m = "提交成功了哦！";
                            $('#warn-info').empty().html(m);
                            // 显示modal
                            $('#warnModal').modal({backdrop: 'static', keyboard: false});
                        } else {
                            var m = "提交失败啦！你还没有登录呢";
                            $('#warn-info').empty().html(m);
                            $('#warn-content').css({
                                'background-color': "#ffffff"
                            });
                            $('#warn-info').css({
                                'color': "#ff0000"
                            });
                            // 显示modal
                            $('#warnModal').modal({backdrop: 'static', keyboard: false});
                        }
                    },
                    error: function () {
                        var m = "不知道为什么提交失败了呢";
                        $('#warn-info').empty().html(m);
                        $('#warn-content').css({
                            'background-color': "#ffffff"
                        });
                        $('#warn-info').css({
                            'color': "#ff0000"
                        });
                        // 显示modal
                        $('#warnModal').modal({backdrop: 'static', keyboard: false});
                    }
                });
            }
        });

        $('#warnModal .close').on('click', function () {
            window.location.reload(true);
        });


        var replyUsername;
        var parentDreamCommentId;

        // 点击回复某一条评论
        $('.replyThisComment').on('click', function () {
            // 弹出回复评论的modal
            $('#addReplyModal').modal({backdrop: 'static', keyboard: false});
            // 获取回复的用户以及是在那条评论下的
            replyUsername = $(this).data('username');
            parentDreamCommentId = $(this).data('dreamcommentid');
        });
        // 点击回复modal提交按钮
        $('#addReplySubmit').on('click', function () {
            var replyContent = $('#reply_content').val();
            if (replyContent == "" || replyContent.length > 140) {
                $('#reply_content').css({
                    'border': "2px solid #ff0000"
                });
                return false;
            } else {
                $('#reply_content').css({
                    'border': "1px solid #ccc"
                });
                var data = {
                    replyUsername: replyUsername,
                    replyContent: replyContent
                }
                data = JSON.stringify(data);
                var url = "comment/" + parentDreamCommentId + "/reply";
                $.ajax({
                    type: "POST",
                    contentType: "application/json",//必须有
                    dataType: "json",//返回值，不必须
                    url: url,
                    data: data,
                    success: function (msg) {
                        if (msg) {
                            $('#resetReplySubmit').click();

                            var m = "回复成功了哦！";
                            $('#warn-info').empty().html(m);
                            // 显示modal
                            $('#warnModal').modal({backdrop: 'static', keyboard: false});
                        } else {
                            $('#resetReplySubmit').click();

                            var m = "回复失败啦！你还没有登录呢";
                            $('#warn-info').empty().html(m);
                            $('#warn-content').css({
                                'background-color': "#ffffff"
                            });
                            $('#warn-info').css({
                                'color': "#ff0000"
                            });
                            // 显示modal
                            $('#warnModal').modal({backdrop: 'static', keyboard: false});
                        }
                    },
                    error: function () {
                        $('#resetReplySubmit').click();

                        var m = "不知道为什么回复失败了呢";
                        $('#warn-info').empty().html(m);
                        $('#warn-content').css({
                            'background-color': "#ffffff"
                        });
                        $('#warn-info').css({
                            'color': "#ff0000"
                        });
                        // 显示modal
                        $('#warnModal').modal({backdrop: 'static', keyboard: false});
                    }
                });
            }
        });
        // 点击回复modal取消按钮后清空modal
        $('#resetReplySubmit').on('click', function () {
            $('#reply_content').css({
                'border': "1px solid #ccc"
            });
            $('#reply_content').val("");
        });



        // 回复评论下面的回复
        $('.replyThisReply').on('click', function(){
            // 获取回复某一条回复的用户以及是在哪一条评论下的
            replyUsername = $(this).data('username');
            parentDreamCommentId = $(this).data('dreamcommentid');
            alert(replyUsername+parentDreamCommentId)
            // 弹出回复评论的modal
            $('#addReplyModal').modal({backdrop: 'static', keyboard: false});

        });

    });

})(jQuery);
