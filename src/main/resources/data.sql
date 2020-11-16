DROP TABLE IF EXISTS jre;
DROP TABLE IF EXISTS jrepackage;
DROP TABLE IF EXISTS jre_package;
 
CREATE TABLE jre (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  jrename VARCHAR(250) NOT NULL,
  basepackage VARCHAR(250) NOT NULL,
  location VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO jre (jrename, basepackage, location) VALUES
  ('JRE11', 'java.awt.im,java.awt.im.spi,java.awt.image', 'E:\STS_Work_Space\jre\JRE11.zip'),
  ('JRE11.1', 'java.awt.im,java.awt.im.spi,java.awt.image', 'E:\STS_Work_Space\jre\JRE11.zip'),
  ('JRE11.2', 'java.awt.im,java.awt.im.spi,java.awt.image', 'E:\STS_Work_Space\jre\JRE11.2zip');
  
  
  CREATE TABLE jrepackage (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  packagename VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL

);

INSERT INTO jrepackage (packagename, description) VALUES
  ('com.sun.jarsigner', 'This package comprises the interfaces and classes used to define the signing mechanism used by the jarsigner tool.'),
  ('com.sun.java.accessibility.util', '	Provides a collection of interfaces and classes that compose the Java Accessibility Utilitie'),
  ('jcom.sun.jdi',	'This is the core package of the Java Debug Interface (JDI), it defines mirrors for values, types, and the target VirtualMachine itself - as well bootstrapping facilities'),
  ('com.sun.jdi.connect','	This package defines connections between the virtual machine using the JDI and the target virtual machine.'),
  ('com.sun.jdi.connect','	This package defines connections between the virtual machine using the JDI and the target virtual machine.'),
  ('com.sun.jdi.event','	This package defines JDI events and event processing.'),
  ('com.sun.jdi.request','	This package is used to request that a JDI event be sent under specified conditions.'),
  ('com.sun.management','This package contains the JDKs extension to the standard implementation of the java.lang.management API and also defines the management'),
  ('com.sun.net.httpserver','ovides a simple high-level Http server API, which can be used to build embedded HTTP servers.'),
  ('com.sun.net.httpserver.spi','Provides a pluggable service provider interface which allows the HTTP server implementation to be replaced with other implementations.'),
  ('com.sun.nio.sctp','	A Java API for Stream Control Transport Protocol.'),
  ('com.sun.security.auth','Provides implementations of Principal.3'),
  ('com.sun.security.auth.callback','	Provides an implementation of CallbackHandler.t4'),
  ('com.sun.security.auth.login','Provides an implementation of Configuration.4'),
  ('com.sun.security.auth.module','	Provides implementations of LoginModule.'),
  ('com.sun.security.jgss','This package defines classes and interfaces for the JDK extensions to the GSS-API.'),
  ('com.sun.source.doctree','	Provides interfaces to represent documentation comments as abstract syntax trees (AST).'),
  ('com.sun.source.tree','	Provides interfaces to represent source code as abstract syntax trees (AST).');
  