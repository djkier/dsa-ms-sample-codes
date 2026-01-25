package datastructure.ds3_1;

import java.time.LocalDate;

public class InventoryItem {
    private LocalDate dateEntered;
    private StockLabel stockLabel;
    private String brand;
    private String engineNumber;
    private Status status;

    public InventoryItem(LocalDate dateEntered, StockLabel stockLabel, String brand,
                         String engineNumber, Status status) {
        this.dateEntered = dateEntered;
        this.stockLabel = stockLabel;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = status;
    }

    // Getters and setters...
}
