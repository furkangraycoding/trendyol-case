
# Running & Tests

- For start running application `./run.sh`
- Application will start at port 8080
- Initiliaze db with name "trendyol"
- For start running test, `mvn test`

# Technical Details
- Application framework : Spring Boot
- Database: MySql
- Unit test tool: Mockito

# API Details
```sh 
POST /v1/url-to-deeplink      # Converts url to deeplink
POST /v1/deeplink-to-url      # Converts deeplink to url
POST /v1/logs                 # Returns logs

```



