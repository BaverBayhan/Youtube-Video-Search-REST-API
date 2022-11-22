from pydantic import BaseModel

class Video(BaseModel):
    youtube_id:str
