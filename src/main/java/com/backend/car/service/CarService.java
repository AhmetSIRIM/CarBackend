package com.backend.car.service;

import com.backend.car.entity.Car;
import com.backend.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(Car car) {
        carRepository.save(car);
    }

    public void createCarList(List<Car> carList) {
        carRepository.saveAll(carList);
    }

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car findCarByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

}
