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
  
- Manage Users & Items (food ingredients) & Recipes
- Recommend Recipes (will be moved)
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
- [ ] CRUD operations
- [ ] Open API with Swagger (Option)
- [ ] Data Streaming with AWS Kinesis
- [ ] ETL process with Apach Spark 
---
- [ ] Integration with Elasticsearch
- [ ] Simple recommendation
- [ ] Integration with Frontend
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
