package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class Node {

  /* Atributos da classe Node */

  private int id;

  private double latitude;

  private double longitude;

  private RedBlackBST<String,String> tagsNode;

  private ArrayList<PoI> listOfPoIs;


  /* Construtores da classe Node */

  public Node(){}

  public Node(int id, double latitude, double longitude){

    setId(id);
    setLatitude(latitude);
    setLongitude(longitude);

  }

  public Node(int id, double latitude, double longitude, RedBlackBST<String,String> tagsNode){

    setId(id);
    setLatitude(latitude);
    setLongitude(longitude);
    setTagsNode(tagsNode);

  }

  public Node(int id, double latitude, double longitude, RedBlackBST<String,String> tagsNode, ArrayList<PoI> listOfPoIs){

    setId(id);
    setLatitude(latitude);
    setLongitude(longitude);
    setTagsNode(tagsNode);
    setListOfPoIs(listOfPoIs);

  }


  /* Gets e sets da classe Node */

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public RedBlackBST<String, String> getTagsNode() {
    return tagsNode;
  }

  public void setTagsNode(RedBlackBST<String, String> tagsNode) {
    this.tagsNode = tagsNode;
  }

  public ArrayList<PoI> getListOfPoIs() {
    return listOfPoIs;
  }

  public void setListOfPoIs(ArrayList<PoI> listOfPoIs) {
    this.listOfPoIs = listOfPoIs;
  }

}