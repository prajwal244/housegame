import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class HousieGame {

	public static void main(String[] args) {
		IntStream.range(0, 5).forEach(value -> {
			System.out.println("----------------------------------------");
			beginGame();
		});
		}

	private static void beginGame() {//added cmmt //dsasd /cccc
		int game[][]= new int[3][9];
		
		int totalCellLimit =15;
		while(totalCellLimit>0) {
		int i = getRandomNumber(3);
		int j = getRandomNumber(9);
		
	
		
		int data = validatAndReturnNum(i,j,game);
		
		if(data>0) {
			
			game[i][j]=data;
			totalCellLimit--;
		}
			
			
		}
		System.out.println(Arrays.deepToString(game).replace("],", "]\n").replace("0", "00").replace(","," || "));
	}

	private static int validatAndReturnNum(int i, int j, int[][] game) {
	//rule 1 if value is filled it cannot be overwritten
		
		if(game[i][j]!=0) {
			return -1;
		}
		
		int rowCounter=0;
		for(int r=0;r<3;r++) {
			
			if(game[r][j] !=0) {
				
				rowCounter++;
			}
				
			
		}
		//Column cannot contain more than two values
		
		if(rowCounter>2) {
			
			return -1;
		}
		
		int columnCounter=0;
		for(int c=0;c<9;c++) {
			
			if(game[i][c] !=0) {
				
				columnCounter++;
			}
		}
		//Rows Cannot have more than five element
		
		if(columnCounter>=5) {
			
			return -1;
		}
		
		int data=0;
		boolean isValueSet= false;
		do {
			data = getRanddomNumForCol(j);
			isValueSet= isValueExistsCol(game,i,j,data);
		}while(isValueSet);
		
		return data;
	}

	

	private static int getRanddomNumForCol(int high) {
		if(high==0) {
			
			high=10;
		}else {
			high=(high+1)*10;
		}
		int low=high-9;
		Random r= new Random();
		
		return r.nextInt(high-low)+low;
	}

	private static boolean isValueExistsCol(int[][] game, int i, int j, int data) {
		boolean status = false;
		for(int k=0;k<3;k++) {
			
			if(game[k][j] ==data) {
				status=true;
				break;
			}
		}
		return status;
	}

	private static int getRandomNumber(int max) {
		
		return(int)(Math.random()*max);
	}
}
