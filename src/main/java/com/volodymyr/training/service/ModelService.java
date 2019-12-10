package com.volodymyr.training.service;

import com.volodymyr.training.dao.ModelDAO;
import com.volodymyr.training.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands/{brandId}/models")
public class ModelService {

    @Autowired
    private ModelDAO modelDAO;

    @GetMapping
    public List<Model> getAllModels(@PathVariable int brandId) {
        return modelDAO.getAllModels(brandId);
    }

    @GetMapping("/{modelId}")
    public Model getModel(@PathVariable int brandId, @PathVariable int modelId) {
        return modelDAO.getModelByID(brandId, modelId);
    }

    @PostMapping
    public void addNewModel(@PathVariable int brandId, Model model) {
        modelDAO.addNewModel(brandId, model);
    }

    @PutMapping("/{modelId}")
    public Model updateModel(@PathVariable int brandId, @PathVariable int modelId, Model newModel) {
        //TODO if updating non-existing model add new or throw exception
        return modelDAO.updateModel(brandId, modelId, newModel);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable int brandId, @PathVariable int modelId) {
        modelDAO.deleteModel(brandId, modelId);
    }
}
