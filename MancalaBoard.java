public class MancalaBoard
{
	public static final int PLAYER_A_MANCALA = 6;
	public static final int PLAYER_B_MANCALA = 13;
    private boolean player=true; //true == a, false == b 
    //player=true;
    private Pit[ ] mancalaBoard;
    public Pit[] getBoard()
    {
    return mancalaBoard;
    }
    public MancalaBoard(int initialStones)
    {
         mancalaBoard = new Pit[14];//set pit 6 and 13 to mancalas
         for(int i = 0; i < PLAYER_A_MANCALA; i++)
         {
             mancalaBoard[i] = new Pit(initialStones, true);
         }
         for(int i = PLAYER_A_MANCALA; i < PLAYER_B_MANCALA; i++)
         {
             mancalaBoard[i] = new Pit(initialStones, false);
         }
         mancalaBoard[PLAYER_A_MANCALA] = new MancalaPit(0, true);  //WAS 6
         mancalaBoard[PLAYER_B_MANCALA] = new MancalaPit(0, false);	// WAS 13
    }
    
   public void move(int mancalaPitIndex)
   {
	   //TODO make sure that a rock isnt placed in the enemy mancala
	   int stonesInHand = mancalaBoard[mancalaPitIndex].getStones();
       int mancalaPitIndex2=0;
	   mancalaBoard[mancalaPitIndex].setStones(0); //removes the stone from the pit you start with 
       for(int i = stonesInHand; i >0 ;i--)
       { 
           mancalaBoard[mancalaPitIndex+= 1].addStones(); // if it isnt a mancala well
          
           //if player does not own the mancala, he must skip the mancalla
           if(i==1)
           {
        	   if((PLAYER_A_MANCALA == mancalaPitIndex)&&(player==true)) //if the last stone is in the players mancalapit, then he gets to go again
        	   { //if you end in your mancala
        		   		mancalaBoard[mancalaPitIndex].addStones();
        	   			move(mancalaPitIndex2); //play again
        	   }
        	   if((PLAYER_B_MANCALA == mancalaPitIndex)&&(player==false))
        	   {
        		   mancalaBoard[mancalaPitIndex].addStones();
        		   move(mancalaPitIndex2); //play again
        	   }
           }
       }
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       if(mancalaBoard[mancalaPitIndex].getStones()==1) //you land on an empty spot
       {
    	   if((player)&&(mancalaPitIndex!=PLAYER_A_MANCALA)) //if it is player A and is not his mancala
    	   {								  //CHANGE THIS SHITTY NAME
    		   mancalaBoard[PLAYER_A_MANCALA].addStoness(mancalaBoard[mancalaPitIndex+7].getStones());//take the opposite +7 to get accross the board if player A. use -7 if player B
    		   mancalaBoard[mancalaPitIndex+7].clearPit();
    		   //mancalaBoard[PLAYER_A_MANCALA].addStones();
    	   }
    	  // else
    		if((!player)&&(mancalaPitIndex!=PLAYER_A_MANCALA))   
    	   {								  //CHANGE THIS SHITTY NAME
    		   mancalaBoard[PLAYER_A_MANCALA].addStoness(mancalaBoard[mancalaPitIndex-7].getStones());//take the opposite +7 to get accross the board if player A. use -7 if player B
    		   mancalaBoard[mancalaPitIndex-7].clearPit();
    	   }
       }
   }
}