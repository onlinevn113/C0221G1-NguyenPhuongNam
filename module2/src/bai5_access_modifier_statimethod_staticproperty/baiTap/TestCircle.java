package Bai5_Access_modifier_statimethod_staticproperty.baiTap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class TestCircle {
    static Circle circle1 = new Circle(5);
    static Circle circle2 = new Circle(7);

    public static void main(String[] args) {
        System.out.println("Diện tích là "+circle1.getArea());
        System.out.println("Diện tích là "+circle2.getArea());
    }
}
