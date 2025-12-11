Feature: PUT /usuarios/{_id} - Actualizar usuario

Background:
  * url 'https://serverest.dev'
  * def usersPath = '/usuarios'
  * headers { 'Content-Type': 'application/json' }
  * def Java = Java.type('com.serverest.helpers.DataGenerator')

Scenario: Actualizar usuario existente devuelve 200
  # Crear usuario base
  Given path usersPath
  And request Java.validUserJson()
  When method POST
  Then status 201
  * def id = response._id

  # Actualizar con email único
  * def newEmail = Java.uniqueEmail()
  Given path usersPath, id
  And request { nome: 'Atualizado_#(id)', email: #(newEmail), password: '1234', administrador: 'false' }
  When method PUT
  Then status 200
  And match response.message == 'Registro alterado com sucesso'

Scenario: Actualizar usuario inexistente devuelve 400
  Given path usersPath, 'inexistente123456'
  And request { nome: 'NoExiste', administrador: 'false' }
  When method PUT
  Then status 400
  And match response contains { "email": "#string", "password": "#string" }

