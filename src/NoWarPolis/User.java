package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class User{

  /* Atributos da classe User */

  private int id;

  private String name;

  private String contact;
  
  private String email;

  private RedBlackBST<Double, Node> nodesVisited;

  private RedBlackBST<Double, Way> waysVisited;

  private RedBlackBST<Double, PoI> PoIsVisited;


  /* Construtores da classe User */

  public User() {
  }

  public User(int id, String name, String contact, String email) {

    setId(id);
    setName(name);
    setContact(contact);
    setEmail(email);

  }


  /* Gets e sets da classe User */

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
  
   public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RedBlackBST<Double, Node> getNodesVisited() {
    return nodesVisited;
  }

  public void setNodesVisited(RedBlackBST<Double, Node> nodesVisited) {
    this.nodesVisited = nodesVisited;
  }

  public RedBlackBST<Double, Way> getWaysVisited() {
    return waysVisited;
  }

  public void setWaysVisited(RedBlackBST<Double, Way> waysVisited) {
    this.waysVisited = waysVisited;
  }

  public RedBlackBST<Double, PoI> getPoIsVisited() {
    return PoIsVisited;
  }

  public void setPoIsVisited(RedBlackBST<Double, PoI> poIsVisited) {
    PoIsVisited = poIsVisited;
  }
  

  /* Funções de visita */

  public void visitNode(double time, Node node){

    if(this.nodesVisited == null){

      this.nodesVisited = new RedBlackBST<>();

    }

    getNodesVisited().put(time, node);

  }

  public void visitWay(double time, Way way){

    if(this.waysVisited == null){

      this.waysVisited = new RedBlackBST<>();

    }

    getWaysVisited().put(time, way);

  }

  public void visitPoI(double time, PoI poi){

    if(this.PoIsVisited == null){

      this.PoIsVisited = new RedBlackBST<>();

    }

    getPoIsVisited().put(time, poi);
    poi.userVisitedPoI(time, this);

  }

  /* Funções de pesquisa */

  public ArrayList<PoI> searchVisitedPoI(double time1, double time2){

    ArrayList<PoI> arrayPoIs = new ArrayList<>();

    for (double key : this.getPoIsVisited().keys(time1,time2)){

        arrayPoIs.add(this.getPoIsVisited().get(key));

    }

    return arrayPoIs;

  }

}
