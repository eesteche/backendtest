# backendtest


<h1>README</h1>
<br>
<h2>La empresa trabaja en el area de fintech. El test es para un puesto junior.</h2>
<h2>Requerimientos</h2>
  <ul>
    <li>Implementar una app que exponga una API REST de usuarios.</li> 
    <li>Devolver información de usuarios de acuerdo al formato indicado</li>
    <li>Deberán implementarse análogamente métodos POST y DELETE con sus requerimientos. </li>
    <li>Crear una segunda API que exponga listado de préstamos.</li>
    <li>Deberá aceptar request paginadas y con ID opcional</li>
    <li>Deberá respetar la estructura de objeto requerida</li>
  </ul>
	<h2>Tecnologías utilizadas</h2>					
	<ul>
    <li>Base de datos: MySQL 8.0</li>
    <li>IDE: Spring Tool Suit 4</li>
    <li>Postman</li>
    <li>ORM: JPA Standard y Hibernate</li>
    <li>Aplicación: Java Version 11. Apache Maven 3.6.3</li>
  </ul>			
	<h2>Instalación</h2>		
  <ul>
    <li>Iniciar el script .sql proveído por mail. Incluye los datos y el create database. La configuración de credenciales está en application.properties</li>
    <li>Clonar el proyecto, luego desde el IDE mvn install. Run as spring boot app.</li>    
  </ul>	
  <h2>Acerca del proyecto</h2>
  <ul>
    <li>test</li> 
      <ul>
      <li>Hasta el momento, solo había trabajado con pruebas unitarias en Junit. Traté de hacer una prueba integral pero no pude. Dejé el intento en caso de querer chequearlo.</li>    
      </ul>	
    <li>Request Post & Delete</li> 
      <ul>
      <li>Se utilizó el repositorio estándar de Spring rest. Los métodos básicos eran suficientes para realizar la tarea pedida. </li>    
      </ul>	
    <li>Implementación de las entidades básicas</li>
      <ul>
      <li>Para el borrado de cascada se utilizó la anotación “CascadeType.REMOVE”, como se detalla en la documentación de hibernate (<a href="https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html_single/#objectstate-transitive">link</a>). Si bien conozco bastante de SQL, todavía estoy aprendiendo la sintaxis(HQL) y el funcionamiento interno de Hibernate. Esto lo aclaro porque al ser auto didacta, muchas veces me encuentro con tutoriales como <a href="https://thorben-janssen.com/avoid-cascadetype-delete-many-assocations/">éste</a> que lo hacen dudar a uno sobre si lo que está haciendo es una buena práctica. 
	En mi caso activando ”show-sql” no vi ninguna query inusual, por lo que dejé esa implementación sencilla, antes que crear un Stored Procedure custom. 
	Como última observación sobre la implementación aclaro que probablemente sería mejor utilizar una baja_fecha en el usuario y no borrar los registros. Cosa que dejé de lado para mantener sencillo el ejemplo.
</li>    
      </ul>	
    <li>Implementación de Get</li>
      <ul>
      <li>Para la implementación del request get se utilizó un patrón DTO que se encarga de generar el POJO de acuerdo a las especificaciones requeridas. La serialización es hecha con la librería de Jackson que viene por defecto con spring que se encarga de hacer todo el trabajo, solamente requiriendo algunas anotaciones para evitar loops en las listas.</li>    
      </ul>	
    </ul>	
