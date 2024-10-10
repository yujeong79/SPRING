package com.ssafy.sw;

import org.springframework.stereotype.Component;

@Component
public class Player {
    private int attackPower;

    public Player() {
        this.attackPower = 10;
    }

    public Player(int power) {
        this.attackPower = power;
    }

    public void attack(Monster monster) {
        monster.takeDamage(attackPower);
        System.out.println("플레이어가 몬스터를 " + getAttackPower() + " 파워로 공격했습니다.");
    }

    public int getAttackPower() {
        return this.attackPower;
    }
}