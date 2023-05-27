package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alpha {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        do{
            line = reader.readLine();
            line = line.toUpperCase();
            System.out.println(line);
        }while(!"quit".equals(line));
    }
}
