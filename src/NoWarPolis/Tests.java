package NoWarPolis;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.*;
import java.util.ArrayList;

public class Tests {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\gonca\\IdeaProjects\\Projeto_LP2_AED2\\data\\dataset1_nodes.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();
        ArrayList<Node> nodes = new ArrayList<>();
        String[] strings;
        RedBlackBST<String,String> tagsNode = new RedBlackBST<>();

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

}
