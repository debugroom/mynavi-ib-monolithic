package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import lombok.extern.slf4j.Slf4j;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class SavingsAccountRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    FinancialInstitutionRepository financialInstitutionRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Before
    public void before(){
        SavingsAccount savingsAccount1 =
                SavingsAccount.builder()
                        .userId("00000001")
                        .financialCode("0001")
                        .branchId("001")
                        .cifNo("0000001")
                        .accountNo("0000001")
                        .accountType("SAVINGS_ACCOUNT")
                        .totalAmount(BigInteger.valueOf(10000))
                        .accountStartDate(new Timestamp(System.currentTimeMillis()))
                        .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                        .ver(0)
                        .build();

        SavingsAccount savingsAccount2 =
                SavingsAccount.builder()
                        .userId("00000002")
                        .financialCode("0002")
                        .branchId("002")
                        .cifNo("0000002")
                        .accountNo("0000002")
                        .accountType("SAVINGS_ACCOUNT")
                        .totalAmount(BigInteger.valueOf(20000))
                        .accountStartDate(new Timestamp(System.currentTimeMillis()))
                        .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                        .ver(0)
                        .build();
        FinancialInstitution financialInstitution1 = FinancialInstitution.builder()
                .financialCode("0001").financialInstitutionName("AAAA")
//                .branchesByFinancialCode(Arrays.asList(branch1))
                .build();
        FinancialInstitution financialInstitution2 = FinancialInstitution.builder()
                .financialCode("0002").financialInstitutionName("BBBB")
//                .branchesByFinancialCode(Arrays.asList(branch2))
                .build();
        Branch branch1 = Branch.builder()
                .branchId("001")
                .financialCode("0001")
                .branchName("AAAA-Branch")
                .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                .ver(0)
                .financialInstitutionByFinancialCode(financialInstitution1)
                .savingsAccounts(Arrays.asList(savingsAccount1))
                .build();
        Branch branch2 = Branch.builder()
                .financialCode("0002")
                .branchId("002")
                .branchName("BBBB-Branch")
                .lastUpdatedAt(new Timestamp(System.currentTimeMillis()))
                .financialInstitutionByFinancialCode(financialInstitution2)
                .savingsAccounts(Arrays.asList(savingsAccount2))
                .ver(0)
                .build();
        testEntityManager.persist(User.builder().userId("00000001").firstName("FirstName1")
                .savingsAccountsByUserId(Arrays.asList(savingsAccount1)).build());
        testEntityManager.persist(User.builder().userId("00000002").firstName("FirstName2")
                .savingsAccountsByUserId(Arrays.asList(savingsAccount2)).build());
        testEntityManager.persist(financialInstitution1);
        testEntityManager.persist(financialInstitution2);
//        testEntityManager.persist(branch1);
//        testEntityManager.persist(branch2);
//        testEntityManager.persist(savingsAccount1);
//        testEntityManager.persist(savingsAccount2);
    }

    @Test
    public void testExistsById(){

        FinancialInstitution financialInstitution = financialInstitutionRepository.getOne("0001");
//        financialInstitution.getBranchesByFinancialCode()
//                .stream().forEach(p ->log.info(p.getBranchName()));
   //     Branch branch = branchRepository.getOne(BranchPK.builder().financialCode("0001").branchId("001").build());
//        log.info("Branch" + branch.toString());
        boolean isExists = savingsAccountRepository.existsById(
                SavingsAccountPK.builder()
                        .userId("00000001")
                        .financialCode("0001")
                        .branchId("001")
                        .accountNo("0000001")
                        .build());
        if(isExists){
            log.info("existsById is true.");
        }else {
            log.info("existsById is false.");
        }
    }
}
