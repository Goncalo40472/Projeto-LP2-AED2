package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.Hashtable;

public class PoI extends Node {

    /* Atributos da classe PoI */

    private String name;

    private Hashtable<String,String> tagsPoI;

    private RedBlackBST<Double, User> usersThatVisitedPoI;


    /* Construtores da classe PoI */

    public PoI(){}

    public PoI(int id, double id_coord, double latitude, double longitude, String name){

        super(id,id_coord,latitude,longitude);
        setName(name);

    }

    public PoI(int id, double id_coord, double latitude, double longitude, String name, Hashtable<String,String> tagsPoI){

        super(id,id_coord,latitude,longitude);
        setName(name);
        setTagsPoI(tagsPoI);

    }

    /* Gets e sets da classe PoI */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<String, String> getTagsPoI() {
        return tagsPoI;
    }

    public void setTagsPoI(Hashtable<String, String> tagsPoI) {
        this.tagsPoI = tagsPoI;
    }

    public RedBlackBST<Double, User> getUsersThatVisitedPoI() {
        return usersThatVisitedPoI;
    }


    /* Funções de inserção */

    public void userVisitedPoI(double time, User user){

        usersThatVisitedPoI.put(time,user);

    }

    public void addTag(String key, String value){

        if(this.getTagsPoI() == null){

            Hashtable<String,String> tagsPoI = new Hashtable<>();
            this.setTagsPoI(tagsPoI);

        }

        this.tagsPoI.put(key,value);

    }


}