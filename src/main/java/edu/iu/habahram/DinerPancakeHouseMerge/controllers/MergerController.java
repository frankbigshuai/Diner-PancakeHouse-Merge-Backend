package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    CafeRepository cafeRepository;

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;

    public MergerController(CafeRepository cafeRepository, DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.cafeRepository = cafeRepository;
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator<MenuItem> cafeItems = cafeRepository.getTheMenuIterator();
        while(cafeItems.hasNext()) {
            menuItems.add(cafeItems.next());
        }

        Iterator<MenuItem> lunchItems = dinerRepository.getTheMenuIterator();
        while(lunchItems.hasNext()) {
            menuItems.add(lunchItems.next());
        }

        Iterator<MenuItem> breakfastItems = pancakeHouseRepository.getTheMenuIterator();
        while(breakfastItems.hasNext()) {
            menuItems.add(breakfastItems.next());
        }
        return menuItems;
    }
}