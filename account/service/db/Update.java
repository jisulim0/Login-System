package io.wisoft.second.project.account.service.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

  private Connection conn = null;
  private PreparedStatement ps = null;

  public void password(String id, String newPassword){
    try{
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query = "UPDATE userinformation SET password = ? WHERE id = ?";
      ps = conn.prepareStatement(query);

      ps.setString(1, newPassword);
      ps.setString(2, id);

      int retValue = ps.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 요청사항이 처리되었습니다.");
    }catch (SQLException sqex) {
      try {
        if (conn != null) {
          conn.rollback();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("SQLExeption : " + sqex.getMessage());
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

  public void birthday(String id, String password, String newBirthday){
    try{
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query = "UPDATE userinformation SET birthday = ? WHERE id = ? AND password = ?";
      ps = conn.prepareStatement(query);

      ps.setDate(1, Date.valueOf(newBirthday));
      ps.setString(2, id);
      ps.setString(3, password);

      int retValue = ps.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 요청사항이 처리되었습니다.");
    }catch (SQLException sqex) {
      try {
        if (conn != null) {
          conn.rollback();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("SQLExeption : " + sqex.getMessage());
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

  public void answer(String id, String password, String newAnswer){
    try{ //리소스문
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query = "UPDATE userinformation SET answer = ? WHERE id = ? AND password = ?";
      ps = conn.prepareStatement(query);

      ps.setString(1, newAnswer);
      ps.setString(2, id);
      ps.setString(3, password);

      int retValue = ps.executeUpdate();
      conn.commit();

      System.out.println(retValue + "건의 요청사항이 처리되었습니다.");
    }catch (SQLException sqex) {
      try {
        if (conn != null) {
          conn.rollback();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("SQLExeption : " + sqex.getMessage());
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
