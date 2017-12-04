import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][4];
        for(int i=0;i<N;i++){
            for(int j=0;j<4;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] arrShape = new int[10000][2];
        int count =0;
        for(int i=0;i<N;i++){
            int a = arr[i][0];
            int b = arr[i][1];
            int c = arr[i][2];
            int d = arr[i][3];
            for(int j=a+1;j<=c-a+a;j++){
                for(int k=b+1;k<=d-b+b;k++){
                    arrShape[count][0]=j;
                    arrShape[count][1]=k;
                    count++;
                }
            }
        }
        Set<String> set =new  HashSet<String>();
        for(int i=0;i<10000;i++){
            if(arrShape[i][0]!=0 && arrShape[i][1]!=0){
                set.add(arrShape[i][0]+""+arrShape[i][1]);
            }
        }
        System.out.println(set.size());
    }
}