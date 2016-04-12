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
                return "http://localhost:8080/dream/list?pageNumber=" + page;
            }
        };

        page.bootstrapPaginator(options);


        // 发帖click
        $('#addDream').on('click', function () {
            // 显示modal
            $('#addDreamModal').modal({backdrop: 'static', keyboard: false});
        });
        $('#addSubmit').on('click', function(){
            var title = $('#dream_title').val();
            var content = $('#dream_content').val();
            if (title == '' || content == ''){
                if (title == ""){
                    dreamTitleWarn();
                }else {
                   dreamTitleReset();
                }
                if (content == ""){
                    dreamContentWarn()
                }else {
                    dreamConentReset();
                }
                return false;
            }else{
                dreamTitleReset();
                dreamConentReset();
                $('#error').empty();
                if (title.length > 20){
                    dreamTitleWarn();
                    $('#error').empty().html('输入的主题不能超过20个字哦！');
                    return false;
                }
                if (content.length > 140){
                    dreamContentWarn();
                    $('#error').empty().html('输入的内容不能超过140个字哦！');
                    return false;
                }
                // 提交数据
                var data = {
                    title: title,
                    content: content
                }
                data = JSON.stringify(data);

                $('#resetAdd').hide();
                $('#addSubmit').hide();
                $('#error').empty().html('正在提交数据哦..').css({
                    'color': "#2fb289"
                });
                setTimeout(function(){
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",//必须有
                        dataType: "json",//返回值，不必须
                        url: "/dream/add",
                        data: data,
                        success: function(msg){
                            if(msg){
                                var m = "提交成功了哦！梦想还是要有的，万一实现了呢？";
                                $('#error').empty().html(m).css({
                                    'color': "#2fb289"
                                });
                            }else{
                                var m = "你还没有登录呢！我不知道你是谁哦";
                                $('#error').empty().html(m).css({
                                    'color': "#ff0000"
                                });
                            }
                            setTimeout(function(){
                                window.location.assign("/dream/list");
                            }, 2000);
                        },
                        error: function(){
                            var m = "不知道为什么上传失败了呢！";
                            $('#error').empty().html(m).css({
                                'color': "#ff0000"
                            });
                        }
                    });
                }, 1000);
            }
        });
        // 取消按钮点击清空modal框的数据
        $('#resetAdd').on('click',function(){
            $('#dream_title').val("");
            $('#dream_content').val("");
            $('#error').empty();
            $('#resetAdd').show();
            $('#addSubmit').show();
            dreamTitleReset();
            dreamConentReset();
        });

        var dreamTitleWarn = function(){
            $('#dream_title').css({
                'border': '2px solid red'
            });
        };
        var dreamTitleReset = function(){
            $('#dream_title').css({
                'border': '1px solid #ccc'
            });
        };

        var dreamContentWarn = function(){
            $('#dream_content').css({
                'border': '2px solid red'
            });
        };
        var dreamConentReset = function(){
            $('#dream_content').css({
                'border': '1px solid #ccc'
            });
        };

    });
})(jQuery);
