package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;
import java.util.List;

public class User{

  /* Atributos da classe User */

  private int id;

  private String name;

  private String contact;
  
  private String email;

  private ST<Double, Node> nodesVisited;

  private ST<Double, Way> waysVisited;

  private ST<Double, PoI> PoIsVisited;


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
  
  


  /* Funções de visita */

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
