
package demo.helloworld.grpc.client;

import demo.helloworld.grpc.GreetingServiceGrpc;
import demo.helloworld.grpc.HelloRequest;
import demo.helloworld.grpc.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
  public static void main(String[] args) throws InterruptedException {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 10010)
        .usePlaintext(true)
        .build();

    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.greeting(
        HelloRequest.newBuilder()
            .setMsg("Hello")
            .build());

    System.out.println("Server " + helloResponse);

    channel.shutdown();
  }
}
