package ru.denisov.restWithAngularJs.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.denisov.restWithAngularJs.dbo.RandomNumber;
import ru.denisov.restWithAngularJs.repo.RandomNumberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RandomNumberService {

    private final RandomNumberRepository randomNumberRepository;

    public RandomNumberService(@Qualifier("randomNumberRepository") RandomNumberRepository randomNumberRepository) {
        this.randomNumberRepository = randomNumberRepository;
    }

    public List<RandomNumber> getAll() {
        return randomNumberRepository.findAll().stream()
                .sorted((o1, o2) -> (int) (o2.getCreateDate().getTime() - o1.getCreateDate().getTime()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public RandomNumber addRandomNumber(RandomNumber randomNumber) {
        return randomNumberRepository.save(randomNumber);
    }

    public RandomNumber updateRandomNumber(RandomNumber randomNumber) {
        return randomNumberRepository.save(randomNumber);
    }

    public void deleteRandomNumber(Long id) {
        if (randomNumberRepository.findById(id).isPresent()) {
            randomNumberRepository.deleteById(id);
        }
    }
}
