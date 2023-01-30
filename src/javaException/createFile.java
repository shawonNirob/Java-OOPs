package javaException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class createFile {
    public static void main(String[] args) {
        try{
            File file = new File("file2.txt");

            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file);
            out.println("who are you?");
            out.println("10000");
            out.close();
            System.out.println("File creation done");
        }catch (IOException e){
            System.out.println("Here is catch block");
        }
    }
}

