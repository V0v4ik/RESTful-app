package com.volodymyr.training.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.volodymyr.training.validation.EmailConstraint;
import com.volodymyr.training.validation.Views;
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

    @JsonView(Views.Public.class)
    @NotEmpty(message = "Every brand should have it's own name. Even if it's Chinese")
    @EqualsAndHashCode.Include
    private String name;

    @JsonView(Views.Public.class)
    @NotEmpty(message = "Some country have to produce this brand")
    private String country;

    @JsonView(Views.Public.class)
    @NotEmpty(message = "Brand without cars? Are they making TVs?")
    private List<Model> models;

    @JsonView(Views.Public.class)
    @EmailConstraint
    private String contactEmail;
}
