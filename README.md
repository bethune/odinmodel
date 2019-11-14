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
