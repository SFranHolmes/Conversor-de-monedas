# Conversor de Monedas en Java
Este proyecto es una aplicación en Java que permite realizar conversiones de diferentes monedas a dólares estadounidenses (USD), y viceversa, usando una API de tasas de cambio en tiempo real. Actualmente, admite conversiones de varias monedas latinoamericanas como el Peso Mexicano (MXN), el Sol Peruano (PEN) y el Peso Chileno (CLP) al dólar estadounidense. La API se puede actualizar o expandir para incluir otras monedas.

### Clonar el proyecto
```
git clone https://github.com/SFranHolmes/Conversor-de-monedas.git

```
## Estructura del Código

### 1. `ConversorMoneda`

Esta clase se encarga de conectarse a la API de tasas de cambio y de realizar las conversiones. Contiene los siguientes métodos:

- `cargarTasasDeCambio()`: Establece una conexión con la API y obtiene las tasas de cambio en formato JSON. Los datos se almacenan en un objeto `JsonObject` llamado `tasasCambio`.
- `convertir(double cantidad, String moneda, boolean aDolares)`: Convierte la cantidad especificada de una moneda dada a dólares (si `aDolares` es `true`) o de dólares a la moneda especificada (si `aDolares` es `false`). Verifica si las tasas de cambio están disponibles antes de intentar la conversión.

### 2. `Principal`

Esta es la clase principal que interactúa con el usuario. Permite al usuario:

- Ingresar una cantidad de dinero y seleccionar la moneda de origen.
- Seleccionar si desea convertir a dólares o desde dólares a otra moneda.
- Seleccionar si desea continuar realizando conversiones o salir del programa.

### Ejemplo de Uso

1. El usuario ingresa una cantidad en la moneda deseada (por ejemplo, 100 MXN).
2. Elige si desea convertir a USD o desde USD.
3. La aplicación realiza la conversión y muestra el resultado.
4. Luego, el usuario puede elegir entre continuar con otra conversión o salir del programa.

## Manejo de Errores

El programa está diseñado para manejar errores comunes, tales como:

- Conexión fallida a la API.
- Moneda no disponible en las tasas de cambio.
- Tasas de cambio no disponibles debido a una respuesta nula de la API.

Si ocurre un error, se muestra un mensaje informativo para que el usuario sepa la causa y pueda intentar nuevamente.

## Dependencias

Este proyecto usa `Gson` para manejar JSON. Asegúrate de agregar la biblioteca Gson al classpath si no está incluida en tu entorno. Puedes descargar Gson desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson) o incluirla en tu IDE.
