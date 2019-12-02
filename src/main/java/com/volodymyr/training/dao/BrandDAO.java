package com.volodymyr.training.dao;

import com.volodymyr.training.db.DumbDB;
import com.volodymyr.training.exceptions.NoSuchBrandException;
import com.volodymyr.training.model.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BrandDAO {

    public List<Brand> getAllBrands() {
        return new ArrayList<>(DumbDB.getBrands().values());
    }

    public Brand getBrandByID(int id) {
        return DumbDB.getBrands().entrySet().stream()
                .filter(entry -> entry.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new NoSuchBrandException("Brand with id: '" + id + "' doesn't exist"));
    }

    public Brand getBrandByName(String name) {
        return DumbDB.getBrands().values().stream()
                .filter(brand -> brand.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchBrandException("Brand with id: '" + name + "' doesn't exist"));
    }
}
