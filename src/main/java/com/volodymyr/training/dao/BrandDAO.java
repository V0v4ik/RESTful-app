package com.volodymyr.training.dao;

import com.volodymyr.training.db.DumbDB;
import com.volodymyr.training.exceptions.ElementAlreadyExistException;
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
                .orElseThrow(() -> new NoSuchBrandException("Brand with name: '" + name + "' doesn't exist"));
    }

    public void addNewBrand(Brand brand) {
        if (DumbDB.getBrands().containsValue(brand)) {
            throw new ElementAlreadyExistException("Such brand already exist");
        } else {
            int id = DumbDB.getBrands().size();
            DumbDB.getBrands().put(id, brand);
        }
    }

    public Brand updateBrand(Brand newBrand, int id) {
        try {
            DumbDB.getBrands().replace(id, newBrand);
            return DumbDB.getBrands().get(id);
        } catch (NoSuchBrandException ex) {
            addNewBrand(newBrand);
            return DumbDB.getBrands().get(DumbDB.getBrands().size() - 1);
        }
        /*if (!DumbDB.getBrands().containsValue(brand)) {
            throw new NoSuchBrandException("Such brand doesn't exist");
        } else {
            AtomicInteger id = new AtomicInteger();
            DumbDB.getBrands().entrySet().stream()
                    .filter(entry -> entry.getValue().equals(brand))
                    .findFirst()
                    .ifPresent(entry -> {
                        id.set(entry.getKey());
                    });
            DumbDB.getBrands().replace(id.get(), brand);
        }*/
    }

    public void deleteBrand(int id) {
        try {
            DumbDB.getBrands().remove(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new NoSuchBrandException("Brand with id: '" + id + "' doesn't exist");
        }
    }
        /*if (!DumbDB.getBrands().containsValue(brand)) {
            throw new NoSuchBrandException("Such brand doesn't exist");
        } else {
            AtomicInteger id = new AtomicInteger();
            DumbDB.getBrands().entrySet().stream()
                    .filter(entry -> entry.getValue().equals(brand))
                    .findFirst()
                    .ifPresent(entry -> {
                        id.set(entry.getKey());
                    });
            DumbDB.getBrands().remove(id.get());
        }
    }*/
}
