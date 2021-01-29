package model;
import java.util.List;

public class PostMessageLogic {
    public void execute(Message message,List<Message> messageList){
        messageList.add(0,message);
    }
}
