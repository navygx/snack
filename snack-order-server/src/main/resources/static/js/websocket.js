function openWebSocket(usid){
	var socket;
	if(typeof(WebSocket)==undefined){
		alert("对不起，您的浏览器不支持WebSocket通信...");
		return;
	}
	
	socket=new WebSocket("ws://127.0.0.1:8888/Websocket/"+usid);
	
	socket.onopen=function(){
		console.info("Socket已连接...");
	}
	
	socket.onclose=function(){
		console.info("Socket已关闭...");
	}
	
	socket.error=function(){
		console.info("Socket服务器访问失败...");
	}
	
	socket.onmessage=function(msg){
		console.info(msg);
		if(msg.data=="101"){
			alert("对不起，您已经在其他地方登录，若非本人操作，请及时修改密码...");
			location.href="../loginout";
		}
		
	}
}