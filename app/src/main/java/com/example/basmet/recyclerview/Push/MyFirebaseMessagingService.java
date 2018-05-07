package com.example.basmet.recyclerview.Push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by basmet on 4/7/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // Check if message contains a data payload.
        if (remoteMessage.getNotification()!= null) {
            NewMessageNotification.notify(this,remoteMessage.getNotification().getBody(),89);

        }
    }
}
