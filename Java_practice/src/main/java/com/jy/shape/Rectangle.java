package com.jy.shape;

// 상속 실습문제2
public class Rectangle extends Shape{
    private Point[] points = new Point[4];  // has-a 포함관계
    private int width;
    private int height;

    public Rectangle() {}
    public Rectangle(Point[] points, int width, int height) {
        this.points = points;
        this.width = width;
        this.height = height;
    }
    public void setPoints(Point[] points) { this.points = points; }
    public Point[] getPoints() { return this.points; }
    public void setWidth(int width) { this.width = width; }
    public int getWidth() { return this.width; }
    public void setHeight(int height) { this.height = height; }
    public int getHeight() { return this.height; }

    public Rectangle(Point[] points) {
        this.points[0] = new Point(points[0].getX(), points[0].getY());
        this.points[1] = new Point(points[1].getX(), points[1].getY());
        this.points[2] = new Point(points[2].getX(), points[2].getY());
        this.points[3] = new Point(points[3].getX(), points[3].getY());
        this.width = points[1].getX() - points[0].getX();
        this.height = points[3].getY() - points[0].getY();
    }

    public Rectangle(Point leftTop, int width, int height) {
        this.points[0] = leftTop;
        this.points[1] = new Point(leftTop.getX()+width, leftTop.getY());
        this.points[2] = new Point(leftTop.getX()+width, leftTop.getY()+height);
        this.points[3] = new Point(leftTop.getX(), leftTop.getY()+height);
        this.width =width;
        this.height = height;
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        this.points[0] = leftTop;
        this.points[1] = new Point(rightBottom.getX(), leftTop.getY());
        this.points[2] = rightBottom;
        this.points[3] = new Point(leftTop.getX(), rightBottom.getY());
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();
    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이 " + points[0] + ", " + points[1] + ", " + points[2] + ", " + points[3] + "이고, 너비가 " + width + ", 높이가 " + height + "인 사각형을 그린다.");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}