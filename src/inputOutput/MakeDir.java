package inputOutput;

import java.io.File;
import java.io.IOException;

public class MakeDir{
    public static void main(String[] args) throws IOException {
        File dir = new File("/home/shawon/IdeaProjects/HelloWorld/MakeDir");

        dir.mkdir();

        String dirPath = dir.getPath();
        //System.out.println(dir);
        System.out.println(dirPath);

        //create a file
        String fileName = "content.txt";
        File file = new File(dirPath + File.separator + fileName);
        file.createNewFile();

        String filePath = file.getPath();
        System.out.println(filePath);

    }
}
