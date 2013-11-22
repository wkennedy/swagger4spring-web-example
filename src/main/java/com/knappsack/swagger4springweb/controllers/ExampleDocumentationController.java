package com.knappsack.swagger4springweb.controllers;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
* This is an example of how you might extend the ApiDocumentationController in order to set your own RequestMapping
* (instead of the default "/api") among other possibilities.  Going this route, you do not necessarily have to define
* the controller in your servlet context.
*/
@Controller
@RequestMapping(value = "/api")
public class ExampleDocumentationController extends ApiDocumentationController {

    public ExampleDocumentationController() {
        setBaseControllerPackage("com.knappsack.swagger4springweb.controllers.api");
        List<String> controllerPackages = new ArrayList<String>();
        controllerPackages.add("com.knappsack.swagger4springweb.controllers.additionalApi");
        setAdditionalControllerPackages(controllerPackages);

        setBaseModelPackage("com.knappsack.swagger4springweb.models");
        List<String> modelPackages = new ArrayList<String>();
        controllerPackages.add("com.knappsack.swagger4springweb.additionalModels");
        setAdditionalModelPackages(modelPackages);

        setApiVersion("v1");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String documentation() {
        return "documentation";
    }
}
