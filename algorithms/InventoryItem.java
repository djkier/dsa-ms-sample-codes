package algorithms;

import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

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

    public LocalDate getDateEntered() {
        return dateEntered;
    }

    public StockLabel getStockLabel() {
        return stockLabel;
    }

    public String getBrand() {
        return brand;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Date Entered: " + dateEntered +
                "\nStock: " + stockLabel +
                "\nBrand: " + brand +
                "\nEngine Number: " + engineNumber +
                "\nStatus: " + status;
    }
}
