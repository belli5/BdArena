//package com.exbv.BdArena.Config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration // Indica que esta é uma classe de configuração do Spring
//public class configArena{
//
//    // Injeta o valor da URL do banco de dados a partir das propriedades configuradas
//    @Value("${my.app.datasource_url}")
//    private String datasourceUrl;
//
//    // Injeta o nome de usuário para o banco de dados a partir das propriedades configuradas
//    @Value("${my.app.datasource_username}")
//    private String datasourceUsername;
//
//    // Injeta a senha para o banco de dados a partir das propriedades configuradas
//    @Value("${my.app.datasource_password}")
//    private String datasourcePassword;
//
//    // Define um bean do tipo DataSource para gerenciar a conexão com o banco de dados
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        // Configura o driver do MySQL
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//
//        // Configura a URL do banco de dados
//        dataSource.setUrl(datasourceUrl);
//
//        // Configura o nome de usuário do banco de dados
//        dataSource.setUsername(datasourceUsername);
//
//        // Condicional para configurar a senha:
//        // Se o valor da senha for "vazio", define como uma string vazia
//        // Caso contrário, usa o valor real configurado
//        if (datasourcePassword.equals("vazio")) {
//            dataSource.setPassword("");
//        } else {
//            dataSource.setPassword(datasourcePassword);
//        }
//
//        return dataSource; // Retorna o objeto DataSource configurado
//    }
//
//    // Define um bean do tipo JdbcTemplate, que usará o DataSource configurado
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource); // Cria e retorna o JdbcTemplate com o DataSource
//    }
//}