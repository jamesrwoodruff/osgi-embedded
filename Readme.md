
# OSGi Embedded Maven Demo

This maven project demonstrates embedding an osgi service into an application. 

The service is taken from [OSGi Using Maven with Equinox by Ashwin Kumar](http://www.javacodegeeks.com/2011/06/osgi-using-maven-equinox.html)

The code to embed bundles was taken from [How To Embed OSGi by Neil Bartlett](http://njbartlett.name/2011/03/07/embedding-osgi.html)

I tried running with Equinox 3.8.x which gave NullPointerExceptions so I upgraded to Apache Felix. Given that its the same OSGi API switching the runtime had no impact. x

##Commands:

```sh
#build the main class
mvn compile assembly:single

#build the service bundle
mvn -PMathService package

#build the service client
mvn -PMathServiceClient package

#run the main service which loads the two bundles
java -jar ./target/HelloWorld-0.0.1-SNAPSHOT-jar-with-dependencies.jar

```

##Expected output:

```sh
Math Service Registered
1+2=3
awaiting stop
```

Press Ctrl+c to kill the process. 

You may see cached output if you change the code so you may have to blow away the osgi container cache with: 

```sh
rm -rf felix-cache/
```