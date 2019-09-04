import java.util.ArrayList;
import java.util.Deque;

public class WeightedGraph extends Graph {
    public WeightedGraph(int maxVertexCount) {
        super(maxVertexCount);
        matrix = new WeightedEdge[maxVertexCount][maxVertexCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new WeightedEdge(0, false);
            }
        }
    }


    private WeightedEdge[][] matrix;

    public void addEdge(String startLabel, String finishLabel, int weight) {
        int startIndex  = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException(String.format("Invalid labels for vertexes: %s; %s",
                    startLabel, finishLabel));
        }

        matrix[startIndex][finishIndex].setWeight(weight);
        matrix[startIndex][finishIndex].setHaveEdge(true);
    }

    @Override
    public void display() {
        super.display();
    }

    public void dijkstraAlgorithm(String start, String finish){
        VertexWithParent finishVertex = null;
        VertexWithParent startVertex = null;
        ArrayList<VertexWithParent> list = new ArrayList<>();
        for (int i = 0; i < super.getSize(); i++) {
            list.add(new VertexWithParent(super.vertexList.get(i), 2147483647, null));
            if(list.get(i).getVertex().getLabel().equals(start)) {
                list.get(i).setWeight(0);
                startVertex = list.get(i);
            }
            else if(list.get(i).getVertex().getLabel().equals(finish))
                finishVertex = list.get(i);
        }
        VertexWithParent min;

        while (!finishVertex.isMin()){
            min = checkForMin(list);
            checkAllEdges(min, list);
        }

        printResult(startVertex, finishVertex, list);

    }

    private VertexWithParent checkForMin(ArrayList<VertexWithParent> list){
        int x = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isMin())
                x = list.get(x).getWeight() < list.get(i).getWeight() ? x : i;
        }
        list.get(x).setMin(true);
        return list.get(x);
    }

    private void checkAllEdges(VertexWithParent vertexWithMinimalWeight, ArrayList<VertexWithParent> list){
        for (VertexWithParent vertexWithParent : list) {
            WeightedEdge weightedEdge = matrix[indexOf(vertexWithMinimalWeight.getVertex().getLabel())][indexOf(vertexWithParent.getVertex().getLabel())];
            if (weightedEdge.isHaveEdge()){
                if ((vertexWithMinimalWeight.getWeight() + weightedEdge.getWeight()) <
                        vertexWithParent.getWeight()){
                    vertexWithParent.setWeight(vertexWithMinimalWeight.getWeight() + weightedEdge.getWeight());
                    vertexWithParent.setParent(vertexWithMinimalWeight.getVertex());
                }
            }
        }
    }

    private void printResult(VertexWithParent start, VertexWithParent finish, ArrayList<VertexWithParent> list){
        VertexWithParent temp = finish;
        int allWeight = finish.getWeight();

        while (true){
            System.out.print(temp.getVertex() + " " + temp.getWeight());
            for (VertexWithParent vertexWithParent : list) {
                if(vertexWithParent.getVertex().equals(temp.getParent()))
                    temp = vertexWithParent;
            }
            if(temp.getParent() == null) {
                System.out.println(" <- " + start.getVertex());
                System.out.println("Весь путь стоит: " + allWeight);
                break;
            }
            else
                System.out.print(" <- ");
        }
    }
}
