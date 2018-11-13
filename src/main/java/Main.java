package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oliviachisman on 11/12/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/oliviachisman/dev/depaul/csc_421/dijkstras-algorithm/Case1.txt";

        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

        int numVertices = Integer.valueOf(reader.readLine());
        char c = 'A';
        Map<Character, List<Node>> graph = new HashMap<>();

        char last = 'A';
        for (int i = 0; i < numVertices; i++) {
            graph.put(c, new ArrayList<>());
            last = c;
            c++;
        }

        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            graph.get(words[0].charAt(0)).add(new Node(words[1].charAt(0), Integer.valueOf(words[2])));
        }

        System.out.println(graph);

        new Dijkstra(graph, 'A', last).findShortestPath();
    }
}
