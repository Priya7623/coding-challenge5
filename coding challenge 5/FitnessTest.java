import java.util.Scanner;

public class FitnessTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] oxygenLevels = new int[3][3];
        boolean invalidInput = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                oxygenLevels[i][j] = sc.nextInt();
                
                if (oxygenLevels[i][j] < 1 || oxygenLevels[i][j] > 100) {
                    invalidInput = true;
                }
            }
        }

        if (invalidInput) {
            System.out.println("INVALID INPUT");
            return;
        }

        int[] averageOxygenLevels = new int[3];
        
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += oxygenLevels[i][j];
            }
            averageOxygenLevels[i] = Math.round(sum / 3.0f);
        }

        int maxAverage = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (averageOxygenLevels[i] > maxAverage) {
                maxAverage = averageOxygenLevels[i];
            }
        }

        if (maxAverage < 70) {
            System.out.println("All trainees are unfit");
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (averageOxygenLevels[i] == maxAverage) {
                System.out.println("Trainee Number : " + (i + 1));
            }
        }
    }
}
