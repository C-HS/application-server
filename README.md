# application-server
# RUN: mvn spring-boot:run
Publish message(POST: /api/mqtt/publish)

{
	"message": "testMessage",
	"topic":"test",
	"retained":true,
	"qos":0
}
Subscribe Messages From a Topic For X Milliseconds

GET: /api/mqtt/subscribe?topic=test&wait_millis=5000

Returns message array after 5 seconds:
