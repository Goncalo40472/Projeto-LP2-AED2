package NoWarPolis;

import edu.princeton.cs.algs4.DirectedEdge;

import java.io.*;
import java.util.ArrayList;

public class Tests{

    public static void main(String[] args) throws IOException {

        BaseDeDados baseDeDados = new BaseDeDados();

        testFillBaseDeDados(baseDeDados);   /* Função para testar o populamento da base de dados */
        testLogin(baseDeDados);             /* Função para testar o funcionamento do login */
        testGraph(baseDeDados);             /* Função para testar as funcionalidades do grafo */

        //baseDeDados.now();                  /* Método que imprime o estado atual de todos os PoI's */


    }

    private static void testFillBaseDeDados(BaseDeDados baseDeDados) throws IOException {

        System.out.println("\n########################################");
        System.out.println("Testando o populamento da base de dados...");

        baseDeDados.addAdminUser("Goncalo", "931373115", "40472@ufp.edu.pt", "123456");
        baseDeDados.addUser("Francisco", "919874612", "42311@ufp.edu.pt", "12382397");
        baseDeDados.printUsers();

        //baseDeDados.readNodes("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\nodes_test.txt");
        baseDeDados.readNodesBin();
        baseDeDados.printNodes();

        baseDeDados.readWays("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\ways_test.txt");
        baseDeDados.printWays();

        baseDeDados.readPoIs("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\pois_test.txt");
        baseDeDados.printPoIs();

        baseDeDados.writeNodesTxt();
        baseDeDados.writeWaysTxt();
        baseDeDados.writePoIsTxt();
        baseDeDados.writeNodesBin();

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
        login.logAdminUser("40472@ufp.edu.pt", "123456", baseDeDados);

        System.out.println("\nLogin com basic user como admin user:");
        login.logAdminUser("42311@ufp.edu.pt", "12382397", baseDeDados);

        System.out.println("\nLogin com basic user como basic user:");
        login.logUser("42311@ufp.edu.pt", "12382397", baseDeDados);

        System.out.println("\nLogin password errada:");
        login.logUser("42311@ufp.edu.pt", "123", baseDeDados);

        System.out.println("\nFim do teste");
        System.out.println("##############################################");
    }

    public static void testGraph(BaseDeDados baseDeDados){

        System.out.println("\n###########################################");
        System.out.println("Testando diversas funcionalidades do grafo...");

        Map map = new Map(baseDeDados.getNodes().size(), baseDeDados);

        for(Way way : baseDeDados.getWays()){

            map.addWayToGraph(way);

        }

        System.out.println("\nGrafo: " +  map);

        System.out.println("\nCaminho mais curto de 0 para 1:\n" + map.findShortestPath(0,1));
        System.out.println("\nO grafo é conexo?\nR: " + map.isGraphConnected());

        System.out.println("\nFim do teste");
        System.out.println("##############################################");

    }

}
