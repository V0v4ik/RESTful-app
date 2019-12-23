package com.volodymyr.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.volodymyr.training.dao.ModelDAO;
import com.volodymyr.training.model.Model;
import com.volodymyr.training.service.ModelService;
import com.volodymyr.training.validation.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands/{brandId}/models")
public class ModelController {

    @Autowired
    private ModelDAO modelDAO;

    @Autowired
    private ModelService modelService;

    @JsonView(Views.Public.class)
    @GetMapping
    public List<Model> getAllModels(@PathVariable int brandId) {
        return modelService.getAllModels(brandId);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/{modelId}")
    public Model getModelByID(@PathVariable int brandId, @PathVariable int modelId) {
        return modelService.getModelByID(brandId, modelId);
    }

    @GetMapping(params = {"name"})
    public Model getModelByName(@PathVariable int brandId, @RequestParam String name) {
        return modelService.getModelByName(brandId, name);
    }

    @PostMapping
    public void addNewModel(@PathVariable int brandId, @Valid @RequestBody Model model) {
        modelService.addNewModel(brandId, model);
    }

    @PutMapping("/{modelId}")
    public Model updateModel(@PathVariable int brandId, @PathVariable int modelId, @Valid @RequestBody Model newModel) {
        return modelService.updateModel(brandId, modelId, newModel);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable int brandId, @PathVariable int modelId) {
        modelService.deleteModel(brandId, modelId);
    }
}
