public class PackTestDrive {
    public static void main(String[] args) {
        ItemForPack itemForPack = new ItemForPack();
        itemForPack.addItem("игр", 200, 2);
        itemForPack.addItem("кружка", 300, 3);
        itemForPack.addItem("ноут", 500, 1);
        itemForPack.addItem("книга", 100, 1);
        itemForPack.addItem("книга", 30, 2);

        Pack pack = new Pack(3, itemForPack);
        pack.findOptimalList();
        for (int i = 0; i < pack.itemCostTable.length; i++) {
            for (int j = 0; j < pack.itemCostTable[i].length; j++) {
                System.out.print(pack.itemCostTable[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
