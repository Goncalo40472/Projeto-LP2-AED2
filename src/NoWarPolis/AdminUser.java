package NoWarPolis;

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

        baseDeDados.removeNode(id);

    }

    public void removeWay(BaseDeDados baseDeDados, int id){

        baseDeDados.removeWay(id);

    }

    public void removePoI(BaseDeDados baseDeDados, int id){

        baseDeDados.removePoI(id);

    }

    public void removeUser(BaseDeDados baseDeDados, String name){

        baseDeDados.removeUser(name);

    }

    public void removeAdminUser(BaseDeDados baseDeDados, String name){

        baseDeDados.removeAdminUser(name);

    }

}
