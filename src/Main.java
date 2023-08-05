import Play.Game;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to tic tac toe game");
        System.out.println("Please read below instructions..");
        System.out.println();
        System.out.println("This is a 2 players game.");
        System.out.println("one can be Dom and another one can be mike");
        System.out.println("System will inform you who has to play next move");
        System.out.println("Thanks for reading, please enjoy the game :)");


        Game game = new Game();
        game.initializeGame();
        System.out.println("Winner is "+game.startGame());


    }
}