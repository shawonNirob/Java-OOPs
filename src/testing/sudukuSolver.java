package testing;

public class sudukuSolver {
    public void print(int row, int col){
        for(int i=0; i<9; i++){
            int r=3*(row/3)+i/3;
            int c=3*(col/3)+i%3;

            if(r==row && col==c) System.out.println("("+r+","+c+')'+" "+"i="+i);
        }
    }
    public static void main(String[] args) {
        sudukuSolver obj = new sudukuSolver();
        obj.print(4,8);
    }
}
