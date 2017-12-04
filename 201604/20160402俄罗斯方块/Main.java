import java.util.Scanner;
public class Main{
	private static final int row = 15;
	private static final int lie = 10;
    private static int[][] bg = new int[row][lie];
    private static int[][] brick = new int[4][4];
    private static int po;
	private static Boolean isTouched = false;
	private static Boolean isTouchedbtm = false;
    public static void main(String[] args){
		//input 
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < row; i++){
            for(int j = 0; j< lie; j++){
                bg[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < 4; i++){
			for(int j = 0; j< 4; j++){
				brick[i][j] = in.nextInt();
			}
		}
		po = in.nextInt();
		
		po = po -1;
		int bbtemp = 3;
		//处理数据
		for(int i = 0; i < row; i++){
			int itemp = i; 
			int btemp = bbtemp;
			for(; itemp >= 0; itemp--){
				for(int k =0; k < 4; k++){
					if(bg[itemp][k + po] + brick[btemp][k] == 2){
						isTouched = true;
						break;
					} 	
				}
				if(isTouched) {
					break;
				}
				btemp --;
				if(btemp < 0) {
					isTouched = false;
					break;
				}
			}
			
			if(i == row - 1 && isTouched == false){
				for(int l = 0; l<4; l++){
					if(brick[bbtemp][l] == 1){
						isTouched = true;
						isTouchedbtm = true;
						break;
					}
				}
			}
			
			if(isTouched){	
				if(isTouchedbtm) {
					btemp = bbtemp;
					itemp = i;
				}
				else if (bbtemp < 3 ) {
					btemp = bbtemp + 1;
					itemp = i;
				}
				else {
					btemp = bbtemp;
					itemp = i - 1;
				}
				while(btemp >= 0 && itemp >= 0){
					for(int l = 0; l < 4; l++ ){
						if(itemp < 0) break;
						bg[itemp][l+po] += brick[btemp][l];
					}
					btemp--;
					itemp--;
				}
				break;
			}
			if(i == row - 1 && isTouched == false){
				i--;
				bbtemp --;
				if (bbtemp < 0) break;
			}
		}
		
		//output
		for(int i = 0; i < row; i++){
            for(int j = 0; j< lie; j++){
                System.out.print(bg[i][j] + " ");
				if((j+1)%lie == 0) {
					System.out.print("\n");
				}
            }
        }
    }
}