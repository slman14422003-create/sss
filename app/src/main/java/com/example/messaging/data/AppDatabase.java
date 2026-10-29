package com.example.messaging.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.messaging.model.Message;
import com.example.messaging.model.Conversation;

/**
 * قاعدة البيانات الوحيدة للتطبيق.
 */
@Database(entities = {Message.class, Conversation.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MessageDao messageDao();
    public abstract ConversationDao conversationDao();
}
