package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	// resource 경로를 가져오기 위해 ResourceLoader를 주입 받는다.
	@Autowired
	ResourceLoader resLoader;
	
	// 업로드 테스트 페이지로 이동
	@GetMapping("/")
	public String index() {
		return "redirect:/upload";
	}
	
	// 업로드 폼을 보여준다.
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload";
	}
	
	// Q. multipart 형식으로 form으로 부터 파일을 받아 저장하는 메소드를 완성하시오.
	@PostMapping("/upload")
	public String upload(@RequestParam(name="file1", required=true) MultipartFile file, Model model) throws IllegalStateException, IOException {
		if (file != null && file.getSize() > 0) {
			// 파일을 저장할 폴더 지정
			// 실제 경로 : 워크스페이스폴더\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\프로젝트명\\resources\\upload
			Resource res = resLoader.getResource("resources/upload");

			// 파일이 존재하면 파일을 저장한다. 파일명에 현재 시간을 붙여서 중복을 방지한다.
			String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			File target = new File(res.getFile().getPath(), filename);
			
			// 상위 폴더가 존재하지 않으면 생성
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
			}
			
			// 파일을 저장한다.
			file.transferTo(target);
			
			model.addAttribute("fileName", filename);
		}

		return "result";
	}
}
