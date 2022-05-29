package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Map extends EdgeWeightedDigraph implements Serializable {

    /* Atributos da classe Map */

    private ArrayList<Map> subgraphs;

    private Hashtable<DirectedEdge, Integer> edgeToWayReference;

    private BaseDeDados baseDeDados;


    /* Construtores da classe Map */

    public Map(int numVertexes, BaseDeDados baseDeDados){

        super(numVertexes);
        this.baseDeDados = baseDeDados;
        this.baseDeDados.getGraphs().add(this);

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

        return baseDeDados.searchTagNodes(tag);

    }

    public Iterable<DirectedEdge> findShortestPath(int source, int dest){

        DijkstraSP sp = new DijkstraSP(this, source);
        return sp.pathTo(dest);

    }

    public Iterable<DirectedEdge> findSPAvoidingSet(int source, int dest, ArrayList<Node> set){

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(this.V());
        int hasNode;

        for(DirectedEdge de : this.edges()){

            hasNode = 0;

            for(Node node : set){

                if(de.from() == node.getId() || de.to() == node.getId()){

                    hasNode = 1;

                }

            }

            if(hasNode == 0){

                graph.addEdge(de);

            }

        }

        DijkstraSP sp = new DijkstraSP(graph, source);
        return sp.pathTo(dest);

    }

    public Map createSubgraph(String key, String value) {

        Map subgraph = new Map(this.V(), this.baseDeDados);

        if(this.subgraphs == null){

            this.subgraphs = new ArrayList<>();

        }

        ArrayList<Way> ways = baseDeDados.searchWayWithTag(key, value);

        for(DirectedEdge de : this.edges()){

            for(Way way : ways){

                if(way.from() == de.from() && way.to() == de.to()){

                    subgraph.addEdge(de);
                    subgraph.getEdgeToWayReference().put(way, way.getId());

                }

            }

        }

        this.subgraphs.add(subgraph);

        return subgraph;

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

    public RedBlackBST<Double, Node> top5ClosestTS(double longitude, double latitude){

        RedBlackBST<Double, Node> closestNodes = new RedBlackBST<>();
        RedBlackBST<Double, Node> distNode = new RedBlackBST<>();

        ArrayList<Node> tempNodes = this.baseDeDados.searchNodeWithTag("highway","traffic_signals");

        for(Node node : tempNodes){

         double dist = Math.sqrt(Math.pow(latitude - node.getLatitude(), 2) + Math.pow(longitude - node.getLongitude(), 2));
         distNode.put(dist, node);

        }

        if(distNode.size() > 5){

            for(int i = 0; i < 5; i++){

                double key = distNode.select(i);
                closestNodes.put(key, distNode.get(key));

            }

        }

        else{

            for(int i = 0; i < distNode.size(); i++){

                double key = distNode.select(i);
                closestNodes.put(key, distNode.get(key));

            }

        }

        return closestNodes;

    }

    public ArrayList<Node> searchNodeByTag(String key, String value){

        ArrayList<Node> nodesWithTag = baseDeDados.searchNodeWithTag(key,value);
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
