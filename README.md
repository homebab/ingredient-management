```                                            
  ____  ____  ____        _____   ___  ____  __ __    ___  ____      
 /    ||    \|    \      / ___/  /  _]|    \|  |  |  /  _]|    \     
|  o  ||  o  )  o  )    (   \_  /  [_ |  D  )  |  | /  [_ |  D  )    
|     ||   _/|   _/      \__  ||    _]|    /|  |  ||    _]|    /     
|  _  ||  |  |  |        /  \ ||   [_ |    \|  :  ||   [_ |    \     
|  |  ||  |  |  |        \    ||     ||  .  \\   / |     ||  .  \    
|__|__||__|  |__|         \___||_____||__|\_| \_/  |_____||__|\_|    
                                                                     
                                                                   
```
fundamental API service for the following:
  
- Management
  - Users & Items (food ingredients) & Recipes
- Push alarm (will be moved)

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
---
- [ ] Add 'Push alarm'
...

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
