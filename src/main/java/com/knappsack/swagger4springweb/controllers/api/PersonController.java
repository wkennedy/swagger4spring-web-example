package com.knappsack.swagger4springweb.controllers.api;

import com.knappsack.swagger4springweb.models.Category;
import com.knappsack.swagger4springweb.models.Person;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/v1/persons")
@Api(value = "Person operations", listingClass = "PersonController", basePath = "/api/v1/persons", description = "All operations for persons")
public class PersonController {

    @ApiOperation(value = "Find all persons", notes = "Get all persons currently available", httpMethod = "GET", responseClass = "Person", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Person[] persons() {
        Category category = new Category();
        category.setId(1);
        category.setName("Full Time");

        Person person = new Person();
        person.setId(1);
        person.setName("John Does");
        person.setCategory(category);

        return new Person[]{person};
    }

    @ApiOperation(value = "Find all persons", notes = "Get all persons currently available", httpMethod = "GET", responseClass = "Person", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Person person(@ApiParam(internalDescription = "java.lang.Long", name = "personId", required = true, value = "long") @PathVariable Long personId) {
        Category category = new Category();
        category.setId(1);
        category.setName("Full Time");

        Person person = new Person();
        person.setId(1);
        person.setName("John Does");
        person.setCategory(category);

        return person;
    }

    @ApiOperation(value = "Delete a person", notes = "Remove a specific person with the given ID", httpMethod = "DELETE")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void deletePerson(@ApiParam(internalDescription = "java.lang.Long", name = "personId", required = true, value = "long") @PathVariable Long personId) {
        //Remove person with this ID
    }

    @ApiOperation(value = "Create a person", notes = "Creates a new person in the system", httpMethod = "PUT")
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody Person createPerson(
            @ApiParam(internalDescription = "com.knappsack.swagger4springweb.models.Person", name = "person", required = true, value = "Person")
            @RequestBody Person person) {
        return person;
    }
}
