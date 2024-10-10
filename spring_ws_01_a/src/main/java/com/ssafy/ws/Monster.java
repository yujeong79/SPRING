package com.ssafy.ws;

import org.springframework.stereotype.Component;

// Q3. 해당 클래스를 스프링이 관리하는 빈으로 등록해주는 어노테이션을 작성하시오.
@Component
public class Monster {
    private int health;

    public Monster() {
        this.health = 50;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return this.health;
    }
}
