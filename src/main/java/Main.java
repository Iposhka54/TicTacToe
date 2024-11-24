//игрок всегда ходит первым
//игрок всегда ставит Х
//бот всегда ставит О
//бот выбирает случайно пустую клетку
//без ООП
public class Main{
    public static void main(String[] args) {

    }
    public static void startGameRound(){
        //create board
        //startGameLoop()
    }

    public static void startGame(){
        //while(gameNotOver)
        //playerTurn
        //botTurn
        //checkGameState(O_WIN, X_WIN, DRAW, GAME_NOT_OVER)
    }
    public static void makePlayerTurn(){
        //get input
        //validate input
        //place X on board
    }
    public static void makeBotTurn(){
        //choose a random empty ceil
        //place O on board
        }
    public static void checkGameState(){
        //X = 1, O = -1, empty = 0
        //count sums for rows, cols, diagonals
        //if sum.contains(3) -> X won
        //if sum.contains(-3) -> O won
        //if allCellsTaken() -> draw
        //else -> game not over
    }
}