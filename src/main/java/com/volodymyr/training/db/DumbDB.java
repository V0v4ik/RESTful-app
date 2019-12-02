package com.volodymyr.training.db;

import com.volodymyr.training.model.Brand;
import com.volodymyr.training.model.Model;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DumbDB {

    @Getter
    private static Map<Integer, Brand> brands = new HashMap<>();

    public DumbDB() {
        brands.put(0, new Brand("Ford", "USA", Arrays.asList(
                new Model("Focus", "Diesel", 190, 150),
                new Model("Mustang", "Gas", 350, 400),
                new Model("F150", "Diesel", 170, 380))));
        brands.put(1, new Brand("Tesla", "USA", Arrays.asList(
                new Model("Model S", "Electric", 250, 310),
                new Model("Model X", "Electric", 190, 330),
                new Model("Model 3", "Electric", 220, 300))));
        brands.put(2, new Brand("Toyota", "Japan", Arrays.asList(
                new Model("Corolla", "Diesel", 240, 230),
                new Model("Prius", "Hybrid", 190, 170),
                new Model("Land Cruiser", "Diesel", 230, 450))));
        brands.put(3, new Brand("BMW", "Germany", Arrays.asList(
                new Model("X5", "Diesel", 250, 350),
                new Model("I3", "Electric", 180, 140),
                new Model("Z7", "Gas", 310, 480))));
    }
}
