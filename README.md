```                                            
  ____  ____ ____       _____   ___  ____  __ __  ____   __    ___ 
 /    ||    \    |     / ___/  /  _]|    \|  |  ||    | /  ]  /  _]
|  o  ||  o  )  |     (   \_  /  [_ |  D  )  |  | |  | /  /  /  [_ 
|     ||   _/|  |      \__  ||    _]|    /|  |  | |  |/  /  |    _]
|  _  ||  |  |  |      /  \ ||   [_ |    \|  :  | |  /   \_ |   [_ 
|  |  ||  |  |  |      \    ||     ||  .  \\   /  |  \     ||     |
|__|__||__| |____|      \___||_____||__|\_| \_/  |____\____||_____|
                                                                   
```
fundamental API service for the following:
  
- Manage Users & Items (food ingredients) & Recipes
- Recommend Recipes (will be moved)
- Push alarm (will be moved)

## Plan
- [x] RDS migrations
- [ ] CRUD operations
- [ ] Open API with Swagger (Option)
- [ ] Data Streaming with AWS Kinesis
- [ ] ETL process with Apach Spark 

- [ ] Integration with Elasticsearch
- [ ] Simple recommendation
- [ ] Integration with Frontend
- [ ] Add 'Push alarm'

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
  
 


