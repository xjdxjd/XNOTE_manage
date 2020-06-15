layui.use(['upload','element'], function(){
	var $ = layui.jquery,
		upload = layui.upload,
		element = layui.element;
	
	var uploadInst = upload.render({
		elem: '#lic',
		url: '',
		accept: 'file',
		exts: 'lic',
		auto: true,
		multiple: false,
		number: 1,
		data: {
			id: function () {
				return $('#id').val();
			}
		},
		done: function (res, index, upload) {
			layer.msg('上传成功');
			console.log(res);
		},
		error: function (res) {
			
		}
	});
});