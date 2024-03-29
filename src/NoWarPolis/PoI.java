package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class PoI extends Node implements Serializable {

    /* Atributos da classe PoI */

    private String name;

    private Hashtable<String,String> tagsPoI;

    private RedBlackBST<Long, User> usersThatVisitedPoI;


    /* Construtores da classe PoI */

    public PoI(){}

    public PoI(int id, int index, double latitude, double longitude, String name){

        super(id, index, latitude,longitude);
        setName(name);
        this.tagsPoI = new Hashtable<>();

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

    public RedBlackBST<Long, User> getUsersThatVisitedPoI() {
        return usersThatVisitedPoI;
    }


    /* Funções de inserção */

    public void userVisitedPoI(long time, User user){

        if(this.getUsersThatVisitedPoI() == null){

            this.usersThatVisitedPoI = new RedBlackBST<>();

        }

        this.usersThatVisitedPoI.put(time,user);

    }

    public void addTag(String key, String value){

        if(this.getTagsPoI() == null){

            Hashtable<String,String> tagsPoI = new Hashtable<>();
            this.setTagsPoI(tagsPoI);

        }

        this.tagsPoI.put(key,value);

    }

    public ArrayList<User> searchVisitors(long time1, long time2){

        ArrayList<User> arrayUsers = new ArrayList<>();

        if(this.usersThatVisitedPoI == null){

            this.usersThatVisitedPoI = new RedBlackBST<>();

        }

        for (long key : this.getUsersThatVisitedPoI().keys(time1,time2)){

            arrayUsers.add(this.getUsersThatVisitedPoI().get(key));

        }

        return arrayUsers;

    }

}