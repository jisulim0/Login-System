package io.wisoft.second.project.account.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlAccess {

  private static Connection conn = null;

  public void init() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    String url = "";
    String username = "";
    String password = "";

    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

}
