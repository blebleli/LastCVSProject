(function($)
{
    $.fn.calendar = function( toObj )
    {
    	var opts = {
    		id : {from:null, to:null},
    		flag : "-"
    	}    	

    	var funcDate = {    			

    		// 날짜포맷에 맞는지 검사
			// 비스킷 대단해~~~~~
    		isDateFormat : function( d ) {
    			var df;
    			if( opts.flag == "-" ) {
    				df = /[0-9]{4}-[0-9]{2}-[0-9]{2}/;
    			} else if( opts.flag == "." ) {
    				df = /[0-9]{4}.[0-9]{2}.[0-9]{2}/;
    			}
			    return d.match(df);
			},

			// 윤년여부 검사
			isLeaf : function( year )
			{
			    var leaf = false;
			    if(year % 4 == 0) {
			        leaf = true;
			        if(year % 100 == 0) leaf = false;
			        if(year % 400 == 0) leaf = true;
			    }

			    return leaf;
			},

			// 날짜가 유효한지 검사
			isValidDate : function(d)
			{
			    // 포맷에 안맞으면 false리턴
			    if( !funcDate.isDateFormat(d) ) return false;
			    var month_day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
			    var dateToken = d.split( opts.flag );
			    var year = Number(dateToken[0]);
			    var month = Number(dateToken[1]);
			    var day = Number(dateToken[2]);			    

			    // 날짜가 0이면 false
			    if(day == 0) return false;
			    var isValid = false;

			    // 윤년일때
			    if( funcDate.isLeaf( year ) ) {
			        if(month == 2) {
			            if(day <= month_day[month-1] + 1) isValid = true;
			        } else {
			            if(day <= month_day[month-1]) isValid = true;
			        }
			    } else {
			        if(day <= month_day[month-1]) isValid = true;
			    }

			    return isValid;
			}
    	}    	

    	var funcEvent = {   			

			change : function()
			{
				var $fromObj = opts.id.from;
				var $toObj = opts.id.to;
				
				if( $fromObj ) {
					if( $fromObj.val().length >= 8 ) {
						if( funcDate.isValidDate( $fromObj.val() ) ) {
							if( $toObj ) {
								$toObj.datepicker('option', 'minDate', $fromObj.val());
							}
						} else {
							alert("존재하지 않는 날짜입니다.");
							$fromObj.val("");
							$fromObj.focus();
							return;
						}
					}
				}				

				if( $toObj ) {
					if( $toObj.val().length >= 8 ) {
						if( funcDate.isValidDate( $toObj.val() ) ) {
							if( $fromObj ) {
								$fromObj.datepicker('option', 'maxDate', $toObj.val());
							}
						} else {
							alert("존재하지 않는 날짜입니다.");
							$toObj.val("");
							$toObj.focus();
							return;
						}
					}
				}
			}
    	}     	

    	var setCalendar = function( fromObj )
    	{
    		opts.id.from = $(fromObj);
    		$(fromObj).attr("maxlength", 10);
    		$(fromObj).change( funcEvent.change );    		

    		// from 달력 세팅
    		$(fromObj).datepicker({
        	    showOn: "both",
        	    buttonImage: contextPath + "/images/button/btn_calendar.png",
                dateFormat: "yy-mm-dd",
                changeMonth: true,
                changeYear: true,
                showButtonPanel: true,
                onSelect: function() {
                	funcEvent.change();
                }
            });    		

    		// to 달력 세팅
    		if( toObj )
    		{
        		opts.id.to = $(toObj);
        		$(toObj).attr("maxlength", 10);
        		$(toObj).change( funcEvent.change );    			

        		$(toObj).datepicker({
					showOn: "button",
					dateFormat: "yy-mm-dd",
					changeMonth: true,
					changeYear: true,
					showButtonPanel: true,
					onSelect: function() {
						funcEvent.change();
					}
				});
    		}
    	}    	

    	return this.each(function(){
    		setCalendar( this );
    	});
    }
})
(jQuery);