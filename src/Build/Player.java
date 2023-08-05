package Build;

public class Player {
    String name;
    PlayingPiece playingPiece;

    public Player(PlayingPiece playingPiece, String name){
        this.name = name;
        this.playingPiece = playingPiece;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
