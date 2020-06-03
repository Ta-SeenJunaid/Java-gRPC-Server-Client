package grpcClient;

import com.bjit.grpc.User.APIResponse;
import com.bjit.grpc.User.LoginRequest;
import com.bjit.grpc.userGrpc;
import com.bjit.grpc.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("Jun").setPassword("Jun").build();
		
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println("Response code: " + response.getResponseCode());

		System.out.println("Response message: " + response.getResponsemessage());
	}

}
