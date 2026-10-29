package com.example.messaging.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * كيان يمثل محادثة (دردشة) مع شخص أو مجموعة.
 */
@Entity(tableName = "conversations")
public class Conversation {

    @PrimaryKey
    @NonNull
    public String id;               // يمكن أن يكون UUID أو رقم هاتف

    @NonNull
    public String title;            // اسم المرسل أو اسم المجموعة

    public long lastMessageTime;    // توقيت آخر رسالة لفرز القائمة

    public Conversation(@NonNull String id, @NonNull String title, long lastMessageTime) {
        this.id = id;
        this.title = title;
        this.lastMessageTime = lastMessageTime;
    }
}
