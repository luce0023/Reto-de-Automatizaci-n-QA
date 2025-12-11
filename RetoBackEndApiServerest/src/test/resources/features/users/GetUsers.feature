Feature: GET /usuarios - Listar usuarios

Background:
  * url 'https://serverest.dev'
  * def usersPath = '/usuarios'
  * headers { 'Content-Type': 'application/json' }
  * def Java = Java.type('com.serverest.helpers.DataGenerator')

Scenario: Listar usuarios devuelve 200 y esquema válido
  Given path usersPath
  When method GET
  Then status 200
  And match response == read('classpath:schemas/userListSchema.json')

Scenario: Consultar usuario con ID inválido devuelve 400
  Given path usersPath, '1234567'
  When method GET
  Then status 400
  And match response.id == 'id deve ter exatamente 16 caracteres alfanuméricos'
