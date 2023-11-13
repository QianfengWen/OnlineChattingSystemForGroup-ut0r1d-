package main.java.chattingSystem.entities.Message;

import java.time.LocalDateTime;

public class TextMessageFactory implements MessageFactory{
    public Message create(int messageID, String senderID, String senderName, LocalDateTime timestamp, String text) {
        return new TextMessage(messageID, senderID, senderName, timestamp, text);
    }
}
