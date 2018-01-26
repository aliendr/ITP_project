$(document).ready(function(){
	var hwindow = $(window).height();
	$("#topic").css({"margin-top":((hwindow / 2) - 67) + "px"}).animate({"margin-top":((hwindow / 2) - 127) + "px", "opacity":"1"}, 600);
	$("#main_button_box").css({"margin-top":((hwindow / 2) - 53) + "px"}).animate({"width":"335px"}, 600);
	$("#more_box").css({"margin-top":(hwindow - 86) + "px"});
	setInterval(function(){
		$("#more_box").animate({"background-position-y":"+=10px"}, 750).animate({"background-position-y":"-=10px"}, 750);
	}, 2000);
	$("#enter").click(function(){
		if($(this).text() == "Sign in"){
			$(this).css({"background-color":"white", "color":"black", "border":"none"}).text("Continue").animate({"margin-top":"+=82px"}, 200);
			$("#reg").css({"margin-top":"-=2px"});
			$("#enter_inputs_box").animate({"height":"82px"}, 200);
			$(".enter_inputs").css({"opacity":"1"});
		}
		if($("#reg").text() == "Continue"){
			$("#reg").css({"background-color":"none", "color":"white"}).text("Sign up").animate({"margin-top":"-=123px"}, 200);;
			$("#reg_inputs_box").animate({"height":"0px"}, 200);
			$(".reg_inputs").css({"opacity":"0"});
		}
		else{
			$("#reg").animate({"margin-top":"+=82px"}, 200);;
		}
	});
	$("#reg").click(function(){
		if($(this).text() == "Sign up"){
			$(this).css({"background-color":"white", "color":"black"}).text("Continue");
			$("#reg_inputs_box").animate({"height":"205px"}, 200);
			$(".reg_inputs").css({"opacity":"1"});
		}
		if($("#enter").text() == "Continue"){
			$("#enter").css({"background-color":"none", "color":"white", "border-bottom":"2px solid white"}).text("Sign in").animate({"margin-top":"-=82px"}, 200);;
			$("#enter_inputs_box").animate({"height":"0px"}, 200);
			$(".enter_inputs").css({"opacity":"0"});
			$("#reg").css({"margin-top":"+=2px"}).animate({"margin-top":"+=123px"}, 200);
		}
		else{
			$("#reg").animate({"margin-top":"+=205px"}, 200);
		}
	});
	$(".main_buttons").mouseenter(function(){
		if($(this).text() == "Continue")
			$(this).css({"background-color":"#e7e7e7"});
		else
			$(this).css({"background-color":"rgba(180, 180, 180, 0.4)"});
	});
	$(".main_buttons").mouseout(function(){
		if($(this).text() == "Continue")
			$(this).css({"background-color":"#ffffff"});
		else
			$(this).css({"background-color":"none"});
	});
});