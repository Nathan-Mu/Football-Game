import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nathan on 12/5/18.
 */
public class Game {
    private final String INPUT_FILE_NAME = "teams.txt";
    private ArrayList<Team> teams;

    public Game() {
        teams = new ArrayList<>();
    }

    public void main()
    {
        init();
        initName();
        startGame();
    }

    public void startGame() {
        String option = "";
        while (option.equals("X")) {
            Menu.displayMenu();
            System.out.println("Please choose an option: ");
            option = getUserInput().trim().toUpperCase();
            switch (option) {
                case "A":
                    playPreliminaryStage();
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    break;
                case "E":
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void init()
    {
        ArrayList<String> lines = FileIO.readFile(INPUT_FILE_NAME);

        for (String line: lines) {
            String[] teamInfo = line.split(",");
            String teamName = teamInfo[0].trim();
            String teamRankString = teamInfo[1].trim();
            int teamRanking = Integer.valueOf(teamRankString);
            Team team = new Team(teamName, teamRanking);
            teams.add(team);
        }
    }

    public void initName()
    {
        for (Team team: teams) // for each team
        {
            for (int i = 0; i < 2; i++) // two chances
            {
                String name = askPlayerName(i, team.getName());
                if (name.isEmpty())
                    // set default player name
                    name = "player-" + i + "-" + team.getName();
                Player player = new Player(name);
                team.addPlayer(player);
            }
        }
    }


    public String askPlayerName(int index, String teamName)
    {
        String[] stringIndex = {"first", "second"};
        String name = "";
        for (int i = 0; i < 2; i++) {
            System.out.println("Please input the name of " + stringIndex[index] + " scorer from " + teamName +":");
            name = getUserInput();
            if (Validation.isPlayerName(name))
                break;
        }
        return name;
    }

    public String getUserInput()
    {
        return new Scanner(System.in).nextLine();
    }

    public void playPreliminaryStage()
    {
        for (Team firstTeam: teams) {
            for (Team secondTeam: teams) {
                if (firstTeam.getName().equals(secondTeam.getName()))
                {
                    continue;
                }
                else
                {
                    playGame(firstTeam, secondTeam);
                }
            }
        }
    }

    public void playGame(Team team1, Team team2)
    {
        // stimulate a match
        if (team1.getRanking() > team2.getRanking())
        {
            stimulateMatch(team1, team2);
        }
        else
        {
            stimulateMatch(team2, team1);
        }

        // generate cards
        generateCards(team1);
        generateCards(team2);
    }

    public void stimulateMatch(Team higherTeam, Team lowerTeam)
    {
        // generate goals
        // higherTeam
        int randomUpset1 = RandomNumberGenerator.generateRandomNumber(0, 2);
        int goals1 = RandomNumberGenerator.generateRandomNumber(0, 5 + randomUpset1);
        // lowerTeam
        int randomUpset2 = RandomNumberGenerator.generateRandomNumber(0, 2);
        int goals2 = RandomNumberGenerator.generateRandomNumber(0, 5 - higherTeam.getRanking() + lowerTeam.getRanking() + randomUpset2);

        // divide goals
        divideGoals(higherTeam, goals1);
        divideGoals(lowerTeam, goals2);

        // compare goals & decide winner
        if (goals1 > goals2)
        {
            higherTeam.win();
            lowerTeam.lose();
        }
        else if (goals1 == goals2)
        {
            higherTeam.draw();
            lowerTeam.draw();
        }
        else
        {
            higherTeam.lose();
            lowerTeam.draw();
        }
    }

    public void divideGoals(Team team, int goals)
    {
        int player1Goals = RandomNumberGenerator.generateRandomNumber(1, goals);
        team.getPlayers().get(0).setGoals(player1Goals);
        team.getPlayers().get(1).setGoals(goals - player1Goals);
    }

    public void generateCards(Team team)
    {
        // init numOfYellow, init numOfRed
        int numOfYellow = 0;
        int numOfRed = 0;
        for (int i = 0; i < 10; i++)
        {
            // yellowCardIndicator & redCardIndicator
            int yellowCardIndicator = RandomNumberGenerator.generateRandomNumber(1, 10);
            int redCardIndicator = RandomNumberGenerator.generateRandomNumber(1, 40);
            // if yellowCardIndicator or redCardIndicator, it means the team is assigned a card
            if (yellowCardIndicator == 1)
                numOfYellow++;
            if (redCardIndicator == 1)
                numOfRed++;
        }
        team.addYellow(numOfYellow);
        team.addRed(numOfRed);
    }
}
