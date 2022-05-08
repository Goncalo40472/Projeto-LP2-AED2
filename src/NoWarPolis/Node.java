package NoWarPolis;

import edu.princeton.cs.algs4.ST;

public class Node {

  /* Atributos da classe Node */

  private int id;
  
  private double id_coord;

  private double latitude;

  private double longitude;

  //private Hashtable<String,String> tagsNode;
  private ST<String,String> tagsNode;

  //private RedBlackBST<Double, Node> usersThatVisitedNode;
  private ST<Double, Node> usersThatVisitedNode;


  /* Construtores da classe Node */

  public Node(){}

  public Node(int id, double id_coord, double latitude, double longitude){

    setId(id);
    setId_coord(id_coord);
    setLatitude(latitude);
    setLongitude(longitude);

  }

  public Node(int id, double id_coord, double latitude, double longitude, ST<String,String> tagsNode){

    setId(id);
    setId_coord(id_coord);
    setLatitude(latitude);
    setLongitude(longitude);
    setTagsNode(tagsNode);

  }


  /* Gets e sets da classe Node */

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
  
   public double getId_coord() {
    return id_coord;
  }

  public void setId_coord(double id_coord) {
    this.id_coord = id_coord;
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

  public ST<String, String> getTagsNode() {
    return tagsNode;
  }

  public void setTagsNode(ST<String, String> tagsNode) {
    this.tagsNode = tagsNode;
  }


  /* Funções de inserção */

  public void addTag(String key, String value){

    if(this.getTagsNode() == null){

      ST<String,String> tagsNode = new ST<>();
      this.setTagsNode(tagsNode);

    }

    this.tagsNode.put(key,value);

  }

}
