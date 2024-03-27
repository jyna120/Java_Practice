package com.jy.shape;

// 상속 실습문제2
public class Circle extends Shape {
    private int r;  // 반지름
    private Point center;   // 중심점

    public Circle() {}
    public Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }
    public void setR(int r) { this.r = r; }
    public int getR() { return this.r; }
    public void setCenter(Point center) { this.center = center; }
    public Point getCenter() { return this.center; }

    @Override
    public double getArea() {
        return Math.round(r * r * Math.PI * 100) / 100.0;
    }

    @Override
    public void draw() {
        System.out.println("중심점이 " + center + "이고, 반지름이 " + r + "인 원을 그린다.");
    }
}