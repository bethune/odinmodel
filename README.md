# OdinModel 
### A framework for custom rapid web application prototyping

In a nutshell, OdinModel should help developers transforming a familiar custom web application development process into a model-driven rapid prototyping approach, regardless of the target development platform. A developer may use OdinModel as is, with default supported features, or tweak/extend it to his requirements at some/every development level: model, code generator templates, and produced application code. 

## A short background

Web application developers with custom development stacks and requirements rarely have a proper corresponding vendor model-driven rapid prototyping framework. Such requirement may be some library (Querydsl, JOOQ, PrimeFaces, etc.), a whole framework (Struts 1, JavaServer Faces, Django, Flask, Play)


Hence, developers have to abandon their established, familiar, and appropriate web application development (WAD) and conform to the vendor's approach. We propose OdinModel, our standards-based MDRP framework which developers may adapt to their custom WAD. As a result, we show that unified development of personalized MDRP frameworks is possible. Also, specific non-generic yet repetitive web application features could have the same unified declarative support as the common supported generic ones.


You can invent your own language or build a support for already existing textual language or file format.


## What is the problem?

## Consequneces of the problem

## OdinModel to the rescue

## Outcomes

## Feature highlights

## Installation

## Getting started




Such requirement may be a library (Querydsl, JOOQ, PrimeFaces), a whole framework (Struts 1, JavaServer Faces, Spring Boot), or even some combination of libraries and frameworks

in a unified manner based on existing standards. Instead of developers abandoning their established familiar custom WAD and adapting to some vendor MDRP framework, OdinModel adapts to developers, thus supporting a more personalized MDRP approach. OdinModel promotes domain problem modeling of repetitive target requirements and building of custom MDRP framework with necessary developer-specific 

OdinModel aims for helping developers that need an MDRP framework but have to use or develop a feature unsupported by a vendor MDRP framework. 

For example, in this paper we cover a custom WAD stack for developing Spring Boot RESTful server-side applications (see Sect. ~\ref{sec:5}). An obvious vendor MDRP framework should be JHipster \cite{jhipster}. However, our stack uses Querydsl library for a dynamic search which JHipster does not support. Developers may integrate Querydsl by themselves after JHipster generates a target Spring Boot application. Yet, such an approach then does not prototype a dynamic search.

in a current version, supports transforming a familiar custom Spring Boot development process into a model-driven rapid prototyping approach. Developers may model domain problem, generate corresponding Spring Boot application, and without restrictions customize everything from the model features, code generator facilities, to the produced application. By using only existing standards-compliant development tools, OdinModel does not impose internal proprietary opinionated solutions of any kind. Developers have at their disposal a set of predefined supported functionalities both common and advanced which may serve as a guideline for further customization.



OdinModel framework has three main parts: a domain model, code generator software, and a target generated project. A developer may first create either a domain model, or an empty starter target project. The next step is configuring code generator software to extract data from the model and produce target project's application-level code.

For a domain problem modeling, OdinModel relies on the core features of the Unified Modeling Language (UML) class diagram. As for producing target code, OdinModel uses template-based code generator software Acceleo \cite{acceleo} - an open-source implementation of the MOFM2T standard from the Object Management Group (OMG). Target project is optional and corresponds with developers current WAD stack.

A detailed user guide for modeling, template building, and configuring UML, Acceleo, and any target project can be found at \cite{wiki}. Developers should already be familiar with UML, while Acceleo may require some learning. Yet, by providing a set of predefined Acceleo guidelines (queries, if conditions, and for loops) with detailed examples, the learning curve should not be steep. It is important to point out that although customizable, UML and Acceleo guidelines are an attempt for unifying domain problem modeling and code generator building.

The main OdinModel functionality is customizing without restrictions everything from the model features, code generator facilities, to the produced application. Since OdinModel produces prototypes, developers may customize the target application. In case that predefined code is not satisfying, developers may customize code generator inside predefined templates. Modifying the generator's structure and template organization is another approach. At last, adding new templates is also an option. Customizing predefined set of UML class diagram features that code generator supports is also possible. Another important functionality is supporting mappings from UML class diagram elements into target application features. Developers have at their disposal examples with predefined supported functionalities both common and advanced which may serve as a guideline for further customization. Beside common create, read, update and delete (CRUD) functionalities, there is a dynamic search with and without pagination. OdinModel also supports update and read by  fields with the unique constraint. Read all comes with or without pagination. For entities in many-to-one relationship, OdinModel supports a read all by parent instance's id or fields with the unique constraint, with or without pagination. Developers may customize or extend any of the aforementioned functionalities. Examples of all customization options, supported mappings, and predefined target application functionalities can be found at \cite{wiki}.

As working prototypes are an essential part of a rapid and flexible response to changes, the MDRP benefits should also be available to developers with an established familiar custom WAD stack. The OdinModel framework supports transforming such WAD processes into personalized MDRP approaches. Developers may model domain problem, generate corresponding web application, and without restrictions customize everything from the model features, code generator facilities, to the produced application. By using only existing standards-compliant development tools, OdinModel does not impose internal proprietary opinionated solutions of any kind. Developers have at their disposal examples with predefined supported functionalities both common and advanced which may serve as a guideline for further customization. OdinModel should be open for every development approach and rely on a model that covers all repetitive requirements since more model supported features means less manual and more automated code writing. Another contribution of this paper is also exposing the possibility of an approach which may help developers to achieve and use the UDS for custom implemented constraints like the IRIC. Hence, our approach may serve as a guideline for all developers who need the IRIC UDS. Also, it could help in unification and standardization of the IRIC and UDS. Eventually, our approach may even help elevate UDS for other custom implemented constraints to the generic RDBMS or ORM level.

