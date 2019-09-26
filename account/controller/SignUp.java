package io.wisoft.second.project.account.controller;

import io.wisoft.second.project.account.service.ViewService;
import io.wisoft.second.project.account.service.db.Insert;
import io.wisoft.second.project.account.service.db.Select;
import io.wisoft.second.project.account.vo.Account;

import java.util.Scanner;

public class SignUp implements ViewService {

  private Account account = new Account();
  private Scanner scanner = new Scanner(System.in);
  private Insert insert = new Insert();
  private Select select = new Select();
  private CheckBirthday check = new CheckBirthday();
  private Back goBack = new Back();

  public void view() {
    System.out.println("==================================================");
    System.out.println("                   ||  form  ||                   ");
    System.out.println("--------------------------------------------------");
    System.out.println();
    System.out.println("1.  You cannot type 'Back' in any input box.");
    System.out.println("2.  ID and Password must be 20 characters.");
    System.out.println("3.  Password and Confirm Password must be match.");
    System.out.println("4.  Name must be 10 charaters.");
    System.out.println("5.  Birthday Example : 1998-06-05");
    System.out.println("6.  Gender is F or M");
    System.out.println("7.  If you want to return to the menu,");
    System.out.println("    enter 'Back' correctly in the input box.");
    System.out.println();
    System.out.println("========  Please enter your information.  ========");
    System.out.println();

    enterId();
    enterPassword();
    enterName();
    enterBirthday();
    enterGender();
    enterAnswer();

    insert.information(account);
  }

  public void enterId() {
    System.out.println("--------------------------------------------------");

    while (true) {
      System.out.print("ID >> ");
      String checkId = scanner.next();
      if (checkId.equals("Back")) {
        goBack.menu();
      } else {
        if (select.checkReceivedIdExists(checkId) > 0) {
          System.out.println("This ID is already taken.");
          System.out.println("Please enter it again.");
        } else {
          account.setId(checkId);
          break;
        }
      }
    }
    System.out.println("");
  }

  public void enterPassword() {
    while (true) {
      System.out.print("Password >> ");
      String checkPassword = scanner.next();
      if (checkPassword.equals("Back")) {
        goBack.menu();
      } else {
        System.out.print("Reconfirm password >> ");
        String coincide = scanner.next();

        if (!checkPassword.equals(coincide)) {
          System.out.println("Passwords don't match");
          System.out.println("Please enter it again.");
        } else {
          account.setPassword(checkPassword);
          break;
        }
      }
    }

    System.out.println("");
  }

  public void enterName() {
    System.out.print("Name >> ");
    String checkName = scanner.next();
    if (checkName.equals("Back")) {
      goBack.menu();
    } else {
      account.setUserName(checkName);
    }

    System.out.println("");
  }

  public void enterBirthday() {
    while (true) {
      System.out.print("Birthday >>");
      String checkBirthday = scanner.next();

      if (checkBirthday.equals("Back")) {
        goBack.menu();
      }

      if (check.correct(checkBirthday)) {
        account.setBirthday(checkBirthday);
        break;
      } else {
        System.out.println("You mistyped it.");
        System.out.println("Please enter according to the format.");
      }
    }
    System.out.println(" ");
  }


  public void enterGender() {
    while (true) {
      System.out.print("Gender >> ");
      String checkGender = scanner.next();
      if (checkGender.equals("Back")) {
        goBack.menu();
      }
      if (checkGender.equals("F") || checkGender.equals("M")) {
        account.setGender(checkGender);
        break;
      } else {
        System.out.println("You mistyped it.");
        System.out.println("Please enter according to the format.");
      }

      System.out.println("");
    }
  }


  public void enterAnswer(){
    System.out.println("Question to find ID.");
    System.out.print("What is your favorite food? >> ");
    String checkAnswer = scanner.next();
    if (checkAnswer.equals("Back")) {
      goBack.menu();
    } else {
      account.setAnswer(checkAnswer);
    }
  }

}
