

"""Python implementation of the GRPC server."""

from concurrent import futures
import time

import grpc

import ExampleServices_pb2
import ExampleServices_pb2_grpc

_ONE_DAY_IN_SECONDS = 60 * 60 * 24


class Greeter(ExampleServices_pb2_grpc.GreetingServiceServicer):

  def greeting(self, request, context):
    print("From Client: %s" % request.msg)
    return ExampleServices_pb2.HelloResponse(greeting='%s World' % request.msg)
    
def serve():
  server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
  ExampleServices_pb2_grpc.add_GreetingServiceServicer_to_server(Greeter(), server)
  server.add_insecure_port('[::]:10010')
  server.start()
  print("Server Started")
  try:
    while True:
      time.sleep(_ONE_DAY_IN_SECONDS)
  except KeyboardInterrupt:
    server.stop(0)

if __name__ == '__main__':
  serve()
