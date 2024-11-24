import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//игрок всегда ходит первым
//игрок всегда ставит Х
//бот всегда ставит О
//бот выбирает случайно пустую клетку
//без ООП
public class Main{

    private static final int ROW_COUNT = 3;
    private static final int COL_COUNT = 3;

    private static final int INPUT_COUNT_ARGUMENTS = 2;

    private static String CELL_STATE_EMPTY = " ";
    private static String CELL_STATE_X = "X";
    private static String CELL_STATE_O = "O";
    private static String BOARD_LINE_UPPER = "_________";
    private static String BOARD_LINE_DOWN =  "---------";


    private static Scanner scanner = new Scanner(System.in);

    private static Random random = new Random();

    private static StringBuilder printer = new StringBuilder();

    public static void main(String[] args) {
        startGameRound();
    }
    public static void startGameRound(){
        String[][] board = createBoard();
        startGameLoop(board);
    }

    public static String[][] createBoard(){
        String[][] board = new String[ROW_COUNT][COL_COUNT];

        for(int row = 0; row < ROW_COUNT; row++){
            for(int col = 0; col < COL_COUNT; col++){
                board[row][col] = String.valueOf(CELL_STATE_EMPTY);
            }
        }

        return board;
    }

    public static void startGameLoop(String[][] board){
        while(true){
            printBoard(board);
            makePlayerTurn(board);
            makeBotTurn(board);
            //checkGameState(O_WIN, X_WIN, DRAW, GAME_NOT_OVER)
        }
    }
    public static void makePlayerTurn(String[][] board){
        int[] coordinates = inputCellCoordinates(board);

        board[coordinates[0]][coordinates[1]] = CELL_STATE_X;
    }

    public static int[] inputCellCoordinates(String[][] board){
        System.out.println("Введите координаты через пробел, (0-2):");

        int col, row;

        do{
            try {
                String[] input = scanner.nextLine().split(" ");

                //Проверка введенных координат
                if (input.length != INPUT_COUNT_ARGUMENTS)continue;

                row = Integer.parseInt(input[0]);
                col = Integer.parseInt(input[1]);
            }catch (NumberFormatException e){
                e.printStackTrace();

                System.out.println("Введите координаты через пробел от 0 до 2:");
                continue;
            }

            if(row < 0 || row  >= ROW_COUNT || col < 0 || col >= COL_COUNT){
                System.out.println("Введите координаты через пробел от 0 до 2:");
                continue;
            }
            else if(!Objects.equals(board[row][col], CELL_STATE_EMPTY)){
                System.out.println("Данная ячейка уже занята!");
                System.out.println("Введите координаты через пробел от 0 до 2:");
            }
            else{
                return new int[]{row, col};
            }
        }while(true);

    }

    public static void makeBotTurn(String[][] board){
        int[] coordinates = getRandomEmptyCellCoordinates(board);

        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;
    }

    public static int[] getRandomEmptyCellCoordinates(String[][] board){
        do{
            int row = random.nextInt(ROW_COUNT);
            int col = random.nextInt(COL_COUNT);
            if(Objects.equals(board[row][col], CELL_STATE_EMPTY))return new int[]{row, col};
        }while(true);
    }

    public static void checkGameState(){
        //X = 1, O = -1, empty = 0
        //count sums for rows, cols, diagonals
        //if sum.contains(3) -> X won
        //if sum.contains(-3) -> O won
        //if allCellsTaken() -> draw
        //else -> game not over
    }

    public static void printBoard(String[][] board){

        System.out.println(BOARD_LINE_UPPER);
        for (int row = 0; row < ROW_COUNT; row++) {
            printer.append("| ");
            for (int col = 0; col < COL_COUNT; col++) {
                printer.append(board[row][col] + " ");
            }
            printer.append("|");
            System.out.println(printer);
            printer.delete(0, printer.length());
        }
        System.out.println(BOARD_LINE_DOWN);
    }
}