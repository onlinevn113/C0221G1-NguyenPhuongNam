package bai16_.bai_tap.bai1;
import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
//        File file=new File("src\\bai16_\\bai_tap\\bai1\\WriteFile.csv");
//        file.createNewFile();
        String string1="src\\bai16_\\bai_tap\\bai1\\write.txt";
        String string2="src\\bai16_\\bai_tap\\bai2\\ReadFile.csv";
        FileReader fileReader=new FileReader(string2);
        FileWriter fileWriter=new FileWriter(string1);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            bufferedWriter.append(line);
//            bufferedWriter.append("\n");
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
