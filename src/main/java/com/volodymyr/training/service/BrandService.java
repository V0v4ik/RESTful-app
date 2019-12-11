package com.volodymyr.training.service;

import com.volodymyr.training.dao.BrandDAO;
import com.volodymyr.training.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @GetMapping
    public List<Brand> getBrands() {
        return brandDAO.getAllBrands();
    }

    @PostMapping
    public void addBrand(@Valid @RequestBody Brand newBrand) {
        brandDAO.addNewBrand(newBrand);
    }

    @GetMapping("/{id}")
    public Brand getBrandByID(@PathVariable Integer id) {
        return brandDAO.getBrandByID(id);
    }

    @RequestMapping
    public Brand getBrandByName(@RequestParam("name") String name) {
        return brandDAO.getBrandByName(name);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@Valid @RequestBody Brand newBrand, @PathVariable int id) {
        return brandDAO.updateBrand(newBrand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id) {
        brandDAO.deleteBrand(id);
    }
}
