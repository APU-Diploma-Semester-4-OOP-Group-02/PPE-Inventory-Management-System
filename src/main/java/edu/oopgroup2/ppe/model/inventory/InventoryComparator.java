package edu.oopgroup2.ppe.model.inventory;

import java.util.Comparator;

public class InventoryComparator implements Comparator<Inventory> {
    @Override
    public int compare(Inventory i1, Inventory i2) {
        return i1.getItemCode().compareTo(i2.getItemCode());
    }
}
