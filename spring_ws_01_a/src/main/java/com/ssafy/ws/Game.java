package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Q3. 해당 클래스를 스프링이 관리하는 빈으로 등록해주는 어노테이션을 작성하시오.
@Component
public class Game {
	
	// Q4. 스프링에 의해 자동으로 주입되는 어노테이션을 작성하시오.
    @Autowired
    private Monster monster;

    // Q4. 스프링에 의해 자동으로 주입되는 어노테이션을 작성하시오.
    @Autowired
    // Q5. 명시적으로 "heroA" 빈을 주입하는 어노테이션을 작성하시오.
    @Qualifier("heroA")
    private Player player;


    public void run() {
        System.out.println("게임을 시작합니다.");
        System.out.println("------------------------------------------");
        // 몬스터의 원래 체력 출력
        System.out.println("몬스터의 원래 체력: " + monster.getHealth() + " HP");
        // 플레이어가 몬스터를 공격
        player.attack(monster);
        System.out.println("------------------------------------------");
        System.out.println("몬스터의 바뀐 체력: " + monster.getHealth() + " HP");
    }

}
