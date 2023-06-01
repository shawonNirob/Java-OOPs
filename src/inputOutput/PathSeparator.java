package inputOutput;

import java.io.File;

public class PathSeparator {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);

        String newFile = workingDir + File.separator + "Nirob.txt";

        File file = new File(newFile);

        System.out.println(file);
    }
}
