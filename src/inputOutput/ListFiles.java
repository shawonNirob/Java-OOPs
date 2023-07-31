package inputOutput;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File home = new File("/home/shawon/IdeaProjects/HelloWorld");
        File[] lisRoots = home.listFiles();

        for(File file : lisRoots){
            System.out.println(file);
        }
    }
}
