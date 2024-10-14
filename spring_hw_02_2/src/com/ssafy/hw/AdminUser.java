package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	@Override
	public void useApp() throws ApplicationException {
		System.out.println("애플리케이션을 관리합니다.");
		
		// 예외 발생 코드
		// 실습을 위해서 예외를 일부러 랜덤하게 발생시킨다.
		 if(new Random().nextBoolean()) {
		 	throw new ApplicationException();
		 }
	}

}
