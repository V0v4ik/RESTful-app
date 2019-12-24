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

    public DumbDB() {
        brands.put(0, new Brand("Ford", "USA", new ArrayList<Model>() {
            {
                add(new Model(0, "Focus", "Diesel", 190, 150, 22000));
                add(new Model(1, "Mustang", "Gas", 350, 400, 45000));
                add(new Model(2, "F150", "Diesel", 170, 380, 37000));
            }
        }, "Henry@ford.com"));
        brands.put(1, new Brand("Tesla", "USA", new ArrayList<Model>() {
            {
                add(new Model(0, "Model S", "Electric", 250, 310, 41000));
                add(new Model(1, "Model X", "Electric", 190, 330, 86000));
                add(new Model(2, "Model 3", "Electric", 220, 300, 80000));
            }
        }, "changing_world@teslamotors.com"));
        brands.put(2, new Brand("Toyota", "Japan", new ArrayList<Model>() {
            {
                add(new Model(0, "Corolla", "Diesel", 240, 230, 36000));
                add(new Model(1, "Prius", "Hybrid", 190, 170, 24000));
                add(new Model(2, "Land Cruiser", "Diesel", 230, 450, 58000));
            }
        }, "always_the_best@toyota.com"));
        brands.put(3, new Brand("BMW", "Germany", new ArrayList<Model>() {
            {
                add(new Model(0, "X5", "Diesel", 250, 350, 37000));
                add(new Model(1, "I3", "Electric", 180, 140, 51000));
                add(new Model(2, "Z7", "Gas", 310, 480, 78000));
            }
        }, "never_give_up@bmw.com"));
    }
}
