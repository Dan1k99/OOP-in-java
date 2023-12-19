import java.util.Scanner;

public class WesterGame extends Board{
	static Scanner sc = new Scanner(System.in);
	
	public static int firstRow;
	public static int firstCol;
	public static int secondRow;
	public static int secondCol;
	public static boolean playAgain=true;
	
	//The function contains all initializations
	public static void initGame ()
	{
		Board.buildLaddersBoard();
		System.out.print("Welcome to Fatma Westeros Memory Game! ");
		Board.displayLedderBoard();
		Board.buildFigureBoard();
	}
	
		//The function checks if the cards are the same
		public static boolean checkSameCards (String rowAndCol1, String rowAndCol2)
		{
			if(rowAndCol1.equals(rowAndCol2)) 
				{
				return false;
				}
			else return true;
		}
		
	// The function checks if the input is valid : inside the board, place without a card or illegal input
		public static boolean checkValidInput (String rowAndCol)
		{
			if(rowAndCol.charAt(0)>='0' && rowAndCol.charAt(0)<='4' && rowAndCol.charAt(1)>='0' && rowAndCol.charAt(1)<='3')
				return true;
			return false;
		}

		//The function contains all the players moves 
		public static void playerTurn ()
		{
			askForCards();
			if(checkMatchPair(firstRow, firstCol, secondRow, secondCol))
			{
				System.out.print("Cards match!  \r\n");
				Board.changeFromLaddersToStars(firstRow, firstCol, secondRow, secondCol);
			}
			else
				System.out.print("Cards do not match!  \r\n");
			while(!checkEndGame())
			{
				askForCards();
				if(checkMatchPair(firstRow, firstCol, secondRow, secondCol))
				{
					System.out.print("Cards match!  \r\n");
					Board.changeFromLaddersToStars(firstRow, firstCol, secondRow, secondCol);
				}
				else
					System.out.print("Cards do not match!  \r\n");
			}
		}
		
		// The function checks if the game ended
		public static boolean checkEndGame ()
		{
			boolean star = true;
			for(int i = 0; i<boardUpsideDown.length;i++)
			{
				for (int j = 0;j<boardUpsideDown[0].length;j++)
				{
					if (boardUpsideDown [i][j] == '#')
					{
						star = false;
					}
				}
			}
			if(star)
			{
				System.out.println("Game is over! All cards are matched");
			}	
			for(int i = 0; i<boardUpsideDown.length;i++)
				{
					for (int j = 0;j<boardUpsideDown[0].length;j++)
					{
						for(int k = 0; k<boardUpsideDown.length;k++)
						{
							for (int m = 0;m<boardUpsideDown[0].length;m++)
							{
								if (boardUpsideDown [i][j] == '#')
								{
									if(checkMatchPair(i, j, k, m))
										return false;
								}		
							}
						}
					}
				}
				System.out.println("Game is over! No more possible matches.");
			return true;
		}
		
		// The function switches the places between the queen and the king
		public static void switchFigure (int rowFirstCard,int colFirstCard, int rowSecondCard,int colSecondCard)
		{
			Figure tempChange = new Figure("temp", '0');
			tempChange  = figureBoard[rowFirstCard][colFirstCard];
			if(figureBoard[rowFirstCard][colFirstCard].getSign()=='Q' && figureBoard[rowSecondCard][colSecondCard].getSign()=='K') 
			{
				
				figureBoard[rowFirstCard][colFirstCard] = figureBoard[rowSecondCard][colSecondCard];
				figureBoard[rowSecondCard][colSecondCard] = tempChange;
			}
			if(figureBoard[rowFirstCard][colFirstCard].getSign()=='K' && figureBoard[rowSecondCard][colSecondCard].getSign()=='Q')
			{
				figureBoard[rowFirstCard][colFirstCard] = figureBoard[rowSecondCard][colSecondCard];
				figureBoard[rowSecondCard][colSecondCard] = tempChange;
			}
					
		}
		
		//checks if the open card are match
		public static boolean checkMatchPair(int rowFirstCard,int colFirstCard, int rowSecondCard,int colSecondCard)
		{
			if( figureBoard[rowFirstCard][colFirstCard].check(figureBoard[rowSecondCard][colSecondCard]))
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
		
		// The function asks the user for the cards location
		public static void askForCards()
		{
			System.out.print("Please choose the first card to flip \r\n ");
			String rowCol1 = sc.next();
			while(!checkValidInput(rowCol1))
			{
				System.out.println("Sorry, wrong input. Please try again.");
				Board.displayLedderBoard();
				rowCol1 = sc.next();
			}
			firstRow = Character.getNumericValue(rowCol1.charAt(0));
			firstCol= Character.getNumericValue(rowCol1.charAt(1));
			Board.displayBoard1(firstRow, firstCol);
			System.out.println("Please choose the second card to flip  ");
			String rowCol2 = sc.next();
			
			while(!checkValidInput(rowCol2) && checkSameCards(rowCol1,rowCol2))
			{
				System.out.println("Sorry, wrong input. Please try again.");
				Board.displayLedderBoard();
				rowCol2 = sc.next();
			}
			secondRow = Character.getNumericValue(rowCol2.charAt(0));
			secondCol= Character.getNumericValue(rowCol2.charAt(1));
			Board.displayBoard2(firstRow, firstCol, secondRow, secondCol);
		}
		
		// The function asks the user for another game
		public static void askForAnotherGame() 
		{
		System.out.println("Would you like to start a new game?");
		char answer = sc.next().charAt(0);
		while(!checkAnswer(answer)) {
			System.out.println("Would you like to start a new game?");
			 answer = sc.next().charAt(0);
		
		}
		}
		// The function checks the user input for another game
		public static boolean checkAnswer(char answer) {
			if(answer =='y'|| answer=='Y') {
				playAgain = true;
			return true;
			}
			 if(answer=='n'|| answer=='N') {
				playAgain = false;
			return true;
			 }
			else return false; 
		}
		
		
		//Main
		public static void main(String[] args) {
			while(playAgain)
			{
				initGame();
				playerTurn();
				askForAnotherGame(); 
			}
		}
		
		
		

}