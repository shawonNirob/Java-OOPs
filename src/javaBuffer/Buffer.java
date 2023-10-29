package javaBuffer;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class Buffer{
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(8);
        System.out.println("Capacuity: " + bb.capacity());
        System.out.println("Limit: " + bb.limit());
        System.out.println("Position: " + bb.position());

        try{
            bb.reset();
            System.out.println("Mark: " + bb.position());
        }catch (InvalidMarkException e){
            System.out.println("Mark is not safe");
        }
    }
}

