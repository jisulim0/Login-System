package io.wisoft.second.project.account.service;

import java.util.Scanner;

import io.wisoft.second.project.account.controller.Back;
import io.wisoft.second.project.account.controller.CheckBirthday;
import io.wisoft.second.project.account.service.db.Select;
import io.wisoft.second.project.account.service.db.Update;
import io.wisoft.second.project.account.vo.Account;

public class Find implements ViewService {

  private Account account = new Account();
  private Select select = new Select();
  private Update update = new Update();
  private Back goBack = new Back();

  public void view() {
    System.out.println("");
    System.out.println("====================================================================");
    System.out.println("                Find your ID and password.");
    System.out.println("                  Please select a menu.");
    System.out.println("            If you want to return to the menu,");
    System.out.println("          enter 'Back' correctly in the input box.");
    System.out.println("====================================================================");
  }

  public void id() {
    CheckBirthday check = new CheckBirthday();
    Scanner scn = new Scanner(System.in);

    String birthday;
    String answer;

    System.out.println("\n§------------------------------------------§");
    System.out.println("  Find your ID by birthday and question.");
    System.out.println("§------------------------------------------§");

    while (true) {
      System.out.println(" ");
      while (true) {
        System.out.println("  1. When is your Birthday?");
        System.out.print("    >> ");
        birthday = scn.next();

        if (birthday.equals("Back")) {
          goBack.menu();
        }

        System.out.println("  2. What is your favorite food?");
        System.out.print("    >> ");
        answer = scn.next();

        if (answer.equals("Back")) {
          goBack.menu();
        }

        if (check.correct(birthday)) {
          account.setBirthday(birthday);
          break;
        } else {
          System.out.println("You mistyped it.");
          System.out.println("Please enter according to the format.");
        }
      }

      if (select.existBirthAns(birthday, answer) > 0) {
        select.setInfoByBirthAns(birthday, answer, account);
        break;
      } else {
        System.out.println("This information does not exist.");
      }
    }

    System.out.println(" ");
    System.out.println("Your Id is    \" " + account.getId() + "\"");
  }

  public void password() {
    Scanner scn = new Scanner(System.in);

    String id;
    String answer;

    System.out.println("§-----------------------------------------------------§");
    System.out.println("  Please answer the questions to reset your password.");
    System.out.println("§-----------------------------------------------------§");

    System.out.println("  1. What is your ID ");
    System.out.print("    >> ");
    id = scn.next();

    if (id.equals("Back")) {
      goBack.menu();
    }

    System.out.println("  2. What is your favorite food??");
    System.out.print("    >>");
    answer = scn.next();

    if (answer.equals("Back")) {
      goBack.menu();
    }

    System.out.println("Reset your password.");

    while (true) {
      if (select.existIdAns(id, answer) > 0) {
        while (true) {
          System.out.print("Password >> ");
          String checkPassword = scn.next();

          System.out.print("Reconfirm password >> ");
          String coincide = scn.next();

          if (!checkPassword.equals(coincide)) {
            System.out.println("Passwords don't match");
            System.out.println("Please enter it again.");
          } else {
            account.setPassword(checkPassword);
            break;
          }
        }
        update.password(id, account.getPassword());
        break;
      } else {
        System.out.println("This information does not exist.");
      }
    }
  }

}
