Feature: GET /usuarios/{_id} - Consultar usuario por ID

Background:
  * url 'https://serverest.dev'
  * def usersPath = '/usuarios'
  * def Java = Java.type('com.serverest.helpers.DataGenerator')

Scenario: Consultar usuario existente devuelve 200
  # Crear usuario primero
  Given path usersPath
  And request { nome: 'LuceroQA', email: 'luceroqa@teste.com', password: '1234', administrador: 'true' }
  When method POST
  Then status 201
  * def id = response._id

  # Consultar usuario recién creado
  Given path usersPath, id
  When method GET
  Then status 200
  And match response ==
  """
  {
    nome: '#string',
    email: '#string',
    password: '#string',
    administrador: '#string',
    _id: '#string'
  }
  """

Scenario: Consultar usuario inexistente devuelve 400
  Given path usersPath, '0OVpqKpcpjlKEycW'
  When method GET
  Then status 400
  And match response.message == 'Usuário não encontrado'