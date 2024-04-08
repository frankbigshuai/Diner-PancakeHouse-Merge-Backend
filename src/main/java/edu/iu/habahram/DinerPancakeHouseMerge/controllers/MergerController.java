package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;

import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;
    CustomerRepository customerRepository;


    public MergerController(MergerRepository mergerRepository, CustomerRepository customerRepository) {
        this.mergerRepository = mergerRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianMenuItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> vege = new ArrayList<>();
        for (MenuItemRecord item : items) {
            if(item.vegetarian())
            {
                vege.add(item);
            }
        }
        return vege;
   }
    @GetMapping("/lunch")
    public List<MenuItemRecord> getBreakfastMenuItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> lunch = new ArrayList<>();
        for (MenuItemRecord item : items) {

            if (isLunchItem(item.name())) {
                lunch.add(item);
            }
        }
        return lunch;
    }
    private boolean isLunchItem(String itemName) {
        DinerMenu dinerMenu = new DinerMenu("Diner Menu", "Lunch"); // Instantiate DinerMenu
        return dinerMenu.containsItem(itemName);
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getLunchMenuItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> breakfast = new ArrayList<>();
        for (MenuItemRecord item : items) {

            if (isBreakfastItem(item.name())) {
                breakfast.add(item);
            }
        }
        return breakfast;
    }
    private boolean isBreakfastItem(String itemName) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu("PANCAKE HOUSE MENU","Breakfast");
        return pancakeHouseMenu.containsItem(itemName);
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperMenuItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> supper = new ArrayList<>();


        for (MenuItemRecord item : items) {

            if (isSupperItem(item.name())) {
                supper.add(item);
            }
        }

        return supper;
    }

    private boolean isSupperItem(String itemName) {
        CafeMenu cafeMenu = new CafeMenu("CAFE MENU", "Dinner");
        return cafeMenu.containsItem(itemName);
    }

    @PostMapping("/signup")

    public void signup(@RequestBody Customer customer){
        try{
            customerRepository.save(customer);

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}