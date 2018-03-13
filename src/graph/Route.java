package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route implements Comparable <Route>{
    private List<Integer> nodeIndexes = new ArrayList<>();
    private Graph graph;
    private static List <Route> allRoutes = new ArrayList<>();

    // constructor for creation of the first route instance
    public Route(Graph graph) {
        this.graph = graph;
    }

    // constructor for creating a route based on another one
    public Route(Route r) {
        this.nodeIndexes = new ArrayList<>();
        this.nodeIndexes.addAll(r.getNodes());
        this.graph = r.graph;
    }

    public Route findShortestRoute(List<Route> routes){
        if(!routes.isEmpty()){
        return Collections.min(routes);
        }
        else return null;
    }

    public List<Route> generateAllRoutes(int start, int end, Graph graph){
        Route firstRoute = new Route(graph);
        calculateFinalRoutes(firstRoute, start, end);
        List<Route> result = new ArrayList<>();
        result.addAll(allRoutes);
        allRoutes.clear();
        return result;
    }

    public void calculateFinalRoutes(Route oldRoute, int oldIndex, int endIndex){
        oldRoute.getNodes().add(oldIndex);
        if ( graph.getNodeByIndex(oldIndex).hasOutByIndex(endIndex)){
            oldRoute.getNodes().add(endIndex);
            allRoutes.add(oldRoute);
        }
        else if (!graph.getNodeByIndex(oldIndex).getOut().isEmpty()){
            for (Integer tempIndex : graph.getNodeByIndex(oldIndex).getOut()){
                Route temp = new Route(oldRoute);
                calculateFinalRoutes(temp, tempIndex, endIndex);
            }
        }
    }

    public List<Integer> getNodes() {
        return nodeIndexes;
    }

    public void setNodes(List<Integer> nodes) {
        this.nodeIndexes = nodes;
    }

    public int getDistance (){
        return nodeIndexes.size();
    }

    public static List<Route> getAllRoutes() {
        return allRoutes;
//        for (Route route : allRoutes){
//            System.out.println(route.getNodes());
//        }
    }

    @Override
    public int compareTo(Route o) {
        return this.getDistance() - o.getDistance();
    }

}
