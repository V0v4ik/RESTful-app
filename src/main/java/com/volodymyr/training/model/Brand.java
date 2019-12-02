package com.volodymyr.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private String name;

    private String country;

    private List<Model> models;
}
