package acasestudy_FuramaResort.Commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;
    private static String path;
    public static void writerFile(String[] content){
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write(StringUtils.concat(content,StringUtils.COMMA));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> readFile(){
        List<String> arrayContent=new ArrayList<String>();
        try {
            bufferedReader=new BufferedReader(new FileReader(path));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                arrayContent.add(line);
            }
        bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return arrayContent;
    }
    public static void setFullPathFile(String fileName){
        StringBuffer path = new StringBuffer("src/acasestudy_FuramaResort/Data/");
        path.append(fileName).append(StringUtils.CSV);
        FileUtils.path=path.toString();
    }
}
