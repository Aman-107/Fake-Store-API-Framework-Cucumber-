Feature: Validating Fake Store API

Scenario Outline: Verify if user has successfully Loged In
Given Add User Payload with "<username>" and "<password>"
When user calls API with https request
Then the API got success with status code 200

Examples:
| username | password |
|   johnd  | m38rmF$  |
|kevinryan | kev02937@|

# Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
#	Given Add Place Payload with "<name>","<language>","<place>"
#	When user calls "AddPlaceAPI" with "Post" http request
#	Then the API got success with status code 200
#	And "status" in response body is "OK"
#	And "scope" in response body is "APP" 
#	And verify place_Id created maps to "<name>" using "GetPlaceAPI"