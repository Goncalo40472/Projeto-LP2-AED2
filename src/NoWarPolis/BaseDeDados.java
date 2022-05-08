package NoWarPolis;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

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

    private Hashtable<String,ArrayList<PoI>> tagsPoIs;


    /* Construtores da classe BaseDeDados */

    public BaseDeDados(){}


    /* Gets e sets da classe BaseDeDados */

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Way> getWays() {
        return ways;
    }

    public ArrayList<PoI> getPoIS() {
        return PoIS;
    }

    public ArrayList<User> getUsers() {
        return users;
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

    public Hashtable<String, ArrayList<Way>> getTagsWays() {
        return tagsWays;
    }


    /* Funções de pesquisa */

    public ArrayList<Node> searchTagNodes(String tag){

        return this.tagsNodes.get(tag);

    }

    public ArrayList<Way> searchTagWays(String tag){

        return this.tagsWays.get(tag);

    }

    public ArrayList<PoI> searchTagPoIs(String tag){

        return this.tagsPoIs.get(tag);

    }

    public Node searchNode(int id){

        for (Node node : this.nodes) {

            if (Objects.equals(node.getId(), id)) {

                return node;

            }

        }

        return null;

    }

    public Way searchWay(int id){

        for (Way way : this.ways) {

            if (Objects.equals(way.getId(), id)) {

                return way;

            }

        }

        return null;

    }

    public PoI searchPoI(int id){

        for (PoI poi : this.PoIS) {

            if (Objects.equals(poi.getId(), id)) {

                return poi;

            }

        }

        return null;

    }

    public User searchUser(String name){

        for (User user : this.users) {

            if (Objects.equals(user.getName(), name)) {

                return user;

            }

        }

        return null;

    }


    /* Funções de inserção */

    public void addNodeToTag(String tag, Node node){

        if(this.tagsNodes == null){

            this.tagsNodes = new Hashtable<>();

        }

        if(this.tagsNodes.get(tag) == null){

            ArrayList<Node> arraynodes = new ArrayList<>();
            arraynodes.add(node);
            this.tagsNodes.put(tag, arraynodes);

        }

        else{

            this.tagsNodes.get(tag).add(node);

        }


    }

    public void addWayToTag(String tag, Way way){

        if(this.tagsWays == null){

            this.tagsWays = new Hashtable<>();

        }

        if(this.tagsWays.get(tag) == null){

            ArrayList<Way> arrayways = new ArrayList<>();
            arrayways.add(way);
            this.tagsWays.put(tag, arrayways);

        }

        else{

            this.tagsWays.get(tag).add(way);

        }

    }

    public void addPoIToTag(String tag, PoI poi){

        if(this.tagsPoIs == null){

            this.tagsPoIs = new Hashtable<>();

        }

        if(this.tagsPoIs.get(tag) == null){

            ArrayList<PoI> arraypois = new ArrayList<>();
            arraypois.add(poi);
            this.tagsPoIs.put(tag, arraypois);

        }

        else{

            this.tagsPoIs.get(tag).add(poi);

        }

    }

    public void addNode(Node node){

        if(this.nodes == null){

            this.nodes = new ArrayList<>();

        }

        this.nodes.add(node);

    }

    public void addWay(Way way){

        if(this.ways == null){

            this.ways = new ArrayList<>();

        }

        this.ways.add(way);

    }

    public void addPoI(PoI poi){

        if(this.PoIS == null){

            this.PoIS = new ArrayList<>();

        }

        this.PoIS.add(poi);

    }

    public void addUser(User user){

        if(this.users == null){

            this.users = new ArrayList<>();

        }

        this.users.add(user);

    }

    public void addTag(String key, String value){

        if(this.tags == null){

            this.tags = new Hashtable<>();

        }

        this.tags.put(key, value);

    }

    public void addLongitude(int id, double longitude){

        if(this.longNodes == null){

            this.longNodes = new BST<>();

        }

        this.longNodes.put(id, longitude);

    }

    public void addLatitude(int id, double latitude){

        if(this.latNodes == null){

            this.latNodes = new BST<>();

        }

        this.latNodes.put(id, latitude);

    }


    /* Funções de remoção */

    public void removeNode(Node node){

        this.nodes.remove(node);

    }

    public void removeWay(Way way){

        this.ways.remove(way);

    }

    public void removePoI(PoI poi){

        this.PoIS.remove(poi);

    }

    public void removeUser(User user){

        this.users.remove(user);

    }

    public void removeTag(String key){

        this.tags.remove(key);

    }

}