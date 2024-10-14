package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	/** "/" 이라는 요청이 GET이든 POST든 들어오면 아래의 메서드를 수행 */
	@RequestMapping("/") 
	public String index() {
		return "index"; // prefix + index.jsp 로 이동하게 됨
	}
	
	/** home 이라는 요청이 GET 방식으로 들어오면 */
	@RequestMapping(value="/home", method=RequestMethod.GET) 
	public ModelAndView homeHandle1() { // 기본적으로 Controller는 DispatcherServlet에게 ModelAndView를 반환
		ModelAndView mav = new ModelAndView(); // ModelAndView 객체는 Data를 담을 수 있는 Model 바구니와 View 이름을 담을 수 있는 View 바구니를 가진다. 
		
		// 데이터를 심어서 보내보자.
		mav.addObject("msg", "Welcome to Spring MVC (GET)"); // 데이터를 담음
		
		// view 이름을 결정 해야함 -> 포워딩한 것과 같음
		mav.setViewName("home"); // 이렇게 바구니에 담으면 View Resolver가 prefix + home.jsp로 이동
//		mav.setViewName("redirect:home"); // 이렇게 하면 redirect와 같음
		
		return mav;
	}
	
	/**
	 * 위 메서드와 아래 메서드는 똑같은 요청을 받지만 어떻게 요청을 받느냐에 따라서 서로 다르게 처리할 수 있다.
	 */
	
	/** home 이라는 요청이 POST 방식으로 들어오면 */
	@RequestMapping(value="/home", method=RequestMethod.POST) 
	public ModelAndView homeHandle2() { // 기본적으로 Controller는 DispatcherServlet에게 ModelAndView를 반환
		ModelAndView mav = new ModelAndView(); // ModelAndView 객체는 Data를 담을 수 있는 Model 바구니와 View 이름을 담을 수 있는 View 바구니를 가진다. 
		
		// 데이터를 심어서 보내보자.
		mav.addObject("msg", "Welcome to Spring MVC (POST)"); // 데이터를 담음
		
		// view 이름을 결정 해야함 -> 포워딩한 것과 같음
		mav.setViewName("home"); // 이렇게 바구니에 담으면 View Resolver가 prefix + home.jsp로 이동
		
		return mav;
	}
}
