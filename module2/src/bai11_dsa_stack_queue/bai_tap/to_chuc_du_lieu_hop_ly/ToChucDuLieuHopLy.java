package bai11_dsa_stack_queue.bai_tap.to_chuc_du_lieu_hop_ly;

import java.util.*;

public class ToChucDuLieuHopLy  {
    public static void main(String[] args) {
        List <QuanLyNhanSu> quanLyNhanSus=new ArrayList<>();
        quanLyNhanSus.add(new QuanLyNhanSu("Nguyễn","Nam","28/06/2000"));
        quanLyNhanSus.add(new QuanLyNhanSu("Nam","Nam","27/06/1999"));
        quanLyNhanSus.add(new QuanLyNhanSu("Phương","Nu","27/05/1999"));

        quanLyNhanSus.add(new QuanLyNhanSu("Duyên","Nu","10/02/2001"));


        Queue<QuanLyNhanSu> queueNam = new LinkedList<>();
        Queue<QuanLyNhanSu> queueNu = new LinkedList<>();

        while (!quanLyNhanSus.isEmpty()){
            QuanLyNhanSu i=quanLyNhanSus.remove(0);
            if (i.getGioiTinh().equals("Nam")){
                queueNam.add(i);
            }else if (i.getGioiTinh().equals("Nu")){
                queueNu.add(i);
            }
        }


        while (!queueNu.isEmpty()){
            quanLyNhanSus.add(queueNu.remove());
        }

        while (!queueNam.isEmpty()){
            quanLyNhanSus.add(queueNam.remove());
        }

        for (QuanLyNhanSu i : quanLyNhanSus){
            System.out.println(i+"\n");
        }

    }
}
