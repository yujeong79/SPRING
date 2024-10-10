package com.ssafy.sw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // 스프링의 IoC 컨테이너를 가리키는 인터페이스 (스프링 컨테이너는 빈을 관리하는 컨테이너)
        // * AnnotationConfigApplicationContext : 자바 설정 클래스를 지정하여 컨테이너 초기화
        // Q1. Game 클래스를 통해 스프링 컨테이너 초기화 진행
        ApplicationContext context = new AnnotationConfigApplicationContext(Game.class);

        // Q2. Game 클래스 Bean을 가져와서 run 메소드 실행
        Game game = context.getBean(Game.class);
        game.run();
    }
}