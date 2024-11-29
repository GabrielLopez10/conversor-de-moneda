![convertidor logo](https://res.cloudinary.com/dfzw74nlk/image/upload/v1728926616/viw7kkf1zeamkicojjzs.jpg)

# Conversor de Monedas

## Descripción
Este es un proyecto en Java que permite convertir una cantidad de dinero de una moneda a otra
utilizando una API de tipo de cambio. El programa obtiene la tasa de cambio actual de la API **ExchangeRate-API**
y realiza la conversión. Además, guarda la información de la conversión en un archivo JSON.

## Características
- Convierte monedas de una divisa base a una divisa destino.
- Obtiene tasas de cambio en tiempo real utilizando **ExchangeRate-API**.
- Guarda los detalles de cada conversión (moneda base, moneda destino, cantidad y resultado) en un archivo JSON.
- Permite cambiar la moneda base dentro del programa.

## Tecnologías utilizadas
- **Java 17** o superior.
- **Gson** para la manipulación del JSON.
- **ExchangeRate-API** para la obtención de tasas de cambio.
- **HttpClient** para hacer solicitudes HTTP.

## Requisitos

Para ejecutar este proyecto necesitarás tener:

- **Java 17** o superior.
- Una cuenta en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener una API key.

## Configuración

### Paso 1: Clonar el repositorio

Clona el repositorio en tu maquina local:

```
git clone https://github.com/GabrielLopez10/conversor-de-moneda
cd conversor-de-moneda
```

### Paso 2: Configurar API

Debes configurar tu clave de la API de ExchangeRate-API. 
Para ello, crea un archivo config.properties en la ruta src/com/aluracursos/conversordemoneda/recursos/ con el siguiente contenido:

```
api.key=TU_API_KEY
```

### Paso 3: Ejecutar el programa

en la carpeta conversor-de-moneda:

```
java -cp ".:../gson/gson-2.11.0.jar:" src/com/aluracursos/conversordemoneda/principal/Principal.java
```
En mi caso, guardé el archivo JAR de gson en una carpeta del mismo nombre y lo ejecute directamente con el comando java.

Otra manera es compilar y despues ejecutar:

```
javac -cp ".:../gson/gson-2.11.0.jar:" src/com/aluracursos/conversordemoneda/principal/*.java src/com/aluracursos/conversordemoneda/calculos/*.java src/com/aluracursos/conversordemoneda/modelos/*.java
java -cp ".:../gson/gson-2.11.0.jar:" src/com/aluracursos/conversordemoneda/principal/Principal.java
```
