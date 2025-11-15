# Метеосервіс

## Про проект

Імітаційний прототип системи метеорологічного сервісу, розроблений з використанням принципів об'єктно-орієнтованого програмування та паттернів проектування. Система дозволяє керувати метеорологічними даними, розповсюджувати попередження та сповіщення для підписників.

### Основні можливості:
- Управління метеорологічною інформацією та прогнозами
- Система сповіщень для підписників
- Відправка попереджень про небезпечні погодні явища
- Управління порогами подій та регіонами
- Інжекція залежностей за допомогою Google Guice

## Структура проєкту

```
weatherservice/
├── src/
│   ├── main/java/com/weatherservice/
│   │   ├── Main.java                      - Точка входу програми
│   │   ├── App.java                       - Базовий клас приложення
│   │   ├── weatherserviceModule.java      - Модуль Guice для інжекції залежностей
│   │   ├── WeatherSystemParticipant.java  - Абстрактний клас учасника системи
│   │   ├── Meteorologist.java             - Клас метеоролога
│   │   ├── Technician.java                - Клас техніка
│   │   ├── Subscriber.java                - Клас підписника
│   │   ├── SubscriberService.java         - Сервіс управління підписниками
│   │   ├── ServiceNotifier.java           - Сервіс для відправки сповіщень
│   │   ├── NotificationService.java       - Служба сповіщень
│   │   ├── INotificationPlan.java         - Інтерфейс плану сповіщень
│   │   ├── Region.java                    - Клас регіону
│   │   ├── Warning.java                   - Клас попередження
│   │   └── EventThreshold.java            - Клас порога подій
│   ├── test/java/com/weatherservice/
│   │   └── AppTest.java                   - Тести проекту
│   └── resources/
├── pom.xml                                - Конфігурація Maven
└── target/                                - Результати компіляції

```

## Залежності

- **Google Guice 5.1.0** - Фреймворк для інжекції залежностей
- **SQLite JDBC 3.36.0.3** - Драйвер для роботи з БД SQLite
- **JUnit 3.8.1** - Фреймворк для тестування

## Требування до середовища

- **Java**: 21 LTS або вище
- **Maven**: 3.6 або вище

## Компіляція

Для компіляції проекту виконайте наступну команду з директорії `weatherservice/`:

```bash
mvn clean compile
```

Або для повної компіляції з тестами:

```bash
mvn clean package
```

## Запуск

### За допомогою Maven:

Запустіть програму з основним класом:

```bash
mvn exec:java -Dexec.mainClass="com.weatherservice.Main"
```

Або з базовим класом App:

```bash
mvn exec:java -Dexec.mainClass="com.weatherservice.App"
```

### Запуск JAR-файлу:

Після компіляції можна запустити JAR:

```bash
java -jar target/weatherservice-1.0-SNAPSHOT.jar
```

## Тестування

Запустіть тести проекту:

```bash
mvn test
```

Для запуску конкретного тесту:

```bash
mvn test -Dtest=AppTest
```

## Документація

- `docs/requirements.md` - Вимоги проекту
- `docs/class.puml` - Діаграма класів (PlantUML)
- `docs/usecase.puml` - Діаграма прецедентів (PlantUML)
- `docs/sequence.mmd` - Діаграма послідовності (Mermaid)
- `docs/state.mmd` - Діаграма станів (Mermaid)
