#!/bin/bash

# Function to make HTTP request and check response status
function check_response() {
    response_body=$(curl -s -o response.json -w "%{http_code}" -X "$1" "$2" \
        -H "Content-Type: application/json" \
        -d "$3")
    expected_status="$4"
    if [[ "$response_body" != "$expected_status" ]]; then
        echo "Expected HTTP $expected_status but got $response_body for $1 $2"
        exit 1
    fi
}

# Create User1
check_response "POST" "http://localhost:8080/users" '{"username": "User1", "email": "User1@UserEmail.com"}' 200

# Create User2
check_response "POST" "http://localhost:8080/users" '{"username": "User2", "email": "User2@UserEmail.com"}' 200

# Create Poll
check_response "POST" "http://localhost:8080/polls" '{"userId": 1, "question": "Pineapple on pizza?", "voteOptions": ["yes", "no"]}' 200

# Create a Vote
check_response "POST" "http://localhost:8080/votes" '{"userId": 2, "pollId": 1, "voteOptionId": 1}' 200

# Update the Vote
check_response "PUT" "http://localhost:8080/votes/1" '{"userId": 2, "pollId": 1, "voteOptionId": 2}' 200

# Delete the Poll
check_response "DELETE" "http://localhost:8080/polls/1" '' 200

echo "All HTTP tests passed successfully."
