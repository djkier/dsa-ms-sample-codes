package datastructure.ds3_1_4;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;

public class QueueMain {
    public static void main(String[] args) {
        QueueCustom inventoryQueue = new QueueCustom();

        // Create inventory items
        InventoryItem data1 = new InventoryItem(LocalDate.of(2023, 2, 1),
                StockLabel.OLD, "Honda", "142QVTSIUR", Status.ON_HAND);
        InventoryItem data2 = new InventoryItem(LocalDate.of(2023, 2, 3),
                StockLabel.OLD, "Kawasaki", "PZCT1S00XE", Status.SOLD);
        InventoryItem data3 = new InventoryItem(LocalDate.of(2023, 2, 7),
                StockLabel.OLD, "Kymco", "J8JA99VWZE", Status.SOLD);

        // Enqueue items
        inventoryQueue.enqueue(data1);
        inventoryQueue.enqueue(data2);
        inventoryQueue.enqueue(data3);

        // Peek front item
        InventoryItem frontItem = inventoryQueue.peek();
        System.out.println("Front item brand: " + frontItem.getBrand());

        // Dequeue item
        InventoryItem removedItem = inventoryQueue.dequeue();
        System.out.println("Dequeued item brand: " + removedItem.getBrand());

        // Peek again
        frontItem = inventoryQueue.peek();
        System.out.println("New front item brand: " + frontItem.getBrand());
    }
}
