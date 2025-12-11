Feature: POST /usuarios - Crear usuario

Background:
  * url 'https://serverest.dev'
  * def usersPath = '/usuarios'
  * headers { 'Content-Type': 'application/json' }
  * def Java = Java.type('com.serverest.helpers.DataGenerator')

Scenario: Crear usuario válido devuelve 201
  Given path usersPath
  * def body = Java.validUserJson()
  And request body
  When method POST
  Then status 201
  And match response contains { "_id": "#string" }