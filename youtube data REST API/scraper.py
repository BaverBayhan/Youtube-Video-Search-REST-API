import json
from youtube_transcript_api import YouTubeTranscriptApi


video_id="bqSQEG2Iphc"
json_file=open("sample.json", "w")
transcript_list=YouTubeTranscriptApi.get_transcript(video_id)
with open('data.json', 'w') as f:
    json.dump(transcript_list, f)



