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
        String field = criteriaField.toLowerCase();

        for (InventoryItem item : inventoryList) {
            switch (field) {
                case "date":
                    if (item.getDateEntered().toString().equals(searchValue)) {
                        return item;
                    }
                    break;

                case "stocklabel":
                    if (item.getStockLabel().toString().equalsIgnoreCase(searchValue)) {
                        return item;
                    }
                    break;

                case "brand":
                    if (item.getBrand().equalsIgnoreCase(searchValue)) {
                        return item;
                    }
                    break;

                case "enginenumber":
                    if (item.getEngineNumber().equalsIgnoreCase(searchValue)) {
                        return item;
                    }
                    break;

                case "status":
                    if (item.getStatus().toString().equalsIgnoreCase(searchValue)) {
                        return item;
                    }
                    break;

                default:
                    // invalid field, skip
                    break;
            }
        }

        //Not found
        return null;
    }
}
