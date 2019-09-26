package io.wisoft.second.project.account.controller;

import io.wisoft.second.project.account.service.ViewService;
import io.wisoft.second.project.account.service.db.Delete;
import io.wisoft.second.project.account.service.db.Select;
import io.wisoft.second.project.account.vo.Account;

import java.util.Scanner;

public class Secession implements ViewService {

  private Select select = new Select();
  private Delete delete = new Delete();
  private Back goBack = new Back();
  private Account account = new Account();

  public void view() {
    System.out.println("§--------------------------------§");
    System.out.println("    Delete your information.");
    System.out.println("§--------------------------------§");

    matchInfo();
  }

  public void matchInfo() {
    String id;
    String password;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("      [ ID ]  :   ");
      id = scanner.next();

      if (id.equals("Back")) {
        goBack.menu();
      }
      if (select.checkReceivedIdExists(id) != 1) {
        System.out.println("ID does not exist.");
        matchInfo();
      } else {
        account.setId(id);
        break;
      }
    }

    while (true) {
      System.out.print("[ Password ]  :   ");
      password = scanner.next();

      if (password.equals("Back")) {
        goBack.menu();
      }
      if (select.checkIfPasswordMatchesID(id).equals(password)) {
        account.setPassword(password);
        delete.user(account.getId(), account.getPassword(), account);
        break;
      }else{
        System.out.println("The password is incorrect.");
      }
    }

  }

}
