package io.wisoft.second.project.account.controller;

public class CheckBirthday {

  public boolean correct(final String birthday){
    if(birthday.length() != 10){
      return false;
    }

    String year = birthday.substring(0,4);
    String month = birthday.substring(5,7);
    String date = birthday.substring(8);

    if(!birthday.substring(4,5).equals("-") || !birthday.substring(7,8).equals("-")){
      return false;
    }

    if(date.length() != 2){
      return false;
    }

    try{
      Integer.parseInt(year);
      Integer.parseInt(month);
      Integer.parseInt(date);
    } catch (NumberFormatException e) {
      return false;
    }

    return true;
  }

}
