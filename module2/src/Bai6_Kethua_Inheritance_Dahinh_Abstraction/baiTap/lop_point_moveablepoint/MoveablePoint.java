package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.lop_point_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

//    public MoveablePoint(float xSpeed, float ySpeed) {
//        this.xSpeed = xSpeed;
//        this.ySpeed = ySpeed;
//    }
////    public MoveablePoint(float x,float y,float xSpeed,float ySpeed)

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }


    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {

    }
    public float[] getSpeed(){
        float[] a={this.xSpeed,this.ySpeed};
        return a;
    }
    public Point move(){
        this.x+=this.xSpeed;
        this.y+=this.ySpeed;
        return this;
    }

//    @Override
//    public String toString() {
//        return "MoveablePoint{" +
//                "xSpeed=" + xSpeed +
//                ", ySpeed=" + ySpeed +
//                '}';
//    }


    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
