11. Testing Endpoints
Here's how you can test the endpoints using cURL commands:

User Registration


curl -X POST -H "Content-Type: application/json" -d '{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123",
  "firstName": "Test",
  "lastName": "User",
  "roles": ["user"]
}' http://localhost:8080/api/auth/signup


curl -X POST -H "Content-Type: application/json" -d '{
  "username": "testuser",
  "password": "password123"
}' http://localhost:8080/api/auth/signin


curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer YOUR_JWT_TOKEN" -d '{
  "accountType": "SAVINGS"
}' http://localhost:8080/api/accounts


curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer YOUR_JWT_TOKEN" -d '{
  "accountNumber": "ACCOUNT_NUMBER_FROM_CREATE",
  "amount": 1000.00,
  "transactionType": "DEPOSIT",
  "description": "Initial deposit"
}' http://localhost:8080/api/transactions


curl -X GET -H "Authorization: Bearer YOUR_JWT_TOKEN" http://localhost:8080/api/transactions/ACCOUNT_NUMBER_FROM_CREATE



