package datastructure.ds3_1_2;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;

public class LinkedListMain {

    public static void main(String[] args) {
        //Create sample data
        InventoryItem data1 = new InventoryItem(LocalDate.of(2023, 2, 1),
                StockLabel.OLD, "Honda", "142QVTSIUR", Status.ON_HAND);
        InventoryItem data2 = new InventoryItem(LocalDate.of(2023, 2, 3),
                StockLabel.OLD, "Kawasaki", "PZCT1S00XE", Status.SOLD);
        InventoryItem data3 = new InventoryItem(LocalDate.of(2023, 2, 7),
                StockLabel.OLD, "Kymco", "J8JA99VWZE", Status.SOLD);

        // Initialize linked list
        LinkedListCustom inventoryList = new LinkedListCustom();
        inventoryList.add(data1);
        inventoryList.add(data2);
        inventoryList.add(data3);

    }
}
