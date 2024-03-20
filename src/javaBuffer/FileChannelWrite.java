package javaBuffer;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {
    public static void main(String[] args) {
        File outputFile = new File("/home/shawon/Code/File/write.txt");
        String text = "ChatGPT write code";

        try{
            FileOutputStream fos = new FileOutputStream(outputFile);
            FileChannel fileChannel = fos.getChannel();

            byte[] bytes = text.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(bytes);

            fileChannel.write(buffer);
            fileChannel.close();
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
