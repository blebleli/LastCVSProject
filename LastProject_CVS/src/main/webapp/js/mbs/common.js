$(function(){
	var $menuTimer;
	//$('.gnb_bg').toggle();
	$('#gnb ul > li[class*=gnb] > a').bind('mouseover focus', function(){
		//$('.gnb_bg').show();
		$('#gnb li > ul').fadeIn(200);
		$('.gnb_bg').fadeIn(200);
		$('.gnb_bg p').fadeIn(200);
		
		$('#head').css('background-color','#fff');
		clearTimeout($menuTimer);
	});
	$('#gnb li ul').bind('mouseover focus',function(){ 
		$('li[class*=gnb] a').removeClass('on');
		$(this).parent().find('>a').addClass('on');
		clearTimeout($menuTimer);
	});
	$('#gnb li ul').bind('mouseout focusout',function(){
		$('li[class*=gnb] a').removeClass('on');
		$menuTimer = setTimeout(timerSet,100);
	});
	$('#gnb li ul a').bind('mouseover focus',function(){
		clearTimeout($menuTimer);
	});
	
	$('#gnb ul li[class*=gnb] > a').bind('mouseout focusout',function(){
		$menuTimer = setTimeout(timerSet,100);
	});
	function timerSet(){
		$('li[class*=gnb] a').removeClass('on');
		$('#gnb li > ul').fadeOut(200);
		$('.gnb_bg p').fadeOut(200);
		$('.gnb_bg').fadeOut(200);
		$('#head').css('background-color','transparent');
		//clearTimeout($menuTimer);
	}
});