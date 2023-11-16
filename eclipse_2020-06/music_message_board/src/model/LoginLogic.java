package model;

public class LoginLogic {
    public boolean execute (UserInformation user){
        if (user.getPass().equals("pass")) { return true; }
        return false;
    }
}
