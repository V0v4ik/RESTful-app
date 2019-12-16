package com.volodymyr.training.service;

import com.volodymyr.training.dao.ModelDAO;
import com.volodymyr.training.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelDAO modelDAO;

    public List<Model> getAllModels(int brandId) {
        return modelDAO.getAllModels(brandId);
    }

    public Model getModelByID(int brandId, int modelId) {
        return modelDAO.getModelByID(brandId, modelId);
    }

    public Model getModelByName(int brandId, String modelName) {
        return modelDAO.getModelByName(brandId, modelName);
    }

    public void addNewModel(int brandId, Model model) {
        modelDAO.addNewModel(brandId, model);
    }

    public Model updateModel(int brandId, int modelId, Model newModel) {
        return modelDAO.updateModel(brandId, modelId, newModel);
    }

    public void deleteModel(int brandId, int modelId) {
        modelDAO.deleteModel(brandId, modelId);
    }
}
