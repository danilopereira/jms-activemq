build:
	 mvn clean install package

consume:
	 java -jar jms-activemq-consumer/target/jms-activemq-consumer-1.0-SNAPSHOT-jar-with-dependencies.jar

produce:
	 java -jar jms-activemq-producer/target/jms-activemq-producer-1.0-SNAPSHOT-jar-with-dependencies.jar
