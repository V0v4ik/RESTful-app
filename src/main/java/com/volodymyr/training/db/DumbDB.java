package com.volodymyr.training.db;

import com.volodymyr.training.model.Brand;
import com.volodymyr.training.model.Model;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DumbDB {

    @Getter
    private static Map<Integer, Brand> brands = new HashMap<>();

    //TODO Arrays.asList creates immutable collection
    public DumbDB() {
        brands.put(0, new Brand("Ford", "USA", new ArrayList<Model>() {
            {
                add(new Model("Focus", "Diesel", 190, 150));
                add(new Model("Mustang", "Gas", 350, 400));
                add(new Model("F150", "Diesel", 170, 380));
            }
        }));
        brands.put(1, new Brand("Tesla", "USA", new ArrayList<Model>() {
            {
                add(new Model("Model S", "Electric", 250, 310));
                add(new Model("Model X", "Electric", 190, 330));
                add(new Model("Model 3", "Electric", 220, 300));
            }
        }));
        brands.put(2, new Brand("Toyota", "Japan", new ArrayList<Model>() {
            {
                add(new Model("Corolla", "Diesel", 240, 230));
                add(new Model("Prius", "Hybrid", 190, 170));
                add(new Model("Land Cruiser", "Diesel", 230, 450));
            }
        }));
        brands.put(3, new Brand("BMW", "Germany", new ArrayList<Model>() {
            {
                add(new Model("X5", "Diesel", 250, 350));
                add(new Model("I3", "Electric", 180, 140));
                add(new Model("Z7", "Gas", 310, 480));
            }
        }));
    }
}
