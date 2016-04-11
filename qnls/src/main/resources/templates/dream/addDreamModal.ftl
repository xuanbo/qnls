<#-- 填写Dream modal框 -->
<div>
    <div id="addDreamModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title">敢不敢写下你的梦想？</h2>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="dream_title" class="control-label">主题:</label>
                        <input type="text" class="form-control" id="dream_title" placeholder="输入主题：不超过20个字">
                    </div>
                    <div class="form-group">
                        <label for="dream_content" class="control-label">内容:</label>
                        <textarea class="form-control" id="dream_content" placeholder="请输入内容：不超过140个字"></textarea>
                    </div>

                    <div id="error">

                    </div>
                </div>
                <div class="modal-footer">
                    <button id="resetAdd" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="addSubmit" type="button" class="btn btn-primary">提交</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
