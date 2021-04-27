package bai17_.bai_tap.copy_file_nhi_phan;

import java.io.*;

import java.util.Scanner;

public class CopyFileNhiPhan {
//    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
//        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = in.nextLine();
//        File sourceFile = new File(sourcePath);
//        File destFile = new File(destPath);
//        try {
//            copyFileUsingJava7Files(sourceFile, destFile);
//            System.out.printf("Copy completed");
//        } catch (IOException ioe) {
//            System.out.printf("Can't copy that file");
//            System.out.printf(ioe.getMessage());
//        }



        try {
            InputStream  inputStream = new FileInputStream(sourcePath);
            int length = (int) new File(destPath).length();
            byte[] content = new byte[length];
            OutputStream  outputStream = new FileOutputStream(sourcePath);
            while (inputStream.read() != -1) {
                outputStream.write(content);
            }
            System.out.println("DONE!");
            System.out.println(destPath.length());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

