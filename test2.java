
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String first = reader.nextLine();
        String second = reader.nextLine();

        int arrayLen = Integer.parseInt(first.split(" ")[0]);
        int[] input = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            String[] inputs = second.split(" ");
            input[i] = Integer.parseInt(inputs[i]);
        }

        int sum = input.length;
        int[] sumArray = new int[input.length];
        int countOne = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                countOne++;
            }
        }
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == 0) {
                sumArray[i] = countOne;
            }
            if (input[i] == 1) {
                countOne--;
            }
        }
        for (int i = 0; i < input.length; i++) {
            sum += sumArray[i];
        }
        System.out.println(sum);
    }
}
