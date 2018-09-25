package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.BusinessDay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class BusinessDayRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    BusinessDayRepository businessDayRepository;

    @Before
    public void before(){
        testEntityManager.persist(
                BusinessDay.builder().yyyymmdd("99991231").isBusinessDay(false).build());
    }

    @Test
    public void testFindAll() throws Exception{
        List<BusinessDay> businessDays = businessDayRepository.findAll();
        businessDays.forEach(e ->{
            log.info(e.getYyyymmdd());
        });
    }

}
