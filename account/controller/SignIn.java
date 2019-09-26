package io.wisoft.second.project.account.controller;

import io.wisoft.second.project.account.service.Edit;
import io.wisoft.second.project.account.service.ViewService;
import io.wisoft.second.project.account.service.db.Select;
import io.wisoft.second.project.account.vo.Account;

import java.util.Scanner;

public class SignIn implements ViewService {

  private Select select = new Select();
  private Account account = new Account();
  public Edit edit;

  private Scanner scanner = new Scanner(System.in);

  public void view(){
    System.out.println("§----------------------------------------§");
    System.out.println("                 Sign In                  ");
    System.out.println("§----------------------------------------§");
    System.out.print("      [ ID ]  :   ");
    String id = scanner.next();
    System.out.print("[ Password ]  :   ");
    String password = scanner.next();

    if(select.checkReceivedIdExists(id) != 1){
      System.out.println("ID does not exist.");
      view();
    }else {
      match(id, password);
    }

    Menu menu = new Menu();
    menu.edit(edit, account);
  }

  private void match(final String id, final String password){
    String returnPassword;

    returnPassword = select.checkIfPasswordMatchesID(id);

    if(password.equals(returnPassword)){
      edit =  new Edit();
      select.setInfoByIdPassword(id, password, account);
      edit.view();
    }else {
      System.out.println("Passwords don't match!");
      System.out.println("Please enter it again!");
      view();
    }

  }

}
