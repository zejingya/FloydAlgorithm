package Tree;

import java.util.*;


public class HuffmanCode {

    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }

        Map<String, Byte>  map = new HashMap<String,Byte>();
        for(Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for(int  i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while(flag) {
                String key = stringBuilder.substring(i, i+count);
                b = map.get(key);
                if(b == null) {
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte b[] = new byte[list.size()];
        for(int i = 0;i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }

    private static String byteToBitString(boolean flag, byte b){
        int temp = b; //�� b ת�� int
        //������������ǻ����ڲ���λ
        if(flag) {
            temp |= 256; //��λ�� 256  1 0000 0000  | 0000 0001 => 1 0000 0001
        }
        String str = Integer.toBinaryString(temp); //���ص���temp��Ӧ�Ķ����ƵĲ���
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    private static byte[] huffmanZip(byte[] bytes) {
        List<Node1> nodes = getNodes(bytes);
        //���� nodes �����ĺշ�����
        Node1 huffmanTreeRoot = createHuffmanTree(nodes);
        //��Ӧ�ĺշ�������(���� �շ�����)
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //�������ɵĺշ������룬ѹ���õ�ѹ����ĺշ��������ֽ�����
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){

        StringBuilder stringBuilder = new StringBuilder();
        for(byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        int len;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;

        for (int i = 0;i < stringBuilder.length();i += 8){
            String strByte;
            if (i +8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i +8);
            }

            huffmanCodeBytes[index++] = (byte)Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(Node1 root) {//������ظо���̫�б�Ҫ
        if(root == null) {
            return null;
        }
        //����root��������
        getCodes(root.left, "0", stringBuilder);
        //����root��������
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(Node1 node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null){

            if (node.data == null){
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            }else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }




    private static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("�շ�����Ϊ��");
        }
    }

    private static List<Node1> getNodes(byte[] bytes){

        ArrayList<Node1> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b :
                bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count++);
            }

        }
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {//�����
            nodes.add(new Node1(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node1 createHuffmanTree(List<Node1> nodes){

        while (nodes.size() > 1){

            Collections.sort(nodes);

            Node1 left = nodes.get(0);
            Node1 right = nodes.get(1);
            Node1 parent = new Node1(null, left.weight + right.weight);

            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}
class Node1 implements Comparable<Node1>  {
    Byte data;
    int weight;
    Node1 left;
    Node1 right;
    public Node1(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node1 o) {
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node1 [data = " + data + " weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

}
