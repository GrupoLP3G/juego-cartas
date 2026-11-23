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

## 2. Strategy (jefes)

```mermaid
classDiagram
    class Jefe {
        -String nombre
        -int vida
        -int vidaMaxima
        -AccionJefe intencion
        -EstrategiaJefe estrategiaNormal
        -EstrategiaJefe estrategiaRabia
        -int porcentajeRabia
        +decidirIntencion(Jugador jugador)
        +estaEnRabia() boolean
        +recibirDanio(int cantidad)
        -getEstrategiaActual() EstrategiaJefe
    }
    class EstrategiaJefe {
        <<interface>>
        +elegirAccion(Jefe jefe, Jugador jugador) AccionJefe
    }
    class EstrategiaAgresivaNormal
    class EstrategiaAgresivaRabia
    class AccionJefe {
        <<interface>>
        +ejecutar(Partida partida)
        +getDescripcion() String
    }
    class Atacar {
        -String nombre
        -int danio
    }
    class AtaqueDoble {
        -String nombre
        -int danio
    }
    class CatalogoJefes {
        +crearAgresivo()$ Jefe
    }
    class Jugador
    class Partida

    Jefe --> EstrategiaJefe : estrategiaNormal
    Jefe --> EstrategiaJefe : estrategiaRabia
    Jefe --> AccionJefe : intencion
    EstrategiaJefe <|.. EstrategiaAgresivaNormal
    EstrategiaJefe <|.. EstrategiaAgresivaRabia
    AccionJefe <|.. Atacar
    AccionJefe <|.. AtaqueDoble
    EstrategiaJefe ..> AccionJefe : crea
    CatalogoJefes ..> Jefe : crea
    Jefe ..> Jugador : usa
    AccionJefe ..> Partida : usa
```

Roles: `Jefe` es el contexto, `EstrategiaJefe` la estrategia y `EstrategiaAgresivaNormal` y `EstrategiaAgresivaRabia` las estrategias concretas. `Jefe` elige una según su vida (`estaEnRabia`) y le delega la decisión, así que no tiene `if` por tipo de jefe. Cada estrategia devuelve una `AccionJefe`.