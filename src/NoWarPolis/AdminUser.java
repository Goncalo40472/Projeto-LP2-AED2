package NoWarPolis;

import java.util.ArrayList;
import java.util.List;

public class AdminUser extends User{

    public AdminUser(String name, String contact, String email, String password){

        super(name,contact,email,password);

    }


    /* Funções de inserção */

    public void addNodeToBD(BaseDeDados baseDeDados ,Node node){

        baseDeDados.addNode(node);

    }

    public void addWayToBD(BaseDeDados baseDeDados ,Way way){

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

}
