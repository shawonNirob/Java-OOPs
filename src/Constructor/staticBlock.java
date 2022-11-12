package Constructor;

public class staticBlock{
    static {
        //static block
        //execute when a class is loaded into memory
        //1st execute
        System.out.println("This is static block");
    }
    {
        //instance block
        //execute during the object creation time
        //2nd execute
        System.out.println("This is the instance block");
    }
    public staticBlock(){
        //constructor
        //execute during the object creation time
        //3nd execute
        System.out.println("This is the default constructor");
    }

    public static void main(String[] args){
        staticBlock obj = new staticBlock();
    }
}
