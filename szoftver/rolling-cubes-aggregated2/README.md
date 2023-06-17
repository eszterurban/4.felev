rolling-cubes
=============

Puzzle game implemented in [JavaFX](https://openjfx.io/) based on the Model-View-Controller (MVC) architectural pattern.

Game results are stored in a [H2](https://www.h2database.com/) database with [Hibernate ORM](https://hibernate.org/orm/).

Run with the following commands, from the project's root directory:

```
mvn package
java -jar ./target/rolling-cubes-1.0.jar
```

**Note**:
For testing purposes, set `jdbc:h2:~/.h2/rollingcubes;AUTO_SERVER=TRUE` as `db.url` property's value in `db.properties`. Then open _H2 Console_, select _Generic H2 (Server)_ setting, and enter the same value into the _JDBC URL_ field. This way you can observe the database from the _H2 Console_.
