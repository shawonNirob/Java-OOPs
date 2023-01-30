package javaException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class openFile {
    public static void main(String[] args){
        String str = "Discipline made a man stronger than ever";

        try{
            System.out.println("Entered try statement: ");

            PrintWriter out = new PrintWriter("fileNirob");
            out.print(str);
            out.close();
            System.out.println("File creation done");
        }catch (IOException e){
            System.out.println("Here is catch block");
        }
    }
}
