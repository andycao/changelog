function show_confirm(addr){
	var r = confirm("确定删除吗？");
	if(r == true){
		window.location.href=addr;
	}
}