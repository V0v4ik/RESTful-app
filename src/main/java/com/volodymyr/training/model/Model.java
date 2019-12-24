package com.volodymyr.training.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.volodymyr.training.validation.CreateValidationGroup;
import com.volodymyr.training.validation.UpdateValidationGroup;
import com.volodymyr.training.validation.Views;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @JsonView(Views.Admin.class)
    @PositiveOrZero(groups = UpdateValidationGroup.class, message = "Id can't be empty")
    @Negative(groups = CreateValidationGroup.class, message = "New item can't have predefined id")
    @EqualsAndHashCode.Exclude
    private int id;

    @JsonView(Views.Public.class)
    @NotEmpty(message = "If you don't know how to name it, just call it like some fruit")
    private String name;

    @JsonView(Views.Public.class)
    @NotEmpty(message = "Car without engine... Kak tebye takoe, Elon Mask?") //second idea is about Flintstones=)
    private String engineType;

    @JsonView(Views.Public.class)
    @Max(value = 350, message = "You can't drive faster than 350km/h, you're not a plane")
    @Positive
    private int maxSpeed;

    @JsonView(Views.Public.class)
    @Min(value = 35, message = "Less than 35 Hp is not a car")
    @Max(value = 1100, message = "more than 1100 Hp is a tank")
    private int enginePower;

    @JsonView(Views.Admin.class)
    @PositiveOrZero(message = "Our cars aren't so bad")
    private int price;
}
