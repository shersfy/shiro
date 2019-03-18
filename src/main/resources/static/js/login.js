$(function(){
	$("#loginform").form('clear');
	$("#password").textbox("textbox").bind('keydown', function(e){
		if (e.keyCode==13){
			$("#login").trigger("click");
		}
	});
});

var Login = {
	login: function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if ($.trim(username).length==0){
			$.messager.alert('提示', '用户名不能为空','error');
			return;
		}
		if ($.trim(password).length==0){
			$.messager.alert('提示', '密码不能为空','error');
			return;
		}
		$.ajax({ 
			url: basePath+"/user/login", 
			type: "POST", 
			data: {
				'username':username,
				'password':password
			}, 
			beforeSend: function () {
				//异步请求时spinner出现
				var target = $("#content").get(0);
				spinner.spin(target); 
			},
			success:function (data){
				if (data.code!=0){
					$.messager.alert('错误', data.msg,'error');
				}
				//关闭spinner
				spinner.spin();
				location.href = basePath;
			}, 
			error:function(error){
				$.messager.alert('错误', '登录错误','error');
				//关闭spinner
				spinner.spin();
			} 
		});
	}
}
