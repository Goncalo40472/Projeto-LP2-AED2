package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDados {

    /* Atributos da classe BaseDeDados */

    private ArrayList<Node> nodes;

    private ArrayList<Way> ways;

    private ArrayList<PoI> PoIS;

    private ArrayList<User> users;

    private ArrayList<AdminUser> adminUsers;

    private ArrayList<Map> graphs;

    private ArrayList<Node> nodesRemoved;

    private ArrayList<Way> waysRemoved;

    private ArrayList<PoI> PoISRemoved;

    private ArrayList<User> usersRemoved;

    private ArrayList<AdminUser> adminUsersRemoved;

    private Hashtable<String, String> tags;

    private BST<Integer, Double> longNodes;

    private BST<Integer, Double> latNodes;

    private Hashtable<String, ArrayList<Node>> tagsNodes;

    private Hashtable<String, ArrayList<Way>> tagsWays;

    private Hashtable<String,ArrayList<PoI>> tagsPoIs;


    /* Construtores da classe BaseDeDados */

    public BaseDeDados(){

        nodes = new ArrayList<>();
        ways = new ArrayList<>();
        PoIS = new ArrayList<>();
        users = new ArrayList<>();
        adminUsers = new ArrayList<>();
        graphs = new ArrayList<>();
        nodesRemoved = new ArrayList<>();
        waysRemoved = new ArrayList<>();
        PoISRemoved = new ArrayList<>();
        usersRemoved = new ArrayList<>();
        adminUsersRemoved = new ArrayList<>();
        tags = new Hashtable<>();
        longNodes = new BST<>();
        latNodes = new BST<>();
        tagsNodes = new Hashtable<>();
        tagsWays = new Hashtable<>();
        tagsPoIs = new Hashtable<>();

    }


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

    public ArrayList<Node> getNodesRemoved() {
        return nodesRemoved;
    }

    public ArrayList<Way> getWaysRemoved() {
        return waysRemoved;
    }

    public ArrayList<PoI> getPoISRemoved() {
        return PoISRemoved;
    }

    public ArrayList<User> getUsersRemoved() {
        return usersRemoved;
    }

    public ArrayList<AdminUser> getAdminUsersRemoved() {
        return adminUsersRemoved;
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

    public Hashtable<String, ArrayList<PoI>> getTagsPoIs() {
        return tagsPoIs;
    }


    /* Funções de pesquisa */

    public ArrayList<Node> searchTagNodes(String tag){

        return this.tagsNodes.get(tag);

    }

    public ArrayList<Node> searchNodeWithTag(String key,String value){

        ArrayList<Node> nodes = searchTagNodes(key);
        ArrayList<Node> nodesWithValue = new ArrayList<>();

        for(Node node : nodes){

            if(Objects.equals(node.getTagsNode().get(key), value)){

                nodesWithValue.add(node);

            }

        }

        return nodesWithValue;

    }

    public ArrayList<Way> searchTagWays(String tag){

        return this.tagsWays.get(tag);

    }

    public ArrayList<Way> searchWayWithTag(String key,String value){

        ArrayList<Way> ways = searchTagWays(key);
        ArrayList<Way> waysWithValue = new ArrayList<>();

        for(Way way : ways){

            if(Objects.equals(way.getTagsWay().get(key), value)){

                waysWithValue.add(way);

            }

        }

        return waysWithValue;

    }

    public ArrayList<PoI> searchTagPoIs(String tag){

        return this.tagsPoIs.get(tag);

    }

    public ArrayList<PoI> searchPoIsWithTag(String key,String value){

        ArrayList<PoI> pois = searchTagPoIs(key);
        ArrayList<PoI> PoIsWithValue = new ArrayList<>();

        for(PoI poi : pois){

            if(Objects.equals(poi.getTagsPoI().get(key), value)){

                PoIsWithValue.add(poi);

            }

        }

        return PoIsWithValue;

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

    public ArrayList<PoI> searchNotVisitedPoIs(long time1, long time2){

        ArrayList<PoI> notVisitedPoIs = new ArrayList<>();

        for(PoI poi : this.getPoIS()){

            boolean visited = false;

            for(User user : this.getUsers()){

                if(user.searchVisitedPoI(time1, time2).contains(poi)){

                    visited = true;

                }

            }

            for(AdminUser adminUser : this.getAdminUsers()){

                if(adminUser.searchVisitedPoI(time1, time2).contains(poi)){

                    visited = true;

                }

            }

            if(!visited){

                notVisitedPoIs.add(poi);

            }

        }

        return notVisitedPoIs;

    }

    public ArrayList<PoI> top5VisitedPoIs(long time1, long time2){

        RedBlackBST<Integer, PoI> tempPoIs = new RedBlackBST<>();
        ArrayList<PoI> top5PoIs = new ArrayList<>();

        for(PoI p : this.getPoIS()){

            int tam = p.searchVisitors(time1, time2).size();
            tempPoIs.put(tam, p);

        }

        if(tempPoIs.size() > 5){

            for(int i = 0; i < 5; i++){

                int key = tempPoIs.select(i);
                PoI poi = tempPoIs.get(key);
                top5PoIs.add(poi);

            }

        }

        else{

            for(int i = 0; i < tempPoIs.size(); i++){

                int key = tempPoIs.select(i);
                PoI poi = tempPoIs.get(key);
                top5PoIs.add(poi);

            }

        }

        return top5PoIs;

    }

    public ArrayList<User> top5Visitors(long time1, long time2){

        RedBlackBST<Integer, ArrayList<User>> tempUsers = new RedBlackBST<>();
        ArrayList<User> top5Users = new ArrayList<>();

        for(User u : this.getUsers()){

            int tam = u.searchVisitedPoI(time1,time2).size();

            if(tempUsers.contains(tam)){

                tempUsers.get(tam).add(u);

            }

            else{

                ArrayList<User> array = new ArrayList<>();
                array.add(u);
                tempUsers.put(tam, array);

            }

        }

        for(AdminUser au : this.getAdminUsers()){

            int tam = au.searchVisitedPoI(time1,time2).size();

            if(tempUsers.contains(tam)){

                tempUsers.get(tam).add(au);

            }

            else{

                ArrayList<User> array = new ArrayList<>();
                array.add(au);
                tempUsers.put(tam, array);

            }

        }

        int totalUsers = 0;

        if(tempUsers.size() > 5){

            for(int i = 0; i < 5; i++){

                int key = tempUsers.select(i);
                ArrayList<User> users = tempUsers.get(key);

                if(totalUsers == 5) break;

                if(totalUsers + users.size() <= 5){

                    top5Users.addAll(users);
                    totalUsers += users.size();

                }

                else{

                    for(User user : users){

                        if(totalUsers == 5) break;

                        top5Users.add(user);
                        totalUsers++;

                    }

                }

            }

        }

        else{

            for(int i = 0; i < tempUsers.size(); i++){

                int key = tempUsers.select(i);
                ArrayList<User> users = tempUsers.get(key);

                if(totalUsers == 5) break;

                if(totalUsers + users.size() <= 5){

                    top5Users.addAll(users);
                    totalUsers += users.size();

                }

                else{

                    for(User user : users){

                        if(totalUsers == 5) break;

                        top5Users.add(user);
                        totalUsers++;

                    }

                }

            }

        }

        return top5Users;

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
        addLatitude(node.getId(), node.getLatitude());
        addLongitude(node.getId(), node.getLongitude());

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

    public void removeNode(int id){

        Node node = this.searchNode(id);

        for(User user : this.getUsers()){

            for(Long key : user.getNodesVisited().keys()){

                if(user.getNodesVisited().get(key) == node){

                    user.getNodesVisited().delete(key);

                }

            }

        }

        for(AdminUser adminUser : this.getAdminUsers()){

            for(Long key : adminUser.getNodesVisited().keys()){

                if(adminUser.getNodesVisited().get(key) == node){

                    adminUser.getNodesVisited().delete(key);

                }

            }

        }

        ArrayList<Way> ways = new ArrayList<>();

        for(Way way : this.getWays()){

            if(way.from() == id || way.to() == id){

                ways.add(way);

            }

        }

        for(Way way : ways){

            this.getWays().remove(way);

        }

        for(Integer key : this.getLatNodes().keys()){

            if(key == id){

                this.getLatNodes().delete(key);

            }

        }

        for(Integer key : this.getLongNodes().keys()){

            if(key == id){

                this.getLongNodes().delete(key);

            }

        }

        ArrayList<Node> nodes = new ArrayList<>();

        for(String key : this.getTagsNodes().keySet()){

            for(Node n : this.getTagsNodes().get(key)){

                if(n.getId() == id){

                    nodes.add(n);

                }

            }

            for (Node n : nodes){

                this.getTagsNodes().get(key).remove(n);

            }

        }

        this.nodes.remove(node);
        this.nodesRemoved.add(node);

    }

    public void removeWay(int id){

        Way way = this.searchWay(id);

        for(User user : this.getUsers()){

            for(Long key : user.getWaysVisited().keys()){

                if(user.getWaysVisited().get(key) == way){

                    user.getWaysVisited().delete(key);

                }

            }

        }

        for(AdminUser adminUser : this.getAdminUsers()){

            for(Long key : adminUser.getWaysVisited().keys()){

                if(adminUser.getWaysVisited().get(key) == way){

                    adminUser.getWaysVisited().delete(key);

                }

            }

        }

        ArrayList<Way> ways = new ArrayList<>();

        for(String key : this.getTagsWays().keySet()){

            for(Way w : this.getTagsWays().get(key)){

                if(w.getId() == id){

                    ways.add(w);

                }

            }

            for (Way w : ways){

                this.getTagsWays().get(key).remove(w);

            }

        }

        this.ways.remove(way);
        this.getWaysRemoved().add(way);

    }

    public void removePoI(int id){

        PoI poi = this.searchPoI(id);

        for(User user : this.getUsers()){

            for(Long key : user.getPoIsVisited().keys()){

                if(user.getPoIsVisited().get(key) == poi){

                    user.getPoIsVisited().delete(key);

                }

            }

        }

        for(AdminUser adminUser : this.getAdminUsers()){

            for(Long key : adminUser.getPoIsVisited().keys()){

                if(adminUser.getPoIsVisited().get(key) == poi){

                    adminUser.getPoIsVisited().delete(key);

                }

            }

        }

        ArrayList<PoI> pois = new ArrayList<>();

        for(String key : this.getTags().keySet()){

            for(PoI p : this.getTagsPoIs().get(key)){

                if(p.getId() == id){

                    pois.add(p);

                }

            }

            for (PoI p : pois){

                this.getTagsPoIs().get(key).remove(p);

            }

        }

        this.PoIS.remove(poi);
        this.getPoISRemoved().add(poi);


    }

    public void removeUser(String name){

        User user = searchUser(name);

        this.users.remove(user);
        this.getUsersRemoved().add(user);

    }

    public void removeAdminUser(String name){

        AdminUser adminUser = searchAdminUser(name);

        this.adminUsers.remove(adminUser);
        this.getAdminUsersRemoved().add(adminUser);

    }


    /* Método que imprime o estado atual de todos os PoI's */

    public void now(){

        if(this.getPoIS() == null){

            System.out.println("\nThere is no PoI's!\n");
            return;

        }

        System.out.println("\n###########################################");
        System.out.println("\nEstado atual dos PoIS:");

        for(PoI poi : this.getPoIS()){

            System.out.println("\n\nId: " + poi.getId() + "\nId Coordenada: " + poi.getIndex() + "\nLatitude: " + poi.getLatitude()
                    + "\nLongitude: " + poi.getLongitude() + "\nNome do PoI: " + poi.getName());

            if(poi.getUsersThatVisitedPoI() != null){

                for(long time : poi.getUsersThatVisitedPoI().keys()){

                    User user = poi.getUsersThatVisitedPoI().get(time);

                    System.out.println("\nNome Utilizador " + user.getName());

                }

            }

        }

        System.out.println("\n###########################################");

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

    public void readWays(String filename) throws IOException {

        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        while ((st = br.readLine()) != null) {

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            int idNoOrig = Integer.parseInt(strings[1]);
            int idNoDest = Integer.parseInt(strings[2]);
            double weight = Double.parseDouble(strings[3]);

            Way way = new Way(id, idNoOrig, idNoDest, weight);

            if (strings.length > 4) {

                for (int i = 4; i < strings.length; i += 2) {

                    way.addTag(strings[i], strings[i + 1]);
                    this.addTag(strings[i], strings[i + 1]);
                    this.addWayToTag(strings[i], way);

                }

            }

            this.addWay(way);

        }

    }

    public void readPoIs(String filename) throws IOException {

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
            String name = strings[4];

            PoI poi = new PoI(id, index, lat, lon, name);

            if (strings.length > 5) {

                for (int i = 5; i < strings.length; i += 2) {

                    poi.addTag(strings[i], strings[i + 1]);
                    this.addTag(strings[i], strings[i + 1]);
                    this.addPoIToTag(strings[i], poi);

                }

            }

            this.addPoI(poi);

        }

    }

    public void readNodesBin(){

        String filename = "data/Nodes.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                Node node = (Node) ois.readObject();
                this.getNodes().add(node);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }

    /*public void readWaysBin(){

        String filename = "data/Ways.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                Way way = (Way) ois.readObject();
                this.getWays().add(way);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    public void readPoIsBin(){

        String filename = "data/PoIs.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                PoI poi = (PoI) ois.readObject();
                this.getPoIS().add(poi);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }

    /*public void readGraphsBin(){

        String filename = "data/Graphs.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                Map graph = (Map) ois.readObject();
                this.getGraphs().add(graph);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    /*public void readUsersBin(){

        String filename = "data/Users.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                User user = (User) ois.readObject();
                this.getUsers().add(user);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    /*public void readAdminUsersBin(){

        String filename = "data/AdminUsers.bin";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            int size = (Integer) ois.readObject();

            for(int i = 0; i < size; i++){

                AdminUser adminUser = (AdminUser) ois.readObject();
                this.getAdminUsers().add(adminUser);

            }

        } catch ( IOException | ClassNotFoundException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    /* Funções de escrita para ficheiros de texto */

    public void writeNodesTxt(){

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("data", "Nodes.txt");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);

            pw.println(this.getNodes().size());
            pw.flush();

            for(Node node : this.getNodes()){

                pw.print(node.getId());
                pw.print(",");
                pw.print(node.getIndex());
                pw.print(",");
                pw.print(node.getLatitude());
                pw.print(",");
                pw.print(node.getLongitude());

                if(node.getTagsNode() != null){

                    for(String key : node.getTagsNode().keySet()){

                        pw.print(",");
                        pw.print(key);
                        pw.print(",");
                        pw.print(node.getTagsNode().get(key));

                    }

                }

                pw.println();
                pw.flush();

            }


        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e);
        } finally {
            try {
                // Flush and close
                if (pw!=null) pw.close();
                if (fw!=null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void writeWaysTxt(){

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("data", "Ways.txt");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);

            pw.println(this.getWays().size());
            pw.flush();

            for(Way way : this.getWays()){

                pw.print(way.getId());
                pw.print(",");
                pw.print(way.from());
                pw.print(",");
                pw.print(way.to());
                pw.print(",");
                pw.print(way.weight());

                if(way.getTagsWay() != null){

                    for(String key : way.getTagsWay().keySet()){

                        pw.print(",");
                        pw.print(key);
                        pw.print(",");
                        pw.print(way.getTagsWay().get(key));

                    }

                }

                pw.println();
                pw.flush();

            }


        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e);
        } finally {
            try {
                // Flush and close
                if (pw!=null) pw.close();
                if (fw!=null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void writePoIsTxt(){

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File f = new File("data", "PoIs.txt");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);

            pw.println(this.getPoIS().size());
            pw.flush();

            for(PoI poi : this.getPoIS()){

                pw.print(poi.getId());
                pw.print(",");
                pw.print(poi.getIndex());
                pw.print(",");
                pw.print(poi.getLatitude());
                pw.print(",");
                pw.print(poi.getLongitude());
                pw.print(",");
                pw.print(poi.getName());

                if(poi.getTagsPoI() != null){

                    for(String key : poi.getTagsPoI().keySet()){

                        pw.print(",");
                        pw.print(key);
                        pw.print(",");
                        pw.print(poi.getTagsPoI().get(key));

                    }

                }

                pw.println();
                pw.flush();

            }


        } catch (Exception e) {
            System.err.println("FilePrintWriterApp - main(): " + e);
        } finally {
            try {
                // Flush and close
                if (pw!=null) pw.close();
                if (fw!=null) fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void writeNodesBin(){

        String filename = "data/Nodes.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getNodes().size());

            for(Node node : this.getNodes()){

                oos.writeObject(node);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }

    public void writeWaysBin(){

        String filename = "data/Ways.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getWays().size());

            for(DirectedEdge de : this.getWays()){

                oos.writeObject(de);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }

    public void writePoIsBin(){

        String filename = "data/PoIS.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getPoIS().size());

            for(PoI poi : this.getPoIS()){

                oos.writeObject(poi);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }

    /*public void writeGraphsBin(){

        String filename = "data/Graphs.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getGraphs().size());

            for(Map graph : this.getGraphs()){

                oos.writeObject(graph);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    /*public void writeUsersBin(){

        String filename = "data/Users.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getUsers().size());

            for(User user : this.getUsers()){

                oos.writeObject(user);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/

    /*public void writeAdminUsersBin(){

        String filename = "data/AdminUsers.bin";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){

            oos.writeObject(this.getAdminUsers().size());

            for(AdminUser adminUser : this.getAdminUsers()){

                oos.writeObject(adminUser);
                oos.flush();

            }

        } catch (IOException e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.SEVERE, null, e);
        }

    }*/


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

                System.out.println("\nId: " + way.getId() + "\nNo de Origem: " + way.from() + "\nNo de Destino: " + way.to() +
                        "\nDistancia em metros: " + way.weight() + "\nTempo de carro(min): " + way.weight("Car") +
                        "\nTempo de autocarro(min): " + way.weight("Bus") + "\nTempo de bicicleta(min): " + way.weight("Bike") +
                        "\nTempo a pe(min): " + way.weight("Foot"));

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

    public void printPoIs(){

        if(this.getPoIS() == null) System.out.println("\nNao existem PoI's na base de dados");

        else{

            System.out.println("\nPoI's na base de dados:");

            for(PoI poi : this.getPoIS()){

                System.out.println("\nId: " + poi.getId() + "\nIndex: " + poi.getIndex() + "\nLatitude: " + poi.getLatitude() +
                        "\nLongitude: " + poi.getLongitude() + "\nNome: " + poi.getName());

                if(poi.getTagsPoI() != null){

                    System.out.println("\nTags:");

                    Hashtable<String,String> tags = poi.getTagsPoI();
                    Set<String> keys = tags.keySet();

                    for(String key : keys){

                        System.out.println("Key: " + key + "\nValue: " + tags.get(key));

                    }

                }

            }

        }

    }


    /* Função para atualizar as etiquetas */

    public void updateTagNode(String key, String value, int id){

        Node node = searchNode(id);

        node.getTagsNode().remove(key);

        node.getTagsNode().put(key,value);

    }

    public void updateTagWay(String key, String value, int id){

        Way way = searchWay(id);

        way.getTagsWay().remove(key);

        way.getTagsWay().put(key,value);

    }

    public void updateTagPoI(String key, String value, int id){

        PoI poi = searchPoI(id);

        poi.getTagsPoI().remove(key);

        poi.getTagsPoI().put(key,value);

    }

}