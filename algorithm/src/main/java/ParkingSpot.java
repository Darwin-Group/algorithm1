import java.util.*;

public class ParkingSpot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] tokens = input.split(",");

        List<Integer> parkedIndices = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("1")) {
                parkedIndices.add(i);
            }
        }

        int maxDistance = 0;
        int n = tokens.length;
        int[] distances = new int[n];

        // Calculate distances to nearest parked car from left to right
        int lastParkedIndex = -1;
        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("1")) {
                lastParkedIndex = i;
            }
            if (lastParkedIndex != -1) {
                distances[i] = i - lastParkedIndex;
            } else {
                distances[i] = Integer.MAX_VALUE; // No parked car on the left
            }
        }

        // Calculate distances to nearest parked car from right to left
        lastParkedIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (tokens[i].equals("1")) {
                lastParkedIndex = i;
            }
            if (lastParkedIndex != -1) {
                distances[i] = Math.min(distances[i], lastParkedIndex - i);
                maxDistance = Math.max(maxDistance, distances[i]);
            }
        }

        System.out.println(maxDistance);
    }
}