package grpcService;

import com.bjit.grpc.User.APIResponse;
import com.bjit.grpc.User.Empty;
import com.bjit.grpc.User.LoginRequest;
import com.bjit.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			response.setResponseCode(200).setResponsemessage("*********** Success *********");
		}
		else {
			response.setResponseCode(400).setResponsemessage("*********** Invalid Password *******");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {

	}

}
