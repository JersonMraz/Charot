public class TableAndChair {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 1; j <= 22; j++) {
				if((j==1 || j == 22 ) || (i==3 && j>=7 && j<=16) || (i==4 && j<=5) || (i==4 && j>=18) || (i==4 && j==7) || (i==4 && j==16) || (i==5 && j==5) || (i==5 && j==7) || (i==5 && j==16) || (i==5 && j==18) || (i==6 && j==5) || (i==6 && j==7) || (i==6 && j==16) || (i==6 && j==5) || (i==6 && j==7) || (i==6 && j==16) || (i==6 && j==18)){
					System.out.print("X");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}