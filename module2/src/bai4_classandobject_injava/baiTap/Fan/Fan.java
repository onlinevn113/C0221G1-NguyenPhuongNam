package Bai4_ClassandObject_InJava.baiTap.Fan;

public class Fan {
    final int SLOW=1;
    final int MEDIUM=2;
    final int FAST=3;

    private int speed=1;

    private boolean on=false;

    private double radius = 5;
    private String color="blue";

    public int getSlow() {
        return SLOW;
    }

    public int getMedium() {
        return MEDIUM;
    }

    public int getFast() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public String toString(){
        String save="";
        if (this.on){
            save+=" Tốc độ "+this.speed+" Bán kính "+this.radius+" Màu "+this.color+" Fan is on ";
        }else{
            save+=" Bán kính "+this.radius+" Màu "+this.color+" Fan is off ";
        }return save;


    }
    
}
