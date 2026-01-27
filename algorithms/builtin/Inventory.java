package algorithms.builtin;

import algorithms.InventoryItem;

import java.util.LinkedList;

public class Inventory {
    private LinkedList<InventoryItem> inventoryList;

    public Inventory() {
        this.inventoryList = new LinkedList<>();
    }

    //Add new stock
    public void addNewStock(InventoryItem newItem) {
        //Add the item to the end
        inventoryList.add(newItem);
    }

    //Delete stock using the engine number
    public void deleteStock(String targetEngineNum) {
        for (InventoryItem item : inventoryList) {
            if (item.getEngineNumber().equals(targetEngineNum)) {
                //Remove the node from the list
                inventoryList.remove(item);
                //Exit once the item is found and removed
                return;
            }
        }
    }

    //Search by brand
    public LinkedList<InventoryItem> searchByBrand() {
        //Create a copy of the inventoryList
        LinkedList<InventoryItem> sortedList = new LinkedList<>(inventoryList);

        //Sort the sortedList
        sortedList.sort((item1, item2) ->
                //Use brand as a comparison
                item1.getBrand().compareToIgnoreCase(item2.getBrand())
        );

        return sortedList;
    }

    //Search inventory
    public InventoryItem searchInventory(String criteriaField, String searchValue) {
        //Simplify criteria field case
        String field = criteriaField.toLowerCase();

        //Search all the item on the inventoryList
        for (InventoryItem item : inventoryList) {
            //If the criteriaField is "date"
            if (field.equals("date") &&
                    //And if the item date string is equals to the searchValue
                    item.getDateEntered().toString().equals(searchValue)) {
                return item;

            }
            //Else if the criteriaField is "stock label"
            else if (field.equals("stock label") &&
                    //And if the item StockLabel[NEW, OLD] string is equals to searchValue
                    item.getStockLabel().toString().equalsIgnoreCase(searchValue)) {
                return item;

            }
            //Else if the criteriaField is "brand"
            else if (field.equals("brand") &&
                    //And if the item brand is same with the searchValue ignoring the capitalization
                    item.getBrand().equalsIgnoreCase(searchValue)) {
                return item;

            }
            //Else if the criteriaField is "engine number"
            else if (field.equals("engine number") &&
                    //And if the item engine number is same with the searchValue ignoring the capitalization
                    item.getEngineNumber().equalsIgnoreCase(searchValue)) {
                return item;

            }
            //Else if the criteriaField is "status"
            else if (field.equals("status") &&
                    //And if the item STATUS[ON_HAND, SOLD] string is equals to searchValue
                    item.getStatus().toString().equalsIgnoreCase(searchValue)) {
                return item;
            }
        }

        //Return nothing if match not found
        return null;
    }

}
