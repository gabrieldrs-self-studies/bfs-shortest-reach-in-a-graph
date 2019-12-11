import org.w3c.dom.ranges.Range;

import java.util.*;

public class Main {

    private static final int WEIGHT = 6;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            // Array of distances, at first all are -1
            int[] distance = new int[s.nextInt()];
            Arrays.fill(distance, -1);
            // Array of edges each entry
            int[][] edges = new int[s.nextInt()][2];
            
            for (int[] edge : edges) {
                edge[0] = s.nextInt() - 1;
                edge[1] = s.nextInt() - 1;
            }

            int start = s.nextInt() - 1;

            distance[start] = 0;

            ArrayList<Integer> currentLevel = new ArrayList<>();

            currentLevel.add(start);
            while(currentLevel.size() > 0) {
                ArrayList<Integer> nextLevel = new ArrayList<>();
                while (currentLevel.size() > 0) {
                    int current = currentLevel.remove(0);
                    for (int[] edge : edges) {
                        if (edge[0] == current) {
                            distance[edge[1]] = distance[edge[0]] + WEIGHT;
                            nextLevel.add(edge[1]);
                        }
                    }
                }
                currentLevel = nextLevel;
            }
            for (int j : distance) {
                if (j != 0) System.out.print(j+" ");
            }
            System.out.println();

        }
    }
}
