import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean playAgain;

        // Clear the board and start with X.
        // Get valid row and column choices and record each move.
        // Check for a win or tie, or switch players and continue.
        // Ask whether the players want another game.
        do {
            clearBoard();
            String player = "X";
            int moveCount = 0;
            boolean gameOver = false;

            while (!gameOver) {
                display();
                System.out.println("Player " + player + ", choose your move.");
                int row;
                int col;
                do {
                    row = SafeInput.getRangedInt(console, "Enter row", 1, ROWS) - 1;
                    col = SafeInput.getRangedInt(console, "Enter column", 1, COLS) - 1;
                    if (!isValidMove(row, col)) {
                        System.out.println("That cell is already occupied. Choose another move.");
                    }
                } while (!isValidMove(row, col));

                board[row][col] = player;
                moveCount++;
                if (moveCount >= ROWS + COLS - 1 && isWin(player)) {
                    display();
                    System.out.println("Player " + player + " wins!");
                    gameOver = true;
                } else if (isTie()) {
                    display();
                    System.out.println("The game is a tie!");
                    gameOver = true;
                } else {
                    player = player.equals("X") ? "O" : "X";
                }
            }
            playAgain = SafeInput.getYNConfirm(console, "Play again?");
        } while (playAgain);
        System.out.println("Thanks for playing Tic Tac Toe!");
        console.close();
    }
    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void display() {
        System.out.println("\n    1   2   3");
        for (int row = 0; row < ROWS; row++) {
            System.out.print((row + 1) + "   ");
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);
                if (col < COLS - 1) System.out.print(" | ");
            }
            System.out.println();
            if (row < ROWS - 1) System.out.println("   ---+---+---");
        }
    }
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS
                && board[row][col].equals(" ");
    }
    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagnalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            boolean complete = true;
            for (int row = 0; row < ROWS; row++) {
                if (!board[row][col].equals(player)) complete = false;
            }
            if (complete) return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            boolean complete = true;
            for (int col = 0; col < COLS; col++) {
                if (!board[row][col].equals(player)) complete = false;
            }
            if (complete) return true;
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        boolean forward = true;
        boolean backward = true;
        for (int row = 0; row < ROWS; row++) {
            if (!board[row][row].equals(player)) forward = false;
            if (!board[row][COLS - 1 - row].equals(player)) backward = false;
        }
        return forward || backward;
    }

    // A tie means every winning line is blocked.
    private static boolean isTie() {
        return !hasOpenLine("X") && !hasOpenLine("O");
    }

    // An open line has no opposing mark.
    private static boolean hasOpenLine(String player) {
        String opponent = player.equals("X") ? "O" : "X";
        for (int row = 0; row < ROWS; row++) {
            boolean open = true;
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals(opponent)) open = false;
            }
            if (open) return true;
        }
        for (int col = 0; col < COLS; col++) {
            boolean open = true;
            for (int row = 0; row < ROWS; row++) {
                if (board[row][col].equals(opponent)) open = false;
            }
            if (open) return true;
        }
        boolean forward = true;
        boolean backward = true;
        for (int row = 0; row < ROWS; row++) {
            if (board[row][row].equals(opponent)) forward = false;
            if (board[row][COLS - 1 - row].equals(opponent)) backward = false;
        }
        return forward || backward;
    }
}



