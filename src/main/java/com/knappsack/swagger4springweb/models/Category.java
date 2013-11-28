package com.knappsack.swagger4springweb.models;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "The classification for a person", description = "Defines a specific classification for a person, for example full time or part time", discriminator = "")
public class Category {
    @ApiModelProperty(value = "ID of the category", notes = "This value correlates to the primary key", required = true, dataType = "int64")
    private long id;
    @ApiModelProperty(value = "Name of the category", notes = "This is the human readable name of the category", required = true)
    private String name;

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
}
