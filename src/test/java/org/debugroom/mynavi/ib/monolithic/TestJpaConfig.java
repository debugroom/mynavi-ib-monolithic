package org.debugroom.mynavi.ib.monolithic;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DataJpaTest needs @SpringBootConfiguration class in parent hierarchy
 * See https://stackoverflow.com/questions/39084491/unable-to-find-a-springbootconfiguration-when-doing-a-jpatest
 */
@SpringBootApplication
public class TestJpaConfig {
}