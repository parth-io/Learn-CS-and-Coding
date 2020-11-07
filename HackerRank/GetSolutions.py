from pathlib import Path
import json
import requests

##Firstly, you need to download a JSON file from HackerRank's REST API. This file contains a summary of all your submissions. It is found at "https://www.hackerrank.com/rest/contests/master/submissions/". Download the raw data JSON file. 
##You can add limit and offset to it, of your own choice - "https://www.hackerrank.com/rest/contests/master/submissions/?offset=0&limit=100"
##Next, import the file

##Print current working directory as a check
##print(Path.cwd())

p = Path('Data.json')
with p.open() as f:
    data = json.load(f)

## 2 debugging statements to check if JSON file loads properly
##print(json.dumps(data, indent = 4, sort_keys=True)) - outputs a lot of lines of JSON code, but in pretty print JSON format
##print(data) - basically a massive unreadable Python nested dictionary

id_d = str(data['models'][3]['id'])
challenge_slug = data['models'][3]['challenge']['slug']
url = 'https://www.hackerrank.com/rest/contests/master/challenges/' + challenge_slug + '/submissions/' + id_d 
print(url)
r = requests.get(url, allow_redirects=True)

##To get the values for headers, I logged into HackerRank on my browser. Using the Inspect Element tool, I obtained the relevant values from the cookies file in Sources.
headers = {'session_id' : '3qr6lti0-1604678268021', 'remember_hacker_token' : 'BAhbCFsGaQOBbYZJIhl0WU9IZ0thYWMyM1cyY1dZWGluSgY6BkVUSSIXMTYwNDQ4NzI1NC40MzUxNTU0BjsARg%3D%3D--aa7c4fffa0f06b57f612978adadfa1facc9193ff'}

open('/home/parth/Desktop/Coding/Learn-CS-and-Coding/Learn-CS-and-Coding/HackerRank/lo.json', 'wb').write(r.content)

##for x in range(0, data['total']):
##    id_d = str(data['models'][x]['id'])
##    challenge_slug = data['models'][x]['challenge']['slug']
##    url = 'https://www.hackerrank.com/rest/contests/master/challenges/' + challenge_slug + '/submissions/' + id_d 
##    r = requests.get(url, allow_redirects=True)

##Path().mkdir(parents=False, exist_ok=True)
