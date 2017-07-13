To run Server or Client in JAVA:
  Go to grpcDemo/grpc-java

  $ cd grpcDemo/grpc-java
  $ mvn install

Run GRPC JAVA Server:

  $ cd grpcDemo/grpc-java/simple-grpc-server
  $ mvn install exec:java -Dexec.mainClass=demo.helloworld.grpc.server.MyGrpcServer
  
Run GRPC JAVA Client:
  
  $ cd grpcDemo/grpc-java/simple-grpc-client
  $ mvn install exec:java -Dexec.mainClass=demo.helloworld.grpc.client.MyGrpcClient
