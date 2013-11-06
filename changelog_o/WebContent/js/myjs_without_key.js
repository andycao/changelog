$(document).ready(function(e) {
        $('#buttons_submit').click(function(){
    		$("form").submit();
    	});
        $("#buttons_cancel").click(function(){
        	$("form").reset;
        	history.go(-2);
    	});
});
function setDate(){
	var date=new Date();
	var result=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	document.getElementById("timelabel").innerHTML=result;
}
setInterval("setDate()", 50);