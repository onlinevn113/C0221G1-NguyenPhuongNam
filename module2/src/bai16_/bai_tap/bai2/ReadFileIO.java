package bai16_.bai_tap.bai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileIO {
    public static void main(String[] args) throws IOException {
        File file=new File( "src\\bai16_\\bai_tap\\ReadFile.csv");
        if (!file.exists()){
            file.createNewFile();
        }
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            String[] strings=line.split(",");
            System.out.println(strings[strings.length-1]);
        }

    }
}
