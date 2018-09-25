package org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import org.debugroom.mynavi.ib.monolithic.app.service.ordinary.deposit.impl.TransferServiceImpl;
import org.debugroom.mynavi.ib.monolithic.apinfra.exception.BusinessException;
import org.debugroom.mynavi.ib.monolithic.config.TestConfig;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.SavingsAccountRepository;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.sql.Timestamp;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.ServiceTestConfig.class,
        TransferServiceImplTest.Config.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TransferServiceImplTest{

    @Configuration
    public static class Config{
        @Bean
        TransferService transferService(){
            return new TransferServiceImpl();
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @MockBean
    SavingsAccountRepository savingsAccountRepositoryMock;

    @Autowired
    TransferService transferService;

    @Test
    public void testCreateTransferOrderNormalCase() throws BusinessException {
        String financialCode1 = "0001";
        String financialCode2 = "0002";
        String branchId1 = "001";
        String branchId2 = "002";
        String accountNo1 = "0000001";
        String accountNo2 = "0000002";
        String userId = "00000001";
        when(savingsAccountRepositoryMock.existsById(
                SavingsAccountPK
                .builder()
                .financialCode(financialCode2)
                .branchId(branchId2)
                .accountNo(accountNo2)
                .build()))
                .thenReturn(true);
        when(savingsAccountRepositoryMock.getOne(
                SavingsAccountPK
                        .builder()
                        .financialCode(financialCode1)
                        .branchId(branchId1)
                        .accountNo(accountNo1)
                        .build()))
                .thenReturn(SavingsAccount
                        .builder()
                        .userId(userId)
                        .financialCode(financialCode1)
                        .branchId(branchId1)
                        .accountNo(accountNo1)
                        .accountType("SAVINGS_ACCOUNT")
                        .totalAmount(BigInteger.valueOf(100000))
                        .accountStartDate(new Timestamp(System.currentTimeMillis()))
                        .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                        .build());

        log.info(transferService.createTransferOrder(financialCode2, branchId2, accountNo2,
                org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount
                        .builder().financialCode(financialCode1).branchId(branchId1).accountNo(accountNo1).build())
                .toString());
    }

    @Test(expected = BusinessException.class)
    public void testCreateTransferOrderAbnormalCase() throws BusinessException{
        String financialCode1 = "0001";
        String financialCode2 = "0002";
        String branchId1 = "001";
        String branchId2 = "002";
        String accountNo1 = "0000001";
        String accountNo2 = "0000002";
        String userId = "00000001";
        when(savingsAccountRepositoryMock.existsById(
                SavingsAccountPK
                        .builder()
                        .financialCode(financialCode2)
                        .branchId(branchId2)
                        .accountNo(accountNo2)
                        .build()))
                .thenReturn(false);

        log.info(transferService.createTransferOrder(financialCode2, branchId2, accountNo2,
                org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount
                        .builder().financialCode(financialCode1).branchId(branchId1).accountNo(accountNo1).build())
                .toString());
    }

}
