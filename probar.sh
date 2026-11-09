#!/bin/bash
# Compila el proyecto y ejecuta una prueba. Uso: ./probar.sh PruebaJugador
mvn -q clean test-compile && java -cp target/classes:target/test-classes juego.$1
