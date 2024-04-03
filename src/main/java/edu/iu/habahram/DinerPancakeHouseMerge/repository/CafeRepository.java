package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

import java.util.Iterator;

public class CafeRepository {
    public MenuItem[] getTheMenu() {
        CafeMenu cafeMenu = new CafeMenu();
        return cafeMenu.getMenuItems();
    }

    public Iterator<MenuItem> getTheMenuIterator() {
        Menu cafeMenu = new CafeMenu();
        return cafeMenu.createIterator();
    }
}
