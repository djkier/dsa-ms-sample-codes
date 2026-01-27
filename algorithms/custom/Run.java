package algorithms.custom;

import algorithms.InventoryItem;
import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;

public class Run {
    public static void main(String[] args) {
        //Create sample data
        InventoryItem data1 = new InventoryItem(LocalDate.of(2023, 2, 1),
                StockLabel.OLD, "A", "A", Status.ON_HAND);
        InventoryItem data2 = new InventoryItem(LocalDate.of(2023, 2, 3),
                StockLabel.OLD, "B", "B", Status.SOLD);
        InventoryItem data3 = new InventoryItem(LocalDate.of(2023, 2, 7),
                StockLabel.OLD, "C", "C", Status.SOLD);



        Inventory inventory = new Inventory();

        inventory.addNewStock(data1);
        inventory.addNewStock(data3);
        inventory.addNewStock(data2);
        inventory.addNewStock(data3);
        inventory.addNewStock(data3);
        inventory.addNewStock(data3);
        inventory.addNewStock(data1);
        inventory.addNewStock(data1);
        inventory.addNewStock(data2);
        inventory.addNewStock(data1);

        inventory.sortByBrand().display();
    }
}
