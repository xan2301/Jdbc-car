package pl.wiktorowski.jdbccar;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration

public class Config {


    @Bean

    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("natalia2301");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();

    }

    @Bean

    public JdbcTemplate getJdbcTemplate() {

        return new JdbcTemplate(getDataSource());

    }

    @EventListener(ApplicationReadyEvent.class)

    public void dbinit() {

       String sql = ("CREATE TABLE nazwaTabeli ( ID INT, Imie VARCHAR(200), Nazwisko VARCHAR(200) )");

//hh

        getJdbcTemplate().update(sql);
    }


}
