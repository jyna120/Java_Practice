package com.jy.member.model.vo;

// 포인트관리시스템 실습문제3
public abstract class Member implements Buyable {
    private String name;    // 이름
    private String grade;   // 등급
    private int point;  // 포인트

    public Member() {}
    public Member(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public abstract double getEjapoint();

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getGrade() { return this.grade; }
    public void setPoint(int point) { this.point = point; }
    public int getPoint() { return this.point; }
}
