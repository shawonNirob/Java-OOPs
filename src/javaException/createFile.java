package javaException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class createFile {
    public static void main(String[] args) {
        File file = new File("file2.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file);
            out.println("example string");
            out.close();
            System.out.println("File creation done");
        }catch (IOException e){
            System.err.println("throws an excep");
        }
    }
}

