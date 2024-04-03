package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;

import java.util.ArrayList;
import java.util.Iterator;

public class MergerRepository {

    public ArrayList<Menu> getTheMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new DinerMenu());
        menus.add(new PancakeHouseMenu());
        menus.add(new CafeMenu());
        return menus;
    }


}
