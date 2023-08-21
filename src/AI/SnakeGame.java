package AI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private static final int BOARD_WIDTH = 20;
    private static final int BOARD_HEIGHT = 10;
    private static final char EMPTY_CELL = '.';
    private static final char SNAKE_BODY = 'o';
    private static final char FOOD = '*';

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
    private List<int[]> snake = new ArrayList<>();
    private int[] food = new int[2];
    private Random random = new Random();
    private int direction = 1; // 0: up, 1: right, 2: down, 3: left

    public SnakeGame() {
        initializeBoard();
        placeFood();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j] = 0;
            }
        }

        int initialSnakeX = BOARD_WIDTH / 2;
        int initialSnakeY = BOARD_HEIGHT / 2;
        snake.add(new int[]{initialSnakeY, initialSnakeX});
        board[initialSnakeY][initialSnakeX] = 1;
    }

    private void placeFood() {
        int foodX, foodY;
        do {
            foodX = random.nextInt(BOARD_WIDTH);
            foodY = random.nextInt(BOARD_HEIGHT);
        } while (board[foodY][foodX] != 0);

        food[0] = foodY;
        food[1] = foodX;
        board[foodY][foodX] = 2;
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j] == 0) {
                    System.out.print(EMPTY_CELL);
                } else if (board[i][j] == 1) {
                    System.out.print(SNAKE_BODY);
                } else if (board[i][j] == 2) {
                    System.out.print(FOOD);
                }
            }
            System.out.println();
        }
    }

    private boolean move() {
        int[] head = snake.get(snake.size() - 1);
        int newHeadX = head[1] + ((direction == 1) ? 1 : ((direction == 3) ? -1 : 0));
        int newHeadY = head[0] + ((direction == 2) ? 1 : ((direction == 0) ? -1 : 0));

        if (newHeadX < 0 || newHeadY < 0 || newHeadX >= BOARD_WIDTH || newHeadY >= BOARD_HEIGHT) {
            return false; // Game over, snake hit the wall
        }

        if (board[newHeadY][newHeadX] == 1) {
            return false; // Game over, snake collided with itself
        }

        snake.add(new int[]{newHeadY, newHeadX});
        if (newHeadX == food[1] && newHeadY == food[0]) {
            placeFood();
        } else {
            int[] tail = snake.remove(0);
            board[tail[0]][tail[1]] = 0;
        }
        board[newHeadY][newHeadX] = 1;
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.print("Enter direction (w: up, d: right, s: down, a: left): ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'w':
                    if (direction != 2) direction = 0;
                    break;
                case 'd':
                    if (direction != 3) direction = 1;
                    break;
                case 's':
                    if (direction != 0) direction = 2;
                    break;
                case 'a':
                    if (direction != 1) direction = 3;
                    break;
                default:
                    System.out.println("Invalid input. Please use w, a, s, or d.");
                    continue;
            }

            if (!move()) {
                printBoard();
                System.out.println("Game over!");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.play();
    }
}

