require 'socket'

server = TCPServer.new 8088
print "Porta 8088 aberta!"
loop do
  client = server.accept
  
  print client.read

  client.close
end
