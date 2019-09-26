package io.wisoft.second.project.account.service.db;

import io.wisoft.second.project.account.vo.Account;
import java.sql.*;

public class Insert {

  private Connection conn = null;
  private PreparedStatement ps = null;

  public void information(Account account) {
    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query = "INSERT INTO userinformation(id, password, name, birthday, gender, answer) VALUES (?,?,?,?,?,?)";
      ps = conn.prepareStatement(query);
      ps.setString(1, account.getId());
      ps.setString(2, account.getPassword());
      ps.setString(3, account.getUserName());
      ps.setDate(4, Date.valueOf(account.getBirthday()));
      ps.setString(5, account.getGender());
      ps.setString(6, account.getAnswer());

      int retValue = ps.executeUpdate();
      conn.commit();
      System.out.println(retValue + "건의 사항이 처리되었습니다.");
    } catch (SQLException sqex) {
      try {
        if (conn != null) {
          conn.rollback();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      System.out.println("SQLExeption: " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (ps != null) {
        try {
          ps.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
