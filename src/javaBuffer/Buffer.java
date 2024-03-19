package javaBuffer;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class Buffer{
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(8);

        System.out.println("Capacuity: " + bb.capacity());
        System.out.println("Limit: " + bb.limit());
        System.out.println("Position: " + bb.position());

        //Set the mark(if mark is not set then reset() function throws invalid)
        bb.mark();
        System.out.println("Mark set at position: " + bb.position());

        //Move the position
        bb.position(4);
        System.out.println("new position: " + bb.position());

        try{
            bb.reset();
            System.out.println("Mark: " + bb.position());
        }catch (InvalidMarkException e){
            System.out.println("Mark is not set or invalid");
        }
    }
}

