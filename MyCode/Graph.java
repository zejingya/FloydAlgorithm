import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //�洢���㼯��
    private int[][] edges; //�洢ͼ��Ӧ���ڽ����
    private int numOfEdges; //��ʾ�ߵ���Ŀ
    //���������boolean[], ��¼ĳ������Ƿ񱻷���
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public void showGraph() {
        for(int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited, int i){

        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int j = getFirstNeighbor(i);

        while (j != -1){

            if (!isVisited[j]){
                dfs(isVisited,j);
            }
            j = getNextNeighbor(i,j);
        }
    }

    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //�������еĽ�㣬����dfs[����]
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i){

        int u ;
        int w ;
        LinkedList queue = new LinkedList();

        System.out.print(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()){

            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);

            while (w != -1){

                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }

                w = getNextNeighbor(i,w);
            }
        }

    }

    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

}
