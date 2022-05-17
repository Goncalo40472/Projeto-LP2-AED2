package NoWarPolis;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.ArrayList;

public class Map {

    public EdgeWeightedDigraph graph;

    public Map(int numVertexes){

        this.graph = new EdgeWeightedDigraph(numVertexes);

    }

    public ArrayList<Node> setOfNodes(String tag, BaseDeDados baseDeDados){

        return baseDeDados.searchNodesWithTag(tag);

    }

}
