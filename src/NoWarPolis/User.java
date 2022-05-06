package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.List;

public class User {

  /* Atributos da classe User */

  private int id;

  private String name;

  private String contact;

  private RedBlackBST<Double, Node> nodesVisited;

  private RedBlackBST<Double, Way> waysVisited;

  private RedBlackBST<Double, PoI> PoIsVisited;


  /* Construtores da classe User */

  public User() {
  }

  public User(int id, String name, String contact) {

    setId(id);
    setName(name);
    setContact(contact);

  }


  /* Gets e sets da classe User */

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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


  /* Funções */

  public void visitNode(double time, Node node){

    nodesVisited.put(time, node);

  }

  public void visitWay(double time, Way way){

    waysVisited.put(time, way);

  }

  public void visitPoI(double time, PoI poi){

    PoIsVisited.put(time, poi);

  }

}