import grpc
import cloudDrive_pb2
import cloudDrive_pb2_grpc
import sys
import time
from os import listdir, path
from os.path import join, isfile
import bisect


def run():
    with grpc.insecure_channel('localhost:9000') as channel:
        stub = cloudDrive_pb2_grpc.cloudDriveStub(channel)
        folder = sys.argv[1]
        path_components = folder.split('/')
        folder_name = path_components[-1]
        folder_path = folder + '/'
        response = stub.createBackupFolder(cloudDrive_pb2.createFolderRequest(folder_name=folder_name))
        print("RESPONSE FROM SERVICE PROVIDER ==> ", response.response)
        files = listdir(folder_path)		# this holds all file names
        files_count = len(files)
        if ".DS_Store" in files:
            files_count -= 1

        for f in files:
            file_path = join(folder_path, f)
            if isfile(file_path) and f != ".DS_Store":
                file = open(file_path, "rb")
                byte = file.read()
                file_size = len(byte)
                print("Uploading", f, "to the cloud...")
                response = stub.uploadFile(cloudDrive_pb2.updateFileRequest(file_name=f, file_size=file_size, file_bytes=byte))
                print("RESPONSE FROM SERVICE PROVIDER ==> ", response.response)

        old_files = files
        last_modified_list = []
        for f in files:
            file_path = join(folder_path, f)
            last_modified = path.getmtime(file_path)
            last_modified_list.append(last_modified)

        while True:
            current_files = listdir(folder_path)
            current_last_modified_list = []
            for f in current_files:
                file_path = join(folder_path, f)
                last_modified = path.getmtime(file_path)
                current_last_modified_list.append(last_modified)
            print("Checking if any files were added...")
            for idx, current_file in enumerate(current_files):
                file_path = join(folder_path, current_file)
                if isfile(file_path) and current_file not in old_files:
                    print("Uploading", current_file, "to the cloud...")
                    file = open(file_path, "rb")
                    byte = file.read()
                    file_size = len(byte)
                    response = stub.uploadFile(cloudDrive_pb2.updateFileRequest(file_name=current_file, file_size=file_size, file_bytes=byte))
                    print("RESPONSE FROM SERVICE PROVIDER ==> ", response.response)
                    bisect.insort(old_files, current_file)
                    last_modified_list.insert(idx, current_last_modified_list[idx])

            print("Checking if any files were deleted...")
            for idx, old_file in enumerate(old_files):
                if old_file not in current_files:
                    ans = input("Are you sure you want to delete " + old_file + " permanently from the backup folder? (Y/N) ")
                    if ans == 'Y' or ans == 'y':
                        response = stub.deleteFile(cloudDrive_pb2.deleteFileRequest(file_name=old_file))
                        last_modified_list.pop(idx)
                        old_files.remove(old_file)
                        print("Deleting", old_file, "from the cloud...")
                        print("RESPONSE FROM SERVICE PROVIDER ==> ", response.response)

            print("Checking if any files were modified...")
            # iterating in parallel over old files and current files
            for idx, current_file in enumerate(current_files):
                if idx == len(old_files):
                    break
                if current_file == ".DS_Store":
                    continue
                file_path = join(folder_path, current_file)
                if current_last_modified_list[idx] != last_modified_list[idx]:
                    print("Updating", current_file, "on the cloud...")
                    file = open(file_path, "rb")
                    byte = file.read()
                    file_size = len(byte)
                    response = stub.uploadFile(cloudDrive_pb2.updateFileRequest(file_name=current_file, file_size=file_size, file_bytes=byte))
                    print("RESPONSE FROM SERVICE PROVIDER ==> ", response.response)
                    old_files = current_files

            last_modified_list.clear()
            for f in old_files:
                file_path = join(folder_path, f)
                last_modified = path.getmtime(file_path)
                last_modified_list.append(last_modified)
            time.sleep(5)
            print("5 SECONDS LATER!")


if __name__ == "__main__":
    run()
