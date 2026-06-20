
class Delivery {
    int over, ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }
}

public class CricketDeliverySort {

    static Delivery[] countingSortByOver(Delivery[] input) {

        int K = 50;

        int[] count = new int[K + 1];

        for (Delivery d : input)
            count[d.over]++;

        for (int i = 1; i <= K; i++)
            count[i] += count[i - 1];

        Delivery[] output =
                new Delivery[input.length];

        for (int i = input.length - 1; i >= 0; i--) {

            Delivery d = input[i];

            output[--count[d.over]] = d;
        }

        return output;
    }

    public static void main(String[] args) {

        Delivery[] deliveries = {

                new Delivery(2,4),
                new Delivery(1,1),
                new Delivery(3,6),
                new Delivery(1,5),
                new Delivery(2,2),
                new Delivery(3,1),
                new Delivery(1,3),
                new Delivery(2,6),
                new Delivery(3,4),
                new Delivery(1,2)
        };

        Delivery[] sorted =
                countingSortByOver(deliveries);

        System.out.println(
                "Sorted Deliveries:"
        );

        for (Delivery d : sorted) {

            System.out.println(
                    "(" + d.over +
                    "," + d.ball + ")"
            );
        }

        System.out.println(
                "\nTime Complexity = O(n + k)"
        );
    }
}