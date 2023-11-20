// chat.component.ts

import { Component, OnInit } from '@angular/core';
import { SocketService } from '../../services/socket.service';  // Correction du chemin d'importation

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messages: string[] = [];
  messageInput: string = '';

  constructor(private socketService: SocketService) {}

  ngOnInit(): void {
    const messageObservable = this.socketService.receiveMessage();
    if (messageObservable) {
      messageObservable.subscribe((data: string) => {
        this.messages.push(data);
      });
    }
  }

  sendMessage() {
    if (this.messageInput.trim() !== '') {
      this.socketService.sendMessage(this.messageInput);
      this.messageInput = ''; // Efface le champ de saisie après l'envoi
    }
  }
}