package generics;

public class Alpha {
    public static void main(String[] args) {
        GenerisJ<Integer> printer = new GenerisJ<>(123);
        printer.Print();

        GenerisJ<Double> doublePrinter = new GenerisJ<>(230.52);
        doublePrinter.Print();

        GenerisJ<String> str = new GenerisJ<>("Hey there");
        str.Print();
    }
}
