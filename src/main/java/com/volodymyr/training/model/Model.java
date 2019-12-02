package com.volodymyr.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private String name;

    private String engineType;

    private int maxSpeed;

    private int enginePower;

}
