import { Injectable } from '@angular/core';
import io from 'socket.io-client';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SocketService {
  private socket: any;
  private serverUrl = 'http://localhost:80';

  constructor() {
    this.socket = io(this.serverUrl);
  }

  sendMessage(message: string) {
    this.socket.emit('chat-message', message);
  }

  receiveMessage(): Observable<string> {
    return new Observable<string>(observer => {
      this.socket.on('chat-message', (data: string) => {
        observer.next(data);
      });
    });
  }
}