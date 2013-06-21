package com.knappsack.swagger4springweb.controllers.additionalApi;

import com.knappsack.swagger4springweb.additionalModels.Car;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/v1/cars")
@Api(value = "Car operations", listingClass = "CarController", basePath = "/api/v1/cars", description = "All operations for cars")
public class CarController {

    @ApiOperation(value = "Find all cars", notes = "Get all cars currently available", httpMethod = "GET", responseClass = "Car", multiValueResponse = true)
    @ApiError(code = 500, reason = "Process error")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Car[] cars() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear("2005");

        return new Car[]{car};
    }
}
