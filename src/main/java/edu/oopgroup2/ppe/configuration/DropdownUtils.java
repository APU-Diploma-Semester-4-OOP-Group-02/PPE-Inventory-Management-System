package edu.oopgroup2.ppe.configuration;

import edu.oopgroup2.ppe.model.hospital.HospitalManagement;
import edu.oopgroup2.ppe.model.inventory.Inventory;
import edu.oopgroup2.ppe.model.inventory.InventoryComparator;
import edu.oopgroup2.ppe.model.inventory.InventoryManagement;
import edu.oopgroup2.ppe.model.supplier.SupplierManagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JComboBox;

public class DropdownUtils {
    // Populate Item Code dropdown
    public static void populateItemCodeDropdown(JComboBox<String> itemCodeDropdown) {
        itemCodeDropdown.removeAllItems();
        itemCodeDropdown.addItem("");
        List<String> itemCodes = InventoryManagement.getAllItemCodes();
        List<Inventory> inventoryList = new ArrayList<>();
        for (String itemCode : itemCodes) {
            Inventory inventory = new Inventory(itemCode, "", "", 0);
            inventoryList.add(inventory);
        }
        Collections.sort(inventoryList, new InventoryComparator());
        for (Inventory inventory : inventoryList) {
            itemCodeDropdown.addItem(inventory.getItemCode());
        }

    }
    
    // Populate Item Without Supplier dropdown
    public static void populateItemWithoutSupplierDropdown(JComboBox<String> itemCodeDropdown) {
        itemCodeDropdown.removeAllItems();
        List<String> itemCodes = InventoryManagement.getAllItemCodesWithoutSupplier();
        List<Inventory> inventoryList = new ArrayList<>();
        for (String itemCode : itemCodes) {
            Inventory inventory = new Inventory(itemCode, "", "", 0);
            inventoryList.add(inventory);
        }
        Collections.sort(inventoryList, new InventoryComparator());
        for (Inventory inventory : inventoryList) {
            itemCodeDropdown.addItem(inventory.getItemCode());
        }

    }

    // Populate Supplier ID dropdown
    public static void populateSupplierIDDropdown(JComboBox<String> supplierIDDropdown) {
        supplierIDDropdown.removeAllItems();
        supplierIDDropdown.addItem("");
        List<String> suppliers = SupplierManagement.getAllSupplierCodes();
        for (String supplier : suppliers) {
            supplierIDDropdown.addItem(supplier);
        }
    }

    // Populate Hospital ID dropdown
    public static void populateHospitalIDDropdown(JComboBox<String> hospitalIDDropdown) {
        hospitalIDDropdown.removeAllItems();
        hospitalIDDropdown.addItem("");
        List<String> hospitals = HospitalManagement.getAllHospitalCodes();
        for (String hospital : hospitals) {
            hospitalIDDropdown.addItem(hospital);
        }
    }
}
