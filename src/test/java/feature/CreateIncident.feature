Feature: Create Incident in ServiceNow
Scenario: Create Incident Only with Short Description

Given Request URL is Initiated
And Authorization is performed
When Body is posted with Json file data1.json
Then Status code should be 201
And Response time within 10 seconds