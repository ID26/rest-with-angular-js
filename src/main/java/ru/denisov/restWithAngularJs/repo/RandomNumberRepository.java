package ru.denisov.restWithAngularJs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.restWithAngularJs.dbo.RandomNumber;

@Repository
public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}
