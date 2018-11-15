package main.java;

import java.util.*;

/**
 * Created by oliviachisman on 11/12/18
 */
public class Dijkstra {

    private final Map<Character, List<Node>> graph;
    private final Character start;
    private final Character end;

    private Map<Character, Integer> dist = new HashMap<>();
    private Map<Character, Character> childToParent = new HashMap<>();
    private PriorityQueue<Node> heap = new PriorityQueue<>();
    private List<Character> inHeap = new ArrayList<>();


    public Dijkstra(Map<Character, List<Node>> graph, Character start, Character end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
    }

    public void findShortestPath() {
        populate();

        while (!heap.isEmpty()) {
            Node u = heap.poll();
            inHeap.remove(u.getC());
            for (Node w : graph.get(u.getC())) {
                int newDist = dist(u) + getWeightBetween(u, w);
                if (inHeap.contains(w.getC()) && dist(w) > newDist) {
                    dist.put(w.getC(), newDist);
                    childToParent.put(w.getC(), u.getC());
                    decreaseKey(w, newDist);
                }
            }
        }

        printShortestPath();
    }

    private void decreaseKey(Node w, int newDist) {
        heap.remove(w);
        heap.add(new Node(w.getC(), newDist));
    }

    private void printShortestPath() {
        System.out.println("Shortest path length: " + dist.get(end));
        Stack<Character> stack = new Stack<>();
        Character current = end;
        stack.push(end);
        while ((current = childToParent.get(current)) != null) {
            stack.push(current);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private int dist(Node n) {
        return dist.get(n.getC());
    }

    private int getWeightBetween(Node start, Node end) {
        for (Node n : graph.get(start.getC())) {
            if (n.getC().equals(end.getC())) {
                return n.getValue();
            }
        }

        return 0;
    }

    private void populate() {
        for (Character c : graph.keySet()) {
            if (c == start) {
                dist.put(c, 0);
                heap.add(new Node(c, 0));
            } else {
                dist.put(c, Integer.MAX_VALUE);
                heap.add(new Node(c, Integer.MAX_VALUE));
            }
            inHeap.add(c);
        }
    }

}
