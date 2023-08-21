package learJavaClass;

public class NonStaticClass {
    public class InnerClass1{
        int id;
        public InnerClass1(int id){
            this.id = id;
        }
        void print(){
            System.out.println("Jhon");
        }
        int number(){
            return id;
        }
    }
    public class InnerClass2{
        String course;
        public InnerClass2(String course){
            this.course = course;
        }
        void courseName(){
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        NonStaticClass call = new NonStaticClass();

        NonStaticClass.InnerClass1 classOne =call.new InnerClass1(253615);
        classOne.print();
        System.out.println(classOne.number());

        NonStaticClass.InnerClass2 classTwo =call.new InnerClass2("Quantum Computing");
        classTwo.courseName();
    }
}
