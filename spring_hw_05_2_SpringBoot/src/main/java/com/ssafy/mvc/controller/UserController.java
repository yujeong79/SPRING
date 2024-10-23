package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.dto.User;

@Controller
public class UserController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping({"/", "index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist_form";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		// 파일이 등록됐는지 확인하자.
		if(file != null && file.getSize() > 0) {
			user.setOrgImg(file.getOriginalFilename());
			user.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			
			Resource resource = resourceLoader.getResource("/resource/img");
			
			file.transferTo(new File(resource.getFile(), user.getImg()));
		}
		
		model.addAttribute("user", user);
		return "regist_result";
	}
	
}
