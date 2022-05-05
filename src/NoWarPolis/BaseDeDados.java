package NoWarPolis;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Hashtable;

public class BaseDeDados {

    /* Atributos da classe BaseDeDados */

    private ArrayList<Node> nodes;

    private ArrayList<Way> ways;

    private ArrayList<PoI> PoIS;

    private ArrayList<User> users;

    private Hashtable<String, String> tags;

    private BST<Integer, Double> longNodes;

    private BST<Integer, Double> latNodes;

    private Hashtable<String, ArrayList<Object>> tagsUsed;

    private RedBlackBST<Double, ArrayList<PoI>> PoIsVisitedByUser;

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

    public Hashtable<String, ArrayList<Object>> getTagsUsed() {
        return tagsUsed;
    }

    public void setTagsUsed(Hashtable<String, ArrayList<Object>> tagsUsed) {
        this.tagsUsed = tagsUsed;
    }

    public RedBlackBST<Double, ArrayList<PoI>> getPoIsVisitedByUser() {
        return PoIsVisitedByUser;
    }

    public void setPoIsVisitedByUser(RedBlackBST<Double, ArrayList<PoI>> poIsVisitedByUser) {
        this.PoIsVisitedByUser = poIsVisitedByUser;
    }

    public RedBlackBST<Double, ArrayList<User>> getUsersThatVisitedPoI() {
        return usersThatVisitedPoI;
    }

    public void setUsersThatVisitedPoI(RedBlackBST<Double, ArrayList<User>> usersThatVisitedPoI) {
        this.usersThatVisitedPoI = usersThatVisitedPoI;
    }


    /* Funções de pesquisa */

    public ArrayList<PoI> searchPoIsVisitedByUser(RedBlackBST<Double, ArrayList<PoI>> PoIsVisitedByUser, double time){

        ArrayList<PoI> arrayPoIs = new ArrayList<>();

        arrayPoIs = PoIsVisitedByUser.get(time);

        return arrayPoIs;

    }

}