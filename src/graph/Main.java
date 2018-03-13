package graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new GraphImpl();
        List<Integer> for1 = new ArrayList<>();
        for1.add(2);
//        for1.add(3);
        List<Integer> for2 = new ArrayList<>();
        for2.add(4);
        List <Integer> for3 = new ArrayList<>();
        for3.add(4);
        List <Integer> for4 = new ArrayList<>();
        g.add(new Node(for4, for1));
        g.add(new Node(for4, for2));
        g.add(new Node(for4, for3));
        g.add(new Node(for4, for4));

        Route r = new Route(g);
        System.out.println(g.findShortestPath(1, 4));
    }
}
