from pathlib import Path
import getpass
import json
import requests

#Things to understand/do:
#1. JSON syntax
#2. REST API
#3. Python syntax
#4. How this code was refactored/can be refactored further
#5. Requests, json, pathlib, and getpass Python libraries
#5a. How important are headers? Why do we need a Requests' Session?
#6. Progress bar file
#7. Package the program - see if I need an init and __main__ file, see how the main guys imported the other .py files

class Get:
    base_url = 'https://www.hackerrank.com/'
    login_url = base_url + 'auth/login'
    submissions_url = base_url + 'rest/contests/master/submissions/?offset={}&limit={}'
    challenge_url = base_url + 'rest/contests/master/challenges/{}/submissions/{}'
    domain_url = base_url + 'domains/{}'
    subdomain_url = base_url + 'domains/{}/{}'
    problem_url = base_url + 'challenges/{}/problem'
    
    user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36 Edg/85.0.564.63'

##See the first 3 options below - why are they needed
    def __init__(self):
        self.session = requests.Session()
        self.total_submissions = 0
        self.limit = 0
        self.offset = 0
        self.username = ''
        self.password = ''
        self.headers = {}

    def get_values(self):
        self.username = input('What is your HackerRank username? ')
        self.password = getpass.getpass('What is your HackerRank password? ')
        
    def login(self):
        resp = self.session.post(self.login_url, auth=(self.username, self.password), headers={'user-agent': self.user_agent}) #why do we need to send user-agent?
        data = resp.json()
        if data['status']:
            self.cookies = self.session.cookies.get_dict()
            self.headers = resp.request.headers
            self.get_number_of_submissions()
        return data['status']
    
    def get_number_of_submissions(self):
        if not self.total_submissions:
            total_submissions_url = self.submissions_url.format(0, 0)
            resp = self.session.get(total_submissions_url, headers=self.headers)
            self.total_submissions = resp.json()['total']
        return self.total_submissions

    def get_values_2(self):
        user_limit_and_offset = ''
        user_limit_and_offset = input('Do you want to start from a specific solution number or need a specific number of solution? Yes/No' )
        if user_limit_and_offset in ('Y', 'y', 'yes', 'Yes'):
            self.offset = input('Which solution number do you want to start from? ')
            self.limit = input('How many solutions do you need? ')
        else:
            self.limit = self.total_submissions

##You need to download a JSON file from HackerRank's REST API. This file contains a summary of all your submissions.
    def get_list(self):
        get_list_url = self.submissions_url.format(self.offset, self.limit)
        resp = self.session.get(get_list_url, headers=self.headers)
        data = resp.json()
        models = data['models']
        return models
    
    def get_submissions(self, models):
        

def main():
    getter = Get()
    getter.get_values()
    getter.login()
    if getter.get_list() is False:
        print('Could not authenticate login')
        exit(1)
    getter.get_values_2()
    models = getter.get_list()
    getter.get_submissions(models)
    
if __name__ == "__main__":
    main()
    
##print(Path.cwd())


#p = Path('Data.json')
#with p.open() as f:
    #data = json.load(f)


## 2 debugging statements to check if JSON file loads properly
##print(json.dumps(data, indent = 4, sort_keys=True)) - outputs a lot of lines of JSON code, but in pretty print JSON format
##print(data) - basically a massive unreadable Python nested dictionary


#id_d = str(data['models'][3]['id'])
#challenge_slug = data['models'][3]['challenge']['slug']
#url = 'https://www.hackerrank.com/rest/contests/master/challenges/' + challenge_slug + '/submissions/' + id_d 
#print(url)
#r = requests.get(url, allow_redirects=True)


##To get the values for headers, I logged into HackerRank on my browser. Using the Inspect Element tool, I obtained the relevant values from the cookies file in Sources.


#headers = {'session_id' : '3qr6lti0-1604678268021', 'remember_hacker_token' : 'BAhbCFsGaQOBbYZJIhl0WU9IZ0thYWMyM1cyY1dZWGluSgY6BkVUSSIXMTYwNDQ4NzI1NC40MzUxNTU0BjsARg%3D%3D--aa7c4fffa0f06b57f612978adadfa1facc9193ff'}

#open('/home/parth/Desktop/Coding/Learn-CS-and-Coding/Learn-CS-and-Coding/HackerRank/lo.json', 'wb').write(r.content)


##for x in range(0, data['total']):
##    id_d = str(data['models'][x]['id'])
##    challenge_slug = data['models'][x]['challenge']['slug']
##    url = 'https://www.hackerrank.com/rest/contests/master/challenges/' + challenge_slug + '/submissions/' + id_d 
##    r = requests.get(url, allow_redirects=True)

##Path().mkdir(parents=False, exist_ok=True)
