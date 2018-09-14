import java.util.ArrayList;

/**
 * Created by nathan on 12/5/18.
 */
public class Team {
    private ArrayList<Player> players;
    private String name;
    private int ranking;
    private int numOfWins;
    private int numOfLost;
    private int numOfDrawn;
    private int points;
    private int numOfYellow;
    private int numOfRed;
    private int fairPlayScore;


    public Team() {
    }

    public Team(String name, int ranking) {
        this.players = new ArrayList<>();
        this.name = name;
        this.ranking = ranking;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLost() {
        return numOfLost;
    }

    public void setNumOfLost(int numOfLost) {
        this.numOfLost = numOfLost;
    }

    public int getNumOfDrawn() {
        return numOfDrawn;
    }

    public void setNumOfDrawn(int numOfDrawn) {
        this.numOfDrawn = numOfDrawn;
    }

    public void win() {
        numOfWins++;
        points += 3;
    }

    public void lose() {
        numOfLost++;
    }

    public void draw() {
        numOfDrawn++;
        points += 1;
    }

    public int getScore() {
        return points;
    }

    public int getNumOfYellow() {
        return numOfYellow;
    }

    public int getNumOfRed() {
        return numOfRed;
    }

    public void addYellow(int number)
    {
        numOfYellow += number;
        fairPlayScore += number;
    }

    public void addRed(int number)
    {
        numOfRed += number;
        fairPlayScore += number * 2;
    }


}
