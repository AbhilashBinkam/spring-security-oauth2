# spring-security-oauth2
This Repository consists of APIs that are secured with OAuth-2.0.

Below are the REST API details

## REST API Details

`http://localhost:8081/api/v1/users/login (POST)`  -- **OAuth-2 Authentication Server - Login which is open for all the clients. Existing users can log in, and if no user found the client will be displayed with appropriate error message**

`http://localhost:8081/api/v1/users (POST)` -- **Protected resource - Use Bearer <Token> in HttpHeaders as Key = `Authorization` value = `Bearer <Token>` obtained from the `http://localhost:8081/api/v1/users/login (POST)` endpoint. can only be accessed by the authorized users. Users with admin role can create a new user in the H2 in-memory Database**



`http://localhost:8081/api/v1 (GET)` -- **Protected Resources - Protected resource - Use Bearer <Token> in HttpHeaders as Key = `Authorization` value = `Bearer <Token>` obtained from the `http://localhost:8081/api/v1/users/login (POST)` endpoint. Fetch All the available users. This can be accessed by the users with all the different roles**


-----------------------
`http://localhost:8081/api/v1/image (GET)` -- **Protected Resources - Use Bearer <Token> in HttpHeaders as Key = `Authorization` value = `Bearer <Token>` obtained from the `http://localhost:8081/api/v1/users/login (POST)` endpoint. Fetch all the available images linked to the account in the ImgUr**

`http://localhost:8081/api/v1/image (POST)` -- **Protected Resource - Use Bearer <Token> in HttpHeaders as Key = `Authorization` value = `Bearer <Token>` obtained from the `http://localhost:8081/api/v1/users/login (POST)` endpoint. Upload a new image to the existing user**
