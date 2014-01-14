Goto  Eclipse Plugin directory in command prompt

cd C:\setup\Eclipse\eclipse\plugins

type java -jar org.eclipse.osgi_3.6.1.R36x_v20100806.jar -console  or

java -jar org.eclipse.osgi_[version].jar -console


now type ss to see all services

Sample Commands to install services

install file:E:\AshwinOlympus\Ashwin\OSGI\MavenProject\target\HelloWorld-0.0.1-SNAPSHOT.jar
install file:E:\AshwinOlympus\Ashwin\OSGI\MavenProject\target\MathService-0.0.1-SNAPSHOT.jar
install file:E:\AshwinOlympus\Ashwin\OSGI\MavenProject\target\MathServiceClient-0.0.1-SNAPSHOT.jar


Sample Commands to start and stop services

start 1
stop 1