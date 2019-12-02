package com.volodymyr.training.dao;

import com.volodymyr.training.db.DumbDB;
import com.volodymyr.training.exceptions.NoSuchBrandException;
import com.volodymyr.training.exceptions.NoSuchModelException;
import com.volodymyr.training.model.Brand;
import com.volodymyr.training.model.Model;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ModelDAO {

    public List<Model> getAllModels(int brandID) {
        return DumbDB.getBrands().get(brandID).getModels();
    }

    public Model getModelByID(int brandID, int modelId) {
        try {
            return getAllModels(brandID).get(modelId);
        } catch (NullPointerException ex) {
            throw new NoSuchModelException("Model with id: '" + modelId + "' doesn't exist");
        }
    }

    public Model getModelByName(int brandID, String modelName) {
        return getAllModels(brandID).stream()
                .filter(model -> model.getName().equals(modelName))
                .findFirst()
                .orElseThrow(() -> new NoSuchBrandException("Brand with id: '" + modelName + "' doesn't exist"));
    }
}