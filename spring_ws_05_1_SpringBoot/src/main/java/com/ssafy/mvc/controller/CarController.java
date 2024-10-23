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

import com.ssafy.mvc.dto.Car;

@Controller
public class CarController {
	
	// 스프링에서 파일이나 클래스 등 리소스를 로드할 때는 ResourceLoader 인터페이스를 이용해서 가져온다.
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "regist_form";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute Car car, @RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException {
		
		// 파일 가져오기
		if(file != null && file.getSize() > 0) { // 파일이 있으면
			car.setOrgImg(file.getOriginalFilename());
			// car의 img 필드에는 중복을 방지하기 위해 현재시간_파일명 형태로 저장하자.
			car.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			
			// 지정된 경로에 있는 리소스를 추상화된 Resource 객체로 저장
			Resource resource = resourceLoader.getResource("/resources/img");
			
			// 업로드된 파일을 서버의 특정 경로에 저장
			// resource.getFile()로 가져온 실제 디렉터리 안에 car의 img이라는 이름으로 파일을 저장
			file.transferTo(new File(resource.getFile(), car.getImg()));
		}
		
		model.addAttribute("car", car);
		
		return "regist_result";
	}
	
}
