package kr.or.ddit.admin.prod.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/event")
@Controller("eventController")
public class EventController {
	
	
	@RequestMapping("/view")
	public String eventView(Model model){
		
		
		return "eventList";
	}


}