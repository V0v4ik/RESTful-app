package com.volodymyr.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand {

    @NotEmpty(message = "Every brand should have it's own name. Even if it's Chinese")
    @EqualsAndHashCode.Include
    private String name;

    @NotEmpty(message = "Some country have to produce this brand")
    private String country;

    @NotEmpty(message = "Brand without cars? Maybe they're making TVs?")
    private List<Model> models;
}
