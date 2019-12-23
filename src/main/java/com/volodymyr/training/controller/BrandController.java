package com.volodymyr.training.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.volodymyr.training.model.Brand;
import com.volodymyr.training.service.BrandService;
import com.volodymyr.training.validation.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @JsonView(Views.Public.class)
    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping
    public void addBrand(@Valid @RequestBody Brand newBrand) {
        brandService.addNewBrand(newBrand);
    }

    @JsonView(Views.Public.class)
    @GetMapping(value = "/{id}")
    public Brand getBrandByID(@PathVariable Integer id) {
        return brandService.getBrandByID(id);
    }

    @JsonView(Views.Public.class)
    @GetMapping(params = {"name"})
    public Brand getBrandByName(@RequestParam("name") String name) {
        return brandService.getBrandByName(name);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@Valid @RequestBody Brand newBrand, @PathVariable int id) {
        return brandService.updateBrand(newBrand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
    }
}
