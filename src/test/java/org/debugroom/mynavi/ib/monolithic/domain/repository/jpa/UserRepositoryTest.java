package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Before
    public void before(){
        testEntityManager.persist(User.builder().userId("00000001").firstName("FirstName1").build());
        testEntityManager.persist(User.builder().userId("00000002").firstName("FirstName2").build());
        testEntityManager.persist(User.builder().userId("00000003").firstName("FirstName3").build());
    }

    @Test
    public void testFindAll() throws Exception{
        List<User> users = userRepository.findAll();
        users.forEach(e -> {
            log.info(e.getFirstName());
            switch (e.getUserId()) {
                case "00000001": assertThat(e.getFirstName() , is("FirstName1")); break;
                case "00000002": assertThat(e.getFirstName() , is("FirstName2")); break;
                case "00000003": assertThat(e.getFirstName() , is("FirstName3")); break;
            }
        });
    }

}
