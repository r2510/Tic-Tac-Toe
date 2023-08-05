package Play;

import Build.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;

    //Initialize players and Board
    public void initializeGame(){
        players = new LinkedList<>();

        PlayingPiece crossPiece = new PlayingPieceX();
        PlayingPiece noughtPiece  = new PlayingPieceO();

        //2 players
        Player xPlayer = new Player(crossPiece, "Dom");
        Player oPlayer = new Player(noughtPiece, "mike");

        players.add(xPlayer);
        players.add(oPlayer);

        board = new Board(3);
    }

    public String startGame(){
        boolean winner = false;

        while (!winner){

            //Player turn
            Player playerTurn = players.removeFirst();

            boolean freeSpace = board.checkFreeCells();

            //end game
            if(!freeSpace){
                winner = true;
                continue;
            }

            System.out.println(playerTurn.getName() + "'s turn");

            board.printBoard();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter row,column you want move next..");
            String s = sc.nextLine();
            String[] str = s.split(",");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);

            boolean markedSuccessfully = board.addPiece(row, col, playerTurn.getPlayingPiece());

            if(!markedSuccessfully){
                System.out.println("Invalid input, please enter valid row and column move again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean isWinner = didPlayerWon(row, col, playerTurn.getPlayingPiece().pieceType);

            if (isWinner)
                return playerTurn.getName();

        }
        return "tie";
    }

    private boolean didPlayerWon(int row, int col, PieceType pieceType) {
            boolean rowMatch = true;
            boolean colMatch = true;
            boolean diagonalMatch = true;
            boolean antiDiagonalMatch = true;

            for (int i=0; i<board.size; i++){
                if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType)
                    rowMatch = false;
            }

        for (int i=0; i<board.size; i++){
            if(board.board[i][col] == null || board.board[i][col].pieceType != pieceType)
                colMatch = false;
        }

        for(int i=0,j=0; i< board.size && j< board.size ; i++, j++){
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType)
                diagonalMatch = false;
        }

        for(int i=0,j=board.size-1; i< board.size && j >= 0 ; i++, j--){
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType)
                antiDiagonalMatch = false;
        }


            return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch ;
    }
}
