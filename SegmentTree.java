public class SegmentTree {

    int[] tree;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        System.out.println("Building Segment Tree...");
        build(arr, 0, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            System.out.println("Leaf Node: Index " + start + " Value: " + arr[start]);
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            System.out.println("Built Node [" + start + "," + end + "] Sum: " + tree[node]);
        }
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }

        if (l <= start && end <= r) {
            System.out.println("Using Node [" + start + "," + end + "] Sum: " + tree[node]);
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(2 * node + 1, start, mid, l, r) +
               query(2 * node + 2, mid + 1, end, l, r);
    }

    public static void main(String[] args) {
        int[] prices = {100, 200, 300, 400, 500};
        SegmentTree st = new SegmentTree(prices);

        System.out.println("\nPerforming Range Query (1 to 3):");
        int result = st.query(0, 0, prices.length - 1, 1, 3);

        System.out.println("Total Price in Range: " + result);
    }
}