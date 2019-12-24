package com.volodymyr.training.dao;

import com.volodymyr.training.exceptions.ElementAlreadyExistException;
import com.volodymyr.training.exceptions.NoSuchModelException;
import com.volodymyr.training.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelDAO {

    @Autowired
    BrandDAO brandDAO;

    public List<Model> getAllModels(int brandID) {
        return brandDAO.getBrandByID(brandID).getModels();
    }

    public Model getModelByID(int brandID, int modelId) {
        return getAllModels(brandID).stream()
                .filter(model -> model.getId()==(modelId))
                .findFirst()
                .orElseThrow(() -> new NoSuchModelException("Model with id: '" + modelId + "' doesn't exist"));
    }

    public Model getModelByName(int brandID, String modelName) {
        return getAllModels(brandID).stream()
                .filter(model -> model.getName().equals(modelName))
                .findFirst()
                .orElseThrow(() -> new NoSuchModelException("Model with name: '" + modelName + "' doesn't exist"));
    }

    public void addNewModel(int brandID, Model model) {
        if (!getAllModels(brandID).contains(model)) {
            model.setId(getAllModels(brandID).size());
            getAllModels(brandID).add(model);
        } else {
            throw new ElementAlreadyExistException("Such model already exist");
        }
    }

    public Model updateModel(int brandID, int modelID, Model model) {
        Model oldModel = getModelByID(brandID, modelID);
        model.setId(oldModel.getId());
        return model;
    }

    public void deleteModel(int brandID, int modelID) {
        getAllModels(brandID).remove(getModelByID(brandID, modelID));
    }

}