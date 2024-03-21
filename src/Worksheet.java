import java.util.*;

/**
 * Node class to answer problem 1 -  huffman tree
 */
class HuffmanNode{
    char c;
    int freq;
    String path;

    public HuffmanNode(char c, int freq, String path){
        this.c = c;
        this.freq = freq;
        this.path = path;
    }
}

/**
 * Node class for B-tree
 */
class BNode{
    List data;
    List<BNode> children;

    public BNode(List data){
        this.data = data;
        this.children = new ArrayList<BNode>();
    }
    public void setChildren(List<BNode> children){
        this.children = children;
    }

    public void addChildren(BNode node){
        this.children.add(node);
    }
}




/**
 * Java file that stores answers to problem 1(huffman encoding) and problem 2(B-tree)
 */
public class Worksheet {


    /**
     * Answer to q1(a)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1aEncodeChar(){
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('d', 1, "01011"));
        nodeList.add(new HuffmanNode('s', 1, "10001"));
        nodeList.add(new HuffmanNode('c', 1, "010001"));
        nodeList.add(new HuffmanNode('1', 1, "10000"));
        nodeList.add(new HuffmanNode('3', 1, "01000"));
        nodeList.add(new HuffmanNode('4', 1, "01010"));
        nodeList.add(new HuffmanNode('5', 1, "100110"));
        System.out.println("I give up");
        return nodeList;
    }

    /**
     * Answer to q1(b)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1bEncodeChar(){
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('d', 1, "01011"));
        nodeList.add(new HuffmanNode('s', 1, "10001"));
        nodeList.add(new HuffmanNode('c', 1, "010001"));
        nodeList.add(new HuffmanNode('1', 1, "10000"));
        nodeList.add(new HuffmanNode('3', 1, "01000"));
        nodeList.add(new HuffmanNode('4', 1, "01010"));
        nodeList.add(new HuffmanNode('5', 1, "100110"));
        System.out.println("I give up");
        return nodeList;
    }

    /**
     * Answer to 2(a)
     * @return a list of BNodes
     */
    public static ArrayList<BNode> q2EncodeTree(){
        /*TODO: insert BNodes into a nodeList, where each node stores the data and path of a character */
        ArrayList<BNode> nodeList = new ArrayList<BNode>();
        //example of adding nodes to nodeList : nodeList.add(new BNode(Arrays.asList(17,24)));
        nodeList.add(new BNode(Arrays.asList(25,26,32)));
        nodeList.add(new BNode(Arrays.asList(39,41)));
        nodeList.add(new BNode(Arrays.asList(51)));
        nodeList.add(new BNode(Arrays.asList(59,62)));
        nodeList.add(new BNode(Arrays.asList(76)));
        nodeList.add(new BNode(Arrays.asList(87)));

        nodeList.add(new BNode(Arrays.asList(33,44,52)));
        nodeList.add(new BNode(Arrays.asList(79)));
        nodeList.add(new BNode(Arrays.asList(69)));

        nodeList.get(6).children.add(nodeList.get(0));
        nodeList.get(6).children.add(nodeList.get(1));
        nodeList.get(6).children.add(nodeList.get(2));
        nodeList.get(6).children.add(nodeList.get(3));

        nodeList.get(7).children.add(nodeList.get(4));
        nodeList.get(7).children.add(nodeList.get(5));

        nodeList.get(8).children.add(nodeList.get(6));
        nodeList.get(8).children.add(nodeList.get(7));
        return nodeList;

    }

    public static void main(String[] args) {
        ArrayList<BNode> nodes = q2EncodeTree();
        System.out.println("number of nodes  = "+nodes.size());
        for(int i = nodes.size()-1;i>=0;i--){
            List<BNode> children = nodes.get(i).children;
            String output = "";
            output+="current data = "+nodes.get(i).data+"\n";
            output+="children = ";
            if(children.size()==0){
                output+="None";
            }
            for(int j=0;j<children.size();j++){
                output+=children.get(j).data;
            }
            System.out.println(output);
            System.out.println("____________________");
        }
    }
}
