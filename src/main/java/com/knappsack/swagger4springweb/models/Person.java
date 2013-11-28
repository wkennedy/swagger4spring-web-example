package com.knappsack.swagger4springweb.models;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "A single person", description = "This is a test model that represents a person", discriminator = "", subTypes = Category.class)
public class Person {

    @ApiModelProperty(value = "ID of the person", notes = "This value correlates to the primary key", required = true, dataType = "int64")
    private long id;
    @ApiModelProperty(value = "Name of the person", notes = "The first and last name of this person", required = true)
    private String name;
    @ApiModelProperty(value = "Category of this person", notes = "The specific category of this person, for example full time or part time", required = true)
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
