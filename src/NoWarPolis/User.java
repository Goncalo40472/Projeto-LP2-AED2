package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class User {

  /* Atributos da classe User */

  private String name;

  private String contact;
  
  private String email;

  private String password;

  private RedBlackBST<Double, Node> nodesVisited;

  private RedBlackBST<Double, Way> waysVisited;

  private RedBlackBST<Double, PoI> PoIsVisited;


  /* Construtores da classe User */

  public User() {
  }

  public User(String name, String contact, String email, String password) {

    setName(name);
    setContact(contact);
    setEmail(email);
    setPassword(password);

  }


  /* Gets e sets da classe User */

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

  public void setPassword(String password) {
    this.password = password;
  }

  public RedBlackBST<Double, Node> getNodesVisited() {
    return nodesVisited;
  }

  public RedBlackBST<Double, Way> getWaysVisited() {
    return waysVisited;
  }

  public RedBlackBST<Double, PoI> getPoIsVisited() {
    return PoIsVisited;
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

  public ArrayList<Node> searchTagNodes(BaseDeDados baseDeDados, String tag){

    return baseDeDados.searchTagNodes(tag);

  }

  public ArrayList<Way> searchTagWays(BaseDeDados baseDeDados, String tag){

    return baseDeDados.searchTagWays(tag);

  }

  public ArrayList<PoI> searchTagPoIs(BaseDeDados baseDeDados, String tag){

    return baseDeDados.searchTagPoIs(tag);

  }

  public Node searchNode(BaseDeDados baseDeDados, int id){

    return baseDeDados.searchNode(id);

  }

  public Way searchWay(BaseDeDados baseDeDados, int id){

    return baseDeDados.searchWay(id);

  }

  public PoI searchPoI(BaseDeDados baseDeDados, int id){

    return baseDeDados.searchPoI(id);

  }

  public User searchUser(BaseDeDados baseDeDados, String email){

    return baseDeDados.searchUser(email);

  }

  public AdminUser searchAdminUser(BaseDeDados baseDeDados, String email){

    return baseDeDados.searchAdminUser(email);

  }

  public boolean checkPassword(String password){

    return this.password == password;

  }

}
