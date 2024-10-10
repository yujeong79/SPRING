package com.ssafy.sw;

import org.springframework.stereotype.Component;

// 데일리 실습 1-A 예시를 그대로 가져오도록 합니다.
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
