package com.jparelation.repository;

import com.jparelation.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    public void before() {

        personRepository.saveAll(
                Arrays.asList(
                        Person.builder()
                                .name("ming")
                                .cars(Collections.emptyList())
                                .build(),
                        Person.builder()
                                .name("mingble")
                                .cars(Collections.emptyList())
                                .build()
                )
        );
    }

    @Test
    void findAllTest() {

        List<Person> personList = personRepository.findAll();

        personList.forEach(person -> System.out.println(person.toString()));
        assertThat(personList)
                .hasSize(2);
    }
}
