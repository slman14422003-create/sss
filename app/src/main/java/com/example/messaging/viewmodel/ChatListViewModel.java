package com.example.messaging.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.messaging.model.Conversation;
import com.example.messaging.repository.MessageRepository;

import java.util.List;

/**
 * ViewModel لقائمة الدردشات.
 */
public class ChatListViewModel extends AndroidViewModel {

    private final MessageRepository repository;
    private final LiveData<List<Conversation>> conversations;

    public ChatListViewModel(@NonNull Application application) {
        super(application);
        repository = new MessageRepository(application);
        conversations = repository.getAllConversations();
    }

    public LiveData<List<Conversation>> getConversations() {
        return conversations;
    }
}
