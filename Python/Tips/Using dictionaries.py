users = {} 
users['Kim'] = {'email' : 'kim@oreilly.com','gender': 'f', 'age': 27, 'friends': ['John', 'Josh']}
users['John'] = {'email' : 'john@abc.com','gender': 'm', 'age': 24, 'friends': ['Kim', 'Josh']}
users['Josh'] = {'email' : 'josh@wickedlysmart.com','gender': 'm', 'age': 32, 'friends': ['Kim']}

max = 1000
for name in users:
   user = users[name]
   friends = user['friends']
   if len(friends) < max:
       most_anti_social = name
       max = len(friends)

print('The most anti-social is', most_anti_social)

movies = {}
movie = {}

movie['name'] = 'Forbidden Planet'
movie['year'] = 1957
movie['rating'] = '*****'
movie['year'] = 1956

movies['Forbidden Planet'] = movie

movie2 = {'name': 'I Was a Teenage Werewolf',
               'year': 1957, 'rating': '****'}
movie2['rating'] = '***'
movies[movie2['name']] = movie2

movies['Viking Women and the Sea Serpent'] = {'name': 'Viking Women and the Sea Serpent',
                                              'year': 1957,
                                              'rating': '**'}

movies['Vertigo'] =  {'name': 'Vertigo',
                      'year': 1958,
                      'rating': '*****'}

print('Head First Movie Recommendations')
print('--------------------------------')
for name in movies:
    movie = movies[name]
    if len(movie['rating']) >= 4:
        print(movie['name'], '(' + movie['rating'] + ')',  movie['year'])

print('Head First Movie Staff Pick')
print('---------------------------')
movie = movies['I Was a Teenage Werewolf']
print(movie['name'], '(' + movie['rating'] + ')',  movie['year'])
