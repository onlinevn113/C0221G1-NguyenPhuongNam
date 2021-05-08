package character_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program demonstrates how to read characters from a text file.
 * @author www.codejava.net
 *
 */

public class TextFileReadingExample1 {

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("MyFile.txt");
            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //cách 2
        try {
            FileReader reader = new FileReader("MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] temp = line.split(",");
                //Trường hợp 1: length khác nhau
//                if(temp.length == 6) {
//
//                } else if(temp.length == 7) {
//
//                }

                //trường hợp 2: length bằng nhau
                if(temp[0].contains("Villa")) {

                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}