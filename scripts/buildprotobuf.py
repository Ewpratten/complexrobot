from common.dirtools import recursiveFileListingFor
from common.projcfg import ProjectConfiguration
import os

# Load the default project
root_proj = dict(ProjectConfiguration(""))

# Get project listing
sub_projects = root_proj.get("subprojects", [])

# Gen protobuf for each sub-project
for proj in sub_projects:
    
    # Get the project config
    sp = dict(ProjectConfiguration(proj))
    
    # Find all protos
    protopath = sp.get("protobuf", {}).get("srcdir", "")
    protooutpath = sp.get("protobuf", {}).get("gendir", "")
    protos = recursiveFileListingFor(f"{proj}{protopath}", "proto")
    
    # Run protobuf for each 
    for proto in protos:
        prefix = ''.join([''.join([p, "/"]) for p in proto.split("/")[:-1]])
        os.system(f"protoc -I {prefix} --java_out {proj}{protooutpath} {proto}")
        print(f"protoc -I {prefix} --java_out {proj}{protooutpath} {proto}")