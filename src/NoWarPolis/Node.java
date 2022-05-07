package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.Hashtable;

public class Node {

  /* Atributos da classe Node */

  private int id;

  private double latitude;

  private double longitude;

  private Hashtable<String,String> tagsNode;

  private RedBlackBST<Double, Node> usersThatVisitedNode;


  /* Construtores da classe Node */

  public Node(){}

  public Node(int id, double latitude, double longitude){

    setId(id);
    setLatitude(latitude);
    setLongitude(longitude);

  }

  public Node(int id, double latitude, double longitude, Hashtable<String,String> tagsNode){

    setId(id);
    setLatitude(latitude);
    setLongitude(longitude);
    setTagsNode(tagsNode);

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

  public Hashtable<String, String> getTagsNode() {
    return tagsNode;
  }

  public void setTagsNode(Hashtable<String, String> tagsNode) {
    this.tagsNode = tagsNode;
  }

}