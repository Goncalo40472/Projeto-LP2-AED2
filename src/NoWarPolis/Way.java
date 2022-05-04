package NoWarPolis;

import java.util.Hashtable;

public class Way {

    /* Atributos da classe Way */

    private int indNoOrig;

    private int indNoDest;

    private float weight;

    private Hashtable<String,String> info;


    /* Construtores da classe Node */

    public Way(){}

    public Way(int indNoOrig, int indNoDest, float weight, Hashtable<String,String> info){

        setIndNoOrig(indNoOrig);
        setIndNoDest(indNoDest);
        setWeight(weight);
        setInfo(info);

    }


    /* Gets e sets da classe Way */

    public int getIndNoOrig() {
        return indNoOrig;
    }

    public void setIndNoOrig(int indNoOrig) {
        this.indNoOrig = indNoOrig;
    }

    public int getIndNoDest() {
        return indNoDest;
    }

    public void setIndNoDest(int indNoDest) {
        this.indNoDest = indNoDest;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Hashtable<String, String> getInfo() {
        return info;
    }

    public void setInfo(Hashtable<String, String> info) {
        this.info = info;
    }

}