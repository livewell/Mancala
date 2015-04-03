public class Pit
{
    private int stones;
    private boolean whichPlayer;//true for A, false for B
    private int previousStones;
    public Pit(int initialStones, boolean player)
    {
        stones = initialStones;
        whichPlayer = player;
        previousStones = 0;
    }
    public void setStones(int stones)
    { 
        this.stones = stones;
    }
    public void clearPit()
    {
        previousStones = stones;
        stones = 0;
    }
    public int getStones()
    {
        return stones;
    }     
    public void addStones()
    {
        previousStones = stones;
        stones++;
    }
    
    public void addStoness(int stoness) //CHANGE THIS SHITTY NAME
    {
        previousStones = stones;
        this.stones+=stoness;
    }
    public void reset()
    {
        stones = previousStones;
    }
    public boolean whichPlayer()
    {
    return whichPlayer;
    }    
}