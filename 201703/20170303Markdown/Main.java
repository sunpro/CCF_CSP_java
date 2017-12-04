import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String line = null;
		boolean isFull = false;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.equals ("")) { //空行
				if(isFull){
					isFull = false;
					System.out.print("<p>");
				}
			}
			else { //不是空行
				int i = 0;
				int length = line.length();
				for(; i < length; i++){
					if(line.charAt(i) == ' ')
						continue;
					else
						break;
				}
				
				char c = line.charAt(i);
				switch(c) {
					case '#':
						int countH = 1;
						++i;
						for(; i < length; i++){
							if(line.charAt(i) == '#')
								countH++;
							else
								break;
						}
						for(; i < length; i++){
							if(c == ' ')
								continue;
							else
								break;
						}
						String head = line.substring(i,length);
						System.out.println("<h" + countH + ">" + head + "</h" + countH + ">");
						break;
					case '*':
						 
						break;
					default :
						//if(isStartP &&  isFull)
						if(!isFull) {
							isFull = true;
							System.out.print("<p>");
						}
						//todo
						System.out.print(line);
						break;
				}
				
			}
				
		}
	}
}