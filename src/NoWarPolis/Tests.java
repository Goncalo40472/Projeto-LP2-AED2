package NoWarPolis;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;

import java.io.*;
import java.util.ArrayList;

public class Tests {

    public static void main(String[] args) throws IOException {

        BaseDeDados baseDeDados = new BaseDeDados();
        testNodes(baseDeDados);
        testWays(baseDeDados);
        testPoI(baseDeDados);
        testUsers(baseDeDados);
        testAdminUsersFunctions(baseDeDados);
        now(baseDeDados);

        Map map = new Map(2);

        DirectedEdge de = new DirectedEdge(0,1,10);
        DirectedEdge de2 = new DirectedEdge(1,0,5);
        map.graph.addEdge(de);
        map.graph.addEdge(de2);

    }

    private static void testNodes(BaseDeDados baseDeDados) throws IOException {

        System.out.println("\n\nTest Nodes");

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\nodes_test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            double id_coord = Double.parseDouble(strings[1]);
            double lat = Double.parseDouble(strings[2]);
            double lon = Double.parseDouble(strings[3]);

            Node node = new Node(id, id_coord, lat, lon);

            System.out.println("\n\nId: " + node.getId() + "\nId Coordenada: " + node.getId_coord() + "\nLatitude: " + node.getLatitude()
                    + "\nLongitude: " + node.getLongitude());

            if(strings.length > 4){

                for(int i = 4; i < strings.length; i += 2){

                    node.addTag(strings[i], strings[i+1]);
                    baseDeDados.addTag(strings[i], strings[i+1]);

                }

            }

            baseDeDados.addNode(node);

        }

    }

    private static void testWays(BaseDeDados baseDeDados) throws IOException {

        System.out.println("\n\nTest Ways");

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\ways_test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            int idNoOrig = Integer.parseInt(strings[1]);
            int idNoDest = Integer.parseInt(strings[2]);
            double weight = Double.parseDouble(strings[3]);

            Way way = new Way(id,idNoOrig,idNoDest,weight);

            System.out.println("\n\nId: " + way.getId() + "\nId No Origem: " + way.from() + "\nId No Destino: " + way.to()
                    + "\nPeso: " + way.weight());

            if(strings.length > 4){

                for(int i = 4; i < strings.length; i += 2){

                    way.addTag(strings[i], strings[i+1]);
                    baseDeDados.addTag(strings[i], strings[i+1]);

                }

            }

            baseDeDados.addWay(way);

        }

    }

    private static void testPoI(BaseDeDados baseDeDados) throws IOException {

        System.out.println("\n\nTest PoIs");

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\pois_test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        /*In in = new In(file);

        in.readLine();

        int a = in.readInt();
        System.out.println("\nInputaço " + a);

        in.readInt();

        double d = in.readDouble();
        System.out.println("\nInputinho " + d);*/

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            double id_coord = Integer.parseInt(strings[1]);
            double lat = Double.parseDouble(strings[2]);
            double lon = Double.parseDouble(strings[3]);
            String name = strings[4];

            PoI poi = new PoI(id, id_coord, lat, lon, name);

            System.out.println("\n\nId: " + poi.getId() + "\nId Coordenada: " + poi.getId_coord() + "\nLatitude: " + poi.getLatitude()
                    + "\nLongitude: " + poi.getLongitude() + "\nNome: " + poi.getName());

            if(strings.length != 5){

                for(int i = 3; i < strings.length; i += 2){

                    poi.addTag(strings[i], strings[i+1]);
                    baseDeDados.addTag(strings[i], strings[i+1]);

                }

            }

            baseDeDados.addPoI(poi);

        }

    }

    private static void testUsers(BaseDeDados baseDeDados) throws IOException{

        System.out.println("\n\nTest Users");

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\users_test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        String[] strings;

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            String name = strings[1];
            String contact = strings[2];
            String email = strings[3];

            User user = new User(id, name, contact, email);

            System.out.println("\n\nId: " + user.getId() + "\nNome: " + user.getName() + "\nContacto: " + user.getContact()
                    + "\nEmail: " + user.getEmail());

            baseDeDados.addUser(user);

        }

    }

    private static void testAdminUsersFunctions(BaseDeDados baseDeDados) {

        AdminUser adminUser = new AdminUser(40472, "Goncalo", "912381321", "40472@ufp.edu.pt");
        baseDeDados.addUser(adminUser);

        PoI poi = baseDeDados.searchPoI(1);

        adminUser.visitPoI(100, poi);
        ArrayList<PoI> arrayPoIsVis = adminUser.searchVisitedPoI(50, 100);

        System.out.println("\n\nPoIs visitados entre 50 e 100:\n");

        for (PoI arrayPoIsVi : arrayPoIsVis) {

            System.out.println(arrayPoIsVi.getName());

        }

    }

    private static void now(BaseDeDados baseDeDados){

        for(PoI poi : baseDeDados.getPoIS()){

            System.out.println("\n\nId: " + poi.getId() + "\nId Coordenada: " + poi.getId_coord() + "\nLatitude: " + poi.getLatitude()
                    + "\nLongitude: " + poi.getLongitude() + "\nNome do PoI: " + poi.getName());

            if(poi.getUsersThatVisitedPoI() != null){

                for(double time : poi.getUsersThatVisitedPoI().keys()){

                    User user = poi.getUsersThatVisitedPoI().get(time);

                    System.out.println("\nNome Utilizador " + user.getName());

                }

            }

        }

    }

}
