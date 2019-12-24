package com.volodymyr.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.volodymyr.training.dao.ModelDAO;
import com.volodymyr.training.model.Model;
import com.volodymyr.training.service.ModelService;
import com.volodymyr.training.validation.CreateValidationGroup;
import com.volodymyr.training.validation.UpdateValidationGroup;
import com.volodymyr.training.validation.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands/{brandId}/models/admin")
public class ModelAdminController {

    @Autowired
    private ModelDAO modelDAO;

    @Autowired
    private ModelService modelService;

    @JsonView(Views.Admin.class)
    @GetMapping
    public List<Model> getAllModels(@PathVariable int brandId) {
        return modelService.getAllModels(brandId);
    }

    @JsonView(Views.Admin.class)
    @GetMapping("/{modelId}")
    public Model getModelByID(@PathVariable int brandId, @PathVariable int modelId) {
        return modelService.getModelByID(brandId, modelId);
    }

    @JsonView(Views.Public.class)
    @GetMapping(params = {"name"})
    public Model getModelByName(@PathVariable int brandId, @RequestParam String name) {
        return modelService.getModelByName(brandId, name);
    }

    @PostMapping
    public void addNewModel(@PathVariable int brandId,
                            @Validated(CreateValidationGroup.class) @RequestBody Model model) {
        modelService.addNewModel(brandId, model);
    }

    @PutMapping("/{modelId}")
    public Model updateModel(@PathVariable int brandId, @PathVariable int modelId,
                             @Validated(UpdateValidationGroup.class) @RequestBody Model newModel) {
        return modelService.updateModel(brandId, modelId, newModel);
    }

    @DeleteMapping("/{modelId}")
    public void deleteModel(@PathVariable int brandId, @PathVariable int modelId) {
        modelService.deleteModel(brandId, modelId);
    }
}
