package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {

  /* Atributos da classe User */

  private String name;

  private String contact;
  
  private String email;

  private String password;

  private RedBlackBST<Long, Node> nodesVisited;

  private RedBlackBST<Long, Way> waysVisited;

  private RedBlackBST<Long, PoI> PoIsVisited;


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

  public RedBlackBST<Long, Node> getNodesVisited() {
    if(this.nodesVisited == null) this.nodesVisited = new RedBlackBST<>();
    return nodesVisited;
  }

  public RedBlackBST<Long, Way> getWaysVisited() {
    if(this.waysVisited == null) this.waysVisited = new RedBlackBST<>();
    return waysVisited;
  }

  public RedBlackBST<Long, PoI> getPoIsVisited() {
    if(this.PoIsVisited == null) this.PoIsVisited = new RedBlackBST<>();
    return PoIsVisited;
  }
  

  /* Funções de visita */

  public void visitNode(BaseDeDados baseDeDados, int id){

    Node node = baseDeDados.searchNode(id);

    if(this.nodesVisited == null){

      this.nodesVisited = new RedBlackBST<>();

    }

    Date date = new Date();

    getNodesVisited().put(date.getTime(), node);
    node.userVisitedNode(date.getTime(), this);

  }

  public void visitWay(BaseDeDados baseDeDados, int id){

    Way way = baseDeDados.searchWay(id);

    if(this.waysVisited == null){

      this.waysVisited = new RedBlackBST<>();

    }

    Date date = new Date();

    getWaysVisited().put(date.getTime(), way);

  }

  public void visitPoI(BaseDeDados baseDeDados, int id){

    PoI poi = baseDeDados.searchPoI(id);

    if(this.PoIsVisited == null){

      this.PoIsVisited = new RedBlackBST<>();

    }

    Date date = new Date();

    getPoIsVisited().put(date.getTime(), poi);
    poi.userVisitedPoI(date.getTime(), this);

  }

  /* Funções de pesquisa */

  public ArrayList<PoI> searchVisitedPoI(long time1, long time2){

    ArrayList<PoI> arrayPoIs = new ArrayList<>();

    for (long key : this.getPoIsVisited().keys(time1,time2)){

        arrayPoIs.add(this.getPoIsVisited().get(key));

    }

    return arrayPoIs;

  }

  public ArrayList<PoI> searchNotVisitedPoI(BaseDeDados baseDeDados ,long time1, long time2){

    ArrayList<PoI> arrayPoIsVisited = searchVisitedPoI(time1, time2);
    ArrayList<PoI> arrayPoIsNotVisited = new ArrayList<>();

    for(PoI poi : baseDeDados.getPoIS()){

      if(!arrayPoIsVisited.contains(poi)){

        arrayPoIsNotVisited.add(poi);

      }

    }

    return arrayPoIsNotVisited;

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

    return Objects.equals(this.password, password);

  }

}
