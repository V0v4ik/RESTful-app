package com.volodymyr.training.controller;

import com.volodymyr.training.dao.BrandDAO;
import com.volodymyr.training.model.Brand;
import com.volodymyr.training.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping
    public void addBrand(@Valid @RequestBody Brand newBrand) {
        brandService.addNewBrand(newBrand);
    }

    @GetMapping(value = "/{id}")
    public Brand getBrandByID(@PathVariable Integer id) {
        return brandService.getBrandByID(id);
    }

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
