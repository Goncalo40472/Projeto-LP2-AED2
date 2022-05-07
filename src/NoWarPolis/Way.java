package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.Hashtable;

public class Way {

    /* Atributos da classe Way */

    private int id;

    private int idNoOrig;

    private int idNoDest;

    private double weight;

    private Hashtable<String,String> tagsWay;

    private RedBlackBST<Double, Way> usersThatVisitedWay;


    /* Construtores da classe Node */

    public Way(){}

    public Way(int id, int idNoOrig, int idNoDest, double weight, Hashtable<String,String> tagsWay){

        setId(id);
        setIndNoOrig(idNoOrig);
        setIndNoDest(idNoDest);
        setWeight(weight);
        setInfo(tagsWay);

    }


    /* Gets e sets da classe Way */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndNoOrig() {
        return idNoOrig;
    }

    public void setIndNoOrig(int indNoOrig) {
        this.idNoOrig = indNoOrig;
    }

    public int getIndNoDest() {
        return idNoDest;
    }

    public void setIndNoDest(int indNoDest) {
        this.idNoDest = indNoDest;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Hashtable<String, String> getInfo() {
        return tagsWay;
    }

    public void setInfo(Hashtable<String, String> tagsWay) {
        this.tagsWay = tagsWay;
    }

}