package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

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

    public Way(int id, int idNoOrig, int idNoDest, double weight){

        setId(id);
        setIdNoOrig(idNoOrig);
        setIdNoDest(idNoDest);
        setWeight(weight);

    }


    /* Gets e sets da classe Way */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNoOrig() {
        return idNoOrig;
    }

    public void setIdNoOrig(int indNoOrig) {
        this.idNoOrig = indNoOrig;
    }

    public int getIdNoDest() {
        return idNoDest;
    }

    public void setIdNoDest(int indNoDest) {
        this.idNoDest = indNoDest;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Hashtable<String, String> getInfo() {
        return getTagsWay();
    }

    public void setInfo(Hashtable<String, String> tagsWay) {
        this.setTagsWay(tagsWay);
    }

    public Hashtable<String, String> getTagsWay() {
        return tagsWay;
    }

    public void setTagsWay(Hashtable<String, String> tagsWay) {
        this.tagsWay = tagsWay;
    }

    public RedBlackBST<Double, Way> getUsersThatVisitedWay() {
        return usersThatVisitedWay;
    }

    public void setUsersThatVisitedWay(RedBlackBST<Double, Way> usersThatVisitedWay) {
        this.usersThatVisitedWay = usersThatVisitedWay;
    }


    /* Funções de inserção */

    public void addTag(String key, String value){

        if(this.getTagsWay() == null){

            Hashtable<String,String> tagsWay = new Hashtable<>();
            this.setTagsWay(tagsWay);

        }

        this.getTagsWay().put(key,value);

    }

}