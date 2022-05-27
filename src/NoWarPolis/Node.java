package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.util.Hashtable;

public class Node {

  /* Atributos da classe Node */

  private int id;

  private int index;

  private double latitude;

  private double longitude;

  private Hashtable<String,String> tagsNode;

  private RedBlackBST<Long, User> usersThatVisitedNode;


  /* Construtores da classe Node */

  public Node(){}

  public Node(int id, int index, double latitude, double longitude){

    setId(id);
    setIndex(index);
    setLatitude(latitude);
    setLongitude(longitude);

  }


  /* Gets e sets da classe Node */

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
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

  public RedBlackBST<Long, User> getUsersThatVisitedNode(){return this.usersThatVisitedNode;}


  /* Funções de inserção */

  public void addTag(String key, String value){

    if(this.getTagsNode() == null){

      Hashtable<String,String> tagsNode = new Hashtable<>();
      this.setTagsNode(tagsNode);

    }

    this.tagsNode.put(key,value);

  }

  public void userVisitedNode(long time, User user){

    if(this.usersThatVisitedNode == null){

      this.usersThatVisitedNode = new RedBlackBST<>();

    }

    this.getUsersThatVisitedNode().put(time, user);

  }

}
