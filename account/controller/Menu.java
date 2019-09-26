package io.wisoft.second.project.account.controller;

import io.wisoft.second.project.account.service.Edit;
import io.wisoft.second.project.account.service.Find;
import io.wisoft.second.project.account.vo.Account;

import java.util.Scanner;

public class Menu {

  private SignUp signUp = new SignUp();
  private SignIn signIn = new SignIn();
  private Find find = new Find();
  private Secession secession = new Secession();

  private Scanner scanner = new Scanner(System.in);

  public void start() {
    String menuSelection;
    boolean match = true;

    System.out.println("===================================");
    System.out.println("              WELCOME              ");
    while (match) {
      System.out.println("===================================");
      System.out.println("||  a. Sign in");
      System.out.println("||  b. Sign up");
      System.out.println("||  c. Find your ID or password");
      System.out.println("||  d. secession");
      System.out.println("||  e. exit");
      System.out.println();
      System.out.print("please select >> ");
      menuSelection = scanner.next();
      System.out.println();
      switch (menuSelection) {
        case "a":
          signIn.view();
          break;
        case "b":
          signUp.view();
          break;
        case "c":
          find();
          break;
        case "d":
          secession.view();
          break;
        case "e":
          System.out.println("End of program.");
          match = false;
          break;
        default:
          System.out.println("Invalid input! Please enter it again.");
      }
    }
    System.out.println("===================================");
    System.out.println();
  }

  public void edit(final Edit edit, final Account account) {
    boolean match = true;

    while (match) {
      System.out.println("||  1. Password");
      System.out.println("||  2. Birthday");
      System.out.println("||  3. Answer");
      System.out.println("||  4. Log out!");

      System.out.println();
      System.out.print("please select >> ");
      String menuSelection = scanner.next();
      System.out.println();
      switch (menuSelection) {
        case "1":
          edit.password(account);
          break;
        case "2":
          edit.birthday(account);
          break;
        case "3":
          edit.answer(account);
          break;
        case "4":
          match = false;
          break;
        default:
          System.out.println("Invalid input! Please enter it again.");
      }
    }
    System.out.println("===================================");
    System.out.println();
  }

  public void find(){
    boolean match = true;

    while (match) {
      find.view();
      System.out.println("||  1. Find ID");
      System.out.println("||  2. Find Password");
      System.out.println("||  3. Back");

      System.out.println();
      System.out.print("please select >> ");
      String menuSelection = scanner.next();
      System.out.println();
      switch (menuSelection) {
        case "1":
          find.id();
          break;
        case "2":
          find.password();
          break;
        case "3":
          start();
          match = false;
          break;
        default:
          System.out.println("Invalid input! Please enter it again.");
      }
    }
    System.out.println("===================================");
    System.out.println();
  }

}

