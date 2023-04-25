import java.util.Arrays;
import java.util.Scanner;

public class SortNum {
    public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.print("> Enter array length: ");
    int n = input.nextInt();

    int[] arr = new int[n];
    System.out.print("> Enter numbers: ");
    for (int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
    }
    input.close();

    System.out.print("Original array: \n");
    for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
    }

    Arrays.sort(arr);
    double sum = 0;
    System.out.print("\nSorted array: \n");
    for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
        sum += arr[i];
    }

    System.out.print("\nSUM: " + sum);
    System.out.print("\nAVERAGE: " + (sum/n));
    }
}
