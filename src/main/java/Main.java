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

    private static final char START = 'A';
    private static final char END = 'B';

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("ERROR: Please specify the test case file location in program arguments");
            return;
        }
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

        int numVertices = Integer.valueOf(reader.readLine());
        char c = START;
        Map<Character, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            graph.put(c, new ArrayList<>());
            c++;
        }

        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            graph.get(words[0].charAt(0)).add(new Node(words[1].charAt(0), Integer.valueOf(words[2])));
        }

        new Dijkstra(graph, START, END).findShortestPath();
    }
}
