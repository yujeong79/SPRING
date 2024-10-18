package com.ssafy.sb.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.sb.model.dto.Minkyu;
import com.ssafy.sb.model.service.MinkyuService;
import com.ssafy.sb.model.service.MinkyuServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MinkyuController extends HttpServlet {

	private MinkyuService service = MinkyuServiceImpl.getInstance();

	@GetMapping("/minsseam/updateform")
	private String doUpdateForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("minkyu", service.getMinkyu(id));
		return "minkyu/updateform";
	}
	
	@PostMapping("/minsseam/update")
	private String doUpdate(@ModelAttribute Minkyu minkyu) {
		service.changeMinkyu(minkyu);
		return "redirect:/minsseam/list";
	}

	@GetMapping("/minsseam/delete")
	private String doRemove(@RequestParam("id") int id) {
		service.removeMinkyu(id);
		return "redirect:/minsseam/list";
	}

	@GetMapping("/minsseam/detail")
	private String doDetail(@RequestParam("id") int id, Model model) {
		model.addAttribute("minkyu", service.getMinkyu(id));
		return "minkyu/detail";
	}

//	@RequestMapping(value = "/minsseam/list", method = RequestMethod.GET)
	@GetMapping("/minsseam/list")
	private String doList(Model model) {
		model.addAttribute("list", service.getMinkyuList());
		return "minkyu/list";
	}
	
	// ModelAndView 사용법
//	@GetMapping("/minsseam/list")
//	private ModelAndView doList(ModelAndView mav) {
//		mav.addObject("list", service.getMinkyuList()); // 데이터 셋팅
//		mav.setViewName("minkyu/list");
//		return mav;
//	}

	@GetMapping("/minsseam/registform")
	private String doRegistForm() {
		return "minkyu/registform";
	}
	
	@PostMapping("/minsseam/regist")
	private String doRegist(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		Minkyu minkyu = new Minkyu(name, email);
		service.registMinkyu(minkyu);
		
		return "redirect:/minsseam/list";
	}
	
}
