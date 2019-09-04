public class WeightedEdge {
    private int weight;
    private boolean haveEdge;

    public WeightedEdge(int weight, boolean haveAdge) {
        this.weight = weight;
        this.haveEdge = haveAdge;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHaveEdge() {
        return haveEdge;
    }

    public void setHaveEdge(boolean haveEdge) {
        this.haveEdge = haveEdge;
    }
}
