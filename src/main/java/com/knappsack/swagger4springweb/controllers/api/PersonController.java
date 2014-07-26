package com.knappsack.swagger4springweb.controllers.api;

import com.knappsack.swagger4springweb.models.Category;
import com.knappsack.swagger4springweb.models.Person;
import com.wordnik.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Api(value = "/api/v1/persons", description = "All operations for persons", position = 1)
@Controller
@RequestMapping("/api/v1/persons")
public class PersonController {

    @ApiOperation(value = "Find all persons", notes = "Get all persons currently available", httpMethod = "GET", response = Person.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Process error"), @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<Person> persons() {
        Category category = new Category();
        category.setId(1);
        category.setName("Full Time");

        Person person = new Person();
        person.setId(1);
        person.setName("John Doe");
        person.setCategory(category);

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("Ansel Adams");
        person2.setCategory(category);

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person2);
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        return persons;
    }

    @ApiOperation(value = "Find specific person", notes = "Get person by specified ID", httpMethod = "GET", response = Person.class, produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Process error"), @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/{personId}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Person person(@ApiParam(name = "personId", required = true, value = "long") @PathVariable Long personId) {
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
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Process error"), @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void deletePerson(@ApiParam(name = "personId", required = true, value = "long") @PathVariable Long personId) {
        //Remove person with this ID
    }

    @ApiOperation(value = "Create a person", notes = "Creates a new person in the system", httpMethod = "PUT", consumes = "application/json", produces = "application/json", protocols = "http, https", nickname = "Create Person", response = Person.class,
                    authorizations = @Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "person", description = "PMI authorization")}))
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Process error"),
                            @ApiResponse(code = 405, message = "Invalid input"),
                            @ApiResponse(code = 415, message = "Bad format")})
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody Person createPerson(
            @ApiParam(name = "person", required = true, value = "Person")
            @RequestBody Person person) {
        return person;
    }

    @ApiOperation(value = "Find all persons", notes = "Get all persons currently available by category", httpMethod = "GET", response = Person.class)
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Process error"), @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Person[] personsByCategory(@ApiParam(name = "categoryId", required = true, value = "long") @PathVariable Long categoryId) {
        Category category = new Category();
        category.setId(1);
        category.setName("Full Time");

        Person person = new Person();
        person.setId(1);
        person.setName("John Does");
        person.setCategory(category);

        return new Person[]{person};
    }
}
