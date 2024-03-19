package javaBuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferMethod {
    public static void main(String[] args){
        //ByteBuffer
        ByteBuffer bb = ByteBuffer.allocate(8);
        System.out.println("Right After Creation: ");
        printBuffer(bb);

        for(int i=10; i<18; i++){
            bb.put((byte) i);
        }
        System.out.println("After populating data: ");
        printBuffer(bb);

        System.out.println();

        //CharBuffer
        CharBuffer cb = CharBuffer.allocate(8);
        System.out.println("Right After Creation: ");
        printBuffer1(cb);

        for(int i=65; i<73; i++){
            cb.put((char) i);
        }
        System.out.println("After populating data: ");
        printBuffer1(cb);
    }
    public static void printBuffer(ByteBuffer bb){
         int limit = bb.limit();
        System.out.println("Position: " + bb.position() + ", " + "limit: " + limit);

        System.out.println("Data: ");
        for(int i=0; i<limit; i++){
            System.out.print(bb.get(i) + " ");
        }
        System.out.println();
    }

    public static void printBuffer1(CharBuffer cb){
        int limit = cb.limit();
        System.out.println("Position: " + cb.position() + ", " + "limit: " + limit);

        System.out.println("Data: ");
        for(int i=0; i<limit; i++){
            System.out.print(cb.get(i) + " ");
        }
        System.out.println();
    }
}
