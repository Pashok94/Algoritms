import java.util.ArrayList;

public class Pack {
    private int packCapacity;
    private int minWeightItem;
    int[][] itemCostTable;                //стоимость подрюкзаков
    ItemForPack itemForPack;            //принимаемый список

    public Pack(int packCapacity, ItemForPack itemForPack){
        this.packCapacity = packCapacity;
        this.itemForPack = itemForPack;
        this.minWeightItem = itemForPack.getMinWeight();
        itemCostTable = new int[itemForPack.size()][packCapacity / minWeightItem];
    }

    public void findOptimalList(){
        for (int i = 0; i < itemForPack.size(); i++) {
            for (int j = 0; j < itemCostTable[i].length; j++) {
                if(itemForPack.getWeightByIndex(i) > minWeightItem * (j + 1))
                    itemCostTable[i][j] = getMaxPriceByColumn(j);

                else {
                    itemCostTable[i][j] = Math.max(getLastMax(i, j - 1),
                            (itemForPack.getPriceByIndex(i) +
                                    getPriceOfPart(i - 1, j - itemForPack.getWeightByIndex(i))));
                    itemCostTable[i][j] = Math.max(itemCostTable[i][j], getMaxPriceByColumn(j));
                }
            }
        }
    }

    private int getLastMax(int i, int j){
        if( j < 0)
            return 0;
        else
            return itemCostTable[i][j];
    }

    private int getPriceOfPart(int i, int j){
        if(i < 0 || j < 0)
            return 0;
        else
            return itemCostTable[i][j];
    }

    private int getMaxPriceByColumn(int numbColumn){
        int maxPrice = 0;
        for (int i = 0; i < itemCostTable[0].length; i++) {
            maxPrice = Math.max(maxPrice, itemCostTable[i][numbColumn]);
        }
        return maxPrice;
    }

}
