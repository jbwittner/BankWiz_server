package fr.bankwiz.server.infrastructure.spijpa;

import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles(value = {"test"})
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
@DisplayName("SPI JPA Layer Test")
@Sql(
        scripts = {"/sql/clean_test.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public abstract class SpiJpaApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(SpiJpaApplicationTests.class.getSimpleName());
    private static final Logger DB_LOG = LoggerFactory.getLogger(MySQLContainer.class);

    private static final MySQLContainer<?> dbContainer =
            new MySQLContainer<>(DockerImageName.parse("mysql:9.0.0")).withLogConsumer(new Slf4jLogConsumer(DB_LOG));

    static {
        dbContainer.withInitScript("sql/init_table.sql");
        dbContainer.start();
    }

    @DynamicPropertySource
    static void configureProperties(final DynamicPropertyRegistry registry) {
        LOG.info("dbContainer JdbcUrl : {}", dbContainer.getJdbcUrl());
        LOG.info("dbContainer username : {}", dbContainer.getUsername());
        LOG.info("dbContainer password : {}", dbContainer.getPassword());
        registry.add("spring.datasource.url", dbContainer::getJdbcUrl);
        registry.add("spring.datasource.username", dbContainer::getUsername);
        registry.add("spring.datasource.password", dbContainer::getPassword);
    }
}
