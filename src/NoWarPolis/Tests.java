package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Tests {

    public static void main(String[] args) throws IOException {

        testNodes();

    }

    private static void testNodes() throws IOException {

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\dataset1_nodes.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        ArrayList<Node> nodes = new ArrayList<>();
        String[] strings;
        Hashtable<String,String> tagsNode = new Hashtable<>();

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            double lat = Double.parseDouble(strings[1]);
            double lon = Double.parseDouble(strings[2]);

            if(strings.length == 3){

                Node node = new Node(id, lat, lon);
                nodes.add(node);

            }else{

                for(int i = 3; i < strings.length; i += 2){

                    tagsNode.put(strings[i], strings[i+1]);

                }

                Node node = new Node(id, lat, lon, tagsNode);
                nodes.add(node);

            }

        }

    }

    private static void testWays() throws IOException {

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\dataset1_ways_nodepairs.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        ArrayList<Way> ways = new ArrayList<>();
        String[] strings;
        Hashtable<String,String> tagsWay = new Hashtable<>();

        while((st = br.readLine()) != null){

            strings = st.split(",");
            int id = Integer.parseInt(strings[0]);
            int idNoOrig = Integer.parseInt(strings[1]);
            int idNoDest = Integer.parseInt(strings[2]);
            double weight = Double.parseDouble(strings[3]);

            for(int i = 4; i < strings.length; i += 2){

                tagsWay.put(strings[i], strings[i+1]);

            }

            Way way = new Way(id, idNoOrig, idNoDest, weight, tagsWay);
            ways.add(way);

        }

    }

}
