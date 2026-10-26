# Gamer JPA

Base de datos de videojuegos con Spring Boot, Spring Data JPA y PostgreSQL.

## Modelo

```
Developer 1 ── N VideoGame N ── 1 Genre
                    │
                    1
                    │
                    N
               Achievement
```

| Entidad | Tabla | Campos |
|---|---|---|
| `Developer` | `developer` | id, name (único), country |
| `Genre` | `genre` | id, name (único) |
| `VideoGame` | `video_game` | id, title, release_year, developer_id (FK), genre_id (FK) |
| `Achievement` | `achievement` | id, title, points, video_game_id (FK) |

## Cómo ejecutarlo

Requisitos: Java 21 y Docker.

1. Copia `.env.example` como `.env` y pon tu usuario y contraseña.
2. Levanta PostgreSQL: `docker compose up -d`
3. Arranca la app: `./gradlew bootRun`. Hibernate crea las tablas automáticamente.

## Pruebas

```
./gradlew test
```

Usan una base H2 en memoria, así que no necesitan PostgreSQL.
