import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //System.out.println(sqrt(2, 5));     //вычисление степени

        //нахождение оптимального набора для рюкзака
        ArrayList<Item> items = new ArrayList<>(); //список предметов
        items.add(new Item("Ручка", 1, 100));
        items.add(new Item("Тетрадь", 1, 200));
        items.add(new Item("Линейка", 2, 400));
//        items.add(new Item("Телефон", 1, 300));
//        items.add(new Item("Ноутбук", 4, 700));

        ArrayList<ItemsPack> itemsPacks = new ArrayList<>();
        ItemsPack itemsPack = createAndFindPack(itemsPacks, items, 2);
        System.out.println(itemsPack);
    }

    public static int sqrt(int value, int sqrt) {   //метод вычисления степени
        if (sqrt == 0)
            return 1;
        if (value == 0)
            return 0;
        if (sqrt == 1)
            return value;

        return value * sqrt(value, sqrt - 1);
    }

    private static class Item {         //класс вещей
        String name;
        int weight;
        int price;

        public Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }
    }

    private static class ItemsPack{
        private ArrayList<Item> itemsPack = new ArrayList<>();

        @Override
        public String toString() {
            String str = "";
            for (Item item: this.itemsPack) {
                str += item.name + ": " + item.price + "; ";
            }
            return str;
        }

        public void add(Item item){
            itemsPack.add(item);
        }

        public int getCostPack(){
            int result = 0;
            for (int i = 0; i < itemsPack.size(); i++) {
                result += itemsPack.get(i).price;
            }
            return result;
        }

        public int getWeightPack(){
            int result = 0;
            for (int i = 0; i < itemsPack.size(); i++) {
                result += itemsPack.get(i).weight;
            }
            return result;
        }
    }

    public static ItemsPack createAndFindPack(ArrayList<ItemsPack> itemsPacks, ArrayList<Item> items, int maxWeightPack){
        int iteration = 0;
        createAllPacks(itemsPacks, items, iteration);
        return findPackByParameters(maxWeightPack, itemsPacks);
    }

    public static void createAllPacks(ArrayList<ItemsPack> itemsPacks, ArrayList<Item> items, int iteration){
        if (iteration >= items.size())
            return;
        for (int i = 0; i < items.size(); i++) {
            itemsPacks.add(new ItemsPack());
            for (int j = 0; j < iteration +1; j++) {
                if((i + j) >= items.size())
                    itemsPacks.get(i + (items.size() * iteration)).add(items.get(i + j - items.size()));
                else
                    itemsPacks.get(i + (items.size() * iteration)).add(items.get(i + j));
            }
        }
        createAllPacks(itemsPacks, items, iteration +1);
    }
     public static ItemsPack findPackByParameters(int maxWeightPack, ArrayList<ItemsPack> itemsPacks){
        ItemsPack itemsPack = itemsPacks.get(0);
         for (ItemsPack items: itemsPacks) {
             if((items.getWeightPack() <= maxWeightPack) && (itemsPack.getCostPack() < items.getCostPack()))
                 itemsPack = items;

         }
         return  itemsPack;
     }
}
