package com.knappsack.swagger4springweb.controllers.api;

import com.knappsack.swagger4springweb.models.Category;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.Authorization;
import com.wordnik.swagger.annotations.AuthorizationScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/v1/categories")
public class CategoryController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    @ApiOperation(value = "Create a category", notes = "Creates a new person in the system", httpMethod = "GET", consumes = "application/json", produces = "application/json", protocols = "http, https", nickname = "Get Category", response = Category.class,
            authorizations = @Authorization(value = "oauth2", scopes = {@AuthorizationScope(scope = "category", description = "PMI authorization")}))
    Category[] categories() {
        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Full Time");
        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Part Time");

        return new Category[]{category1, category2};
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.POST, consumes = "application/json")
    public void updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        //update category
    }
}
