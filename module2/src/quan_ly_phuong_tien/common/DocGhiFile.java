package quan_ly_phuong_tien.common;


import bai11_dsa_stack_queue.bai_tap.thap_phan_sang_nhi_phan.Main;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.PhuongTien;
import quan_ly_phuong_tien.model.XeMay;
import quan_ly_phuong_tien.model.XeTai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {

    public static final String PATH = "E:\\C0221G1-NguyenPhuongNam\\module2\\src\\quan_ly_phuong_tien\\data\\";

    public static void writeFile(String fileName, List<PhuongTien> phuongTienList, boolean trangThai) {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(PATH + fileName);
            fileWriter = new FileWriter(file, trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (PhuongTien o : phuongTienList) {
                bufferedWriter.write(o.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> docFileTheoDong(String fileName) {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<String> stringList = new ArrayList<>();
        String line = null;
        try {
            file = new File(PATH + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    public static List<PhuongTien> docFileXeTai() {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<PhuongTien> arrayList = new ArrayList<>();
        String line = null;
        String[] strings = null;
        try {
            file = new File(PATH + "xetai.csv");
            if (!file.exists()) {

                file.createNewFile();
                System.out.println("Không tìm thấy dữ liệu");

            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings=line.split(",");
                PhuongTien xeTai=new XeTai(strings[0],strings[1],strings[2],strings[3],strings[4]);
                arrayList.add(xeTai);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    } public static  List<PhuongTien> docFileOto() {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<PhuongTien> arrayList = new ArrayList<>();
        String line = null;
        String[] strings = null;
        try {
            file = new File(PATH + "oto.csv");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Không tìm thấy dữ liệu");
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings=line.split(",");
                PhuongTien oto=new Oto(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5]);
                arrayList.add(oto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    } public static  List<PhuongTien> docFileXeMay() {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<PhuongTien> arrayList = new ArrayList<>();
        String line = null;
        String[] strings = null;
        try {
            file = new File(PATH + "xemay.csv");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Không tìm thấy dữ liệu");
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings=line.split(",");
                PhuongTien xeMay=new XeMay(strings[0],strings[1],strings[2],strings[3],strings[4]);
                arrayList.add(xeMay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }


//    public static List<PhuongTien> docFile(String fileName) {
//        File file = null;
//        FileReader fileReader = null;
//        BufferedReader bufferedReader = null;
//        List<PhuongTien> phuongTienList = new ArrayList<>();
//        String line = null;
//        String[] strings = null;
//        try {
//
//            file = new File(PATH + fileName);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            while ((line = bufferedReader.readLine()) != null) {
//                strings = line.split(",");
//                if (strings[5].contains("/7")) {
//                    CanBo congNhan = new CongNhan(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
//                    canBoList.add(congNhan);
//                } else if (strings[5].contains("PV")) {
//                    CanBo nhanVien = new NhanVien(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
//                    canBoList.add(nhanVien);
//                } else {
//                    CanBo kySu = new KySu(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
//                    canBoList.add(kySu);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bufferedReader.close();
//                fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return canBoList;
//    }

}


