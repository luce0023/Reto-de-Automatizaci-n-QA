Feature: DELETE /usuarios/{_id} - Eliminar usuario

Background:
  * url 'https://serverest.dev'
  * def usersPath = '/usuarios'
  * headers { 'Content-Type': 'application/json' }
  * def Java = Java.type('com.serverest.helpers.DataGenerator')

Scenario: Eliminar usuario existente devuelve 200
  # Crear usuario válido
  Given path usersPath
  And request Java.validUserJson()
  When method POST
  Then status 201
  * def id = response._id

  # Eliminar usuario creado
  Given path usersPath, id
  When method DELETE
  Then status 200
  And match response.message == 'Registro excluído com sucesso'
