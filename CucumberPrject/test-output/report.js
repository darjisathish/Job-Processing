$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Selenium_workspace/CucumberPrject/Features/Hooks.feature");
formatter.feature({
  "line": 1,
  "name": "Hooks in cucumber",
  "description": "",
  "id": "hooks-in-cucumber",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1252600,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Add new customer",
  "description": "",
  "id": "hooks-in-cucumber;add-new-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is on add customer page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user fills the customer details",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "customer is added",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinations.user_is_on_add_customer_page()"
});
formatter.result({
  "duration": 258230800,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.user_fills_the_customer_details()"
});
formatter.result({
  "duration": 475900,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.customer_is_added()"
});
formatter.result({
  "duration": 251100,
  "status": "passed"
});
formatter.after({
  "duration": 246800,
  "status": "passed"
});
formatter.before({
  "duration": 173700,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Edit customer",
  "description": "",
  "id": "hooks-in-cucumber;edit-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "user is on edit customer page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user edits contact details",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "contact details updated",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinations.user_is_on_edit_customer_page()"
});
formatter.result({
  "duration": 497000,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.user_edits_contact_details()"
});
formatter.result({
  "duration": 338900,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.contact_details_updated()"
});
formatter.result({
  "duration": 169400,
  "status": "passed"
});
formatter.after({
  "duration": 240200,
  "status": "passed"
});
formatter.before({
  "duration": 330600,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Delete customer",
  "description": "",
  "id": "hooks-in-cucumber;delete-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "user is on delete customer page",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user delete customer",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "customer deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "HooksStepDefinations.user_is_on_delete_customer_page()"
});
formatter.result({
  "duration": 463600,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.user_delete_customer()"
});
formatter.result({
  "duration": 509600,
  "status": "passed"
});
formatter.match({
  "location": "HooksStepDefinations.customer_deleted()"
});
formatter.result({
  "duration": 234400,
  "status": "passed"
});
formatter.after({
  "duration": 75500,
  "status": "passed"
});
});