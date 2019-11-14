# OdinModel
The OdinModel framework, in a current version, supports transforming a familiar custom Spring Boot development process into a model-driven rapid prototyping approach. Developers may model domain problem, generate corresponding Spring Boot application, and without restrictions customize everything from the model features, code generator facilities, to the produced application. By using only existing standards-compliant development tools, OdinModel does not impose internal proprietary opinionated solutions of any kind. Developers have at their disposal a set of predefined supported functionalities both common and advanced which may serve as a guideline for further customization.

**UML to Spring Boot mappings:** <br/>
	Class -> Entity <br/>
	Attribute -> Entity field <br/>
  	Attribute's *Is ID property* -> Primary key constraint <br/>
	Attribute's *Multiplicity* property -> Null constraint <br/>
  	Attribute's *Unique* property -> Unique constraint <br/>
  	Attribute's *Owned comments* -> JPA constraints <br/>
	Association -> Entity relationship <br/>
	Association's *Multiplicity* property -> Types of entity relationships <br/>
	Generalization -> Abstract super class <br/>
	Package's *Name* property -> Custom package path <br/>
	Data Type -> Entity field's data types <br/> 
	Enumeration & Enumeration <br/>

**Supported features:**<br/>
	- all JPA constraints <br/>
	- all four unidirectional relationships: many-to-one, one-to-many, one-to-one, and many-to-many <br/>
	- the IRIC checks before create, update, and delete in many-to-one relationships <br/>
	- Blob, Clob, Long, Integer, Double, Boolean, Enumeration, String, Date, Time, DateTime, and Timestamp data types <br/>
	- create, read, update and delete (CRUD) functionalities <br/>
	- dynamic search for instances with and without pagination <br/>
	- update one instance by id or fields with the unique constraint <br/>
	- read one instance by id or fields with the unique constraint <br/>
	- read all instances with or without pagination <br/>
	- for entities in many-to-one relationship, read all instances by parent instance's either id or fields with the unique constraint, with or without pagination <br/>
	- configuring pom.xml and application.properties files <br/>
	- H2, MySQL, and PostgreSQL configuration <br/>
	- Swagger 2 as UI client for REST <br/>
