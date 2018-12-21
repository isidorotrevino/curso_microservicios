package com.ies.curso.dia5.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@Factory
public class MyBatisFactory {

    protected static final String PRUEBA_REACTIVE_MAPPER="mappers/com/ies/curso/dia5/prueba_reactive.xml";

    protected static final String[] MAPPERS = {PRUEBA_REACTIVE_MAPPER} ;

    @Inject
    DataSource dataSource;

    @Bean
    @Singleton
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment =
                new Environment("production", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        for(String mapperResource : MAPPERS ){
            InputStream inputStream = Resources.getResourceAsStream(mapperResource);
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, mapperResource, configuration.getSqlFragments());
            mapperParser.parse();
        }

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);

        for(String map : sqlSessionFactory.getConfiguration().getMappedStatementNames()){
            System.out.println("Statement registrado: "+map);
        }

        return sqlSessionFactory;
    }

}
