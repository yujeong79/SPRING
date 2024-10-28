package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {
	/** 스프링에서 파일이나 클래스 등 리소스를 로드할 때는 ResourceLoader 인터페이스를 이용해서 가져온다. */
	private ResourceLoader resourceLoader;
	
	@Autowired
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	/**
	 * model에 fileController에서 넘겨준 fileName이란 이름과 fileName 객체가 들어있다.
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileName = (String) model.get("fileName"); // 파일 이름 가져오기
		Resource resource = resourceLoader.getResource("classpath:/static/img"); // 가져오고자 하는 파일의 resource를 resource 객체로 가져오기
		File file = new File(resource.getFile(), fileName); // 가져와서 원하는 리소스에 이름은 fileName으로 파일을 생성했어
		
		// 사전 준비 끝 ///////////////////////////////////////////////////////////////////
	
		/** 한글이 깨질 수 있어서 더 안전하게 인코딩하는 과정*/
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";"); // 다운로드를 받기 위한 약속..
		response.setHeader("Content-Transfer-Encoding", "binary"); // 바이너리 객체라고 응답 객체에게 알려줌
	
		// 응답 헤더 설정 끝 ////////////////////////////////////////////////////////////////////////////
	
		// 파일을 읽어오는 통로를 뚫어서 읽어오겠다!
		try(FileInputStream fis = new FileInputStream(file); OutputStream os = response.getOutputStream();) {
			// 결국 response로 보여줄거니까 response가 가지고 있는 OutputStream을 가져와
			FileCopyUtils.copy(fis, os);
		}
	}

}
