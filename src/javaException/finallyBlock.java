package javaException;

import java.io.FileReader;
import java.io.IOException;

public class finallyBlock {
    public static void main(String[] args) {
        FileReader reader = null;
        try{
            reader = new FileReader("fileNirob.txt");
            int i = 0;
            while(i != -1) {
                i = reader.read();
                System.out.print((char) i);
            }
        }catch (IOException e){
            System.out.println("This is IO Exception");
        }finally {
            if(reader != null){
               try{
                   reader.close();
               }catch (IOException e){
                   System.out.println("File does not close");
               }
            }
        }
        System.out.println("---- File End ----");
    }
}
