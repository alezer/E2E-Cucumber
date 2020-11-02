$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/RegionsAndWines.feature");
formatter.feature({
  "name": "Regions and Wines list",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "I want to get a list of all Regions",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have a list of Regions created in my database",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.iHaveAListOfRegionsCreatedInMyDatabase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call the GET “Regions - All” endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "ApiSteps.iCallTheGetRegionsAllEndpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get a 200 response",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.iGetAResponse(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the correct list of Regions",
  "keyword": "And "
});
formatter.match({
  "location": "ApiSteps.iGetTheCorrectListOfRegions()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "I want to add a Likes to a Wine",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have a Wine created in my database",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.iHaveAWineCreatedInMyDatabase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call the POST “Wines - Like” endpoint with a valid Id and valid Payload",
  "keyword": "When "
});
formatter.match({
  "location": "ApiSteps.iCallTheWinesLikeEndpointWithAValidIdAndPayload(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get a 200 response",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.iGetAResponse(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the selected option is saved",
  "keyword": "And "
});
formatter.match({
  "location": "ApiSteps.theSelectedOptionIsSaved()"
});
formatter.result({
  "status": "passed"
});
});