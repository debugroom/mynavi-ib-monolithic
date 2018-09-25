package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;
import org.debugroom.mynavi.ib.monolithic.app.service.common.PortalService;
import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl.DepositPortalServiceImpl;
import org.debugroom.mynavi.ib.monolithic.config.TestConfig;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.User;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.ServiceTestConfig.class,
        DepositPortalServiceImplTest.Config.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DepositPortalServiceImplTest {

    @Configuration
    public static class Config{
        @Bean
        PortalService depositPortalService(){
            return new DepositPortalServiceImpl();
        }
    }

    @MockBean
    UserRepository userRepositoryMock;

    @Autowired
    @Qualifier("depositPortalService")
    PortalService portalService;

    @Test
    public void testGetPortalResource(){
        String userId = "00000001";
        String firstName = "FIRSTNAME1";
        String lastName = "LASTNAME1";
        String loginId = "LOGINID1";
        User mockUser = User.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .loginId(loginId)
                .birthday("19820105")
                .sex("MAN")
                .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                .savingsAccountsByUserId(Arrays.asList(
                        SavingsAccount.builder()
                                .userId(userId)
                                .accountType("SAVINGS_ACCOUNT")
                                .totalAmount(BigInteger.valueOf(100))
                                .accountStartDate(new Timestamp(System.currentTimeMillis()))
                                .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                                .build()
                ))
                .build();
        when(userRepositoryMock.getOne("00000001")).thenReturn(mockUser);
        PortalResource resource = portalService.getPortalResource("00000001");

        log.info(resource.toString());

    }


}
