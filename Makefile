# https://codetinkering.com/localstack-s3-lambda-example-docker/
ENDPOINT_URL:=http://localhost:4566
ARTIFACT:=basic-webservice-lambda-java-1.0-SNAPSHOT.jar
LAMBDA_NAME:=examplelambda
HANDLER:=main.LambdaHandler
TEST_EVENT_PATH:=events/APIGatewayV2ProxyRequestEvent.json

init-local-test:
	docker-compose up

create:
	aws lambda create-function \
		--endpoint-url $(ENDPOINT_URL) \
		--function-name $(LAMBDA_NAME) \
		--runtime java8 \
		--handler $(HANDLER) \
		--region eu-west-1 \
		--zip-file fileb://target/$(ARTIFACT) \
		--role arn:aws:iam::12345:role/ignoreme
test:
	aws lambda invoke \
		--function-name $(LAMBDA_NAME) \
		--payload fileb://$(TEST_EVENT_PATH) \
		--endpoint-url $(ENDPOINT_URL) \
		response.json && \
	cat response.json && rm response.json

stop-local-test:
	docker-compose down