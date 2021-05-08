package commons;

import models.CanBo;
import models.CongNhan;
import models.KySu;
import models.NhanVien;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {

    public static final String PATH = "E:\\C0221G1-NguyenPhuongNam\\module2\\src\\on_tap_OOP\\src\\data\\";

    public static void writeFile(String fileName, List<CanBo> canBoList, boolean trangThai) {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(PATH + fileName);
            fileWriter = new FileWriter(file, trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (CanBo canBo : canBoList) {
                bufferedWriter.write(canBo.toString());
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

    public static List<CanBo> docFile(String fileName) {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<CanBo> canBoList = new ArrayList<>();
        String line = null;
        String[] strings = null;
        try {

            file = new File(PATH + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
                if (strings[5].contains("/7")) {
                    CanBo congNhan = new CongNhan(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
                    canBoList.add(congNhan);
                } else if (strings[5].contains("PV")) {
                    CanBo nhanVien = new NhanVien(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
                    canBoList.add(nhanVien);
                } else {
                    CanBo kySu = new KySu(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
                    canBoList.add(kySu);
                }
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
        return canBoList;
    }


    public static List<String> docFileNganhDaoTao(String fileName) {
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
}
