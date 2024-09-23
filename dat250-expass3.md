# Assignment 3 - SPA

## Implementation
The way I went about implementing this project is that I first made the user have to create an account, that way when making a poll we won't have to enter the username in the field too because the user is already logged into their account, same with voting.  
  
After the user is logged in they will see already existing polls that they will be able to vote on, and they can also make a new poll where they input the question and voting options.

  You can find the front-end code [here](https://github.com/andreashenriksen/PollApp/tree/main/src).

## Technical problems

### Voting on poll
Voting on a poll is almost implemented correct. A user can vote on a poll, but they can vote more than once without updating their previous vote. So for instance on a poll that has `yes` or `no` options, a user can vote `yes` and then vote `no`, or continue voting for one of the options as much as they want. The way I'm planning to fix this is for every time a user votes, then check if that user already has an existing vote on that poll and if they do then delete it.

## Pending issues

### Making a poll
I have an issue when I tried to make a poll through the front-end of my application where it would fail in making it because of a NullPointerException that occurs when getting the id of the poll which I'm planning on fixing.
