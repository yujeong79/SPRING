package com.ssafy.ws;

import org.springframework.stereotype.Component;

// Q6. 해당 클래스를 스프링이 관리하는 빈으로 등록하되 이름을 "heroA"로 지정하는 어노테이션을 작성하시오.
@Component(value="heroA")
public class Player {
    private int attackPower;

    public Player() {
        this.attackPower = 10;
    }

    public void attack(Monster monster) {
        monster.takeDamage(attackPower);
        System.out.println("플레이어가 몬스터를 " + getAttackPower() + " 파워로 공격했습니다.");
    }

    public int getAttackPower() {
        return this.attackPower;
    }
}