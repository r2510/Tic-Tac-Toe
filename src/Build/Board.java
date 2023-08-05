package Build;

public class Board {
    public int size;
    public PlayingPiece board[][];

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){

        if(board[row][col] != null)
            return false;

        board[row][col] = playingPiece;
        return true;
    }

    public boolean checkFreeCells(){
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++)
                if(board[i][j] == null)
                    return true;
        }
        return false;
    }

    public void printBoard(){
        for (int i=0; i<size; i++) {
            for (int j = 0; j < size; j++){
                System.out.print("| " + (board[i][j] == null ? null : board[i][j].pieceType) + " |");
            }
            System.out.println();
            System.out.println("---------------------------");
        }
    }
}
