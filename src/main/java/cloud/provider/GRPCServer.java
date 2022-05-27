package cloud.provider;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(9000).addService(new CloudDriveService()).build();
        try{
            server.start();
        }
        catch(Exception e){
            System.out.println("Something went wrong while starting the server: " + e);
        }
        System.out.println("Server started at: " + server.getPort());
        try{
            server.awaitTermination();
        }
        catch(Exception e){
            System.out.println("Something went wrong while awaiting for server termination: " + e);
        }
    }

}