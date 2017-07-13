package demo.helloworld.grpc.server;

import demo.helloworld.grpc.GreetingServiceGrpc;
import demo.helloworld.grpc.HelloRequest;
import demo.helloworld.grpc.HelloResponse;
import demo.helloworld.grpc.HelloResponseOrBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class MyGrpcServer {
  static public void main(String [] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(10010)
        .addService(new GreetingServiceImpl()).build();

    System.out.println("Starting server...");
    server.start();
    System.out.println("Server started!");
    server.awaitTermination();
  }

  public static class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
      System.out.println("Client: " + request.getMsg());

      String greeting = request.getMsg() + " World";

      HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }
}
