package leetcode;

import java.awt.*;
import java.util.HashSet;

public class StBul {
    public static void main(String[] args) {
        HashSet<String> set =new HashSet<>();
        StringBuilder shape =  new StringBuilder();
        shape.append(0);
        shape.append(2);
        set.add(shape.toString());

        shape.delete(0, shape.length());
        shape.append(5);
        shape.append(6);
        set.add(shape.toString());

        System.out.println(set);

    }
}
