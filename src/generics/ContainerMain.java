package generics;

public class ContainerMain {
    public static void main(String[] args) {
       /* Container<Integer> container = new Container<>(5);
        container.addItem(50);
        container.addItem(60);
        container.addItem(70);
        container.addItem(80);
        container.addItem(90);
        //container.addItem(6);

        System.out.println(container.getitem(4));
        container.printAll();
        */

        Container<String> container = new Container<>(5);
        container.addItem("Hello");
        container.addItem("I am Nirob");
        container.addItem("Who");
        container.addItem("Are");
        container.addItem("you");

        container.printAll();
        System.out.println(container.getitem(7));
    }
}
