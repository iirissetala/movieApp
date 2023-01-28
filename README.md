## MovieApp

This is a simple backend application for fetching list of movies, finding movies with name or part of name, or listing movies by publishing year.

Movies can be added, a check is made that you can
t add movie with same name twice.

App uses an in memory database, so with every start, movies in resource file are saved to empty database.

# Notice

There's only two tests, mainly to see that after running the application, movies from json-file are saved. Assertion is made of movie list size so it won
t pass after movies have been added.

# Further development ideas

- Error class, would be better to give a proper message why adding a movie failed.
- Logging
- Edit and delete movies
- API doc