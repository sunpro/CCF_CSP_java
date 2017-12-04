import java.util.Random;
public class RandomTest{
	
	public static void main(String args[]){
		Random r = new Random();
		for(int i = 0; i < 5; i++){
			//System.out.println("1nextInt():" + r.nextInt());
			System.out.println("1nextInt(5):" + r.nextInt(5));
		}
		for(int i = 0; i < 5; i++){
			//System.out.println("2nextInt():" + r.nextInt());
			System.out.println("2nextInt(5):" + r.nextInt(5));
		}
		Random ra = new Random();
		for(int i = 0; i < 5; i++){
			//System.out.println("1nextInt():" + r.nextInt());
			System.out.println("1nextInt(5):" + ra.nextInt(5));
		}
		for(int i = 0; i < 5; i++){
			//System.out.println("2nextInt():" + r.nextInt());
			System.out.println("2nextInt(5):" + ra.nextInt(5));
		}
		Random rt = new Random(System.currentTimeMillis());
		for(int i = 0; i < 5; i++){
			//System.out.println("rtnextInt():" + rt.nextInt());
			System.out.println("rtnextInt(5):" + rt.nextInt(5));
		}
	}
}