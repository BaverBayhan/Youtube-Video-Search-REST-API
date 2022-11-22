from fastapi import FastAPI
from model import Video
from youtube_transcript_api import YouTubeTranscriptApi

app= FastAPI()

def getSubstitles(video_id):
    transcript_list=YouTubeTranscriptApi.get_transcript(video_id)
    return transcript_list


@app.post("/api/v1/videos")
def getSubstitlesRequest(video:Video):
    return {"transcript":getSubstitles(video.youtube_id)}

    
