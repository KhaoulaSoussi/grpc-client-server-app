package cloud.provider;

import io.grpc.stub.StreamObserver;
import java.io.File;
import java.io.FileOutputStream;

public class CloudDriveService extends cloudDriveGrpc.cloudDriveImplBase {
    String folderPath;

    @Override
    public void createBackupFolder(CloudDrive.createFolderRequest request, StreamObserver<CloudDrive.Response> responseObserver) {
        String folderName = request.getFolderName();
        boolean isCreated;
        folderPath = folderName + "_Backup/";
        File dir = new File(folderPath);
        if(!dir.exists()) {
            isCreated = dir.mkdir();
        }
        else {
            isCreated = true;
        }
        CloudDrive.Response.Builder response = CloudDrive.Response.newBuilder();
        String responseStr;
        if(!isCreated) {
            responseStr = "FAILURE: FAILED TO CREATE " + folderName + "_Backup" + " IN THE CLOUD...";
            response.setResponse(responseStr);
        }
        else{
            responseStr = "SUCCESS: " + folderName + "_Backup" + " CREATED SUCCESSFULLY...";
            response.setResponse(responseStr);
        }
        System.out.println(responseStr);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void uploadFile(CloudDrive.updateFileRequest request, StreamObserver<CloudDrive.Response> responseObserver){
        String fileName = request.getFileName();
        int fileSize = request.getFileSize();
        byte[] fileBytes = request.getFileBytes().toByteArray();
        CloudDrive.Response.Builder response = CloudDrive.Response.newBuilder();
        String responseStr;
        try{
            FileOutputStream fileOut = new FileOutputStream(folderPath + fileName);
            fileOut.write(fileBytes, 0, fileSize);
            fileOut.close();
            responseStr = "SUCCESS: " + fileName + " UPLOADED SUCCESSFULLY...";
            response.setResponse(responseStr);
        }
        catch (Exception e){
            responseStr = "FAILURE: FAILED TO UPLOAD " + fileName + " TO THE CLOUD...";
            response.setResponse(responseStr);
        }
        System.out.println(responseStr);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteFile(CloudDrive.deleteFileRequest request, StreamObserver<CloudDrive.Response> responseObserver) {
        String fileName = request.getFileName();
        CloudDrive.Response.Builder response = CloudDrive.Response.newBuilder();
        File to_delete = new File(folderPath + fileName);
        String responseStr;
        if (to_delete.delete()){
            responseStr = "SUCCESS: " + fileName + " DELETED SUCCESSFULLY...";
            response.setResponse(responseStr);
        }
        else {
            responseStr = "FAILURE: FAILED TO DELETE " + fileName + " FROM THE CLOUD...";
            response.setResponse(responseStr);
        }
        System.out.println(responseStr);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
