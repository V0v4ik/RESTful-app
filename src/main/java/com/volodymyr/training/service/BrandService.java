package com.volodymyr.training.service;

import com.volodymyr.training.dao.BrandDAO;
import com.volodymyr.training.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BrandService {

    @Autowired
    private BrandDAO brandDAO;

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return brandDAO.getAllBrands();
    }

    @PostMapping("/brands")
    public void addBrand(@RequestBody Brand newBrand) {
        brandDAO.addNewBrand(newBrand);
    }

    @GetMapping("/brands/{id}")
    public Brand getBrandByID(@PathVariable Integer id) {
        return brandDAO.getBrandByID(id);
    }

    /*@GetMapping("/brands")
    public Brand getBrandByName(@PathParam("name") String name) {
        return brandDAO.getBrandByName(name);
    }*/
}
