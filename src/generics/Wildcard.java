package generics;


import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public static void printList(List<?> list){
        for(Object n : list){
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        List<Object> objList = new ArrayList<>();
        objList.add(55);
        printList(objList);

        objList.add("Nirob");
        printList(objList);

        List<Integer> list = new ArrayList<>();
        list.add(505);

        printList(list);
    }
}
