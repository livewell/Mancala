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
    public boolean getPlayer()
    {
    	return player;
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
    public static void printBoard(Pit[] test)
    {
    	System.out.print(" ");
    	for(int i = 12; i > 6; i--)
    	{
    		System.out.print(Integer.toString(test[i].getStones())+ " ");
    	}
    	System.out.println();
    	System.out.println(test[13].getStones() + " a b c d e f " + test[6].getStones());
    	System.out.print(" ");
    	for(int i = 0; i < 6; i++)
    	{
    		System.out.print(test[i].getStones() + " ");
    	}

    }
    /*
    public void printBoard(Pit[] board)
    {
    	for (int i = 0; i < 7; i++)
        {
             System.out.print(Integer.toString(board[i].getStones()));
        }
        System.out.print("\n");
        for (int i = board.length-1; i > 6; i--)
        {
              System.out.print(Integer.toString(board[i].getStones()));
        }
        System.out.print("\n");
    }
    */
    public void move(int mancalaPitIndex)
    {
    	//TODO make sure that a rock isnt placed in the enemy mancala or landing in the mancala clears the opposite pit
    	int stonesInHand = mancalaBoard[mancalaPitIndex].getStones();
    	int mancalaPitIndex2=0;
    	mancalaBoard[mancalaPitIndex].setStones(0); //removes the stone from the pit you start with 
    	for(int i = stonesInHand; i >0 ;i--)
    	{ 
    		if(PLAYER_A_MANCALA==mancalaPitIndex && player==false)
    	   	{   //remove the extra stone added to the enemy players mancala
    		   	mancalaBoard[mancalaPitIndex].setStones(mancalaBoard[mancalaPitIndex].getStones()-1); 
    		   	i++;
    	   	} 
    	   	if(PLAYER_B_MANCALA==mancalaPitIndex && player==true)
    	   	{   //remove the extra stone added to the enemy players mancala
    		   	mancalaBoard[mancalaPitIndex].setStones(mancalaBoard[mancalaPitIndex].getStones()-1);
    		   	i++;
    	   	}
    	   	mancalaBoard[mancalaPitIndex+= 1].addStones(); // if it isnt a mancala well
          
    	   	//if player does not own the mancala, he must skip the mancalla
    	   	if(i==1) //if it is the last stone
    	   	{
    	   		if((PLAYER_A_MANCALA == mancalaPitIndex)&&(player==true)) //if the last stone is in the players mancalapit, then he gets to go again
    	   		{ 	//if you end in your mancala
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
       if((mancalaBoard[mancalaPitIndex].getStones()==1)/*&&(mancalaPitIndex!=PLAYER_A_MANCALA)&&(mancalaPitIndex!=PLAYER_B_MANCALA)*/) //you land on an empty spot and it is not a mancala
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
       //changes the players turn
       if(player){player=false;}
       if(!player){player=true;}
   }
}
