import glob

def recursiveFileListingFor(path:str, filetype:str="*")->list:
    return [f for f in glob.glob(f"{path}/**/*.{filetype}", recursive=True)]