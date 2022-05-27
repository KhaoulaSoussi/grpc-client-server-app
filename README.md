# grpc-client-server-app

## Project Overview

This project is a minimal cloud drive application inspired from Google Drive. It allows the user to automatically backup his/her files on the cloud. We would like to develop a language-agnostic solution for this problem using Java on server side and Python on the client side.

## Technology Enablers

1.Build Tool: Gradle      
Gradle (a Google open-source project) is a build tool that is extremely useful to handle all dependencies implementation on our behalf.

2.Language-Agnostic Technology: gRPC     
GRPC is a framework developed by Google to allow building Remote Procedure Calls with ease. RPC implementations started as language dependent technologies (e.g., RMI, RPyC…) where the service provider and the service consumer must be implemented in the same programming language given the need for data-memory-representation compatibility. GRPC however uses protocol buffers, a pre-existing mature Google project that allows the serialization and deserialization of data in a language neutral way using a specified schema.

3.GRPC Serialization mechanism: Protocol Buffers      
Protocol Buffers is a language neutral mechanism for serializing and deserializing structured data. The data to be serialized and deserialized should be described in a schema which is essentially a file with a .proto extension. A protoc compiler then turns the schema into a generated code for the target language(s). The proto compiler has support for most programming languages (Protobuf supported languages).
It is worth mentioning that Protocol Buffers use binary serialization instead of the human-readable serialization formats used in JSON and XML. Protocol buffers were optimized to be faster and lighter than JSON and XML by making it focused only on serializing and deserializing data as fast as possible and in a light representation (i.e., binary). 

## Implementation Details

1. Define the schema: `cloudDrive.proto`   
Following the contract-first approach, I started by defining the proto file which consists of the following:
- The service
- RPC methods inside the service definition with their request and response types
- Protocol buffer message type definitions for all the request and response types used in the service methods

2.	Install protoc compiler (Protobuf)   
To be able to compile the proto file, we need to install protoc compiler. I did so by following the steps provided in the grpc documentation (protoc installation).

3.	Configure build.gradle file   
The next step is to add plugins, dependencies, and sourceSets to the build.gradle file and also customize `protobuf` compilation. To do so, I followed the steps provided in the protobuf-gradle-plugin github repo [protobuf-gradle-plugin](https://github.com/google/protobuf-gradle-plugin) and I made sure to use the latest versions for the dependencies by consulting [maven repository](https://mvnrepository.com/search?q=grpc-services).

4.	Auto-generate java codes     
To auto-generate necessary java codes, all I needed to do is to build the project using Gradle build command: `./gradlew build`. With that done, the following two files were generated: cloudDrive and cloudDriveGrpc     
The first file contains definitions for the request messages provided in the proto file. It defines getters and setters for the attributes of each request, and it also defines some methods for serialization. Additionally, it provides methods for building and setting responses.      
The second file consists of different types of stub methods (e.g., async, blocking-style…) for the Java server as well as for a Java client. Since our client would be implemented in Python, we will only use the server skeleton. This file also contains an abstract implementation of the class cloudDriveImplBase which should be inherited by the business implementation class detailed in the following step. 

5.	Implement the gRPC service: CloudDriveService    
The gRPC service class inherits the abstract class cloudDriveImplBase which was generated automatically by protoc compiler, and it overrides all its abstract methods (RPC methods whose signature appears in the interface (i.e., proto file)).
The gRPC service class contains the service business implementation. Each of the overridden methods takes a request, acts upon it, and builds a response object which is either a success or a failure message.
The business implementation of the methods is similar to the XML/SOAP solution except that the RPC methods take a request object that wraps the parameters and build a response object, while the web service methods in XML/SOAP directly take the parameters and return the response string. Also, the gRPC service class is not annotated as a web service since that is only part of JAXWS (the Java support for XML/SOAP); we can say that the gRPC service inheritance and implementation of the cloudDriveImplBase abstract class is equivalent to the XML/SOAP `@webservice` annotation.

6.	Implement the server to run the gRPC service    
To run the Cloud Drive service, a server process that runs on a specific port is needed. Using the grpc ServerBuilder class, we can build a server, bind it to a port, and add the Cloud Drive Service to it. Finally, we can just start the server using the Server class `start()` method.

7.	Auto-generate python codes     
Since the client side would be implemented in Python, similarly to the Java provider, we have to generate the necessary python codes for the corresponding client by providing the same schema (i.e., proto file) to the protoc compiler. To do so, we need to run the following two commands:
- Install grpcio tools:  `pip3 install grpcio-tools`     
- Generate Python codes: `python3 -m grpc_tools.protoc -Isrc/main/proto --python_out=src/main/python/ --grpc_python_out=src/main/python/ src/main/proto/cloudDrive.proto`     
Once running this latter command, two files are generated.    
`cloudDrive_pb2.py`    
`cloudDrive_pb2_grpc.py`    
They serve the same purpose as the Java auto-generated files except that these are written in Python for a Python client and a Python server. On client side, we will only use the client stub.

8.	Write Python client    
The gRPC client code is similar to the XML/SOAP client code algorithm-wise, they differ in terms of client-server communication. In the gRPC client, since we have no credentials, we start by creating an insecure channel to the server providing the IP address as well as the port number on which the server is running (i.e., localhost/9000). If the channel is successfully created, we use the grpc generated file to create the Python stub.
To send a request to the server, the client needs to create the corresponding request object, wrap the parameters inside it, and then send the request. The server response is received as a response object. 

9.	Run the Java service provider then the Python service consumer     
Finally, we can run the Java service provider using the Gradle run command: `./gradlew run`; and run the service consumer using the command: 
`python3 src/main/python/consumer.py path_to_local_folder`


