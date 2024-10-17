package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	/** 스프링에서 파일이나 클래스 등 리소스를 로드할 때는 ResourceLoader 인터페이스를 이용해서 가져온다. */
	@Autowired
	private ResourceLoader resourceLoader;
	
	@GetMapping("/singleFileForm")
	public String sigleFileForm() {
		return "singleFileForm";
	}
	
	/**
	 * 파일 사이즈는 application.properties에서 설정 가능
	 * @param file : 스프링에서 파일을 처리하기 위한 MultipartFile 인터페이스로 객체를 받음
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("/singleFileUpload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IllegalStateException, IOException { 
		
		/** 파일이 있는지 검사해보자 */
		if(file != null && file.getSize() > 0) {
			String fileName = file.getOriginalFilename();
			
			/** 코드로 /static/img 폴더를 가져와야한다. main에서부터 시작*/
			Resource resource = resourceLoader.getResource("classpath:/static/img");
			
			//  이 코드는 업로드된 파일(file)을 서버의 특정 경로에 저장(transferTo)하는 역할을 한다.
			file.transferTo(new File(resource.getFile(), fileName)); // resource.getFile()로 실제 디렉터리를 가져오고 그 안에 fileName이라는 이름으로 저장
			
			model.addAttribute("fileName", fileName);
		}
		
		return "result";
	}
	
	@GetMapping("/download")
	public String fileDownload(@RequestParam("fileName") String fileName, Model model) {
		/** 성공적으로 파일이 다운로드가 되면 페이지를 이동하는 것이 아니라 성공적으로 파일이 다운됐다고 알람만 뜬다. */
		model.addAttribute("fileName", fileName);
		
		/** 이러한 이름의 jsp가 없다면 이런 이름을 가진 Bean이 있나 찾는다. */
		/** FileDownloadView라는 클래스에 @Component가 붙어있기 때문에 빈으로 등록되어 있다.*/
		return "fileDownloadView";
	}
	
	@GetMapping("/multiFileForm")
	public String multiFileForm() {
		return "multiFileForm";
	}
	
	@PostMapping("/multiFileUpload")
	public String multiFileUpload(@RequestParam("files") MultipartFile[] files, Model model) throws IllegalStateException, IOException { 
		
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		
		return "result";
	}
}
