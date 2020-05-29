from locust import HttpLocust, TaskSet, task 
from locust import ResponseError 
import json 
  
   
class UserBehavior(TaskSet): 
   
    def __init__(self, parent): 
        super(UserBehavior, self).__init__(parent) 
   
    def on_start(self): 
        self.integrate() 
   
    def integrate(self): 

        headers = {'content-type': 'application/json'}
        payload = {"productId":"id", "amount": "100"}

        response = self.client.post("/integration/", 
                                    headers=headers,
                                    data = json.dumps(payload)) 
          
        return json.loads(response._content)['Message']    
   
  
class WebsiteUser(HttpLocust): 
    # The task_set attribute should point 
    # to a TaskSet class which defines  
    # the behaviour of the user 
    task_set = UserBehavior 
    min_wait = 5000
    max_wait = 9000
