# WSDL- WSDL Client wsimport - WSDL Server Publisher 
WSDL Wsimport

## Step 1
Run server/PersonServicePublisher

## Step 2
cd client
mvn clean install
you will see something like:
```
[INFO] --- jaxws-maven-plugin:2.6:wsimport (default) @ wsdl-service-client ---
[INFO] Processing: http://localhost:8888/ws/person?wsdl
[WARNING] Using platform encoding (Cp1252), build is platform dependent!
[INFO] jaxws:wsimport args: [-keep, -s, 'C:\BX\code\steven\wsdl-wsimport\client\target\generated-sources', -d, 'C:\BX\code\steven\wsdl-wsimport\client\target\classes', -Xnocompile, -p, com.stevenprogramming.soap.ws.client, "http://localhost:8888/ws/person?wsdl"]
parsing WSDL...

Generating code...
```

## Step 3
Run client/CallWsdlService

you will see:
```
[main] INFO com.stevenprogramming.javaee.wsdl.client.CallWsdlService - Person Address:Steven-Address
```

# WSDL- WSDL Client wsimport - WSDL Server Publisher - RPC Format
The difference with this project is wsimport wsdl file based locally
## Step 1
Run server/PersonServicePublisher

## Step 2
cd client-rpc-xml
mvn clean install
you will see something like:
```
[INFO] --- jaxws-maven-plugin:2.6:wsimport (default) @ wsdl-service-client-rpcxml ---
[INFO] Processing: file:/C:/BX/code/steven/wsdl-wsimport/client-rpc-xml/src/main/wsdl/person.wsdl
[WARNING] Using platform encoding (Cp1252), build is platform dependent!
[INFO] jaxws:wsimport args: [-keep, -s, 'C:\BX\code\steven\wsdl-wsimport\client-rpc-xml\target\generated-sources', -d, 'C:\BX\code\steven\wsdl-wsimport\client-rpc-xml\target\classes', -Xnocompile, -p, com.stevenprogramming.soap.ws.client, "file:/C:/BX/code/steven/wsdl-wsimport/client-rpc-xml/src/main/wsdl/person.wsdl"]
parsing WSDL...



Generating code...

[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ wsdl-service-client-rpcxml ---

```