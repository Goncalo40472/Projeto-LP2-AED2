package NoWarPolis;

import java.util.ArrayList;

public class AdminUser extends User{

    public AdminUser(int id, String name, String contact, String email){

        super(id,name,contact,email);

    }


    /* Funções de inserção */

    public void addNode(BaseDeDados baseDeDados ,Node node){

        baseDeDados.addNode(node);

    }

    public void addWay(BaseDeDados baseDeDados ,Way way){

        baseDeDados.addWay(way);

    }

    public void addPoI(BaseDeDados baseDeDados ,PoI poi){

        baseDeDados.addPoI(poi);

    }


    /* Funções de remoção */

    public void removeNode(BaseDeDados baseDeDados, int id){

        Node node = baseDeDados.searchNode(id);
        baseDeDados.removeNode(node);

    }

    public void removeWay(BaseDeDados baseDeDados, int id){

        Way way = baseDeDados.searchWay(id);
        baseDeDados.removeWay(way);

    }

    public void removePoI(BaseDeDados baseDeDados, int id){

        PoI poi = baseDeDados.searchPoI(id);
        baseDeDados.removePoI(poi);

    }

    public void removeUser(BaseDeDados baseDeDados, String name){

        User user = baseDeDados.searchUser(name);
        baseDeDados.removeUser(user);

    }


    /* Funções de pesquisa */

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

    public User searchUser(BaseDeDados baseDeDados, String name){

        return baseDeDados.searchUser(name);

    }

    public ArrayList<PoI> searchNotVisitedPoIs(BaseDeDados baseDeDados, double time1, double time2){

        ArrayList<PoI> arrayPoIs = baseDeDados.getPoIS();
        PoI poi = new PoI();

        for (double key : this.getPoIsVisited().keys(time1,time2)){

            poi = this.getPoIsVisited().get(key);
            arrayPoIs.remove(poi);

        }

        return arrayPoIs;

    }

}
