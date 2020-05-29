# platforms-integration-challenge
This is the challenge to join Bemobi team.

First of all, thanks for this great opportunity, in theese crazy times, we are doing our best to make life work and constantly improve all areas of our lifes. That challenge is prove that i want new things at my proffessional area.

_Talk is cheap! Show me the code!_

This is the contract that our client wants to receive:

productId: String
amount: String

```json
{
  "productId": "8bac677a-1078-4a4d-b8ba-2877b52944ad",
  "amount": "100"
}
```

If you send a payload like this, you will receive a 201 showing that the integration platform created the resource that you want.

If not, you will receive a 400 for BadRequest or a 500 if the error is our fault. 

The Locust config file is on project's root folder to load test (please, be kind with my API)

Thanks a lot for this opportunity!