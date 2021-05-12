package quan_ly_danh_ba.commons;

import quan_ly_danh_ba.model.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    public static final String PATH = "E:\\C0221G1-NguyenPhuongNam\\module2\\src\\quan_ly_danh_ba\\data\\";

    public static void writeFile(String fileName, List<DanhBa> phuongTienList, boolean trangThai) {
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(PATH + fileName);
            fileWriter = new FileWriter(file, trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (DanhBa o : phuongTienList) {
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

    public static List<DanhBa> docFile(String fileName) {
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<DanhBa> danhBaList = new ArrayList<>();
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
                    DanhBa danhBa = new DanhBa(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6]);
                    danhBaList.add(danhBa);
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
        return danhBaList;
    }

}
