package com.weatherservice;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Сервіс для збереження даних підписників у базу даних SQLite.
 */
public class SubscriberService {

    private final Connection connection;

    /**
     * Конструктор з впровадженням залежності через Google Guice.
     *
     * @param connection з'єднання з базою даних SQLite
     */
    @Inject
    public SubscriberService(Connection connection) {
        this.connection = connection;
    }

    /**
     * Зберігає атрибут об'єкта Subscriber у таблицю subscribers.
     *
     * @param subscriber об'єкт Підписника для збереження
     */
    public void saveSubscriber(Subscriber subscriber) {
        String sql = "INSERT INTO subscribers (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subscriber.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save subscriber", e);
        }
    }
}
