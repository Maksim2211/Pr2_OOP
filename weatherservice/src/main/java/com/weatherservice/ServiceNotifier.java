package com.weatherservice;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас сервісу сповіщень, який містить список підписників (композиція)
 * та викликає збереження їхніх даних у базу SQLite.
 */
public class ServiceNotifier {

    private List<Subscriber> subscribers = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();

    private final SubscriberService subscriberService;

    /**
     * Впровадження залежності через конструктор.
     */
    @Inject
    public ServiceNotifier(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    /**
     * Додає адресу в список адресатів.
     */
    public void addAddress(String address) {
        addresses.add(address);
    }

    /**
     * Додає підписника і одразу зберігає його у базу даних.
     */
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);

        // Викликаємо збереження у БД
        subscriberService.saveSubscriber(subscriber);

        System.out.println("Підписник " + subscriber.getName() + " доданий і збережений у базі.");
    }

    /**
     * Розсилає повідомлення всім підписникам.
     */
    public boolean send(String text) {
        if (subscribers.isEmpty()) {
            System.out.println("Немає підписників для відправки.");
            return false;
        }

        for (Subscriber subscriber : subscribers) {
            subscriber.deliverMessage(text);
        }

        return true;
    }
}
