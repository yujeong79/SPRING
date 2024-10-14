package com.ssafy.ws.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String name; // 학생의 이름
    private String state; // 학생의 출결 상태 "입실", "퇴실", "확인불가"
    private LocalDateTime updated; // 학생의 최근 업데이트 일자

    public Student(String name) {
        this.name = name;
        this.state = "확인불가";
        this.updated = LocalDateTime.now();
    }

    // getter
    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUpdated(LocalDateTime date) {
        this.updated = date;
    }

    // 학생의 입실을 처리하는 메소드 enter
    public void enter() {
        this.setState("입실");
    }

    // 학생의 퇴실을 처리하는 메소드 leave
    public void leave() {
        this.setState("퇴실");
    }

    // toString
    @Override
    public String toString() {
        return "Student [name=" + name + ", state=" + state + ", updated=" + updated + "]";
    }
}
