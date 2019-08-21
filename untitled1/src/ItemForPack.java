import java.util.ArrayList;
import java.util.List;

public class ItemForPack {
    private List<Item> listItem = new ArrayList<>();

    public void addItem(String name, int price, int weight){
        listItem.add(new Item(name, price, weight));
    }

    public int getMinWeight(){
        int x = listItem.get(0).weight;
        for (Item item: listItem) {
            x = x < item.weight ? x : item.weight;
        }
        return x;
    }

    public int getPriceByIndex(int index){
        return listItem.get(index).price;
    }

    public int getWeightByIndex(int index){
        return listItem.get(index).weight;
    }

    public int size(){
        return listItem.size();
    }

    private static class Item{
        String name;
        int price;
        int weight;

        public Item(String name, int price, int weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }
    }
}