Web application developers with custom development-specific requirements rarely have a proper corresponding vendor model-driven rapid prototyping (MDRP) framework.%why is it interesting
Hence, developers may abandon familiar custom web application development (WAD) and adopt some vendor MDRP framework, or build their own. %our propositon
We present OdinModel, our open-source customizable standards-based MDRP framework which developers may adapt to any custom WAD. %outcomes
As a result, unified development of personalized MDRP frameworks is possible. Also, specific unsupported yet repetitive web application features could have the same unified declarative support as the common supported generic ones.

  It is important to notice that some of the mentioned frameworks have a proper yet opinionated vendor MDRP support. This could be a problem for developers who use frameworks in a different manner (see Sect.~\ref{sec:3}).

 Querydsl library

, since it does not have a proper unified declarative support (UDS) such as the key, unique, and other common database constraints supported by target relational database management system (RDBMS).

One such feature is the IRIC, an interesting non-generic requirement because it is more common in WAD practice than it seems, yet without a proper UDS. According to \cite{ale13}, current RDBMSs and therefore object relational mapping (ORM) frameworks disregard the IRIC. As a result, there are no unified declarations followed by automated implementations, as in case of the key, unique, and other RDBMS-supported constraints. An illustrative example of the IRIC may be that a price list must have at least one price item referring one product. While the example seems trivial, for the IRIC to work, it is necessary to make the integrity checks before insertion, deletion, and modification. We argue that the IRIC could have the same level of the UDS as RDBMS-supported constraints. UMPLE \cite{umple}, for example, already supports the IRIC through association multiplicity at the model level. However, UMPLE produces pure object-oriented programs with in-memory objects, hence, no support for RDBMS persistence. In this paper, we present our application-level OdinModel-based support for the IRIC UDS with RDBMS persistence in vain of an ORM approach (see Sect.~\ref{sec:4}). To our knowledge, it has not been done before.



%why is it interesting
Hence, developers may abandon familiar custom WAD stacks and adopt some vendor MDRP framework, or build their own. %our propositon
We present OdinModel, our open-source customizable standards-based MDRP framework which developers may adapt to any custom WAD stack. %outcomes
As a result, unified development of personalized MDRP frameworks is possible. Also, specific non-generic unsupported yet repetitive features could have the same unified declarative support as the common supported generic ones.



The OdinModel framework supports transforming such WAD processes into personalized MDRP approaches.

our odinmodel approach, also shows that non-generic repetetive features may have at least an applciation level declarative support.


By promoting prototyping of all repetitive requirements, OdinModel also shows as “proof of concept” that non-generic inverse referential integrity constraints could have the same unified declarative support as the common generic database constraints.


For model-driven rapid prototyping (MDRP) of web applications, OdinModel framework uses standards-based, instead of devising proprietary solutions.

to je frejmvork zanovan na standardima, ali mi dozvoljavamo kasotmizaciju pomoću jasnog skupa acceleo smernica i ujedinjeno modelovanje repetativnih application features


building custom model-driven rapid prototyping (MDRP) frameworks based on corresponding custom web application development (WAD) stacks. As a result, instead of developers abandoning their familiar WAD stacks, with OdinModel they may upgrade them to a MDRP-level solution.

transforming custom web application development into a model-driven rapid prototyping approach

our odinmodel approach, also shows that non-generic repetetive features may have at least an applciation level declarative support.


OdinModel framework supports transforming web application development (WAD) into a model-driven rapid prototyping (MDRP) approach. Instead of developers abandoning their internal custom WAD and adapting to vendor MDRP framework, OdinModel adapts to developers. Based on a core Unified Modeling Language class diagram and a set of proposed Acceleo guidelines, OdinModel supports domain problem modeling and custom MDRP framework building in a unified manner based on standards. By promoting prototyping of all repetitive requirements, OdinModel also shows as “proof of concept” that non-generic inverse referential integrity constraints could have the same unified declarative support as the common generic database constraints.

textX is a meta-language for building Domain-Specific Languages (DSLs) in Python. It is inspired by Xtext.


From a single language description (grammar), textX will build a parser and a meta-model (a.k.a. abstract syntax) for the language. See the docs for the details.

textX follows the syntax and semantics of Xtext but differs in some places and is implemented 100% in Python using Arpeggio PEG parser - no grammar ambiguities, unlimited lookahead, interpreter style of work.
Quick intro

Here is a complete example that shows the definition of a simple DSL for drawing. We also show how to define a custom class, interpret models and search for instances of a particular type.

Docs and tutorials

The full documentation with tutorials is available at http://textx.github.io/textX/stable/

Support in IDE/editors

Projects that are currently in progress are:

    textX-LS - support for Language Server Protocol and VS Code for any textX based language. This project is about to supersede the following projects:
        textX-languageserver - Language Server Protocol support for textX languages
        textX-extensions - syntax highlighting, code outline
    viewX - creating visualizers for textX languages

If you are a vim editor user check out support for vim.

For emacs there is textx-mode which is also available in MELPA.

You can also check out textX-ninja project. It is currently unmaintained.

## License

MIT

## Target platform versions

Tested for Java 8

Tested for Spring 3

Tested for Sping Boot 2.1+
