package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class Map extends EdgeWeightedDigraph{

    private ArrayList<Map> subgraphs;

    private ST<Integer,Integer> idIndexReference;

    private ST<Integer,Integer> indexIdReference;

    public Map(int numVertexes){

        super(numVertexes);

    }

    public ArrayList<Node> setOfNodes(String tag, BaseDeDados baseDeDados){

        return baseDeDados.searchNodesWithTag(tag);

    }

    public Iterable<DirectedEdge> findShortestPath(int source, int dest){

        DijkstraSP sp = new DijkstraSP(this, source);
        return sp.pathTo(dest);

    }

    public ArrayList<Map> getSubgraphs() {
        return subgraphs;
    }

    public void addSubgraphs(Map subgraph) {

        if(this.subgraphs == null){

            this.subgraphs = new ArrayList<>();

        }

        this.subgraphs.add(subgraph);

    }

    public void addWayToGraph(Way way){

        DirectedEdge edge = new DirectedEdge(way.from(), way.to(), way.weight());
        this.addEdge(edge);

    }

}
