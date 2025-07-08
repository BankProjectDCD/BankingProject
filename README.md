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


===========================================================================================================================================================================================================



-- Create users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL REFERENCES users(id),
    role_id BIGINT NOT NULL REFERENCES roles(id),
    PRIMARY KEY (user_id, role_id)
);


CREATE TABLE accounts (
    id BIGSERIAL PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    account_type VARCHAR(20) NOT NULL,
    balance DECIMAL(19, 2) NOT NULL DEFAULT 0.00,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_account_user FOREIGN KEY (user_id) REFERENCES users(id)
);




CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    transaction_id VARCHAR(50) NOT NULL UNIQUE,
    amount DECIMAL(19, 2) NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    description VARCHAR(100),
    account_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES accounts(id)
);
==================================================================================================================================
Date:- 08-07-2025
=================

CREATE TABLE user_profile (
    userProfileId SERIAL PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    gender VARCHAR(255),
    address VARCHAR(255),
    occupation VARCHAR(255),
    martialStatus VARCHAR(255),
    nationality VARCHAR(255)
);

CREATE TABLE users_detail (
    userid BIGINT PRIMARY KEY,
    emailid VARCHAR(255),
    contact_no VARCHAR(255),
    authid VARCHAR(255),
    identificationnumber VARCHAR(255),
    creationon DATE,
    status VARCHAR(50),
    userprofileid INT,
    FOREIGN KEY (userprofileid) REFERENCES user_profile(userprofileid)
);


CREATE TABLE account_detail (
    accountid BIGINT PRIMARY KEY,
    accountnumber VARCHAR(255) NOT NULL,
    accounttype VARCHAR(50) NOT NULL,
    accountstatus VARCHAR(50) NOT NULL,
    openingdate DATE,
    availablebalance DECIMAL(19, 2),
    userid BIGINT
);



CREATE TABLE sequence (
    sequence_id BIGSERIAL PRIMARY KEY,
    account_number BIGINT
);


CREATE TABLE transaction (
    transaction_id BIGSERIAL PRIMARY KEY,
    reference_id VARCHAR(255),
    account_id VARCHAR(255),
    transaction_type VARCHAR(50),
    amount NUMERIC(19, 2),
    transaction_date TIMESTAMP,
    status VARCHAR(50),
    comments VARCHAR(255)
);


CREATE TABLE fund_transfer (
    fund_transfer_id BIGSERIAL PRIMARY KEY,
    transaction_reference VARCHAR(255),
    from_account VARCHAR(255),
    to_account VARCHAR(255),
    amount NUMERIC(19, 2),
    status VARCHAR(50),
    transfer_type VARCHAR(50),
    transferred_on TIMESTAMP
);
