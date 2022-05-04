package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

public class PoI extends Node {

    /* Atributos da classe PoI */

    private String name;

    private RedBlackBST<String,String> tagsPoI;


    /* Construtores da classe PoI */

    public PoI(){}

    public PoI(String name, RedBlackBST<String,String> tagsPoI){

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

    public RedBlackBST<String, String> getTagsPoI() {
        return tagsPoI;
    }

    public void setTagsPoI(RedBlackBST<String, String> tagsPoI) {
        this.tagsPoI = tagsPoI;
    }

}