import java.util.Scanner;

public class MatrixAdd {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int row = 0;
        int col = 0;

        while (true) {
            try {
                System.out.println("> Enter number of ROWs and COLUMNs: ");
                row = input.nextInt();
                col = input.nextInt();
                if (row < 1 || col < 1) {
                    throw new Exception("Invalid size");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid size! Please try again\n");
                input.nextLine();
            }
        }
        
        int[][] firstM = new int[row][col];
        for (int i = 0; i < row; i++) {
            while (true) {
                try {
                    System.out.print("> Input row " + (i+1) + ": ");
                    for (int j = 0; j < col; j++) {
                        firstM[i][j] = input.nextInt();
                    }
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please try again\n");
                    input.nextLine();
                }
            }
        }

        System.out.print("\n>>> FIRST matrix:");
        for (int i = 0; i < row; i++) {
            System.out.print("\n");
            for (int j = 0; j < col; j++) {
                System.out.print(firstM[i][j] + "\t");
            }
        }
        
        int[][] secondM = new int[row][col];
        System.out.println("\n");
        for (int i = 0; i < row; i++) {
            while (true) {
                try {
                    System.out.print("> Input row " + (i+1) + ": ");
                    for (int j = 0; j < col; j++) {
                        secondM[i][j] = input.nextInt();
                        firstM[i][j] += secondM[i][j];
                    }
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please try again\n");
                    input.nextLine();
                }
            }
        }

        input.close();

        System.out.print("\n>>> SECOND matrix:");
        for (int i = 0; i < row; i++) {
            System.out.print("\n");
            for (int j = 0; j < col; j++) {
                System.out.print(secondM[i][j] + "\t");
            }
        }

        System.out.print("\n\n>>> SUM of two matrices:");
        for (int i = 0; i < row; i++) {
            System.out.print("\n");
            for (int j = 0; j < col; j++) {
                System.out.print(firstM[i][j] + "\t");
            }
        }
    }
}
