
<h1>Examen Mercado Libre Facundo Andrés Domínguez</h1>

 

Herramientas y Tecnologías Utilizadas

 


<table>
  <tr>
   <td><strong>Nombre</strong>
   </td>
   <td><strong>Descripción</strong>
   </td>
  </tr>
  <tr>
   <td><strong>Java 8</strong>
<p>
 
   </td>
   <td>Lenguaje de programación
   </td>
  </tr>
  <tr>
   <td><strong>Netbeans</strong>
   </td>
   <td>Ide de desarrollo
   </td>
  </tr>
  <tr>
   <td><strong>Toncat Server</strong>
   </td>
   <td>Servidor
   </td>
  </tr>
  <tr>
   <td><strong>Maven</strong>
   </td>
   <td>Gestor de dependencias\Paquetes
   </td>
  </tr>
  <tr>
   <td><strong>Git</strong>
<p>
 
   </td>
   <td>versionado
   </td>
  </tr>
  <tr>
   <td><strong>Spring boot</strong>
   </td>
   <td>Framework para desarrollo web
   </td>
  </tr>
  <tr>
   <td><strong>Git-hub</strong>
   </td>
   <td>Repositorio
   </td>
  </tr>
  <tr>
   <td><strong>Google App Engine</strong>
<p>
 
   </td>
   <td>Entorno de desarrollo PaaS de alojamiento API
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Google cloud sql</strong>
   </td>
   <td>Servicio web para alojamiento de base de datos
   </td>
  </tr>
  <tr>
   <td><strong>Postgres Sql</strong>
   </td>
   <td>Sistema de gestión de base de datos relacionales
   </td>
  </tr>
  <tr>
   <td><strong>jMeter</strong>
   </td>
   <td>Aplicación para realizar pruebas de comportamiento funcional y evaluar rendimiento
   </td>
  </tr>
</table>



# 


# **Instalación Local**

Entorno


        ·  	IDE: Netbeans 10


        ·  	Java 1.8


        ·  	Apache Maven 3.5.0


        ·  	PostMan
 


## **Decargas**

El proyecto se encuentre en un repositorio público de GitHub:

 

[https://github.com/facundokpo04/meli-exam-mutanapi-FacundoAndresDominguez-](https://github.com/facundokpo04/meli-exam-mutanapi-FacundoAndresDominguez-)

 

Crear y configurar una base de datos PostgresSql con los siguentes datos

        ·  	Direccion: localhost:5432

        ·  	Nombre de BD: dna

        ·  	Usuario:postgres

        ·   Contrasena: postgres

Los valores puede ser modificados desde el archivo aplication.properties

 


## 


## **Servicios**

 

PATH: /mutant

 

Detalles del Servicio


<table>
  <tr>
   <td>Descripcion
   </td>
   <td>Peticion
   </td>
   <td>Header
   </td>
   <td>Respuesta
   </td>
  </tr>
  <tr>
   <td>Servicio Mutant
   </td>
   <td>POST
   </td>
   <td><strong>Content-Type: application/json</strong>
<p>
 
   </td>
   <td>Caso OK devuelve un <strong>HTTP 200</strong> (si es mutante)
<p>
<strong>HTTP 403 </strong> <strong>forbidden</strong>
<p>
En caso si es humano
<p>
<strong>HTTP 400 Bad Request</strong>
<p>
Adn invalido
<p>
 
   </td>
  </tr>
</table>


 

Prueba Local

 

   POST:  [ http://localhost:8080/mutant](http://localhost:8080/mutant)

 


    **Body (no mutante): {"dna":["ACGTTA","CATGTA","TGTACT","GTACGT","AGGTTA","CATGTA"]}


    **Body (mutante): {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}


     

Prueba en cloud

 

POST:[ https://mutanapi-proyect.wl.r.appspot.com/mutant](https://mutanapi-proyect.wl.r.appspot.com/mutant)

 


    **Body (no mutante): {"dna":["ACGTTA","CATGTA","TGTACT","GTACGT","AGGTTA","CATGTA"]}


    **Body (mutante): {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}

 



PATH: /stats

 


<table>
  <tr>
   <td>Descripción
   </td>
   <td>Peticion
   </td>
   <td>Header
   </td>
   <td>Respuesta
   </td>
  </tr>
  <tr>
   <td>Servicio Stats
   </td>
   <td>GET
   </td>
   <td><strong>Content-Type: application/json</strong>
<p>
 
   </td>
   <td>Caso OK devuelve un <strong>HTTP 200</strong>
<p>
Devuelve las estadísticas de ADN consultados en un String con formato JSON.
<p>
 
   </td>
  </tr>
</table>


 

           

Entorno Local

 

 

   GET:  [ http://localhost:8080/stats](http://localhost:8080/stats)

 

Entorno Cloud

 

   GET:  [ https://mutanapi-proyect.wl.r.appspot.com/stats](https://mutanapi-proyect.wl.r.appspot.com/stats)

 

 

**Performance de la Apirest**

 

Para el container de la app se configuró una estrategia de auto escalado automático.

Teniendo en cuenta  cantidad de peticiones y otros parametro, hara que se creen mas instancias automáticas para responder .

Instancias Minimas 10

Instancias Maximas 100.



La aplicación podría escalar horizontalmente sin muchos cambios ya que podriamos cambiar la configuracion para aumentar las instancias.
#Parametros de escalado automatico

   ·  target_cpu_utilization: 0.65
   ·  min_instances: 10
   ·  max_instances: 100
   ·  min_pending_latency: 30ms
   ·  max_pending_latency: automatic
   ·  max_concurrent_requests: 50
 

La aplicación puede escalar verticalmente hasta procesadores con 6 hilos ya que tiene 5 procesos asíncronos :


        ·  	Guardar en la base de datos


        ·  	Recorrer matriz diagonal superior


        ·  	Recorrer matriz diagonal Inferior


        ·  	Recorrer matriz diagonal superior  invertida


        ·  	Recorrer matriz diagonal inferior invertida

 

Prueba de estrés

 

Se usó jMeter para prueba de estrés, se crearon 4 threadgroup para verificar el escalado automático de App engine


        1-	50 peticiones por segundo  durante 10 ciclos


        2-	100 peticiones por segundo durante 10 ciclos


        3-	500 peticiones por segundo durante 10 ciclos


        4-	1000  peticiones por segundo durante 10 ciclos

El escalado de instancias responde bien, escalando automáticamente a medida que aumenta las peticiones a pesar que en algunos casos no responde los primeros segundos hasta que logra escalar a las instancias necesarias.

 

**Resultado 10000 peticiones**

 Tasa 353.7/seg


*********
![alt text](https://github.com/facundokpo04/meli-exam-mutanapi/blob/master/Test%20Jmeter.png "Test jMeter")
*********



