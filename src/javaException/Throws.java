package javaException;

public class Throws {
    public static void main(String[] args) throws InterruptedException{
        try{
            validateAge(15);
            System.out.println("Age is Valid");
        }catch (InvalidAgeException e){
            System.out.println("Invalid Age: "+ e.getMessage());
        }
    }

    private static void validateAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be 18");
        }
    }
}

