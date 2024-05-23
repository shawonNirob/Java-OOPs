package AI;

public class BulbGame {
    public static void main(String[] args) {
        int n = 2025;
        boolean[] canWin = new boolean[n + 1];

        // Emma takes the first turn
        canWin[0] = false; // Emma cannot make a move with 0 bulbs

        // Determine the winner for each number of bulbs from 1 to 2025
        for (int i = 1; i <= n; i++) {
            canWin[i] = false; // Assume Emma loses for now
            if (i >= 1 && !canWin[i - 1]) {
                canWin[i] = true; // Emma can win by lighting up 1 bulb
            }
            if (i >= 3 && !canWin[i - 3]) {
                canWin[i] = true; // Emma can win by lighting up 3 bulbs
            }
            if (i >= 4 && !canWin[i - 4]) {
                canWin[i] = true; // Emma can win by lighting up 4 bulbs
            }
        }

        for(int i=1; i<n+1; i++){
            System.out.println(i+ " "+ canWin[i]+ " ");
        }
        // Determine the winner for n = 2025
        if (canWin[n]) {
            System.out.println("Emma wins!");
        } else {
            System.out.println("Lucas wins!");
        }
    }
}

