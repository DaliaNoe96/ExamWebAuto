Feature: Product - Store
@LoginMyStore
Scenario: Validación del precio de un producto con usuario y clave validos
  Given estoy en la página de la tienda
  And Y me logueo con mi usuario "dalnoelarosa@gmail.com" y clave "70123148D@"
  When Cuando navego a la categoria "Clothes" y subcategoria "Men"
  And Y agrego unidades del primer producto al carrito
  Then Entonces valido en el popup la confirmación del producto agregado
  And Y valido en el popup que el monto total sea "38,24 PEN"
  When Cuando finalizo la compra
  Then Entonces valido el titulo de la pagina del carrito "CARRITO"
  And Y vuelvo a validar el calculo de precios en el carrito sea "38,24 PEN"

  @LogueoInvalido
  Scenario: Intento de logueo con usuario y clave inválidos
    Given me encuentro en la página de la tienda
    When me logueo con mi usuario "dalnoelarosa1@gmail.com" y clave "123000"
    Then Entonces espero que la automatización falle con el mensaje "Error de autenticación."

  @categoriaFailed
  Scenario: Navegar a una categoría inexistente
    Given estoy en la página de la tienda
    And Y me logueo con mi usuario "dalnoelarosa@gmail.com" y clave "70123148D@"
    Then Cuando navego a la categoria "Autos" y espero que la automatización falle al no encontrar el menú
