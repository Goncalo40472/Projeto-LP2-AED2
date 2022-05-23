package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

public class Map extends EdgeWeightedDigraph{

    /* Atributos da classe Map */

    private ArrayList<Map> subgraphs;

    private ST<Integer,Integer> idIndexReference;

    private ST<Integer,Integer> indexIdReference;

    private BaseDeDados baseDeDados;


    /* Construtores da classe Map */

    public Map(int numVertexes, BaseDeDados baseDeDados){

        super(numVertexes);

    }


    /* Funções da classe Map */

    public ArrayList<Node> setOfNodes(String tag){

        return baseDeDados.searchNodesWithTag(tag);

    }

    public Iterable<DirectedEdge> findShortestPath(int source, int dest){

        DijkstraSP sp = new DijkstraSP(this, source);
        return sp.pathTo(dest);

    }

    public ArrayList<Map> getSubgraphs() {
        return subgraphs;
    }

    public void addSubgraphsByTag(String tag) {

        if(this.subgraphs == null){

            this.subgraphs = new ArrayList<>();

        }

        ArrayList<Way> ways = baseDeDados.getTagsWays().get(tag);
        ArrayList<DirectedEdge> edgesSubgraph = new ArrayList<>();

        for(DirectedEdge de : this.edges()){

            for(Way way : ways){

                if(way.from() == de.from() && way.to() == de.to()){

                    edgesSubgraph.add(de);

                }

            }

        }

        ArrayList<Integer> vertexes = new ArrayList<>();

        for(DirectedEdge de : edgesSubgraph){

            if(!vertexes.contains(de.from())){

                vertexes.add(de.from());

            }

            if(!vertexes.contains(de.to())){

                vertexes.add(de.to());

            }

        }

        Map subgraph = new Map(vertexes.size(), this.baseDeDados);

        for(DirectedEdge de: edgesSubgraph){

            subgraph.addEdge(de);

        }

    }

    public void addWayToGraph(Way way){

        this.addEdge(way);

    }

    public boolean isGraphConnected(){

        /* Por fazer */
        return false;

    }

}
