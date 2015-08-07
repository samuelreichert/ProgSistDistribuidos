require 'socket'

socket = TCPSocket.open("www.feevale.br", 80)
socket.print("GET / HTTP/1.0\r\n\r\n")
print socket.read

# socket = TCPSocket.open("www.feevale.br", 80)
# socket.print("GET / HTTP/1.0\r\n\r\n")
# response = socket.read
# print response
# headers,body = response.split("\r\n\r\n", 2)
# print headers
# print "\r\n\r\n"
# print body

