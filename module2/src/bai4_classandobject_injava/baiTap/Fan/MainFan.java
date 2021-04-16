package Bai4_ClassandObject_InJava.baiTap.Fan;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1=new Fan(3,true,2,"Yellow");
        Fan fan2=new Fan(0,false,2.5,"Red");
        System.out.println("Fan1"+fan1.toString());
        System.out.println("Fan2"+fan2.toString());
    }

}
