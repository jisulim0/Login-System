package io.wisoft.second.project.account.service.db;

import io.wisoft.second.project.account.vo.Account;

import java.sql.*;

public class Select {

  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  public int checkReceivedIdExists(String id) {
    int count = 0;

    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select count(*) from userinformation where id = ?";
      ps = conn.prepareStatement(query);
      ps.setString(1, id);
      rs = ps.executeQuery();

      if (rs.next()) {
        count = Integer.parseInt(rs.getString(1));
      }

    } catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return count;
  }

  public String checkIfPasswordMatchesID(String id){
    String password = " ";
    try{
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select password from userinformation where id = ?";
      ps = conn.prepareStatement(query);
      ps.setString(1, id);
      rs = ps.executeQuery();

      if(rs.next()){
        password = rs.getString(1);
      }
    }catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return password;
  }

  public Account setInfoByIdPassword(final String id, final String password, final Account account){
    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select * from userinformation where id = ? and password =?";
      ps = conn.prepareStatement(query);
      ps.setString(1, id);
      ps.setString(2, password);
      rs = ps.executeQuery();

      while (rs.next()) {
        account.setId(rs.getString(1));
        account.setPassword(rs.getString(2));
        account.setUserName(rs.getString(3));
        account.setBirthday(rs.getString(4));
        account.setGender(rs.getString(5));
        account.setAnswer(rs.getString(6));
      }

    } catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return account;
  }

  public int existBirthAns(String birthday, String answer){
    int count = 0;

    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select count(*) from userinformation where birthday = ? and answer = ?";
      ps = conn.prepareStatement(query);
      ps.setDate(1, Date.valueOf(birthday));
      ps.setString(2, answer);
      rs = ps.executeQuery();

      if (rs.next()) {
        count = Integer.parseInt(rs.getString(1));
      }   //true false

    } catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return count;
  }

  public Account setInfoByBirthAns(String birthday, String answer, Account account){
    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select id from userinformation where birthday = ? and answer =?";
      ps = conn.prepareStatement(query);
      ps.setDate(1, Date.valueOf(birthday));
      ps.setString(2, answer);
      rs = ps.executeQuery();

      while (rs.next()) {
        account.setId(rs.getString(1));
      }

    } catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return account;
  }

  public int existIdAns(String id, String answer){
    int count = 0;

    try {
      conn = PostgresqlAccess.getConnection();
      conn.setAutoCommit(false);

      String query =
          "select count(*) from userinformation where id = ? and answer = ?";
      ps = conn.prepareStatement(query);
      ps.setString(1, id);
      ps.setString(2, answer);
      rs = ps.executeQuery();

      if (rs.next()) {
        count = Integer.parseInt(rs.getString(1));
      }

    } catch (SQLException sqex) {
      System.out.println("SQLExeption : " + sqex.getMessage());
      System.out.println("SQLState : " + sqex.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
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
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    return count;
  }

}
