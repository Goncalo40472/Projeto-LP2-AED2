package NoWarPolis;

import edu.princeton.cs.algs4.*;

import java.util.Hashtable;

public class Way extends DirectedEdge {

    /* Atributos da classe Way */

    private int id;

    private Hashtable<String,String> tagsWay;

    private RedBlackBST<Double, String> weights;


    /* Construtores da classe Node */

    public Way(int id, int idNoOrig, int idNoDest, double weight){

        super(idNoOrig,idNoDest,weight);
        setId(id);
        this.weights = new RedBlackBST<>();
        timeOnBus();
        timeOnCar();
        timeOnBike();
        timeOnFoot();

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


    /* Funções de inserção */

    public void addTag(String key, String value){

        if(this.getTagsWay() == null){

            Hashtable<String,String> tagsWay = new Hashtable<>();
            this.tagsWay = tagsWay;

        }

        this.getTagsWay().put(key,value);

    }

    public void timeOnBus(){

        double time = this.weight() * 0.02;
        this.weights.put(time, "Bus");

    }

    public void timeOnCar(){

        double time = this.weight() * 0.01;
        this.weights.put(time, "Car");

    }

    public void timeOnBike(){

        double time = this.weight() * 0.04;
        this.weights.put(time, "Bike");

    }

    public void timeOnFoot(){

        double time = this.weight() * 0.06;
        this.weights.put(time, "Foot");

    }

}