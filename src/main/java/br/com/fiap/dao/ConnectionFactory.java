package br.com.fiap.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection conexao;
    private String url;
    private String user;
    private String pass;
    private String driver;

    public ConnectionFactory(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }

    public static ConnectionFactory getInstance() {
        ConnectionFactory result = instance;
        if (result != null) {
            return result;
        }
        Properties prop = new Properties();
        FileInputStream file = null;
        try{
            file = new FileInputStream("./src/main/resources/application.properties");
            prop.load(file);
            String url = prop.getProperty("datasource.url");
            String user = prop.getProperty("datasource.username");
            String pass = prop.getProperty("datasorce.password");
            String driver = prop.getProperty("datasource.driver-class-name");
            file.close();
            if (instance == null) {
                instance = new ConnectionFactory(url, user, pass, driver);
            }
            return instance;
        } catch (FileNotFoundException e) {
            System.out.println("Erro (FileNotFoundException): ");
        } catch (IOException e) {
            System.out.println("Erro (IOException): " + e.getMessage());
        }
        return null;
    }

    public Connection getConexao() {
        
    }
}
