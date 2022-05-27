package cloud.provider;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: cloudDrive.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class cloudDriveGrpc {

  private cloudDriveGrpc() {}

  public static final String SERVICE_NAME = "cloudDrive";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CloudDrive.createFolderRequest,
      CloudDrive.Response> getCreateBackupFolderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createBackupFolder",
      requestType = CloudDrive.createFolderRequest.class,
      responseType = CloudDrive.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CloudDrive.createFolderRequest,
      CloudDrive.Response> getCreateBackupFolderMethod() {
    io.grpc.MethodDescriptor<CloudDrive.createFolderRequest, CloudDrive.Response> getCreateBackupFolderMethod;
    if ((getCreateBackupFolderMethod = cloudDriveGrpc.getCreateBackupFolderMethod) == null) {
      synchronized (cloudDriveGrpc.class) {
        if ((getCreateBackupFolderMethod = cloudDriveGrpc.getCreateBackupFolderMethod) == null) {
          cloudDriveGrpc.getCreateBackupFolderMethod = getCreateBackupFolderMethod =
              io.grpc.MethodDescriptor.<CloudDrive.createFolderRequest, CloudDrive.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createBackupFolder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.createFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.Response.getDefaultInstance()))
              .setSchemaDescriptor(new cloudDriveMethodDescriptorSupplier("createBackupFolder"))
              .build();
        }
      }
    }
    return getCreateBackupFolderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CloudDrive.updateFileRequest,
      CloudDrive.Response> getUploadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadFile",
      requestType = CloudDrive.updateFileRequest.class,
      responseType = CloudDrive.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CloudDrive.updateFileRequest,
      CloudDrive.Response> getUploadFileMethod() {
    io.grpc.MethodDescriptor<CloudDrive.updateFileRequest, CloudDrive.Response> getUploadFileMethod;
    if ((getUploadFileMethod = cloudDriveGrpc.getUploadFileMethod) == null) {
      synchronized (cloudDriveGrpc.class) {
        if ((getUploadFileMethod = cloudDriveGrpc.getUploadFileMethod) == null) {
          cloudDriveGrpc.getUploadFileMethod = getUploadFileMethod =
              io.grpc.MethodDescriptor.<CloudDrive.updateFileRequest, CloudDrive.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "uploadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.updateFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.Response.getDefaultInstance()))
              .setSchemaDescriptor(new cloudDriveMethodDescriptorSupplier("uploadFile"))
              .build();
        }
      }
    }
    return getUploadFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CloudDrive.deleteFileRequest,
      CloudDrive.Response> getDeleteFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFile",
      requestType = CloudDrive.deleteFileRequest.class,
      responseType = CloudDrive.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CloudDrive.deleteFileRequest,
      CloudDrive.Response> getDeleteFileMethod() {
    io.grpc.MethodDescriptor<CloudDrive.deleteFileRequest, CloudDrive.Response> getDeleteFileMethod;
    if ((getDeleteFileMethod = cloudDriveGrpc.getDeleteFileMethod) == null) {
      synchronized (cloudDriveGrpc.class) {
        if ((getDeleteFileMethod = cloudDriveGrpc.getDeleteFileMethod) == null) {
          cloudDriveGrpc.getDeleteFileMethod = getDeleteFileMethod =
              io.grpc.MethodDescriptor.<CloudDrive.deleteFileRequest, CloudDrive.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.deleteFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CloudDrive.Response.getDefaultInstance()))
              .setSchemaDescriptor(new cloudDriveMethodDescriptorSupplier("deleteFile"))
              .build();
        }
      }
    }
    return getDeleteFileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static cloudDriveStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cloudDriveStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cloudDriveStub>() {
        @java.lang.Override
        public cloudDriveStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cloudDriveStub(channel, callOptions);
        }
      };
    return cloudDriveStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static cloudDriveBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cloudDriveBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cloudDriveBlockingStub>() {
        @java.lang.Override
        public cloudDriveBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cloudDriveBlockingStub(channel, callOptions);
        }
      };
    return cloudDriveBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static cloudDriveFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<cloudDriveFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<cloudDriveFutureStub>() {
        @java.lang.Override
        public cloudDriveFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new cloudDriveFutureStub(channel, callOptions);
        }
      };
    return cloudDriveFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class cloudDriveImplBase implements io.grpc.BindableService {

    /**
     */
    public void createBackupFolder(CloudDrive.createFolderRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBackupFolderMethod(), responseObserver);
    }

    /**
     */
    public void uploadFile(CloudDrive.updateFileRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUploadFileMethod(), responseObserver);
    }

    /**
     */
    public void deleteFile(CloudDrive.deleteFileRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBackupFolderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CloudDrive.createFolderRequest,
                CloudDrive.Response>(
                  this, METHODID_CREATE_BACKUP_FOLDER)))
          .addMethod(
            getUploadFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CloudDrive.updateFileRequest,
                CloudDrive.Response>(
                  this, METHODID_UPLOAD_FILE)))
          .addMethod(
            getDeleteFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                CloudDrive.deleteFileRequest,
                CloudDrive.Response>(
                  this, METHODID_DELETE_FILE)))
          .build();
    }
  }

  /**
   */
  public static final class cloudDriveStub extends io.grpc.stub.AbstractAsyncStub<cloudDriveStub> {
    private cloudDriveStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cloudDriveStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cloudDriveStub(channel, callOptions);
    }

    /**
     */
    public void createBackupFolder(CloudDrive.createFolderRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupFolderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void uploadFile(CloudDrive.updateFileRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFile(CloudDrive.deleteFileRequest request,
        io.grpc.stub.StreamObserver<CloudDrive.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class cloudDriveBlockingStub extends io.grpc.stub.AbstractBlockingStub<cloudDriveBlockingStub> {
    private cloudDriveBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cloudDriveBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cloudDriveBlockingStub(channel, callOptions);
    }

    /**
     */
    public CloudDrive.Response createBackupFolder(CloudDrive.createFolderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupFolderMethod(), getCallOptions(), request);
    }

    /**
     */
    public CloudDrive.Response uploadFile(CloudDrive.updateFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadFileMethod(), getCallOptions(), request);
    }

    /**
     */
    public CloudDrive.Response deleteFile(CloudDrive.deleteFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFileMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class cloudDriveFutureStub extends io.grpc.stub.AbstractFutureStub<cloudDriveFutureStub> {
    private cloudDriveFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cloudDriveFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new cloudDriveFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CloudDrive.Response> createBackupFolder(
        CloudDrive.createFolderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupFolderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CloudDrive.Response> uploadFile(
        CloudDrive.updateFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadFileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CloudDrive.Response> deleteFile(
        CloudDrive.deleteFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BACKUP_FOLDER = 0;
  private static final int METHODID_UPLOAD_FILE = 1;
  private static final int METHODID_DELETE_FILE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final cloudDriveImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(cloudDriveImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BACKUP_FOLDER:
          serviceImpl.createBackupFolder((CloudDrive.createFolderRequest) request,
              (io.grpc.stub.StreamObserver<CloudDrive.Response>) responseObserver);
          break;
        case METHODID_UPLOAD_FILE:
          serviceImpl.uploadFile((CloudDrive.updateFileRequest) request,
              (io.grpc.stub.StreamObserver<CloudDrive.Response>) responseObserver);
          break;
        case METHODID_DELETE_FILE:
          serviceImpl.deleteFile((CloudDrive.deleteFileRequest) request,
              (io.grpc.stub.StreamObserver<CloudDrive.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class cloudDriveBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    cloudDriveBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CloudDrive.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("cloudDrive");
    }
  }

  private static final class cloudDriveFileDescriptorSupplier
      extends cloudDriveBaseDescriptorSupplier {
    cloudDriveFileDescriptorSupplier() {}
  }

  private static final class cloudDriveMethodDescriptorSupplier
      extends cloudDriveBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    cloudDriveMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (cloudDriveGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new cloudDriveFileDescriptorSupplier())
              .addMethod(getCreateBackupFolderMethod())
              .addMethod(getUploadFileMethod())
              .addMethod(getDeleteFileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
