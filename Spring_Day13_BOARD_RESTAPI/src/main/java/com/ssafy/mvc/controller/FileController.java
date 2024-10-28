package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

/**
 * RestController를 쓰는 순간 데이터만 넘기기로 한거니까
 * File Download를 위한 Controller를 새로 만들자.
 */
@Controller
public class FileController {
	
	@GetMapping("/download") // fileName이라고 하고 받아왔지만 실제 여기에 들어가야할 데이터는 이미지를 폴더에 저장한 이름인 fildId
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		model.addAttribute("fileName", fileName);
		return "fileDownloadView";
	}
}
