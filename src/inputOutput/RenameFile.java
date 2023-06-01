package inputOutput;

import java.io.File;
import java.io.IOException;

public class RenameFile {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("OldFile.txt");
        File newFile = new File("NewFile.txt");

        oldFile.createNewFile();

        boolean fileRenamed = oldFile.renameTo(newFile);

        if(fileRenamed){
            System.out.println(oldFile+" renamed to "+newFile);
        }else{
            System.out.println("file rename failed");
        }
    }
}
