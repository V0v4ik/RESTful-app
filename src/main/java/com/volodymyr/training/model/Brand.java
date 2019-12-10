package com.volodymyr.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand {

    @EqualsAndHashCode.Include
    private String name;

    private String country;

    private List<Model> models;
}
