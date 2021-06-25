package Game;

public class Announce {

    public static void addedPlayer(String playerName, int numberOfPlayers) {
        System.out.println("Game.Player " + numberOfPlayers + ": " + playerName);
    }

    public static void playerRolled(String player, int roll) {
        System.out.println(player + " rolled a " + roll);
    }

    public static void playerOutOfPenalty(String player) {
        System.out.println(player + " is getting out of the penalty box");
    }

    public static void playerStayingInPenalty(String player) {
        System.out.println(player + " is not getting out of the penalty box");
    }

    public static void correctAnswer() {
        System.out.println("Answer was correct!!!!");
    }

    public static void incorrectAnswer() {
        System.out.println("Question was incorrectly answered");
    }

    public static void playersGoldCoins(String player, int score) {
        System.out.println(player + " now has " + score + " Gold Coins.");
    }

    public static void wasSentToPenalty(String player) {
        System.out.println(player + " was sent to the penalty box");
    }

    public static void playersLocation(String player, int location) {
        System.out.println(player + "'s new location is " + location);
    }

    public static void playersCategory(String category) {
        System.out.println("The category is " + category);
    }

    public static void question(String question) {
        System.out.println(question);
    }

    public static void winner(String player) {
        System.out.println(player + " HAS WON!");
    }











}
