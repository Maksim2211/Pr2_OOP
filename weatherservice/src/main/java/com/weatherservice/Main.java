package com.weatherservice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Клас для демонстрації роботи системи
 */
public class Main {
    public static void main(String[] args) {

        // Створення Injector з нашим Guice-модулем
        Injector injector = Guice.createInjector(new weatherserviceModule());

        // Отримання екземпляра ServiceNotifier з впровадженими залежностями
        ServiceNotifier service = injector.getInstance(ServiceNotifier.class);

        // Створення інших об'єктів
        Meteorologist meteorologist = new Meteorologist(1, "Peter Johnson", "Forecaster");

        // Додавання підписників та отримувачів
        service.addSubscriber(new Subscriber("John Smith"));
        service.addAddress("weather.com");

        // Демонстрація
        meteorologist.publishForecast();
        meteorologist.publishWarning();
        meteorologist.analyzeAccuracy();

        String notification = meteorologist.formNotification();
        service.send(notification);
    }
}
