package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.util.Hashtable;
import java.util.Objects;

public class Way extends DirectedEdge {

    /* Atributos da classe Way */

    private int id;

    private Hashtable<String,String> tagsWay;

    private RedBlackBST<Long, User> usersThatVisitedWay;


    /* Construtores da classe Node */

    public Way(int id, int idNoOrig, int idNoDest, double weight){

        super(idNoOrig,idNoDest,weight);
        setId(id);

    }


    /* Gets e sets da classe Way */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hashtable<String, String> getTagsWay() {
        return tagsWay;
    }

    public RedBlackBST<Long, User> getUsersThatVisitedWay(){return this.usersThatVisitedWay;}


    /* Funções de inserção */

    public void addTag(String key, String value){

        if(this.getTagsWay() == null){

            this.tagsWay = new Hashtable<>();

        }

        this.getTagsWay().put(key,value);

    }

    public double weight(String type){

        if(Objects.equals(type, "Bus") || Objects.equals(type, "bus")){

            return super.weight() * 0.02;

        }

        if(Objects.equals(type, "Car") || Objects.equals(type, "car")){

            return super.weight() * 0.01;

        }

        if(Objects.equals(type, "Bike") || Objects.equals(type, "bike")){

            return super.weight() * 0.04;

        }

        if(Objects.equals(type, "Foot") || Objects.equals(type, "foot")){

            return super.weight() * 0.06;

        }

        return super.weight();

    }

    public void userVisitedWay(long time, User user){

        if(this.usersThatVisitedWay == null){

            this.usersThatVisitedWay = new RedBlackBST<>();

        }

        this.getUsersThatVisitedWay().put(time, user);

    }

}