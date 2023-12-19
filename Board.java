
public class Board {
	

	public static char[][] boardUpsideDown = new char [5][4];
	public static Figure[][] figureBoard = new Figure [5][4];
	
	// The function displays the first board according to the input
	public static void displayBoard1(int row1 ,int col1)
	{
		for(int i = 0; i<boardUpsideDown.length;i++)
		{
			System.out.println("");
			for (int j = 0;j<boardUpsideDown[0].length;j++)
			{
				if(row1== i && col1==j)
				{
					System.out.print(figureBoard[i][j].getSign()+ " ");
				}
				else
					System.out.print(boardUpsideDown[i][j]+ " ");
			}
		}
		System.out.println("");
	}
	
	//The function changes the ladders to stars if the cards are matched
		public static void changeFromLaddersToStars(int row1, int col1, int row2, int col2)
		{
			boardUpsideDown[row1][col1]='*';
			boardUpsideDown[row2][col2]='*';	
		}
	
	// The function displays the second board according to the input
	public static void displayBoard2(int row1 ,int col1, int row2, int col2 )
	{
		for(int i = 0; i<boardUpsideDown.length;i++)
		{
			System.out.println("");
			for (int j = 0;j<boardUpsideDown[0].length;j++)
			{
				if((row1== i && col1==j)||(row2== i && col2==j))
				{
					System.out.print(figureBoard[i][j].getSign()+ " ");
				}
				else
					System.out.print(boardUpsideDown[i][j]+ " ");
			}
		}
		System.out.println("");
	}
	
	// builds an "upside down" board
	public static void buildLaddersBoard() 
	{
		for(int i = 0; i<boardUpsideDown.length;i++)
		{
			for (int j = 0;j<boardUpsideDown[0].length;j++)
			{
				boardUpsideDown [i][j] = '#';
			}
		}
	}
	
	//The function fills the board with numbers in random order 
			public static void buildFigureBoard ()
			{
				Figure [] tempBoard = new Figure [20];
				tempBoard[0] = new King("k");
				tempBoard[1] = new Queen("q");
				tempBoard[2] = new Prince("p");
				tempBoard[3] = new General("g");
				tempBoard[4] = new Horseman("h");
				tempBoard[5] = new Soldier("s");
				tempBoard[6] = new Blacksmith("b");
				tempBoard[7] = new Carpenter("c");
				tempBoard[8] = new Dairy("d");
				tempBoard[9] = new Winemaker("w");
				tempBoard[10] = new King("k2");
				tempBoard[11] = new Queen("q2");
				tempBoard[12] = new Prince("p2");
				tempBoard[13] = new General("g2");
				tempBoard[14] = new Horseman("h2");
				tempBoard[15] = new Soldier("s2");
				tempBoard[16] = new Blacksmith("b2");
				tempBoard[17] = new Carpenter("c2");
				tempBoard[18] = new Dairy("d2");
				tempBoard[19] = new Winemaker("w2");
				int placedFigure[] = new int[20];
				boolean flag = true;
				while(true)
				{
					for(int i = 0; i<figureBoard.length; i++)
					{
						for(int j = 0; j<figureBoard[0].length; j++)
						
						{
						while(true)
							{
							int random = (int)(Math.random()*tempBoard.length);
							if(placedFigure[random] == 0)
							{
								figureBoard[i][j] = tempBoard[random];
								placedFigure[random] = 1;
								break;
							}
						}
						}
					}
					for(int i = 0; i<figureBoard.length; i++)
					{
						for(int j = 0; j<figureBoard[0].length; j++)
						
						{
							if(!validPos(i, j, figureBoard[i][j]))
								flag = false;
						}
					}
					if(flag = false)
						continue;
					else
						break;
				}
			}
			//The function checks if the figure can be placed according to the constraints
			 public static Boolean validPos(int row, int col, Figure f)
			 {
				 int up = row+1;
				 int down = row-1;
				 int left = col-1;
				 int right = col+1;
				 boolean checkUp=false;
				 boolean checkDown=false;
				 boolean checkLeft=false;
				 boolean checkRight=false;
				 boolean checkNull=false;
					if(figureBoard[row][col]== null)
					{	
						checkNull = true;
					
						try {
						if(figureBoard[up][col]==null || figureBoard[up][col].getSign()!=f.getSign())
							checkUp = true;
						else
							checkUp= false;
						}catch (RuntimeException exception) {}
						
						try {
						
							if((figureBoard[down][col] ==null) || figureBoard[down][col].getSign()!=f.getSign())
								checkDown = true;
							else
								checkDown= false;
						}catch (RuntimeException exception) {}
						
						try {
							if(figureBoard[row][left] == null || figureBoard[row][left].getSign()!=f.getSign()) 
								checkLeft= true;
							else
								checkLeft= false;
						}catch (RuntimeException exception) {}
						
						try {
							if(figureBoard[row][right] == null ||figureBoard[row][right].getSign()!=f.getSign())
								checkRight= true;
							else
								checkRight= false;
						}catch (RuntimeException exception) {}
					}
					else 
						checkNull= false;
					return(checkNull&&checkRight&&checkLeft&&checkUp&&checkDown);
			 }
			
		//The function displays the cards upside down
				public static void displayLedderBoard()
				{
					for(int i = 0; i<boardUpsideDown.length;i++)
					{
						System.out.println("");
						for (int j = 0;j<boardUpsideDown[0].length;j++)
						{
							System.out.print(boardUpsideDown[i][j]+ " ");
						}
					}
					System.out.println("");
				}
	

}
