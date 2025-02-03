import java.util.Scanner;
public class Player
{
    // instance variables
    private String name;
    private String mark;    // holds "X" or "O" for this player
    private int numWins;
    private int numLosses;
    private int numTies;
    private boolean human;

    // Constructor
    public Player(String initName, boolean humanPlayer)
    {
        name = initName;
        mark = " ";
        numWins = 0;
        numLosses = 0;
        numTies = 0;
        human = humanPlayer;
    }


    public int pickSquare(Board b)
    {
        if(human)
        {
            return humanPlay();
        }
        else
        {
            return randomPlay(b);
        }
    }

    private int humanPlay()
    {
        Scanner reader = new Scanner(System.in);
        System.out.print("Which column do you choose (1 - 7)? ");
        int square = reader.nextInt();
        return square;
    }

    /*
     * This is the method you'll want to modify to make the computer choose the squares instead
     * of getting input from a human. This method must choose an integer between 1 and 9, and it
     * must be a square which has not already been taken. To find out what mark is in any given
     * square, your method can use the getMark(squareNum) method from the Board class. This method
     * returns a string with an "X", "O", or " ".
     */
    private int randomPlay(Board b)
    {
        return -1;
    }

    // If you are implementing better AI, this is where it should go. To test this you will need to
    // change the call in pickSquare().
    private int smartPlay(Board b)
    {
        return -1;
    }

    public String toString()
    {
        return "Mark: " + mark + "\nWins: " + numWins + "   Losses: " + numLosses + "   Ties: " + numTies;
    }

    // Below are all the "getter" and "setter" methods
    public String getName()
    {
        return name;
    }
    public void setMark(String mrk)
    {
        mark = mrk;
    }
    public String getMark()
    {
        return mark;
    }
    public void addWin()
    {
        numWins++;
    }
    public void addLoss()
    {
        numLosses++;
    }
    public void addTie()
    {
        numTies++;
    }
    public int getWins()
    {
        return numWins;
    }
    public int getLosses()
    {
        return numLosses;
    }
    public int getTies()
    {
        return numTies;
    }
}