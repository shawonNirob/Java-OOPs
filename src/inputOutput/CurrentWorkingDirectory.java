package inputOutput;

public class CurrentWorkingDirectory {
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
    }
}
