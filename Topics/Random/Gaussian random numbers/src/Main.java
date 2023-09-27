import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double K = scanner.nextDouble();
        double N = scanner.nextDouble();
        double M = scanner.nextDouble();

        Random random = new Random();

        int seed = 0;

        while (true) {
            seed++;
            random.setSeed(seed);
            boolean conditionMet = true;

            for (int i = 0; i < N; i++) {
                double gaussianNumber = random.nextGaussian(); // Generate Gaussian numbers scaled by M
                if (gaussianNumber > M) {
                    conditionMet = false;
                    break;
                }
            }

            if (conditionMet && seed >= K) {
                System.out.println(seed);
                break;
            }
        }
    }
}
