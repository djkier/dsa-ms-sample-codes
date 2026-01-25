package datastructure.ds3_1_1;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;

public class ArrayCode {

    public static void main(String[] args) {
        //Create sample data
        InventoryItem data1 = new InventoryItem(LocalDate.of(2023, 2, 1),
                StockLabel.OLD, "Honda", "142QVTSIUR", Status.ON_HAND);
        InventoryItem data2 = new InventoryItem(LocalDate.of(2023, 2, 3),
                StockLabel.OLD, "Kawasaki", "PZCT1S00XE", Status.SOLD);
        InventoryItem data3 = new InventoryItem(LocalDate.of(2023, 2, 7),
                StockLabel.OLD, "Kymco", "J8JA99VWZE", Status.SOLD);


        //Initialize array
        InventoryItem[] inventoryItems = new InventoryItem[3];

        //Assign data to the array
        inventoryItems[0] = data1;
        inventoryItems[1] = data2;
        inventoryItems[2] = data3;



    }
    //sample data




}
