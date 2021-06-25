package Game;

public class Player {

    private final String name;
    private int score;
    private int location;
    private boolean inPenalty;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int add) {
        this.score += add;
    }

    public int getLocation() {
        return location;
    }

    public void moveUpLocation(int location) {
        this.location += location;
    }

    public void resetLocation() {
        this.location = 0;
    }

    public boolean isInPenalty() {
        return inPenalty;
    }

    public void putInPenalty() {
        this.inPenalty = true;
    }

    public void removeFromPenalty() {
        this.inPenalty = false;
    }
}
