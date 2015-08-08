require 'socket'

socket = TCPSocket.open("www.feevale.br", 80)
socket.print("GET / HTTP/1.0\r\n\r\n")
print socket.read
