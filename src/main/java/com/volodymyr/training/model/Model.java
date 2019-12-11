package com.volodymyr.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @NonNull()
    @NotEmpty(message = "If you don't know how to name it, just call it like some fruit")
    private String name;

    @NotEmpty(message = "Car without engine... Kak tebye takoe, Elon Mask?") //second idea is about Flintstones=)
    private String engineType;

    @Max(value = 350, message = "You can't drive faster than 350km/h, you're not a plane")
    @Positive
    private int maxSpeed;

    @Min(value = 35, message = "Less than 35 Hp is not a car")
    @Max(value = 1100, message = "more than 1100 Hp is a tank")
    private int enginePower;

}
