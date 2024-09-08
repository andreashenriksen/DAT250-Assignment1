# Assignment 2 - REST API

## Table of Contents
- [Implementation](#implementation)
- [Technical problems](#technical-problems)
- [Pending issues](#pending-issues)
- [Author](#author)

## Implementation
The way I implemented this REST API is that I started by first creating the necessary domain and model classes
which the domain model showed us. Then I made the tests using IntelliJ's HTTP Client, and made the controller classes
before starting to expand the code to make the tests pass.  

  You can find the program code [here](https://github.com/andreashenriksen/DAT250-Assignment2/tree/master/src/main/java/com/example/demo)
  and you can find the tests [here](https://github.com/andreashenriksen/DAT250-Assignment2/blob/master/src/main/resources/scratches/scratch.http).
## Technical problems
Some technical problems I encountered while trying to make this project was that I was trying to save a list of created
polls and votes for each user, and when I ran the HTTP requests I noticed that I got an endless object in response. 
The reason I think this happened is that for example in the Poll class I save the user who created it too, 
so they would always reference each other thus creating and endless loop. I fixed this by instead of the user referencing
the whole poll class, it just referenced the poll question.

## Pending issues
An issue I haven't been able to solve yet is that I don't have any way to store the votes for each option in the poll class yet.
I only save the vote per user but my thinking is that it should also be displayed on the poll as well those show how many voted
for each option.

## Author
Andreas S. Henriksen - [andreashenriksen](https://github.com/andreashenriksen)

