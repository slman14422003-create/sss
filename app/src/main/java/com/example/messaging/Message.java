package com.example.messaging;

/**
 * نموذج بيانات الرسالة.
 */
public class Message {
    private final String text;
    private final boolean isSentByUser; // true إذا أرسلها المستخدم، false إذا استقبلها

    public Message(String text, boolean isSentByUser) {
        this.text = text;
        this.isSentByUser = isSentByUser;
    }

    public String getText() {
        return text;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }
}
