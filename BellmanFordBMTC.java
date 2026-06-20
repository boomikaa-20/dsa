import java.util.*;

class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFordBMTC {

    static final int INF = 999999;

    static void bellmanFord(List<Edge> edges, int V, int source) {

        int[] dist = new int[V];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        // V-1 Relaxation Iterations
        for (int i = 1; i <= V - 1; i++) {

            for (Edge edge : edges) {

                if (dist[edge.source] != INF &&
                        dist[edge.source] + edge.weight < dist[edge.destination]) {

                    dist[edge.destination] =
                            dist[edge.source] + edge.weight;
                }
            }
        }

        // Negative Cycle Detection
        boolean negativeCycle = false;

        for (Edge edge : edges) {

            if (dist[edge.source] != INF &&
                    dist[edge.source] + edge.weight < dist[edge.destination]) {

                negativeCycle = true;
                break;
            }
        }

        String[] hubs = {
                "MJC",
                "KEM",
                "JAY",
                "KOR",
                "WHF",
                "HBR",
                "MRT"
        };

        System.out.println("Source Hub : MJC");
        System.out.println("\nShortest Distance Table\n");

        for (int i = 0; i < V; i++) {

            System.out.println(
                    hubs[i] + " = " + dist[i]
            );
        }

        System.out.println();

        if (negativeCycle) {

            System.out.println(
                    "Negative Weight Cycle Detected!"
            );

        } else {

            System.out.println(
                    "No Negative Weight Cycle Detected"
            );
        }

        System.out.println("\nTime Complexity:");
        System.out.println("Bellman-Ford = O(V × E)");
    }

    public static void main(String[] args) {

        int V = 7;

        List<Edge> edges = new ArrayList<>();

        // MJC = 0
        // KEM = 1
        // JAY = 2
        // KOR = 3
        // WHF = 4
        // HBR = 5
        // MRT = 6

        edges.add(new Edge(0, 1, 8));    // MJC -> KEM
        edges.add(new Edge(0, 2, 5));    // MJC -> JAY
        edges.add(new Edge(0, 3, 12));   // MJC -> KOR

        edges.add(new Edge(2, 3, 4));    // JAY -> KOR

        edges.add(new Edge(1, 5, 7));    // KEM -> HBR
        edges.add(new Edge(1, 4, 10));   // KEM -> WHF

        edges.add(new Edge(3, 4, 6));    // KOR -> WHF
        edges.add(new Edge(3, 6, 9));    // KOR -> MRT

        edges.add(new Edge(4, 5, 3));    // WHF -> HBR
        edges.add(new Edge(5, 6, 11));   // HBR -> MRT

        edges.add(new Edge(4, 6, -3));   // WHF -> MRT

        bellmanFord(edges, V, 0);
    }
}