package com.jparelation.repository;

import com.jparelation.entity.Car;
import com.jparelation.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CarRepository carRepository;

    @Transactional
    @Test
    void findAllTest() {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(Car.builder()
                    .name("car" + i)
                    .build());
        }

        personRepository.saveAll(Arrays.asList(
                Person.builder()
                        .name("ming")
                        .cars(cars)
                        .build(),
                Person.builder()
                        .name("mingble")
                        .cars(Collections.emptyList())
                        .build()));

        List<Person> personList1 = personRepository.findAll();

        System.out.println("----------start - getCarName-----------");
        System.out.println(personList1.get(0).getCarNames());
        System.out.println("----------end getCarName-----------");
        assertThat(personList1.get(0).getCarNames())
                .isNotNull();
    }
}
