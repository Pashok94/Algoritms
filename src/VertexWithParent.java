public class VertexWithParent {
    private int weight;
    private Vertex parent;
    private Vertex vertex;
    private boolean isMin = false;

    public boolean isMin() {
        return isMin;
    }

    public void setMin(boolean min) {
        isMin = min;
    }

    public VertexWithParent(Vertex vertex, int weight, Vertex parent) {
        this.weight = weight;
        this.parent = parent;
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getVertex() {
        return vertex;
    }
}
