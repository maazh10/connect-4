import java.util.Scanner;

public class Game
{
    private static Scanner in = new Scanner(System.in);
    private static boolean isX = false;

    public static void main(String[] args)
    {
        String[][] board = {
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
                {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"},
            };

        print(board);

        do
        {
            //TODO: switch the player's turn 
            //      (if isX is true, make it false, and vice versa)
            isX = !isX;

            board = playerTurn(board);
            print(board);

            System.out.println();
        } while( !checkWin(board) );
    }

    public static void print(String[][] board)
    {
        //TODO: print the board
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] playerTurn(String[][] board)
    {
        //set player to the person's turn
        char player = isX ? 'X' : 'O';

        //ask the user for the spot they want
        System.out.print("Player " + player + ", where would you like to go? > ");
        int spot = in.nextInt();

        //TODO: set that spot to the player's letter (char player)
        int findRow = 5;
        while(board[findRow][spot] != "[ ]" && findRow > 0) {
            findRow--;
        }

        board[findRow][spot] = "[" + player + "]";

        return board;
    }

    public static boolean checkWin(String[][] board)
    {
        //TODO: check for win
        for(int i = board.length-1; i > 0; i--) {
            // right to left
            for(int j = 0; j < board[0].length-4; j++) {
                //X horizontal
                if(board[i][j].equals("[X]") && board[i][j+1].equals("[X]") && board[i][j+2].equals("[X]") && board[i][j+3].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //X vertical
                if(board[i][j].equals("[X]") && board[i-1][j].equals("[X]") && board[i-2][j].equals("[X]") && board[i-3][j].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //X diagonal
                if(board[i][j].equals("[X]") && board[i-1][j+1].equals("[X]") && board[i-2][j+2].equals("[X]") && board[i-3][j+3].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //O horizontal
                if(board[i][j].equals("[O]") && board[i][j+1].equals("[O]") && board[i][j+2].equals("[O]") && board[i][j+3].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
                //O vertical
                if(board[i][j].equals("[O]") && board[i-1][j].equals("[O]") && board[i-2][j].equals("[O]") && board[i-3][j].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
                //O diagonal
                if(board[i][j].equals("[O]") && board[i-1][j+1].equals("[O]") && board[i-2][j+2].equals("[O]") && board[i-3][j+3].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
            }
            // left to right
            for(int j = board[0].length-1; j > 2; j--) {
                //X horizontal
                if(board[i][j].equals("[X]") && board[i][j-1].equals("[X]") && board[i][j-2].equals("[X]") && board[i][j-3].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //X vertical
                if(board[i][j].equals("[X]") && board[i-1][j].equals("[X]") && board[i-2][j].equals("[X]") && board[i-3][j].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //X diagonal
                if(board[i][j].equals("[X]") && board[i-1][j-1].equals("[X]") && board[i-2][j-2].equals("[X]") && board[i-3][j-3].equals("[X]")) {
                    System.out.println("Player X Wins!");
                    return true;
                }
                //O horizontal
                if(board[i][j].equals("[O]") && board[i][j-1].equals("[O]") && board[i][j-2].equals("[O]") && board[i][j-3].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
                //O vertical
                if(board[i][j].equals("[O]") && board[i-1][j].equals("[O]") && board[i-2][j].equals("[O]") && board[i-3][j].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
                //O diagonal
                if(board[i][j].equals("[O]") && board[i-1][j-1].equals("[O]") && board[i-2][j-2].equals("[O]") && board[i-3][j-3].equals("[O]")) {
                    System.out.println("Player O Wins!");
                    return true;
                }
            }
        }
        return false;
    }
}