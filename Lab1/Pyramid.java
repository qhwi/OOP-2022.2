import java.util.Scanner;
public class Pyramid {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input height: ");
		int n = keyboard.nextInt();
		keyboard.close();
		
		for (int i = 1; i<=n; i++) {
			System.out.println(" ".repeat(n-i) + "*".repeat(2*i-1) + " ".repeat(n-i));
		}
	}
}
