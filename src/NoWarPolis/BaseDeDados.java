package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.io.*;
import java.util.*;

public class BaseDeDados {

    /* Atributos da classe BaseDeDados */

    private ArrayList<Node> nodes;

    private ArrayList<Way> ways;

    private ArrayList<PoI> PoIS;

    private ArrayList<User> users;

    private ArrayList<AdminUser> adminUsers;

    private ArrayList<Map> graphs;

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

    public ArrayList<AdminUser> getAdminUsers() {
        return adminUsers;
    }

    public ArrayList<Map> getGraphs() {
        return graphs;
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

    public User searchUser(String email){

        if(this.users == null) return null;

        for (User user : this.users) {

            if (Objects.equals(user.getEmail(), email)) {

                return user;

            }

        }

        return null;

    }

    public AdminUser searchAdminUser(String email){

        if(this.adminUsers == null) return null;

        for (AdminUser adminUser : this.adminUsers) {

            if (Objects.equals(adminUser.getEmail(), email)) {

                return adminUser;

            }

        }

        return null;

    }

    public ArrayList<Node> searchNodesWithTag(String tag){

        ArrayList<Node> nodes = new ArrayList<>();

        for(int i = 0; i < this.nodes.size(); i++){

            Hashtable<String,String> tagsNode = this.nodes.get(i).getTagsNode();

            if(tagsNode.contains(tag)) nodes.add(this.nodes.get(i));

        }

        return nodes;

    }

   public ArrayList<PoI> top5VisitedPoIs(double time1, double time2){

        RedBlackBST<Integer, PoI> tempPoIs = new RedBlackBST<>();
        ArrayList<PoI> top5PoIs = new ArrayList<>();


        int count = 0;

        for(PoI p : this.PoIS){

            int tam = p.searchVisitors(time1, time2).size();
            tempPoIs.put(tam, p);

        }

        for(int i = 0; i < 5; i++){

            int key = tempPoIs.select(0);
            PoI poi = tempPoIs.get(key);
            top5PoIs.add(poi);

        }

        return top5PoIs;

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

    public void addUser(String name, String contact, String email, String password){

        User user = new User(name, contact, email, password);

        if(this.users == null){

            this.users = new ArrayList<>();

        }

        this.users.add(user);

    }

    public void addAdminUser(String name, String contact, String email, String password){

        AdminUser adminUser = new AdminUser(name, contact, email, password);

        if(this.adminUsers == null){

            this.adminUsers = new ArrayList<>();

        }

        this.adminUsers.add(adminUser);

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


    /* Método que imprime o estado atual de todos os PoI's */

    public void now(){

        if(this.getPoIS() == null){

            System.out.println("\nThere is no PoI's!\n");
            return;

        }

        for(PoI poi : this.getPoIS()){

            System.out.println("\n\nId: " + poi.getId() + "\nId Coordenada: " + poi.getIndex() + "\nLatitude: " + poi.getLatitude()
                    + "\nLongitude: " + poi.getLongitude() + "\nNome do PoI: " + poi.getName());

            if(poi.getUsersThatVisitedPoI() != null){

                for(double time : poi.getUsersThatVisitedPoI().keys()){

                    User user = poi.getUsersThatVisitedPoI().get(time);

                    System.out.println("\nNome Utilizador " + user.getName());

                }

            }

        }

    }


    /* Funções de leitura de ficheiros de texto */

    public void readNodes(String filename) throws IOException {

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        while ((st = br.readLine()) != null) {

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            int index = Integer.parseInt(strings[1]);
            double lat = Double.parseDouble(strings[2]);
            double lon = Double.parseDouble(strings[3]);

            Node node = new Node(id, index, lat, lon);

            if (strings.length > 4) {

                for (int i = 4; i < strings.length; i += 2) {

                    node.addTag(strings[i], strings[i + 1]);
                    this.addTag(strings[i], strings[i + 1]);
                    this.addNodeToTag(strings[i], node);

                }

            }

            this.addNode(node);

        }

    }


    /* Funções de impressão de dados */

    public void printUsers(){

        if(this.getUsers() == null) System.out.println("\nNao existem basic users na base de dados");

        else{

            System.out.println("\nBasic users na base de dados:");

            for(User user : this.getUsers()){

                System.out.println("\nNome: " + user.getName() + "\nContacto: " + user.getContact() + "\nEmail: " + user.getEmail());

            }

        }

        if(this.getAdminUsers() == null) System.out.println("\nNao existem admin users na base de dados");

        else{

            System.out.println("\nAdmin users na base de dados:");

            for(AdminUser adminUser : this.getAdminUsers()){

                System.out.println("\nNome: " + adminUser.getName() + "\nContacto: " + adminUser.getContact() + "\nEmail: " + adminUser.getEmail());

            }

        }

    }

    public void printNodes(){

        if(this.getNodes() == null) System.out.println("\nNao existem nodes na base de dados");

        else{

            System.out.println("\nNodes na base de dados:");

            for(Node node : this.getNodes()){

                System.out.println("\nId: " + node.getId() + "\nIndex: " + node.getIndex() + "\nLatitude: " + node.getLatitude() +
                        "\nLongitude: " + node.getLongitude());

                if(node.getTagsNode() != null){

                    System.out.println("\nTags:");

                    Hashtable<String,String> tags = node.getTagsNode();
                    Set<String> keys = tags.keySet();

                    for(String key : keys){

                        System.out.println("Key: " + key + "\nValue: " + tags.get(key));

                    }

                }

            }

        }

    }

    public void printWays(){

        if(this.getWays() == null) System.out.println("\nNao existem ways na base de dados");

        else{

            System.out.println("\nWays na base de dados:");

            for(Way way : this.getWays()){

                System.out.println("\nId: " + way.getId() + "");

                if(way.getTagsWay() != null){

                    System.out.println("\nTags:");

                    Hashtable<String,String> tags = way.getTagsWay();
                    Set<String> keys = tags.keySet();

                    for(String key : keys){

                        System.out.println("Key: " + key + "\nValue: " + tags.get(key));

                    }

                }

            }

        }

    }

}