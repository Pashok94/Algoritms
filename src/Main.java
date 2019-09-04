import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(10);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");

        graph.addEdge("A", "E", 2);
        graph.addEdge("E", "B", 1);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "F", 3);
        graph.addEdge("F", "I", 1);
        graph.addEdge("I", "J", 2);
        graph.addEdge("A", "G", 9);
        graph.addEdge("G", "D", 1);
        graph.addEdge("D", "H", 2);
        graph.addEdge("H", "J", 1);
        graph.addEdge("G", "J", 3);
        graph.addEdge("D", "E", 3);

        graph.dijkstraAlgorithm("A", "J");          //сумму целиком считает верно, но "проглатывает
                                                                //граф "В", просто учитывая его цену и все


        graph.dijkstraAlgorithm("E", "B");      //здесь путь видит
        graph.dijkstraAlgorithm("D", "E");      //здесь тоже
        //graph.dijkstraAlgorithm("D", "B");                //но здесь не может найти

    }
}