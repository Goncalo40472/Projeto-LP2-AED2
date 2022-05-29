package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.*;
import java.util.ArrayList;

public class Tests{

    public static void main(String[] args) throws IOException {

        BaseDeDados baseDeDados = new BaseDeDados();

        testFillBaseDeDados(baseDeDados);   /* Função para testar o populamento da base de dados */
        testLogin(baseDeDados);             /* Função para testar o funcionamento do login */
        testGraph(baseDeDados);             /* Função para testar as funcionalidades do grafo */
        testFuncoesBD(baseDeDados);         /* Função para testar as funções da base de dados */

    }

    private static void testFillBaseDeDados(BaseDeDados baseDeDados) throws IOException {

        System.out.println("\n########################################");
        System.out.println("Testando o populamento da base de dados...");

        baseDeDados.addAdminUser("Goncalo", "931373115", "40472@ufp.edu.pt", "123456");
        baseDeDados.addUser("Francisco", "919874612", "42311@ufp.edu.pt", "12382397");
        baseDeDados.printUsers();

        baseDeDados.readNodes("data/nodes_test.txt");
        //baseDeDados.readNodesBin();
        baseDeDados.printNodes();

        baseDeDados.readWays("data/ways_test.txt");
        //baseDeDados.readWaysBin();
        baseDeDados.printWays();

        baseDeDados.readPoIs("data/pois_test.txt");
        //baseDeDados.readPoIsBin();
        baseDeDados.printPoIs();

        baseDeDados.writeNodesTxt();
        baseDeDados.writeWaysTxt();
        baseDeDados.writePoIsTxt();

        //baseDeDados.writeNodesBin();
        //baseDeDados.writeWaysBin();
        //baseDeDados.writePoIsBin();

        System.out.println("\nFim do teste");
        System.out.println("##############################################");
    }

    public static void testFuncoesBD(BaseDeDados baseDeDados){

        System.out.println("\n##############################################");
        System.out.println("Testando as funcoes da base de dados...");

        baseDeDados.removeNode(4);
        baseDeDados.updateTagNode("cars", "2", 0);

        ArrayList<PoI> pois = baseDeDados.top5VisitedPoIs(0, 10000000000000000L);
        ArrayList<User> users = baseDeDados.top5Visitors(0, 10000000000000000L);

        System.out.println("\nTop 5 dos PoIs mais visitados:\n");

        for(PoI poi : pois){

            System.out.println("Nome PoI: " + poi.getName());

        }

        System.out.println("\nTop 5 dos users que mais visitaram PoIs:\n");

        for(User user : users){

            System.out.println("Nome: " + user.getName());

        }

        ArrayList<Node> nodes = baseDeDados.searchNodeWithTag("bus", "yes");
        ArrayList<Way> ways = baseDeDados.searchWayWithTag("bus", "yes");

        System.out.println("\nNos com a etiqueta (bus,yes):\n");

        for(Node node : nodes){

            System.out.println("Id no: " + node.getId());

        }

        System.out.println("\nWays com a etiqueta (bus,yes):\n");

        for(Way way : ways){

            System.out.println("Id way: " + way.getId());

        }

        ArrayList<PoI> nvPoIs = baseDeDados.searchNotVisitedPoIs(0, 10000000000000000L);

        System.out.println("\nPoIs nao visitados:\n");

        for(PoI poi : nvPoIs){

            System.out.println("Nome PoI: " + poi.getName());

        }

        System.out.println("\nUsers que visitaram o PoI com o id 1:\n");

        PoI p = baseDeDados.searchPoI(1);
        ArrayList<User> arrayUsers = p.searchVisitors(0, 10000000000000000L);

        for(User user : arrayUsers){

            System.out.println("Nome: " + user.getName());

        }

        baseDeDados.now();

        System.out.println("\nFim do teste");
        System.out.println("##############################################");

    }

    public static void testLogin(BaseDeDados baseDeDados){

        System.out.println("\n###########################################");
        System.out.println("Testando login...");

        Login login = new Login();

        System.out.println("\nLogin com admin user como basic user:");
        login.logUser("40472@ufp.edu.pt", "123456", baseDeDados);

        System.out.println("\nLogin com admin user como admin user:");
        AdminUser adminUser = login.logAdminUser("40472@ufp.edu.pt", "123456", baseDeDados);

        System.out.println("\nLogin com basic user como admin user:");
        login.logAdminUser("42311@ufp.edu.pt", "12382397", baseDeDados);

        System.out.println("\nLogin com basic user como basic user:");
        User user = login.logUser("42311@ufp.edu.pt", "12382397", baseDeDados);

        System.out.println("\nLogin password errada:");
        login.logUser("42311@ufp.edu.pt", "123", baseDeDados);

        adminUser.visitPoI(baseDeDados, 1);
        user.visitPoI(baseDeDados, 2);

        System.out.println("\nPoIs visitados pelo user:\n");

        ArrayList<PoI> pois = user.searchVisitedPoI(0, 10000000000000000L);

        for(PoI poi : pois){

            System.out.println("Nome PoI: " + poi.getName());

        }

        System.out.println("\nPoIs não visitados pelo user:\n");

        ArrayList<PoI> pois2 = user.searchNotVisitedPoI(baseDeDados,0, 10000000000000000L);

        for(PoI poi : pois2){

            System.out.println("Nome PoI: " + poi.getName());

        }

        System.out.println("\nFim do teste");
        System.out.println("##############################################");
    }

    public static void testGraph(BaseDeDados baseDeDados){

        System.out.println("\n###########################################");
        System.out.println("Testando diversas funcionalidades do grafo...");

        Map graph = new Map(baseDeDados.getNodes().size(), baseDeDados);

        for(Way way : baseDeDados.getWays()){

            graph.addWayToGraph(way);

        }

        RedBlackBST<Double, Node> closestTS = graph.top5ClosestTS(0, 0);

        System.out.println("\nSemaforos mais proximos da coordenada 0,0:");

        for(Double key : closestTS.keys()){

            System.out.println("\nDistancia: " + key + "\nId Node: " + closestTS.get(key).getId());

        }

        System.out.println("\nGrafo: " +  graph);

        System.out.println("\nCaminho mais curto de 0 para 1:\n" + graph.findShortestPath(0,2));
        System.out.println("\nO grafo é conexo?\nR: " + graph.isGraphConnected());

        System.out.println("\nCaminho mais curto de 0 para 2 evitando comboios:\n" + graph.findSPAvoidingSet(0, 2, graph.setOfNodes("train")));

        Map subgraph = graph.createSubgraph("highway", "residential");

        System.out.println("\nSubgrafo: " +  subgraph);

        System.out.println("\nCaminho mais curto de 0 para 1 no subgrafo:\n" + subgraph.findShortestPath(0,2));
        System.out.println("\nO subgrafo é conexo?\nR: " + subgraph.isGraphConnected());

        System.out.println("\nFim do teste");
        System.out.println("##############################################");

    }

}
