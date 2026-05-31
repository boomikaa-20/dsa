import java.util.*;

public class SocialNetworkBFS {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(v);
        graph.get(v).add(u);

        System.out.println("Connected User " + u + " with User " + v);
    }

    void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("\nStarting BFS from User: " + start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Visiting User: " + node);

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    System.out.println("  -> Found Connection to User: " + neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        SocialNetworkBFS g = new SocialNetworkBFS();

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);

        g.bfs(1);
    }
}