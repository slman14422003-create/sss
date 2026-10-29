package com.example.messaging.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * كيان يمثل رسالة داخل محادثة.
 */
@Entity(tableName = "messages")
public class Message {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String conversationId;   // معرف المحادثة

    @NonNull
    public String text;

    public long timestamp;          // الوقت بالمللي ثانية

    public boolean isSentByUser;    // true إذا أرسلها المستخدم

    public Message(@NonNull String conversationId,
                   @NonNull String text,
                   long timestamp,
                   boolean isSentByUser) {
        this.conversationId = conversationId;
        this.text = text;
        this.timestamp = timestamp;
        this.isSentByUser = isSentByUser;
    }
}
