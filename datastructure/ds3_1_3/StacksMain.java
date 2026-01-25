package datastructure.ds3_1_3;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;

public class StacksMain {
    public static void main(String[] args) {
        StacksCustom inventoryStack = getStacksCustom();

        // Peek at the top item
        InventoryItem topItem = inventoryStack.peek();
        System.out.println("Top item brand: " + topItem.getBrand());

        // Pop the top item
        InventoryItem removedItem = inventoryStack.pop();
        System.out.println("Removed item brand: " + removedItem.getBrand());

        // Peek again
        topItem = inventoryStack.peek();
        System.out.println("New top item brand: " + topItem.getBrand());
    }

    private static StacksCustom getStacksCustom() {
        StacksCustom inventoryStack = new StacksCustom();

        // Create inventory items
        InventoryItem data1 = new InventoryItem(LocalDate.of(2023, 2, 1),
                StockLabel.OLD, "Honda", "142QVTSIUR", Status.ON_HAND);
        InventoryItem data2 = new InventoryItem(LocalDate.of(2023, 2, 3),
                StockLabel.OLD, "Kawasaki", "PZCT1S00XE", Status.SOLD);
        InventoryItem data3 = new InventoryItem(LocalDate.of(2023, 2, 7),
                StockLabel.OLD, "Kymco", "J8JA99VWZE", Status.SOLD);

        // Push items onto the stack
        inventoryStack.push(data1);
        inventoryStack.push(data2);
        inventoryStack.push(data3);
        return inventoryStack;
    }
}
