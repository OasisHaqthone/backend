DROP TABLE IF EXISTS jre;
DROP TABLE IF EXISTS jrepackage;
DROP TABLE IF EXISTS jre_package;
 
CREATE TABLE jre (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  jrename VARCHAR(250) NOT NULL,
  basepackage VARCHAR(250) NOT NULL,
  location VARCHAR(250) DEFAULT NULL
);
 

  CREATE TABLE jrepackage (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  packagename VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL

);

INSERT INTO jrepackage (packagename, description) VALUES
  ('java.base','java.base'),('java.compiler','java.compiler'),('java.datatransfer,java.xml','java.datatransfer,java.xml'),('java.prefs','java.prefs'),('java.desktop','java.desktop'),('java.instrument','java.instrument'),('java.logging','java.logging'),('java.management','java.management'),('java.security.sasl','java.security.sasl'),('java.naming','java.naming'),('java.rmi','java.rmi'),('java.management.rmi','java.management.rmi'),('java.net.http','java.net.http'),('java.scripting','java.scripting'),('java.security.jgss','java.security.jgss'),('java.transaction.xa','java.transaction.xa'),('java.sql','java.sql'),('java.sql.rowset','java.sql.rowset'),('java.xml.crypto','java.xml.crypto'),('java.se','java.se'),('java.smartcardio','java.smartcardio'),('jdk.accessibility','jdk.accessibility'),('jdk.internal.vm.ci','jdk.internal.vm.ci'),('jdk.management','jdk.management'),('jdk.unsupported','jdk.unsupported'),('jdk.internal.vm.compiler','jdk.internal.vm.compiler'),('jdk.aot','jdk.aot'),('jdk.internal.jvmstat','jdk.internal.jvmstat'),('jdk.attach','jdk.attach'),('jdk.charsets','jdk.charsets'),('jdk.compiler','jdk.compiler'),('jdk.crypto.ec','jdk.crypto.ec')
  ,('jdk.crypto.cryptoki','jdk.crypto.cryptoki'),('jdk.crypto.mscapi','jdk.crypto.mscapi'),('jdk.dynalink','jdk.dynalink'),('jdk.internal.ed','jdk.internal.ed'),('jdk.editpad','jdk.editpad'),('jdk.hotspot.agent','jdk.hotspot.agent'),('jdk.httpserver','jdk.httpserver'),('jdk.internal.le','jdk.internal.le'),('jdk.internal.opt','jdk.internal.opt'),('jdk.internal.vm.compiler.management','jdk.internal.vm.compiler.management'),('jdk.jartool','jdk.jartool'),('jdk.javadoc','jdk.javadoc'),('jdk.jcmd','jdk.jcmd'),('jdk.management.agent','jdk.management.agent'),('jdk.jconsole','jdk.jconsole'),('jdk.jdeps','jdk.jdeps'),('jdk.jdwp.agent','jdk.jdwp.agent'),('jdk.jdi','jdk.jdi'),('jdk.jfr','jdk.jfr'),('jdk.jlink','jdk.jlink'),('jdk.jshell','jdk.jshell'),('jdk.jsobject','jdk.jsobject'),('jdk.jstatd','jdk.jstatd'),('jdk.localedata','jdk.localedata'),('jdk.management.jfr','jdk.management.jfr'),('jdk.naming.dns','jdk.naming.dns'),('jdk.naming.rmi','jdk.naming.rmi'),('jdk.net','jdk.net'),('jdk.pack','jdk.pack'),('jdk.rmic','jdk.rmic'),('jdk.scripting.nashorn','jdk.scripting.nashorn'),('jdk.scripting.nashorn.shell','jdk.scripting.nashorn.shell'),('jdk.sctp','jdk.sctp'),('jdk.security.auth','jdk.security.auth'),('jdk.security.jgss','jdk.security.jgss'),('jdk.unsupported.desktop','jdk.unsupported.desktop'),('jdk.xml.dom','jdk.xml.dom'),('jdk.zipfs','jdk.zipfs');
  