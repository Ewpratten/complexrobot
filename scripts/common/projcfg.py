import json

class ProjectConfiguration(object):
    
    # Config data
    _config:dict
    
    def __init__(self, path:str):
        # Load the project config
        try:
            self._config = json.load(open(f"{path}project.json", "r"))
        except FileNotFoundError as e:
            self._config = {}
            print(f"Could not find project.json for {path}")
        
    def __iter__(self)->dict:
        for k in self._config:
            yield (k,self. _config[k])
        