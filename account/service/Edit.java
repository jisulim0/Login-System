package io.wisoft.second.project.account.service;

import io.wisoft.second.project.account.controller.CheckBirthday;
import io.wisoft.second.project.account.service.db.Update;
import io.wisoft.second.project.account.vo.Account;

import java.util.Scanner;

public class Edit implements ViewService {

  private Update update = new Update();
  private Scanner scanner = new Scanner(System.in);

  public void view() {
    System.out.println("");
    System.out.println("====================================================================");
    System.out.println("              Member information editing window ");
    System.out.println("    Please enter the number of the information you wish to edit!");
    System.out.println("====================================================================");

    System.out.println("");
  }

  public void password(final Account account) {
    while (true) {
      System.out.print("New Password  >> ");
      String newPassword = scanner.next();
      System.out.print("Reconfirm Password  >>");
      String checkPassword = scanner.next();

      if (newPassword.equals(checkPassword)) {
        update.password(account.getId(), newPassword);
        break;
      } else {
        System.out.println("Passwords don't match");
        System.out.println("Please enter it again.");
      }
    }
  }

  public void birthday(final Account account) {
    CheckBirthday check = new CheckBirthday();
    while (true) {
      System.out.print("Birthday >>");
      String newBirthday = scanner.next();

      if (check.correct(newBirthday)) {
        account.setBirthday(newBirthday);
        update.birthday(account.getId(), account.getPassword(), newBirthday);
        break;
      } else {
        System.out.println("You mistyped it.");
        System.out.println("Please enter according to the format.");
      }
    }
  }

  public void answer(final Account account) {
    System.out.println("Question is 'What is your favorite food?' ");
    System.out.println("Answer >> ");
    String newAnswer = scanner.next();

    account.setAnswer(newAnswer);
    update.answer(account.getId(), account.getPassword(), newAnswer); //account 객체만 파라미터로 넘겨줌. 객체에서 null 이 아닌부분만 수정되는거니까..
  }

}
