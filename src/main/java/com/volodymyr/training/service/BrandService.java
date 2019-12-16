package com.volodymyr.training.service;

import com.volodymyr.training.dao.BrandDAO;
import com.volodymyr.training.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDAO brandDAO;

    public List<Brand> getAllBrands() {
        return brandDAO.getAllBrands();
    }

    public void addNewBrand(Brand newBrand) {
        brandDAO.addNewBrand(newBrand);
    }

    public Brand getBrandByID(Integer id) {
        return brandDAO.getBrandByID(id);
    }

    public Brand getBrandByName(String name) {
        return brandDAO.getBrandByName(name);
    }

    public Brand updateBrand(Brand newBrand, int id) {
        return brandDAO.updateBrand(newBrand, id);
    }

    public void deleteBrand(int id) {
        brandDAO.deleteBrand(id);
    }
}
