package Bai6_Kethua_Inheritance_Dahinh_Abstraction.thucHanh.heHinhHoc;

public class Shape {
    String color;
    Boolean filler;

    public Shape() {
        this.color = "Green";
        this.filler = true;
    }
    public Shape(String color,Boolean filler){
        this.color=color;
        this.filler=filler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFiller() {
        return filler;
    }

    public void setFiller(Boolean filler) {
        this.filler = filler;
    }
    public String toString(){
        return "A Shape with color of "
                +getColor()
                +" and "+(isFiller() ? " filled " : " not filled ");
    }
}
//class ShapeTest {
//    public static void main(String[] args) {
//        Shape shape = new Shape();
//        System.out.println(shape);
//
//        shape = new Shape("red", false);
//        System.out.println(shape);
//    }
//}
