package com.app.controllers;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

@SocketController
public class ChatController<ChatMessage> {

    @EventMapping("chat-message")
    public void handleChatMessage(SocketIOClient client, ChatMessage message) {
        // Traitez le message et diffusez-le à tous les clients connectés
        socketIOServer().getBroadcastOperations().sendEvent("chat-message", message);
    }

    private SocketIOServer socketIOServer() {
        return null;
    }
}

