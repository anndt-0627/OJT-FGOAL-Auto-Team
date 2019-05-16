$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Example.feature");
formatter.feature({
  "line": 1,
  "name": "Example",
  "description": "Description: Example feature file",
  "id": "example",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User want to learn HTML at w3schools",
  "description": "",
  "id": "example;user-want-to-learn-html-at-w3schools",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User click on \"\u003cobjectiveName\u003e\" label",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User input valid \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Title is displayed correctly",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "example;user-want-to-learn-html-at-w3schools;",
  "rows": [
    {
      "cells": [
        "objectiveName",
        "username",
        "password"
      ],
      "line": 11,
      "id": "example;user-want-to-learn-html-at-w3schools;;1"
    },
    {
      "cells": [
        "Learn HTML",
        "vu_123",
        "password123"
      ],
      "line": 12,
      "id": "example;user-want-to-learn-html-at-w3schools;;2"
    },
    {
      "cells": [
        "Learn HTML",
        "vu_456",
        "password456"
      ],
      "line": 13,
      "id": "example;user-want-to-learn-html-at-w3schools;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4521684016,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User want to learn HTML at w3schools",
  "description": "",
  "id": "example;user-want-to-learn-html-at-w3schools;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User click on \"Learn HTML\" label",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User input valid \"vu_123\" and \"password123\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Title is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "StepExample.user_is_on_Home_screen()"
});
formatter.result({
  "duration": 1508086600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Learn HTML",
      "offset": 15
    }
  ],
  "location": "StepExample.user_click_on_label(String)"
});
formatter.result({
  "duration": 858933148,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vu_123",
      "offset": 18
    },
    {
      "val": "password123",
      "offset": 31
    }
  ],
  "location": "StepExample.user_input_valid_and(String,String)"
});
formatter.result({
  "duration": 149334,
  "status": "passed"
});
formatter.match({
  "location": "StepExample.title_is_displayed_correctly()"
});
formatter.result({
  "duration": 89600,
  "status": "passed"
});
formatter.after({
  "duration": 1180216439,
  "status": "passed"
});
formatter.before({
  "duration": 3560193177,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "User want to learn HTML at w3schools",
  "description": "",
  "id": "example;user-want-to-learn-html-at-w3schools;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Home screen",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User click on \"Learn HTML\" label",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User input valid \"vu_456\" and \"password456\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Title is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "StepExample.user_is_on_Home_screen()"
});
formatter.result({
  "duration": 1296552454,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Learn HTML",
      "offset": 15
    }
  ],
  "location": "StepExample.user_click_on_label(String)"
});
formatter.result({
  "duration": 1372011311,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "vu_456",
      "offset": 18
    },
    {
      "val": "password456",
      "offset": 31
    }
  ],
  "location": "StepExample.user_input_valid_and(String,String)"
});
formatter.result({
  "duration": 127573,
  "status": "passed"
});
formatter.match({
  "location": "StepExample.title_is_displayed_correctly()"
});
formatter.result({
  "duration": 45653,
  "status": "passed"
});
formatter.after({
  "duration": 1207869085,
  "status": "passed"
});
});