import java.util.*;

public class KnapsackCargoLoading {

    public static void main(String[] args) {

        String[] items = {
                "A", "B", "C", "D",
                "E", "F", "G", "H"
        };

        int[] weights = {
                5, 8, 3, 10,
                4, 6, 7, 2
        };

        int[] values = {
                40, 50, 20, 70,
                30, 35, 45, 15
        };

        int capacity = 24;
        int n = items.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                dp[i][w] = dp[i - 1][w];

                if (weights[i - 1] <= w) {

                    dp[i][w] = Math.max(
                            dp[i][w],
                            dp[i - 1][w - weights[i - 1]]
                                    + values[i - 1]
                    );
                }
            }
        }

        System.out.println("Truck Capacity = " + capacity);

        System.out.println(
                "\nMaximum Value = "
                        + dp[n][capacity]
        );

        // Backtracking
        List<String> selectedItems =
                new ArrayList<>();

        int w = capacity;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                selectedItems.add(items[i - 1]);

                w -= weights[i - 1];
            }
        }

        Collections.reverse(selectedItems);

        int totalWeight = 0;
        int totalValue = 0;

        System.out.println(
                "\nSelected Items:"
        );

        for (String item : selectedItems) {

            System.out.println(item);

            int index =
                    Arrays.asList(items)
                            .indexOf(item);

            totalWeight += weights[index];
            totalValue += values[index];
        }

        System.out.println(
                "\nTotal Weight = "
                        + totalWeight
        );

        System.out.println(
                "Total Value = "
                        + totalValue
        );

        System.out.println(
                "\nTime Complexity = O(n × W)"
        );

        System.out.println(
                "Space Complexity = O(n × W)"
        );
    }
}