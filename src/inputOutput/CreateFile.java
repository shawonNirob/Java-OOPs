package inputOutput;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("31 July 2023.txt");
        if(file.exists()){
            System.out.println("File existes");
        }else{
            System.out.println("File does not exist, lets create one: ");
            try{
                file.createNewFile();
            }catch(IOException e){
                //However, if an IOException occurs (e.g., due to file permission issues, lack of space, or other file-related problems)
                e.printStackTrace();
            }
        }
    }
}
