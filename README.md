## Get the token
### From this API, you can get the token for a valid user

*curl --location --request POST 'localhost:8090/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
	"username": "ryj",
	"password": "123"
}'*


## Access the secure content with token
### Now you can add the obtained token in the Authorization header.

*curl --location --request GET 'localhost:8090/api/v1/employee/secure' \
--header 'Authorization: Bearer eyEsImlhdCI6MTU4OTgzMDU1MX0.Lj4zi-FgLRDMRhv6UkqoT-2mcMySWGjVuhcRiJrWWBw' \
--header 'Content-Type: application/json'*
