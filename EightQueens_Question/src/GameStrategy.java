public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		
		return (cellId%8);	// just for the heck of it
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		
		return (cellId/8);	// just for the heck of it
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
//		System.out.println(col);
		int row = getRow(cellId);
//		System.out.println(row);
//		System.out.println(placedQueens[row][col]);
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(placedQueens[i][j]==true)
				{
					if(col==j||row==i)
					{
						isValid=false;
					}
				}
			}
		}
		if(isValid==true) {
			for(int p=0;p<8;p++){
		        for(int q=0;q<8;q++){
		            if((placedQueens[p][q] == true ) && ((p+q == row+col) || (p-q == row-col))){
		                isValid = false;
		            }
		        }
		    }
		}
		
		if(isValid==true)
		{
			numQueens++;
			placedQueens[row][col]=true;
		}
		return isValid;
	}
}














