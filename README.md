# spring-security-oauth2
This Repository consists of APIs that are secured with OAuth-2.0.

Below are the REST API details

## REST API Details

`http://localhost:8081/api/v1/users/login (POST)`  -- **OAuth-2 Authentication Server - Login which is open for all the clients. Existing users can log in, and if no user found the client will be displayed with appropriate error message**

`http://localhost:8081/api/v1/users (POST)` -- **Protected resource - can only be accessed by the authorized users. Users with admin role can create a new user in the H2 in-memory Database**

`http://localhost:8081/api/v1 (GET)` -- **Protected Resources - Fetch All the available users. This can be accessed by the users with all the different roles**



