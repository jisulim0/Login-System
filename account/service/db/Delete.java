package io.wisoft.second.project.account.service.db;

import io.wisoft.second.project.account.vo.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

  Connection conn = null;
  PreparedStatement ps = null;

  public void user(String id, String password, Account account){
    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query = "delete from userinformation where id = ? and password = ?";
      ps = conn.prepareStatement(query);

      ps.setString(1, id);
      ps.setString(2, password);

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
      System.out.println("SQLException : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (ps != null) {
        try {
          ps.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
