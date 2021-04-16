package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.triangle;

import Bai6_Kethua_Inheritance_Dahinh_Abstraction.thucHanh.heHinhHoc.Shape;

public class Triangle extends Shape {
    double slide1=1,slide2=1,slide3=1;

    public Triangle() {
    }

    public Triangle(String color, Boolean filler, double slide1, double slide2, double slide3) {
        super(color, filler);
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
    }

    public double getSlide1() {
        return slide1;
    }

    public void setSlide1(double slide1) {
        this.slide1 = slide1;
    }

    public double getSlide2() {
        return slide2;
    }

    public void setSlide2(double slide2) {
        this.slide2 = slide2;
    }

    public double getSlide3() {
        return slide3;
    }

    public void setSlide3(double slide3) {
        this.slide3 = slide3;
    }

    public double getArea(){
        return this.slide1*this.slide2*this.slide3;
    }
    public double getPerimeter(){
        return this.slide1+this.slide2+this.slide3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "slide1=" + slide1 +
                ", slide2=" + slide2 +
                ", slide3=" + slide3 +", Area"+getArea()+
                ", Perimeter" +
                getPerimeter()+
                '}';
    }
}
