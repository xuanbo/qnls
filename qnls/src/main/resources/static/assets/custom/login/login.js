;(function($){
    $(function(){
        // login submit
        $('#login').on('click', function(){
            var username = $('#username').val();
            var password = $('#password').val();
            if (username == '' || password == ''){
                return;
            }else {
                // 表单提交
                $('#loginForm').submit();
            }
        });
    })
})(jQuery);