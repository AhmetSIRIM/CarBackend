package com.backend.car.controller;

import com.backend.car.entity.Car;
import com.backend.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        carService.createCar(car);
        return ResponseEntity.ok("Created car brand: " + car.getBrand());
    }

    @PostMapping("/createCarList")
    public ResponseEntity<String> createCarList(@RequestBody List<Car> carList) {
        carService.createCarList(carList);
        return ResponseEntity.ok("Car list created successfully");
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Car>> getAllCar() {
        List<Car> cars = carService.getAllCar();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car existingCar = carService.getCarById(id);
        if (existingCar != null) {
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setProductionYear(updatedCar.getProductionYear());
            existingCar.setColor(updatedCar.getColor());
            carService.updateCar(existingCar);
            return ResponseEntity.ok(existingCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Car existingCar = carService.getCarById(id);
        if (existingCar != null) {
            carService.deleteCar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/car/brand/{brand}")
    public ResponseEntity<Car> findCarByBrand(@PathVariable String brand) {
        Car car = carService.findCarByBrand(brand);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
