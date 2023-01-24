package pl.wiktorowski.jdbccar;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration

public class Config {


    @Bean

    public DataSource getDataSource()

    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://sql.freedb.tech:3306");
        dataSourceBuilder.username("freedb_xannn");
        dataSourceBuilder.password("$DAT$Nfe3GhJCv2");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();

    }



}
