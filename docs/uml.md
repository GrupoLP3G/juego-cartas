# Diagramas UML

## 1. Cartas

```mermaid
classDiagram
    class Carta {
        <<abstract>>
        -String nombre
        -TipoCarta tipo
        -int costo
        -String descripcion
        -String claveImagen
        +getNombre() String
        +geTipoCarta() TipoCarta
        +getCosto() int
        +getDescripcion() String
        +getClaveImagen() String
        +aplicar(Partida partida)*
    }
    class TipoCarta {
        <<enumeration>>
        ATAQUE
        DEFENSA
        APOYO
    }
    class Partida
    class Golpe
    class Escudo
    class Pocion

    Carta <|-- Golpe
    Carta <|-- Escudo
    Carta <|-- Pocion
    Carta --> TipoCarta : tipo
    Carta ..> Partida : usa en aplicar
```

Muestra la herencia: `Carta` es abstracta y `Golpe`, `Escudo` y `Pocion` la extienden. Cada carta implementa `aplicar` a su manera (polimorfismo). `Carta` guarda su `TipoCarta` y usa `Partida` solo como parámetro.