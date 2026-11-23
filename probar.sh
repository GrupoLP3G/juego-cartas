#!/bin/bash
# Compila todo y ejecuta una prueba. Uso: ./probar.sh PruebaJugador
mvn -q clean package && java -cp target/juego-cartas-1.0.jar:target/test-classes juego.$1
