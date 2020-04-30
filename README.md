# platforms-integration-challenge
Welcome to the challenge of implementing platform integration.

In this repository, you will be guided on how to develop and deliver a software project to the Bemobi Platforms team.

Before you start, pay close attention to these instructions.

- Fork the project.
- Create pull requestes for each implemented feature.
- To deliver the project, create a branch called "develop" and merge the other branches created in it.
- Document what you think is necessary from readme.md.

## Story
We received an integration demand.
In this integration, we need to receive an HTTP request in a rest api and send the payload to an SQS queue. But, we will need to add some new fields to this payload before sending it to the queue.

This is the contract that our client will send:
```json
{
  "productId": "8bac677a-1078-4a4d-b8ba-2877b52944ad"
  "amount": "100"
}
```
This is the model contract we want to save in the queue:
```json
{
  "productId": "8bac677a-1078-4a4d-b8ba-2877b52944ad",
  "amount": 0.01,
  "status": "active",
  "createdAt": "2020-04-30T22:33:16.497Z",
  "ttl": "1588285962993"
}
```

His team decided that it is necessary to create integration tests in this project and, if possible, load testing.

## Requirement
The project must be done with the language and libraries of your choice.

To integration tests with SQS you can use this docker container: [roribio16/alpine-sqs](https://hub.docker.com/r/roribio16/alpine-sqs)

For load tests, we suggest using the [locust](https://locust.io), but this is your choice.

Good luck!
