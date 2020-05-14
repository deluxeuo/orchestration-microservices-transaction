# Services participating in saga

- order-service
- inventory-service
- payment-service
- shipping-service
- notification-service

### orchestrator in saga
- orchestration-service

###  Build the project - 
mvn clean </br>
mvn install

docker-compose -f docker-compose-infra.yml up --build

### Start transaction in saga by order post endpoint``

POST Endpoint : http://localhost:8891/v1/orders/ </br>
Paylaod - 
{
	"itemId" : 2,
	"customerId" :1
}


