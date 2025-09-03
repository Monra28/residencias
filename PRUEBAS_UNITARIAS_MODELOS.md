## Documento de Pruebas Unitarias de Modelos

Este documento describe las pruebas unitarias implementadas para los modelos `Platillo`, `Categoria` y `Usuario`, explicando el propósito de cada prueba individual.

---

### 1. Pruebas para el Modelo `Platillo` (`PlatilloTest.java`)

Las pruebas para el modelo `Platillo` verifican la correcta inicialización, asignación y recuperación de datos, así como el funcionamiento del mecanismo de actualización de la fecha de modificación.

#### Métodos de Prueba:

*   **`testPlatilloCreation()`**
    *   **Propósito**: Verifica que un objeto `Platillo` se inicialice correctamente con valores por defecto cuando se usa el constructor sin argumentos.
    *   **Verifica**:
        *   Que el objeto `platillo` no sea nulo.
        *   Que `fechaCreacion` no sea nula (se asigna automáticamente en el constructor).
        *   Que `fechaModificacion` no sea nula (se asigna automáticamente en el constructor).
        *   Que `disponible` sea `true` por defecto.

*   **`testPlatilloConstructorWithArguments()`**
    *   **Propósito**: Verifica que los valores pasados al constructor con argumentos se asignen correctamente a las propiedades del objeto `Platillo`.
    *   **Verifica**: Que el `nombre`, `categoria`, `descripcion`, `precio`, `imagenUrl` y `disponible` del objeto coincidan con los valores proporcionados al constructor.

*   **`testPlatilloSettersAndGetters()`**
    *   **Propósito**: Asegura que los métodos *setter* y *getter* funcionan correctamente, permitiendo establecer y recuperar los valores de las propiedades del `Platillo`.
    *   **Verifica**: Que después de establecer cada propiedad (ID, nombre, categoría, descripción, precio, URL de imagen, disponibilidad, fechas de creación y modificación), los valores recuperados mediante los *getters* sean idénticos a los valores establecidos.

*   **`testPreUpdateMechanism()`**
    *   **Propósito**: Prueba el método `preUpdate()` del modelo, el cual está diseñado para actualizar automáticamente la `fechaModificacion` antes de una actualización en la base de datos.
    *   **Verifica**:
        *   Que `fechaModificacion` no sea nula después de llamar a `preUpdate()`.
        *   Que `fechaModificacion` haya cambiado (no sea igual) después de llamar a `preUpdate()`, lo que indica que se ha actualizado a una nueva marca de tiempo. (Se incluye un pequeño retraso para asegurar que `LocalDateTime.now()` genere un valor diferente).

---

### 2. Pruebas para el Modelo `Categoria` (`CategoriaTest.java`)

Las pruebas para el modelo `Categoria` cubren la correcta creación, manipulación de propiedades y el funcionamiento del mecanismo de actualización de la fecha de modificación.

#### Métodos de Prueba:

*   **`testCategoriaCreation()`**
    *   **Propósito**: Verifica que un objeto `Categoria` se inicialice correctamente con valores por defecto cuando se usa el constructor sin argumentos.
    *   **Verifica**:
        *   Que el objeto `categoria` no sea nulo.
        *   Que `fechaCreacion` no sea nula.
        *   Que `fechaModificacion` no sea nula.
        *   Que `activa` sea `true` por defecto.

*   **`testCategoriaConstructorWithArguments()`**
    *   **Propósito**: Comprueba que los valores pasados al constructor con `nombre` y `descripcion` se asignen correctamente.
    *   **Verifica**: Que el `nombre` y `descripcion` del objeto coincidan con los valores proporcionados al constructor, y que `activa` siga siendo `true`.

*   **`testCategoriaSettersAndGetters()`**
    *   **Propósito**: Asegura que los métodos *setter* y *getter* para todas las propiedades de `Categoria` funcionan como se espera.
    *   **Verifica**: Que los valores de `id`, `nombre`, `descripcion`, `activa`, `fechaCreacion` y `fechaModificacion` se puedan establecer y recuperar correctamente.

*   **`testPreUpdateMechanism()`**
    *   **Propósito**: Prueba que el método `preUpdate()` de `Categoria` actualiza correctamente la `fechaModificacion`.
    *   **Verifica**:
        *   Que `fechaModificacion` no sea nula después de llamar a `preUpdate()`.
        *   Que `fechaModificacion` haya cambiado con respecto a su valor inicial, confirmando la actualización. (Incluye un retraso para asegurar marcas de tiempo distintas).

---

### 3. Pruebas para el Modelo `Usuario` (`UsuarioTest.java`)

Las pruebas para el modelo `Usuario` validan la creación, la correcta asignación de propiedades, el manejo de diferentes constructores y la funcionalidad del método de pre-actualización.

#### Métodos de Prueba:

*   **`testUsuarioCreation()`**
    *   **Propósito**: Verifica la inicialización de un objeto `Usuario` con el constructor por defecto.
    *   **Verifica**:
        *   Que el objeto `usuario` no sea nulo.
        *   Que `fechaCreacion` y `fechaModificacion` no sean nulas.
        *   Que `activo` sea `true` por defecto.
        *   Que `rol` sea "USUARIO" por defecto.

*   **`testUsuarioConstructorWithMinimumArguments()`**
    *   **Propósito**: Prueba el constructor que toma los argumentos mínimos requeridos (`nombre`, `email`, `password`, `rol`).
    *   **Verifica**: Que todas las propiedades pasadas al constructor se asignen correctamente y que `activo` mantenga su valor por defecto `true`.

*   **`testUsuarioConstructorWithAllArguments()`**
    *   **Propósito**: Valida el constructor que acepta todos los argumentos del modelo `Usuario`.
    *   **Verifica**: Que todas las propiedades, incluyendo `telefono` y `direccion`, se asignen correctamente, y que `activo` sea `true`.

*   **`testUsuarioSettersAndGetters()`**
    *   **Propósito**: Confirma el funcionamiento de todos los métodos *setter* y *getter* del modelo `Usuario`.
    *   **Verifica**: Que cada propiedad (`id`, `nombre`, `email`, `password`, `rol`, `telefono`, `direccion`, `activo`, `fechaCreacion`, `fechaModificacion`) pueda ser establecida y recuperada con los valores esperados.

*   **`testPreUpdateMechanism()`**
    *   **Propósito**: Asegura que el método `preUpdate()` actualice la `fechaModificacion` cuando se invoca.
    *   **Verifica**:
        *   Que `fechaModificacion` no sea nula después de la llamada a `preUpdate()`.
        *   Que el valor de `fechaModificacion` sea diferente al valor inicial, indicando una actualización exitosa. (Incluye un retraso para evitar problemas de granularidad de tiempo).
