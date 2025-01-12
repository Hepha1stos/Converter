# ConverterApp

## Übersicht

ConverterApp ist ein Java-basiertes Programm, das verschiedene Einheitenkonvertierungen durchführt. Es unterstützt die Konvertierung zwischen Celsius und Fahrenheit, Meter und Fuß sowie Fuß und Meter.

## Installation

1. Klone das Repository:
    ```sh
    git clone <repository-url>
    cd converter
    ```

2. Baue das Projekt mit Maven:
    ```sh
    mvn clean install
    ```

## Ausführung

Um das Programm auszuführen, benutze den folgenden Befehl:
```sh
mvn exec:java
```

## Logging
Das Projekt verwendet Log4j2 für das Logging. Die Konfiguration befindet sich in der Datei log4j2.xml. Logs werden unter `<root>/logs/application.log` gespeichert.

<Configuration status="INFO">
    <Appenders>
        <File name="LogDatei" fileName="logs/application.log" append="true">
            <PatternLayout>
                <Pattern>%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n</Pattern>
            </PatternLayout>
        </File>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout>
                <Pattern>%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n</Pattern>
            </PatternLayout>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="LogDatei"/>
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>

## Checkstyle
Das Projekt verwendet Checkstyle, um sicherzustellen, dass der Code den Google Java Style Guide einhält. Die Konfigurationsdatei befindet sich unter google_checks.xml.

Checkstyle ausführen:
```sh
mvn checkstyle:check
```

## PMD
Das Projekt verwendet PMD zur statischen Codeanalyse. Die Konfigurationsdatei befindet sich unter pmd-custom-rulset.xml.

```sh
mvn pmd:check
```