# Plan del proyecto — Juego de cartas contra jefes (LP3)

Última actualización: 18 de noviembre de 2026.

## El juego

Juego de cartas por turnos, para un jugador, contra 3 jefes. Estilo pixel art. Java 17 + Swing, arquitectura MVC, patrones Observer, Strategy y Command.

### Reglas del jugador
- Vida 30. Energía 6, que **no se recarga sola**.
- Al iniciar el turno: el escudo vuelve a 0, el veneno quita 1 de vida por marca (atraviesa el escudo) y se roba hasta tener 3 cartas.
- Cada carta cuesta energía. Si la energía no alcanza, no se puede jugar.
- **Agotado** (energía 0): las cartas se juegan gratis pero hacen la mitad, y el jefe pega un 50 % más.
- **Concentración** recupera toda la energía, pero se pierde el turno.
- Se pueden jugar varias cartas por turno (las que haya en la mano y se puedan pagar).
- Deshacer y rehacer solo funcionan dentro del turno actual.

### Las 10 cartas
| Carta | Tipo | Costo | Efecto |
|---|---|---|---|
| Golpe | Ataque | 1 | 6 de daño |
| Golpe fuerte | Ataque | 2 | 10 de daño |
| Golpe doble | Ataque | 2 | 2 golpes de 4 |
| Contraataque | Ataque | 1 | 3 de daño y +3 de escudo |
| Escudo | Defensa | 1 | +5 de escudo |
| Muro | Defensa | 2 | +10 de escudo |
| Poción | Apoyo | 2 | Cura 5 de vida |
| Antídoto | Apoyo | 1 | Quita todo el veneno |
| Robo | Apoyo | 1 | Roba 2 cartas |
| Concentración | Apoyo | 1 | Recupera toda la energía, pero se pierde el turno |

### Los 3 jefes
Cada jefe tiene acciones propias (no usa cartas), anuncia su intención al inicio del turno del jugador y tiene dos estrategias: normal y rabia. La rabia depende solo de su vida actual.

| Jefe | Regla especial | Rabia al… | En rabia |
|---|---|---|---|
| Agresivo | Pega fuerte | 70 % | Ataca dos veces |
| Mago | Veneno acumulable | 50 % | Pone 2 marcas por ataque |
| Defensor | Guardia: devuelve la mitad del daño | 25 % | Deja de cubrirse y ataca con todo |

## Reglas de trabajo
- El paquete `juego.modelo` nunca usa Swing ni `System.out`.
- No se modifican clases ni métodos de otro integrante sin preguntarle antes.
- No se cambian nombres de clases ni de métodos existentes: son contratos del grupo.
- Nombres claros en español, sin abreviaturas. Código simple, del nivel del curso.
- Cada uno trabaja en su rama (`diseno`, `cartas`) y envía un pull request a `main`. Fre revisa y une.
- Commits pequeños, frecuentes y con mensajes claros, cada uno con su propia cuenta.
- Antes de cada commit: compilar y probar (`./probar.sh NombreDeLaPrueba`).
- El uso de IA se declara en el informe: cada uno anota fecha, para qué la usó y en qué clases.

## Decisiones de diseño (para la defensa)
- `Jugador` protege sus datos; `Partida` aplica las reglas.
- Las reglas de agotado están en un solo lugar: `aplicarDebilidad` y `aplicarVulnerabilidad`.
- `jugarCarta`: primero todas las revisiones, después los cambios. Se revisa con `puedePagar`, se aplica la carta y se cobra al final.
- Los efectos no avisan a los observadores; cada acción avisa una sola vez al terminar.
- El fin de la partida se calcula con `isTerminada()`; nunca se guarda.
- La partida no empieza sola: primero se registran los observadores y después se llama a `iniciarTurno()`.
- Deshacer usa "fotos" (`EstadoPartida`) con constructores de copia. Solo `Partida` puede tomar fotos (`guardarEstado`), y al restaurar se copia otra vez.
- Cada jugada es un comando nuevo (`JugarCartaComando`). Rehacer restaura la foto de después, no vuelve a jugar la carta (por el azar).
- Una acción nueva vacía la pila de rehacer. Al terminar el turno se limpia el historial.

## Reparto
- **Fre:** la base (modelo, Command, controlador, ventana simple, jefe Agresivo como ejemplo, carta Concentración), y después persistencia y SwingWorker.
- **Compañero de diseño** (rama `diseno`): estilo pixel, paneles, tabla del historial, menú, diálogos e imágenes.
- **Compañero de cartas y jefes** (rama `cartas`): Golpe fuerte, Golpe doble, Contraataque, Muro, Antídoto y Robo; después Mago y Defensor siguiendo el ejemplo del Agresivo.

## Avance

### Hecho
- [x] 1. Proyecto Maven y repositorio
- [x] 2. Excepciones propias
- [x] 3. `Jugador`
- [x] 4. `Carta`, 3 cartas de ejemplo y la mano
- [x] 5. `Mazo`
- [x] 6. `ObservadorPartida` y `Partida` (Observer)
- [x] 7. `EstadoPartida`, `Comando`, `JugarCartaComando` y `HistorialComandos` (Command)

### Falta (en este orden)
- [ ] Mandar tareas a los dos compañeros
- [ ] 9. Controlador, ventana simple (`VentanaSimple`) y `Main` (para mostrar el jueves 19)
- [ ] 8. Jefe completo: acciones, estrategias, rabia, Agresivo
- [ ] Carta Concentración
- [ ] Avisar al compañero de jefes que ya puede hacer Mago y Defensor
- [ ] Persistencia (historial CSV) y SwingWorker
- [ ] Informe, UML, README, JAR probado en otra PC, ensayo de la defensa

## Pendientes para después de la base
- [ ] **2 acciones por turno:** jugar una carta o robar una carta. Contador en `Jugador`, revisión en `jugarCarta`, `RobarCartaComando`, botón "Robar carta" en la vista. Quizás bajar la energía inicial.
- [ ] Azar en las decisiones de los jefes.
- [ ] Reloj por turno para el jefe Agresivo.
- [ ] "Cansancio": perder vida cada vez que se acaba el mazo.

## Enlaces
- Mockup: https://claude.ai/artifact/EQPLCdgDAYPAzErJ23BbQU
