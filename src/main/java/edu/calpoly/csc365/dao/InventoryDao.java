package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Inventory;

public interface InventoryDao extends Dao<Inventory> {
    public int getNextAvailabeBook(String id);

}
