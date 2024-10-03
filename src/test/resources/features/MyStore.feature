Feature: Product - Store
@LoginMyStore
Scenario: Validación del precio de un producto con usuario y clave validos
  Given estoy en la página de la tienda
  And Y me logueo con mi usuario "dalnoelarosa@gmail.com" y clave "70123148D@"
  When Cuando navego a la categoria "Clothes" y subcategoria "Men"
  And Y agrego 2 unidades del primer producto al carrito
  Then Entonces valido en el popup la confirmación del producto agregado
  And Y valido en el popup que el monto total sea calculado correctamente
  When Cuando finalizo la compra
  Then Entonces valido el titulo de la pagina del carrito
  And Y vuelvo a validar el calculo de precios en el carrito

  @LogueoInvalido
  Scenario: Intento de logueo con usuario y clave inválidos
    Given me encuentro en la página de la tienda
    When me logueo con mi usuario "dalnoelarosa1@gmail.com" y clave "70123148D@"
    Then Entonces espero que la automatización falle al no llegar a la pantalla principal


