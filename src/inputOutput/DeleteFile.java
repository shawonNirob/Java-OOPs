package inputOutput;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        file.delete(); //delete immediately

        File file2 = new File("file1.txt");
        file.deleteOnExit(); //delete when jvm terminate
    }
}
