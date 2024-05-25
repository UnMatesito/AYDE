# Ejercicio 7

Calcular $T(n)$ y $O(n)$

### Punto A

```java
for(int i = 0; i< n; i++)
    sum++;
```
#### Tiempo de ejecución

$T(n)= \sum_{i=0}^n c$

$T(n)= (n-1+1)*c$

$T(n)= nc$

#### Orden de tiempo de ejecución

$O(n)$

Porque lo que me as crece en este caso es $n$

### Punto B

```java
for(int i = 0; i< n; i++)
    for(int j = 0; j< n; j++)
        sum++;
```

#### Tiempo de ejecución

$T(n)= \sum_{i=0}^n \left(\sum_{j=0}^nc\right)$

$T(n)= \sum_{i=0}^n \left(nc\right)$

$T(n)= n*nc$

$T(n)=n^2c$

#### Orden de tiempo de ejecución

$O(n^2)$

Porque lo que mas va creciendo cuando tengo numeros muy grande es $n^2$

### Punto C

```java
for(int i = 0; i< n; i++)
    for(int j = 0; j< n; j++)
        sum++;

for(int i = 0; i< n; i++)
    sum++;
```

#### Tiempo de ejecución

$T(n)= \sum_{i=0}^n \left(\sum_{j=0}^nc\right) + \sum_{i=0}^nc$

$T(n)= \sum_{i=0}^n \left(nc\right) + nc$

$T(n)= n*nc + nc$

$T(n)=n^2c + nc$

#### Orden de tiempo de ejecución

$O(n^2)$

Porque lo que mas va creciendo cuando tengo numeros muy grande es $n^2$

### Punto D

```java
for(int i = 0; i< n; i+=2)
    sum++;
```

$T(n)= \sum_{i=0}^{n/2} c$

$T(n)= (n/2-1+1)c$

$T(n)= {n\over 2}c$

#### Orden de tiempo de ejecución

$O(n/2)$

Porque lo que mas va creciendo cuando tengo numeros muy grande es $n \over 2$

### Punto E

```java
for(int i = 0; i < n + 100; ++i) {
    for(int j = 0; j < i * n ; ++j){
        sum = sum + j;
    }
    for(int k = 0; k < n + n + n; ++k){
        c[k] = c[k] + sum;
    }
}
```

#### Tiempo de ejecución

$T(n)= \sum_{i=1}^{n+100} \left(\sum_{j=1}^{i*n}c_1 + \sum_{k=1}^{3n}c_2\right)$

$T(n)= \sum_{i=1}^{n+100} \left((i*n-1+1)*c + (3n-1+1)*c\right)$

$T(n)= \sum_{i=1}^{n+100} \left((i*n-1+1)*c + (3n-1+1)*c\right)$

$T(n)= \sum_{i=1}^{n+100} \left(i*n*c + 3n*c\right)$

$T(n)= \sum_{i=1}^{n+100} \left(i*c + 3*c\right)*n$

$T(n)= n*\sum_{i=1}^{n+100} \left(i*c + 3*c\right)$

$T(n)= n*\sum_{i=1}^{n+100} \left(i + 3\right)*c$

$T(n)= nc*\sum_{i=1}^{n+100} \left(i + 3\right)$

$T(n)= nc* \left(\sum_{i=1}^{n+100} i\right) + \left(\sum_{i=0}^{n+100} 3\right)$

$T(n)= nc*({(n+100)*(n+100+1)\over 2} + (3n+300))$

$T(n)= nc*({(n+100)*(n+101)\over 2} + (3n+300))$

$T(n)= nc*({n^2+101n+100n+100*101\over 2} + (3n+300))$

$T(n)= nc*({n^2+201n+10100\over 2} + (3n+300))$

$T(n)= nc*({n^2\over 2}+{201n\over 2}+{10100\over 2} + (3n+300))$

$T(n)= ({n^3\over 2}c+{201n^2\over 2}c+5050nc + 3n^2c+300nc)$

$T(n)= ({n^3\over 2}c+{201n^2\over 2}c+5350nc + 3n^2c)$

#### Orden de tiempo de ejecución

$O(n^3)$

Porque el termino que mas predomina en la funcion polinomica es ${n^3\over 2}c$ al tener un grado cubico el crecimiento es mayor

### Punto F

```java
int i,j;
int x = 1;
for (i = 0; i <= n^2; i=i+2)
    for (j = n; j >= 1; j-= n/4)
        x++;
```

#### Tiempo de ejecución

$T(n)= c_1 + c_2 + \sum_{i=0}^{n^2}\left(\sum_{i=0}^{n/4}c_3\right)$

$T(n)= c_1 + c_2 + \sum_{i=0}^{n^2}\left((n/4-1+1)*c_3\right)$

$T(n)= c_1 + c_2 + \sum_{i=0}^{n^2}\left({n\over 4}*c_3\right)$

$T(n)= c_1 + c_2 + \sum_{i=0}^{n^2}\left({nc_3\over 4}\right)$

$T(n)= c_1 + c_2 + \sum_{i=0}^{n^2}\left({nc_3}\right)*{1\over 4}$

$T(n)= c_1 + c_2 + {1\over 4}*n*\sum_{i=0}^{n^2}c_3$

$T(n)= c_1 + c_2 + {1\over 4}*n*((n^2+1-1)*c_3)$

$T(n)= c_1 + c_2 + {1\over 4}n*(n^2c_3)$

$T(n)= c_1 + c_2 + {1\over 4}n^3c_3$

#### Orden de tiempo de ejecución

$O(n^3)$

Debido a que el termino que mas predomina es el n cubico, por lo tanto determianmos que $n^3$ es el que va aterne uncrecimiento mayor, con respecto a los demas terminos