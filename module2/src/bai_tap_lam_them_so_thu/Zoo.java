package bai_tap_lam_them_so_thu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    List<Room> roomList = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    void addAnimal(int roomNo, Animal a) {
        for (Room room : roomList) {
            if (room.getRoomNo() == roomNo) {
                room.addAnimal(a);
            }
        }

    }


    void removeAnimal(int roomNo, String name) {
        for (Room room : roomList) {
            if (room.getRoomNo() == roomNo) {
                room.removeAnimal(name);
                return;
            }
        }
        System.out.println("Không tìm thấy chuồng");
    }

    void addRoom(Room r) {
        roomList.add(r);
    }

    void removeRoom(int roomNo) {
        for (Room room : roomList) {
            if (room.getRoomNo() == roomNo) {
                roomList.remove(room);
            }
        }
    }
    void display(){
        for (Room room : roomList) {
            room.display();
        }
    }




}
