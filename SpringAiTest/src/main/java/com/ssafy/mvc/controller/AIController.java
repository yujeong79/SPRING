package com.ssafy.mvc.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

	private final OpenAiChatModel openAiChatModel;
	
	// 자동으로 의존성 주입
	public AIController(OpenAiChatModel openAiChatModel) {
		this.openAiChatModel = openAiChatModel;
	}

	@GetMapping("/chatGPT")
	public ResponseEntity<String> chat(@RequestParam("message") String message) { // 인자로 메시지를 던지면 그걸 받아서 ChatGPT에 요청을 보냄
		System.out.println(message);
		
		String response = openAiChatModel.call(message); // message chatGPT 한테 보내서 받은 답을 가져오기
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
