package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.Hashtable;

public class Map extends EdgeWeightedDigraph{

    /* Atributos da classe Map */

    private ArrayList<Map> subgraphs;

    private Hashtable<DirectedEdge, Integer> edgeToWayReference;

    private BaseDeDados baseDeDados;


    /* Construtores da classe Map */

    public Map(int numVertexes, BaseDeDados baseDeDados){

        super(numVertexes);

    }


    /* Gets e sets da classe Map */

    public ArrayList<Map> getSubgraphs() {
        return subgraphs;
    }

    public Hashtable<DirectedEdge, Integer> getEdgeToWayReference() {
        if(edgeToWayReference == null){
            edgeToWayReference = new Hashtable<>();
        }
        return edgeToWayReference;
    }



    /* Funções da classe Map */

    public ArrayList<Node> setOfNodes(String tag){

        return baseDeDados.searchNodesWithTag(tag);

    }

    public Iterable<DirectedEdge> findShortestPath(int source, int dest){

        DijkstraSP sp = new DijkstraSP(this, source);
        return sp.pathTo(dest);

    }

    public void createSubgraph(String tag) {

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

        this.getEdgeToWayReference().put(way, way.getId());

    }

    public boolean isGraphConnected(){

        for(int i = 0; i < this.V(); i++){

            DijkstraSP sp = new DijkstraSP(this, i);

            for(int j = 0; j < this.V(); j++){

                if(j != i){

                    if(!sp.hasPathTo(j)) return false;

                }

            }

        }

        return true;

    }

    public ArrayList<Way> top5ClosestTS(){

        ArrayList<Way> closestWays = new ArrayList<>();
        RedBlackBST<Double, Way> tempWays = new RedBlackBST<>();

        ArrayList<Way> tempWaysTS = this.baseDeDados.searchTagWays("traffic_signals");

        for(DirectedEdge de : this.edges()){

            int id = getEdgeToWayReference().get(de);
            Way way = this.baseDeDados.searchWay(id);

            if(tempWaysTS.contains(way)){

                tempWays.put(de.weight(), way);

            }

        }

        if(tempWays.size() > 5){

            for(int i = 0; i < 5; i++){

                double key = tempWays.select(i);
                closestWays.add(tempWays.get(key));

            }

        }

        return closestWays;

    }

    public ArrayList<Node> searchNodeByTag(String tag){

        ArrayList<Node> nodesWithTag = baseDeDados.searchNodesWithTag(tag);
        ArrayList<Node> nodes = new ArrayList<>();

        for(Node node : nodesWithTag){

            if(node.getId() < this.V()){

                nodes.add(node);

            }

        }

        return nodes;

    }

    public ArrayList<Way> searchWayByTag(String tag){

        ArrayList<Way> waysWithTag = baseDeDados.searchTagWays(tag);
        ArrayList<Way> ways = new ArrayList<>();

        for(DirectedEdge de : this.edges()){

            int id = this.getEdgeToWayReference().get(de);
            Way way = baseDeDados.searchWay(id);

            if(waysWithTag.contains(way)){

                ways.add(way);

            }

        }

        return ways;

    }

}
