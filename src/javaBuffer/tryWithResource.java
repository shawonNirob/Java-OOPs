package javaBuffer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class tryWithResource {
    public static void main(String[] args) {
        File outputFile = new File("/home/shawon/Code/File/write.txt");

        String text = " I love bangladesh";

        try(FileChannel fileChannel = new FileOutputStream(outputFile).getChannel()){
            byte[] bytes = text.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            fileChannel.write(buffer);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
