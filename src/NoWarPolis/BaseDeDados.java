package NoWarPolis;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class BaseDeDados {

    /* Atributos da classe BaseDeDados */

    private ArrayList<Node> nodes;

    private ArrayList<Way> ways;

    private ArrayList<PoI> PoIS;

    private ArrayList<User> users;

    private Hashtable<String, String> tags;

    private BST<Integer, Double> longNodes;

    private BST<Integer, Double> latNodes;

    private Hashtable<String, ArrayList<Node>> tagsNodes;

    private Hashtable<String, ArrayList<Way>> tagsWays;

    private RedBlackBST<Double, ArrayList<User>> usersThatVisitedPoI;



    /* Gets e sets da classe BaseDeDados */

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Way> getWays() {
        return ways;
    }

    public void setWays(ArrayList<Way> ways) {
        this.ways = ways;
    }

    public ArrayList<PoI> getPoIS() {
        return PoIS;
    }

    public void setPoIS(ArrayList<PoI> poIS) {
        PoIS = poIS;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Hashtable<String, String> getTags() {
        return tags;
    }

    public void setTags(Hashtable<String, String> tags) {
        this.tags = tags;
    }

    public BST<Integer, Double> getLongNodes() {
        return longNodes;
    }

    public void setLongNodes(BST<Integer, Double> longNodes) {
        this.longNodes = longNodes;
    }

    public BST<Integer, Double> getLatNodes() {
        return latNodes;
    }

    public void setLatNodes(BST<Integer, Double> latNodes) {
        this.latNodes = latNodes;
    }

    public Hashtable<String, ArrayList<Node>> getTagsNodes() {
        return tagsNodes;
    }

    public void setTagsNodes(Hashtable<String, ArrayList<Node>> tagsNodes) {
        this.tagsNodes = tagsNodes;
    }

    public Hashtable<String, ArrayList<Way>> getTagsWays() {
        return tagsWays;
    }

    public void setTagsWays(Hashtable<String, ArrayList<Way>> tagsWays) {
        this.tagsWays = tagsWays;
    }

    public RedBlackBST<Double, ArrayList<User>> getUsersThatVisitedPoI() {
        return usersThatVisitedPoI;
    }

    public void setUsersThatVisitedPoI(RedBlackBST<Double, ArrayList<User>> usersThatVisitedPoI) {
        this.usersThatVisitedPoI = usersThatVisitedPoI;
    }


    /* Funções de pesquisa */

    public ArrayList<Node> searchTagNodes(String tag, Hashtable<String, ArrayList<Node>> tagsNodes){

        return tagsNodes.get(tag);

    }

    public ArrayList<Way> searchTagWays(String tag, Hashtable<String, ArrayList<Way>> tagsWays){

        return tagsWays.get(tag);

    }


}