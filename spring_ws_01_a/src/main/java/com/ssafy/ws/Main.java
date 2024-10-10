package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // 스프링의 IoC 컨테이너를 가리키는 인터페이스 (스프링 컨테이너는 빈을 관리하는 컨테이너)
        // * GenericXmlApplicationContext : XML 파일을 이용하여 스프링 컨테이너를 초기화하는 클래스
        // Q1. applicationContext.xml 파일을 이용하여 스프링 컨테이너를 초기화하는 코드를 작성하시오.
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        // Q2. Game 클래스 Bean을 가져와서 run 메소드 실행
        Game game = context.getBean(Game.class);
        game.run();
    }
}