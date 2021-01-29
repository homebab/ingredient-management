```                                            
     ____  ____    ____  ____     ___  ___    ____    ___  ____   ______       
    |    ||    \  /    ||    \   /  _]|   \  |    |  /  _]|    \ |      |      
     |  | |  _  ||   __||  D  ) /  [_ |    \  |  |  /  [_ |  _  ||      |      
     |  | |  |  ||  |  ||    / |    _]|  D  | |  | |    _]|  |  ||_|  |_|      
     |  | |  |  ||  |_ ||    \ |   [_ |     | |  | |   [_ |  |  |  |  |        
     |  | |  |  ||     ||  .  \|     ||     | |  | |     ||  |  |  |  |        
    |____||__|__||___,_||__|\_||_____||_____||____||_____||__|__|  |__|        
                                                                           
 ___ ___   ____  ____    ____   ____    ___  ___ ___    ___  ____   ______ 
|   |   | /    ||    \  /    | /    |  /  _]|   |   |  /  _]|    \ |      |
| _   _ ||  o  ||  _  ||  o  ||   __| /  [_ | _   _ | /  [_ |  _  ||      |
|  \_/  ||     ||  |  ||     ||  |  ||    _]|  \_/  ||    _]|  |  ||_|  |_|
|   |   ||  _  ||  |  ||  _  ||  |_ ||   [_ |   |   ||   [_ |  |  |  |  |  
|   |   ||  |  ||  |  ||  |  ||     ||     ||   |   ||     ||  |  |  |  |  
|___|___||__|__||__|__||__|__||___,_||_____||___|___||_____||__|__|  |__|                                                                       
                                                                   
```
fundamental API service for the following:
  
- Management
  - Users & Items (food ingredients)
  
## Updated
- 17.01.21: This API service is not used. 
  - User & Item is managed by AWS Amplify for social login(Auth) and offline appsync(Datastore)

## Get Started
- postgres
```
url: jdbc:postgresql://localhost:5432/omtm
username: postgres
password: postgres
```
- openAPI with swagger 
`http://localhost:8080/swagger-ui.html`

## Plan
- [x] RDS migrations
- [x] CRUD operations
- [x] Open API with Swagger (Option)
- [x] Integration with Frontend

## Stack
- Spring Boot + Java
  - MVC, Blocking IO
- Hibernate + JPA
  - ORM
- PostgreSQL
  - RDS
  
 ## Structure
 - controller: Presentation Layer
 - service: Business Layer
 - repository: Data Access Layer
 - domain: objects
