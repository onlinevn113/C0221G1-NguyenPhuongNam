package Bai6_Kethua_Inheritance_Dahinh_Abstraction.baiTap.Point2d_Point3d;

import javax.lang.model.element.NestingKind;
import java.util.Arrays;

public class Point3D extends Point2D {
   private float z;


    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D() {

    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
    }
    public float []getXYZ(){
        float[] a={ this.x,this.y,this.z};
        return a;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                "Arr"+Arrays.toString(getXYZ())
                +
                '}';
    }
}
