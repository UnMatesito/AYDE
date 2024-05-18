# Ejercicio 6

### Punto A

Se spone que tenemos de un algotimo de $O(log_2(n))$ y se dispone de 1 hora de uso de la CPU. En esa hora la CPU puede jecutar el algotimo con un tamaño de entrada de `n=1024` comno maximo.

#### ¿Cual seria el mayor tamaño de entrada si disponemos de 4 horas?

Sabemos que:

1 hora = $1024$ entrada de datos

4 horas = $x$ entrada de datos

Aplicamos regla de 3 

$4 * 1024 / 1 = 4096$

Es decir que si se ejecuta el algoritmo en un tiempo de 4 horas, la entreda de datos va a ser de $n=4096$

### Punto B

Consideramos que el algoritmo requiere de $T(n)$ operaciones para resolverse y la computadora procesa 10000 operaciones por segundo. si $T(n)=n^2$.

#### Determinar el tiempo en segundos que el algoritmo tarda en resolverse si $n=2000$

$T(n) = n^2$

$n=2000$

Remplazamos $n$ con el valor

$T(n) = 2000^2$

$T(n) = 4000000$

Como se procesan $10000$ instrucciones por segundo, dividimos el resultado de $T(n)$ con las cantidad de instrucciones pro segundo.

$4000000/10000 = 400seg$

Es decir que para resolver el algoritmo con $T(n)=n^2$ si $n=2000$ nesecitaremos de **400 segundos**