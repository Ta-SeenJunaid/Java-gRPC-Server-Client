package grpcServer;

import java.io.IOException;

import grpcService.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Server server = ServerBuilder.
				forPort(9090).addService(new UserService()).build();
		
		server.start();
		
		System.out.println("Server started at" + server.getPort());
		
		server.awaitTermination();
		
		
	}

}