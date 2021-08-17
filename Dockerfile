FROM openjdk:8
VOLUME /temp
EXPOSE 8093
ADD ./target/ms-PaymentCredit-bank-0.0.1-SNAPSHOT.jar paymentcard-service.jar
ENTRYPOINT ["java","-jar","/paymentcard-service.jar"]