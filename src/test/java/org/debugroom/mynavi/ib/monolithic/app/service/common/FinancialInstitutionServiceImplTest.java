package org.debugroom.mynavi.ib.monolithic.app.service.common;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.debugroom.mynavi.ib.monolithic.config.TestConfig;

import org.debugroom.mynavi.ib.monolithic.app.service.common.impl.FinancialInstitutionServiceImpl;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Branch;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FinancialInstitution;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.FinancialInstitutionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.ServiceTestConfig.class,
        FinancialInstitutionServiceImplTest.Config.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FinancialInstitutionServiceImplTest {

    @Configuration
    public static class Config{
        @Bean
        FinancialInstitutionService financialInstitutionService(){
            return new FinancialInstitutionServiceImpl();
        }
    }

    @MockBean
    FinancialInstitutionRepository financialInstitutionRepositoryMock;

    @Autowired
    @Qualifier("financialInstitutionService")
    FinancialInstitutionService financialInstitutionService;

    @Test
    public void testGetFinancialInstitutions(){
        String financialCode1 = "0001";
        String financialCode2 = "0002";
        String financialInstitutionName1 = "AAAA";
        String financialInstitutionName2 = "BBBB";
        FinancialInstitution mockFinancialInstitution1 = FinancialInstitution.builder()
                .financialCode(financialCode1)
                .financialInstitutionName(financialInstitutionName1)
                .branchesByFinancialCode(Arrays.asList(
                        Branch.builder()
                                .financialCode(financialCode1)
                                .branchId("000")
                                .branchName("AAAA-Branch")
                                .build()
                ))
                .build();
        FinancialInstitution mockFinancialInstitution2 = FinancialInstitution.builder()
                .financialCode(financialCode2)
                .financialInstitutionName(financialInstitutionName2)
                .branchesByFinancialCode(Arrays.asList(
                        Branch.builder()
                                .financialCode(financialCode2)
                                .branchId("001")
                                .branchName("BBBB-Branch")
                                .build()
                ))
                .build();
        List<FinancialInstitution> financialInstitutions = new ArrayList<>();
        financialInstitutions.add(mockFinancialInstitution1);
        financialInstitutions.add(mockFinancialInstitution2);
        when(financialInstitutionRepositoryMock.findAll()).thenReturn(financialInstitutions);

        log.info(financialInstitutionService.getFinancialInstitions().toString());

    }

    @Test
    public void testGetBranches(){
        String financialCode1 = "0001";
        String financialCode2 = "0002";
        String financialInstitutionName1 = "AAAA";
        String financialInstitutionName2 = "BBBB";
        FinancialInstitution mockFinancialInstitution1 = FinancialInstitution.builder()
                .financialCode(financialCode1)
                .financialInstitutionName(financialInstitutionName1)
                .branchesByFinancialCode(Arrays.asList(
                        Branch.builder()
                                .financialCode(financialCode1)
                                .branchId("000")
                                .branchName("AAAA-Branch")
                                .build()
                ))
                .build();
        FinancialInstitution mockFinancialInstitution2 = FinancialInstitution.builder()
                .financialCode(financialCode2)
                .financialInstitutionName(financialInstitutionName2)
                .branchesByFinancialCode(Arrays.asList(
                        Branch.builder()
                                .financialCode(financialCode2)
                                .branchId("001")
                                .branchName("BBBB-Branch")
                                .build()
                ))
                .build();
        when(financialInstitutionRepositoryMock.getOne("0001")).thenReturn(mockFinancialInstitution1);
        when(financialInstitutionRepositoryMock.getOne("0002")).thenReturn(mockFinancialInstitution2);

        log.info(financialInstitutionService.getBranches("0001").toString());
        log.info(financialInstitutionService.getBranches("0002").toString());

    }

}
