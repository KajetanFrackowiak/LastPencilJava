import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int minMax = Integer.MAX_VALUE;
        int seedWithMinMax = -1;

        for (int seed = A; seed <= B; seed++) {
            Random random = new Random(seed);
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int randomNumber = random.nextInt(K);
                if (randomNumber > max) {
                    max = randomNumber;
                }
            }

            if (max < minMax) {
                minMax = max;
                seedWithMinMax = seed;
            }
        }

        System.out.println(seedWithMinMax);
        System.out.println(minMax);
    }
}
