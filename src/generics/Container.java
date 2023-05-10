package generics;

public class Container<T> {
    private int MAX_LENGTH;

    private T[] items;

    private int currentIndex = 0;

    public Container(int MAX_LENGTH){
        this.MAX_LENGTH = MAX_LENGTH;
        items  = (T[]) new Object[MAX_LENGTH];
    }

    public void addItem(T item){
        if(currentIndex < MAX_LENGTH){
            items[currentIndex++] = item;
        }else{
            System.out.println("Container is full");
        }
    }

    public T getitem(int index){
        if(index > MAX_LENGTH){
            throw new IllegalArgumentException("Index cannot be larger than max");
        }
        return items[index];
    }

    public void printAll(){
        for(int i=0; i<currentIndex; i++){
            System.out.print(items[i]+", ");
        }
    }
}
