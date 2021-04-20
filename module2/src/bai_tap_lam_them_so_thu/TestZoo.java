package bai_tap_lam_them_so_thu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestZoo  {
    public static void main(String[] args) {
        Zoo zoo=new Zoo();
        Scanner scanner= new Scanner(System.in);
        int choose,roomNo;
        do {
            System.out.println("1. Thêm chuồng\n"+
                    "2. Xoá chuồng\n" +
                    "3. Thêm con vật\n" +
                    "4. Xoá con vật\n" +
                    "5. Xem tất cả các con vật\n" +
                    "6. Thoát\n"
            );
            choose = Integer.parseInt(scanner.nextLine());
            Room room=new Room();
            switch (choose){
                case 1:
                    room.input();
                    zoo.addRoom(room);
                    break;
                case 2:
                    System.out.println("Nhập mã chuồng");
                    roomNo=Integer.parseInt(scanner.nextLine());
                    zoo.removeRoom(roomNo);
                    break;
                case 3:
                    System.out.println("Nhập chuồng cần thêm động vật");
                    roomNo=Integer.parseInt(scanner.nextLine());
                    Animal animal=room.createAnimal();
                    zoo.addAnimal(roomNo,animal);
                    break;
                case 4:
                    System.out.println("Nhập mã chuồng cần xoá");
                    roomNo=Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên con vật cần xoá");
                    String name=scanner.nextLine();
                    zoo.removeAnimal(roomNo,name);
                    break;
                case 5:
                    zoo.display();
                    break;
                case 6:
                    System.out.println("Tạm biệt");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập sai mời nhập lại");
                    break;
            }
        }while (choose!=6);

    }
}
