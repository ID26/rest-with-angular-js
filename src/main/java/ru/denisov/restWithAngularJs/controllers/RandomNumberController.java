package ru.denisov.restWithAngularJs.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.denisov.restWithAngularJs.dbo.RandomNumber;
import ru.denisov.restWithAngularJs.service.RandomNumberService;

import java.util.List;

@RestController
@RequestMapping("/random")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    public RandomNumberController(@Qualifier("randomNumberService") RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @GetMapping
    public List<RandomNumber> getAll() {
        return randomNumberService.getAll();
    }

    @PostMapping("/add")
    public RandomNumber addRandomNumber(@RequestBody RandomNumber randomNumber) {
        return randomNumberService.addRandomNumber(randomNumber);
    }

    @PutMapping("/update/{id}")
    public RandomNumber updateRandomNumber(@PathVariable Long id, @RequestBody RandomNumber randomNumber) {
        randomNumber.setId(id);
        return randomNumberService.updateRandomNumber(randomNumber);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRandomNumber(@PathVariable Long id) {
        randomNumberService.deleteRandomNumber(id);
    }
}
