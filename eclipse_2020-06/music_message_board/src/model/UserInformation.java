package model;
import java.io.Serializable;

public class UserInformation implements Serializable {
    private String name;
    private String pass;


    public UserInformation(){}
    public UserInformation (String name , String pass){
        this.name = name;
        this.pass = pass;
    }

    public String getName(){
        return name;
    }
    public String getPass(){
        return pass;
    }
}
