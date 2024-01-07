# Notas de clase
------------
## Primera clase
    Fecha: 7 de noviembre
### IDE VSCODE
Para preparar nuestro lugar de trabajo, debemos seguir los siguientes pasos:
1. Instalar jdk
2. Instalar Gitbash
3. Instalar el VSCODE

![Imagen 1](1.png)

> Para tener una mejor experiencia dentro de la programación mediante java se recomienda lo siguiente:
- Crear una cuenta de Github y registrarla en VSCODE
- Instalar extensiones (como  Extensión Pack for Java)
- Personalizar la consola o terminal mediante **Oh my push**. De esta manera podemos cambiar el tipo de letra, el fondo y los iconos que se muestran en pantalla.
---
## Segunda clase
    Fecha: 8 de noviembre

Existen dos tipos de IDE: 

**IDE a nivel de nube**: Sirve para programar desde otro dispositivo cuando uno no se encuentra cerca del más utilizado.

 **IDE a nivel local**: Se utiliza diariamente a través de nuestro dispositivo de confianza, por ejemplo el VS CODE.
 
 >Para empezar a trabajar, debemos crear una carpeta para guardar todos nuestros archivos denominados también work space o directorio de trabajo. 

***Shortcuts***

Mediante comandos podemos realizar ciertas acciones de manera más rápida en VS CODE, sin necesidad de utilizar el mouse. 

1. **Paleta de comandos:** CTRL + SHIFT + P
2. **Apertura rápida:** CTRL + P
3. **Alternar barra lateral:** CTRL + B
4. **Cursor de selección múltiple:** CTRL + D
5. **Copiar línea:** SHIFT + ALT + UP o SHIFT + ALT + DOWN
6. **Comentar un bloque de código:** SHIFT + ALT + A (una línea), CTRL + K + C (varias líneas)
7. **Retroceder, avanzar:** ALT + --> o +--> 
8. **Mostrar todos los símbolos:** CTRL + T
9. **Sugerencia de activación y sugerencias de parámetros de activación:** CTRL + SPACE O CTRL + SHIFT + SPACE
10. **Cortar línea:** CTRL + X
--------
## Tercera clase
    Fecha: 9 de noviembre 
### GIT
Git es un sistema de control de versiones distribuido ampliamente utilizado en el desarrollo de software. 

| Conceptos clave        | Utilización           | Comandos  |
| ------------- |:-------------:| -----:|
| Repositorios      | Espacio que almacena archivos y cambios de un proyecto. | $ git init |
| Commit      | Instantánea de cambios con un mensaje descriptivo.      | $ git commit -m "<some_message>" |
| Rama (Branch) | Línea de desarrollo independiente para nuevas funciones o correcciones.      |  $  git branch <name_branch>|
| Fusionar (Merge)      | Combinar cambios de una rama a otra.      |  $ git merge <rama_origen> |
| Clonar (Clone) | Copiar un repositorio completo para iniciar un nuevo proyecto.      |    $ git clone <URL_del_repositorio> |
| Pull      | Obtener cambios remotos y aplicarlos localmente.      |   $ git pull |
| Push | Enviar cambios locales a un repositorio remoto, actualizando el historial.      | $ git push |

![Imagen 2](2.png)

### Comandos Linux
***Gitbash***
1. **Dirección actual:** pwd | Autocompletar: tab
2. **Limpiar la terminal:** clear o CTRL + L  
3. **Regresar al directorio anterior:** cd ..       
4. **Listado de ficheros:** ls  
5. **Mostrar contenido:** cat file.txt                    
6. **Borrar fichero:** rm file.txt | Salto de línea: CtRL + Z
7. **Copiar:** cp file.txt newfile.txt | Pegar: CTRL + V 
8. **Renombrar:** mv file.txt newfile.txt
9. **Crear fichero:** touch file.txt  
---
## Cuarta clase
    Fecha: 10 de noviembre
### JAVA
Java es un lenguaje de desarrollo de propósito general y como tal, es válido para realizar todo tipo de aplicaciones profesionales.

![imagen 3](3.png)

***Diferencias entre otros lenguajes***
- Los programas creados por JAVA son independientes de la arquitectura.
- Permite escribir Applets.
> Un **applet** es un programa que puede incrustarse en un documento HTML, es decir en una página web.
- Se pueden escribir aplicaciones para intraredes.
- Aplicaciones cliente/ servidor.
- Aplicaciones distribuidas en redes locales y en internet.
- Es fácil de aprender y está bien estructurado.

![imagen 4](4.jpg)

***Características principales***
- Es intrínsecamente Orientado a Objetos.
- Funciona perfectamente en red.
- Tiene gran funcionalidad gracias a sus librerías. **(clases)**
- No tiene punteros manejables por el programador, aunque los maneja interna y transparentemente.
- El manejo de memoria no es un problema, la gestiona el propio lenguaje y no el programador.
- Genera aplicaciones con pocos errores posibles.
- Incorpora Multi-Threading.
> **Multi-Threading** Es la capacidad de ejecutar varios procesos o subprocesos a la vez, con el respaldo del sistema operativo.

![imagen 5](5.png)
### Sintaxis de JAVA
```java
package CLASES.IDE; // Todos los archivos permanecen a un paquete

import java.lang.*; // Importar los paquetes para el proyecto

// JAVA usa clases para ejecutar el código
public class Person { 

private String name; // Se debe indicar el tipo de dato
     ----> // Modificadores de acceso: private, public, protected o ninguno.
     |
    public static void main(String[] args) {
                        |
                        ---> // El método principal en JAVA es el main
        
        Person friend = new Person (); // La palabra reservada new crea un objeto del tipo de dato especificado

        friend.name = "David"; // Se utiliza ; para cada sentencia

        System.out.println("Hola Mateo" + friend.name);
    } // Se usan {} para identificar el bloque de código
}
```
### Comandos para JAVA en una terminal
1. **Compilar:** $ javac FileName.java
2. **Ejecutar:** $ java FileName.java  
----
## Quinta clase
    Fecha: 14 de noviembre del 2023
### POO
La programación orientada a objetos **(POO)** es un paradigma de programación que se basa en el concepto de "objetos". Estos objetos pueden contener:
- **Datos:** En forma de campos o atributos.  
- **Código:** En forma de procedimientos, conocidos como métodos.

![imagen 8](8.png)

***Declaración de un método***

![imagen 6](6.png)

***Ámbito o modificadores de acceso***

Los modificadores de acceso en Java son palabras clave que se utilizan para controlar el alcance o visibilidad de clases, variables, métodos y constructores en un programa. Estos modificadores determinan desde dónde se puede acceder a esos elementos en el código.

| Visibilidad | Public | Protected | Default | Private|
|------:      |:-----  |---------  |:------: |:------:|        
|Desde la misma clase |    SÍ| SÍ      | SÍ     | SÍ       |
|Desde cualquier clase del mismo paquete  | SÍ  | SÍ     | SÍ     | NO        |
|Desde una subclase del mismo paquete |  SÍ   |  SÍ      |  SÍ     |   NO     |
|Desde una subclase fuera del mismo paquete| SÍ    |SÍ, a través de la **herencia**    |  NO     |  NO      |
|Desde cualquier clase fuera del paquete  | SÍ    |  NO      | NO      |    NO  |
 
***Estructuras de control***

Las estructuras de control son componentes fundamentales en la programación que permiten modificar el flujo de ejecución de un programa. 

![imagen 7](7.png)

***Documentación***
```java
/**
 * Ejemplos de testing java
 * @author: mateonicolasg
 * @version: 1.0
 */
public class Testing {
    /**
     * valida la compilación del java
    */
    public static void TestJava(){
        System.out.println("java está lista")
    }
    /**
     * valida la compilación del java con saludo 
     * @param nombre: Mateo Simbaña
     * @param fecha: 19 de noviembre del 2023
     * @return un saludo 
    */
    public static String TestJavaSaluda (String nombre, String fecha){
        return "java  te saluda " + nombre + " " + fecha;
    }
}
```
***Tipos de dato***
```java
byte entero;
    entero = 12;
short entero1 = 12456;
int entero2 = 2121322;
long entero3 = 324323512;
float decimal = 3.45f; //Se coloca f al final
double decimal2 = 3.3243434;
//Caracteres
char caracter = 'a';
//Booleanos
boolean decision = true;
//Datos no primitivos
Integer numere = null;
//Cadenas
String palabra = "Hola q tal?";
//Constantes
final int num = 20;
```
-----
## Sexta clase
    Fecha: 16 de noviembre del 2023
### POO + JAVA
**Clases:** Una clase es una plantilla o un plano para crear objetos. Define las propiedades (atributos) y comportamientos (métodos) que los objetos de esa clase tendrán.

**Objetos:** Un objeto es una instancia específica de una clase. Se crea a partir de la plantilla proporcionada por la clase.

![imagen 9](9.png)

---
## Séptima clase
    Fecha: 16 de noviembre del 2023
### JAVA
Para trabajar POO en JAVA se necesita de tres cosas:
- **Propiedades:**  Los atributos son las características o propiedades que definen el estado de un objeto. 
- **Constructor:** El constructor es un método especial que se llama automáticamente al crear un objeto. En él, se definen las propiedades iniciales del objeto. 
- **Métodos:** Estos métodos permiten obtener y actualizar los valores de las propiedades de manera controlada, siguiendo los principios de encapsulamiento.

***Tipos de bucles*** 
Los bucles siempre tienen estas partes
inicio ---> condición ---> cuerpo  ---> actualización o cambio de estado 

Además, se pueden clasificar de la siguiente manera:

**Machos**

No le gusta pedir permiso al principio.

- ***Do while:*** Similar al bucle while, pero la condición se evalúa al final del bloque, lo que garantiza que el bloque de código se ejecute al menos una vez antes de verificar la condición.
```java
// Ejemplo:        
int contadorDoWhile = 0;
do{
    System.out.println("DoWhile " + contadorDoWhile++);
}while(contadorDoWhile < nroTerminos);
```
**Mandarinas**

Siempre pide permiso.

- ***While:*** Ejecuta un bloque de código mientras una condición dada sea verdadera. La condición se verifica antes de cada iteración. Si la condición es falsa desde el principio, el bloque de código no se ejecutará. 
```java
// Ejemplo:
int contadorWhile = 0;
    while(contadorWhile < nroTerminos){
        System.out.println("While " + contadorWhile++);
    };
```
> En ocasiones el bucle **while** puede parecerse a un bucle **medio macho**.
- ***For:*** Itera sobre una secuencia o ejecuta un bloque de código un número específico de veces. En cada iteración, toma el siguiente elemento de la secuencia.
```java
// Ejemplo:
for (int i = 0; i < nroTerminos; i++) {
        System.out.println("For : " + i);
    }
```
***Todos los tipos de dato***
1. **Tipos de datos primitivos:** Se ocupan para las variables. 
```java
byte bin = 0;
boolean b= true;
char c = 'a';
c =54; //Numero ASCII
short edad = 3278;
int num = 20;
```
2. **Tipos de datos referencia:** Se ocupan dentro de las propiedades.
```java
String cad = "Hola mateonicolasg";
Long ll = 123L;
Integer n = 23;
Double dbl = 23.23;
Float ff = 13.2f;
Boolean boo = false;
Character ch = 'x';
String [] arr = {"uno", "dos", "tres"};
```
3. **Cast:** Se dividen en explícitos e implícitos.
```java
long l = 10L; //explícito
float f = 10f; //explícito 
double d = 10d;

//cast explícito
ll = (long)n;
dbl = (double)ff;

//cast implícito
n = n / 2; //11.5  
```
4. **Conversiones:** Utilizan la fuerza bruta.
```java
cad = n.toString();
cad = ff.toString();    
n = Integer.parseInt(cad);
```
5. **Tipos de datos Objeto:** 
```java
Persona oPersona = new Persona ("Juan", 23);
Mujer oMujer = new Mujer();
```
---
## Octava clase
    Fecha: 28 de noviembre del 2023
### String
> **Refactorizar** significa organizar, limpiar, mejorar el código. 

Un **string** es una secuencia de caracteres, es un array (arreglo) dinámico.

- Si dos variables tipo ***String*** tienen el mismo contenido, JAVA se encarga de que ocupen el mismo espacio de memoria.
- Si quiero segmentar un espacio de memoria diferente para cada una de mis variables tipo ***String*** se ocupará lo siguiente:

```java
String cad1 = new String ()
```
![imagen 10](10.png)

 **Pila o stack:** Es una región de memoria donde se almacenan variables locales y datos relacionados con la ejecución de funciones en un programa. 

 **Montón heap:** Es una región de memoria más libre y dinámica que se utiliza para asignar memoria de manera más flexible durante la ejecución de un programa.

***Conceptos fundamentales***
- **Compilación:** El proceso de compilación verifica si el código cumple con la sintaxis del lenguaje, identifica errores y genera el código ejecutable.
- **Referencia:** Es como un "puntero" que apunta a la ubicación en memoria del objeto, pero se utiliza de manera más segura y abstracta. 
- **Declaración:** Se refiere a la especificación del tipo y nombre de una variable.
- **Inicialización:** Es el proceso de asignar un valor inicial a una variable después de declararla.
- **Instanciación:** Se refiere al proceso de crear un objeto de una clase.

**Ejemplo:**

```java
String S0;                   // Declara
String S1 = "TAT";           // Inicialización 
String S2 = "TAT"; 
String S3 = new String ("TAT");     // Instancia e inicialización 
String S4 =  new String ("TAT");
String S5 = new String("");         // Instancia
```
> Si se crea un objeto sin referencia, el **Virtual Machine** limpia el Heap y los elimina mediante el **Garbage Collection**.

***Unmutable y mutable Strings***

**Unmutable:**  Una vez que se crea un objeto String, su contenido no puede ser cambiado. 
**Mutable:** Permiten con el tiempo ir haciendo cambios en la variable.

A continuación se muestran los diferentes tipos de mutabilidad:

```java
String str = "Hola, como estas";

StringBuilder sb = new StringBuilder(); //Inicia la mutabilidad
StringBuffer stringBuffer = new StringBuffer("hola stringBuffer");

sb.append(str);
sb.append(" hoy ");          //Permite agregar más palabras
sb.append( "martes");
System.out.println("sb = " + sb);

str = str.concat(" hoy ");       //Permite agregar más palabras
str = str.concat( "martes ");      
System.out.println("String = " + str);

System.out.println("stringBuffer: " + stringBuffer);
```
***Operaciones con Strings***
- Se puede crear una cadena a partir de un arreglo de números o de caracteres:
```java
byte ascii [] = {71, 70, 72, 73, 75};
String cad = new String(ascii);
System.out.println("Cadenada creada con ASCCI: " + cad);
```  
- Se pueden concatenar varias cadenas:
```java
String cad1 = new String(cad + cad2);
System.out.println("Cadena unida: " + cad1);
```
- Recortar una cadena:
```java
String cadAsc = new String(ascii, 2, 2);    //Empieza en la posición 2 y toma 2 caracteres
        System.out.println("ASCII de la cadena: " + cadAsc);
```
- Tamaño de la cadena:
```java
int tamCad = cad.length();
        System.out.println("Tamaño de la cadena: " + tamCad);
```
- Obtener un caracter de un string:
```java
String str = "abc123!@#$";
System.out.println("Obtener un caracter >>> str.charAt(2): " + str.charAt(2));
```
- Comparar objetos o referencias:
```java
String sVar1 = new String("Hola");
String sVar2 = new String("Hola");

if (sVar1 == sVar2)     // objetos
    System.out.println("Son iguales");
else
    System.out.println("No son iguales");
```
- Comparar el contenido de objetos:
```java
String S3 = new String("Hola");
String S4 = new String("Hola");

if (S3.equals(S4))     // contenido
    System.out.println("Son iguales");
else
    System.out.println("No son iguales");
```
- Comparar el contenido ignorando las mayúsculas:
```java
String S3 = new String("Hola");
String S4 = new String("HOLA");

if (S3.equals(S4))     
    System.out.println("Son iguales");
else
    System.out.println("No son iguales");
```
- Substring
```java
String str = "abc123!@#$";
System.out.println("Substring: " + str.substring(3));
System.out.println("Substring: " + str.substring(3,6));
System.out.println("Substring: " + str.substring(3,str.length()));
```
---
## Novena clase
    Fecha: 29 de noviembre del 2023
### Strings parte 2

**Continuación operaciones con Strings**

- Reemplazar un caracter por otro:
```java
String subStr2 = str.replace('a', 'A');  //abc123!@#$
System.out.println("str.replace('a', 'A'): " + subStr2);
``` 
- Convertir todo a mayúsculas o minúsculas:
```java
String subStr3 = str.toUpperCase();  // Mayúsculas
System.out.println("toUpperCase: " + subStr3);
String subStr4 = str.toLowerCase();  // Minúsculas
System.out.println("toLowerCase: " + subStr4)
```
- Dividir una cadena:
```java
String strSplit [] = str.split("\\.");     // gfg.abc.123.*-+.abc
System.out.println("str.split(\".\"): " + str);
for (String subS : strSplit)
    System.out.println(subS);
```
- Cadena en array de caracteres:
> No necesariamente necesita de una variable.
```java
for (char c1 : str.toCharArray()){       // {'g', 'f', 'g', ... . a b c.123.*-+.abc}
    System.out.println(c1);
}
for (char c1 : "abcde".toCharArray()){
    System.out.println(c1);
}
```
- Nos muestra la posición de la primera vez en la que se muestra un determinado patrón de caracteres:
```java
int indice123 = str.indexOf("123");  //gfg.abc.123.*-+.abc
System.out.println("indexof(): Indice de la primera ocurrencia 123 = " + indice123);
```
- Proceso de conversión de una variable para añadir a un string:
```java
str = str.concat(String.valueOf(10));
System.out.println("str = " + str);
```
- Determinar si una cadena tiene un determinado caracter:
```java
if (str.contains("x"))
    System.out.println("contain(x): La cadena contiene \"x\": " + true);
else
    System.out.println("contain(x): La cadena no contiene \"x\": " + false);
```
- Eliminar espacios a la izquierda y a la derecha de un string:
```java
String nombre = "     Mateo Simbaña      ";
nombre = nombre.trim();
System.out.println("Nombre es: " + nombre);
```
### Scanner
Toma información desde la consola.

Una manera de pedir datos al usuario dentro de la terminal es utilizando **Scanner** dentro de la clase.
```java
Scanner sc = new Scanner(System.in);
String nombre = sc.nextLine();
``` 
Otra manera **más efectiva** de hacerlo es poniendo el **Scanner** en la App.java.
```java
public static Scanner scApp = new Scanner(System.in);
String nombre = App.scApp.nextLine();
```
**Tipos de datos captados con Scanner**
1. **nextInt ():** Toma un valor tipo int.
2. **nextLong ():** Toma un valor tipo long.
3. **nextFloat ():** Toma un valor tipo float.
4. **nextDouble ():** Toma un valor tipo double.

Todos estos se saltan los espacios dejados en blanco hasta encontrar un respectivo valor del tipo que utilicemos.

5. **next():** Salta los espacios dejados en blanco hasta que encuentra un token. Devuelve el token como un valor tipo String.
### POO: Array - List parte 1
Los **arreglos** son estructuras de datos que permiten almacenar múltiples elementos del mismo tipo en una sola variable.

Los **arreglos de tipo dinámicos** permiten trabajar con conjuntos de datos cuyo tamaño puede variar a lo largo del tiempo, evitando la necesidad de definir un tamaño fijo al principio y facilitando la gestión de la memoria.

**Ejemplo:**
```java
int matriz [][] = {{1,2,3}
                    ,{1,2,3,4,5}
                    ,{1,2,3}
                    };
```
El **forache** es una estructura de control que permite recorrer elementos de una colección o arreglo. Su sintaxis simplificada facilita la iteración sobre los elementos de una colección sin la necesidad de trabajar con índices o contadores.

**Ejemplo:**
```java
for (int[] an : matriz) {
    for (int n : an) {
        System.out.print(" " + n);
    }
    System.out.println("");
}
```
***Operadores aritméticos***
|   Operador    | Nombre    | Ejemplo  |
| ------------- |:----------| -----:   |
|      +        |  Adición  | x + y    |
|      -        |  Resta    | x - y    |
|      *        |Multiplicación| x * y |
|      /        |  División | x / y    |
|      %        |  Módulo   | x % y    |
|     ++        | Incremento| x++      |
|     --        |Decremento | --y      |

|   Operador    | Nombre    | Ejemplo           |
| ------------- |:----------| -----:            |
|      &&       |  y        |x > 3 && x < 10    |
|      ''       |  o        |x > 3  '' < 10     |
|      !        |  no       |!(x > 3 && x < 10) |

|   Operador    | Nombre             | Ejemplo  |
| ------------- |:----------         |  -----:  |
|      ==       |  igual             | x = y    |
|      !=       | no igual           | x != y   |
|      >        | mayor que          | x > y    |
|      <        | menor que          | x < y    |
|      >=       |mayor o igual que   | x >= y   |
|      <=       |menor o igual que   | x <= y   |

|   Operador    |  Ejemplo  | Igual a  |
| ------------- |:--------  | -----:   |
|      =        |  x = 5    | x = 5    |
|      +=       |  x += 3   |x = x + 3 |
|      -=       |  x -= 3   |x = x - 3 |
|      *=       |  x *= 3   |x = x * 3 |
|      /=       |  x /= 3   |x = x / 3 |
|      %=       |  x %= 3   |x = x % 3 |
|      &=       |  x &= 3   |x = x & 3 |
|      '=       |  x '= 3   |x = x ' 3 |
|      ^=       |  x ^= 3   |x = x ^ 3 |
|     >>=       | x >>= 3   |x = x >> 3|
|     <<=       | x <<= 3   |x = x << 3|

---
## Décima clase
    Fecha: 30 de noviembre del 2023
### Array - List parte 2

> Lo ideal es que el **main** esté fuera de los objetos para iniciar el proceso de ejecución.  

***static***

Los métodos estáticos salen de los objetos. Solo existe un único punto de acceso para todo el sistema. Además es la mejor manera para no gastar tanta memoria.

Tiene varios propósitos, entre ellos se destacan dos:

1. **Método estático:** Este método puede ser llamado directamente a través de la clase sin necesidad de crear una instancia de esa clase. Se asocian con la clase en sí y no con objetos individuales de esa clase.

2. **Variable estática:** Esa variable se comparte entre todas las instancias (objetos) de esa clase. Esto significa que cualquier cambio realizado en esa variable será reflejado en todas las instancias de esa clase.

***final***

Cuando se la utiliza en una **variable** se está indicando que su valor no puede ser modificado una vez asignado. Es decir, se convierte en una constante solo de lectura.

Si no está colocada la palabra **final** entonces esa variable puede ser de lectura o de escritura.

![imagen 11](11.png)

***Importancia del operador módulo***

Es un operador aritmético que devuelve el residuo de la división entre dos números.

Su uso puede simplificar cálculos, optimizar algoritmos y facilitar la resolución de problemas específicos en la programación.

**Uso para una barra de carga:**
```java
public void ejemploModulo(){
    String sim[] = {"|", "/", "-", "\\"};

    for (int i = 0; i <= 100; i++) {
        String c = sim[i%4];
        System.out.println("\r" + c + " " + i + " %");

        try {Thread.sleep(100);}      // Delay
        catch(InterruptedException ie){}
    }
}
```
> **\r** significa retorno de carro, es decir, que presente la información siempre al inicio.

***String[] args***

Podemos tomar información o parámetros que ingresan al momento de arrancar el programa. 

 **args** en el método main de Java permite recibir argumentos desde la línea de comandos al ejecutar un programa, lo que brinda flexibilidad y personalización a la ejecución del programa sin necesidad de modificar su código fuente.

***split***

Es un método que se utiliza para dividir una cadena (String) en subcadenas más pequeñas basándose en un delimitador dado. El resultado es un arreglo de subcadenas.

***Variable var***

Patea con las dos piernas, tiene varios comportamientos.
Por lo tanto, cuando se utiliza **var**, el compilador infiere el tipo de la variable basándose en el contexto en el que se declara. 

#### Array-List

Lista dinámica cuya función es guardar lo que el programador desee.

```java
ArrayList<String> lstStrings = new ArrayList<>();
ArrayList<Integer> lstInt = new ArrayList<>();
ArrayList<mujer> lstMujereList = new ArrayList<>();

lstStrings.add("abc");  // añadimos elementos 
lstStrings.add("123");
System.out.println(lstStrings);
```

Para crear una lista de objetos:

```java
mujer m1 = new mujer("Juana");  // Creo el objeto y luego lo meto en la lista
lstMujeres.add(m1);
lstMujeres.add(new mujer("Joyce"));  // Lo creo al objeto directamente dentro de la lista
```
Sin embargo, para mostrar lo que se tiene dentro de la lista, **se necesita utilizar un bucle**.

 ---
## Onceava clase
    Fecha: 30 de noviembre del 2023
### Array - List parte 3

El bucle **forache** juega un papel fundamental, puesto que se encarga de presentar las listas de las que no se conocen el tamaño previamente.

- Si se desea poner un elemento u objeto en una determinada posición dentro del Array - List, se hace lo siguiente:

```java
lstMujeres.add(1,new mujer("Maria"));
```

- Para eliminar un objeto o elemento de la lista tenemos dos formas:

***Mediante la referencia***

```java
lstMujeres.remove(m1);
```
***Mediante la posición***
```java
lstMujeres.remove(3);
```

- Colocar un objeto o elemento con la posición en la que deseo ubicarlo:
```java
lstMujeres.remove(3);
```

- Obtener un elemento de una determinada lista:
```java
mujer m = lstMujeres.get(1);
```

- Obtener información de ese elemento:
```java
String nombre = lstMujeres.get(1).nombre;  // Mediante la variable
System.out.println(nombre);
String nombre = lstMujeres.get(1).presentar(); // Una mejor manera de obtener información
System.out.println(m.presentar());  // Mediante un método
```
> Se puede acceder a las variables siempre y cuando sean públicas.

- Para modificar una variable que está publica:
```java
for (mujer mujer : lstMujeres) {
    System.out.println(mujer.presentar() + " Edad: " + mujer.edad);
    mujer.edad -= 5;  // Resta 5 años a la edad de todas las mujeres
}
```
> Cuando se trabaja con objetos pasamos las **referencias**, por eso debemos tener cuidado en alterar esos espacios de memoria.
- A través de métodos podemos cambiar el valor de las variables:
```java
private static void CambiaEdad(mujer m){
    m.edad -= 5;    
}
for (mujer mujer : lstMujeres)    //Llama al método y cambia la edad de todos los objetos mujer.
    CambiaEdad(mujer);
```
> Cuando recorremos la lista con un for y hacemos algún cambio, le estamos cambiando el contenido de todos los objetos creados.

- Dos listas apuntan al mismo espacio de memoria:
```java
ArrayList<mujer> lstAmigas = lstMujeres;
```
Si modifico una variable en una lista, lo mismo le va a pasar a la otra.

- Clonar una lista en un nuevo espacio de memoria:
```java
ArrayList<mujer> lstAmigas = new ArrayList<mujer>(lstMujeres);
```
***Wrapper***
También conocido como **boxing**,es un tema de conversión, similar a un casting. Se refiere a pasar de un tipo de dato primitivo a un tipo de dato por referencia.

Al proceso contrario se lo denomina **unboxing**.

Cuando se ocupa otro tipo de variable en una lista, esta ejecuta un proceso de boxing, unboxing.

>Si se conoce el número de elementos que se va a utilizar en un programa, trabajamos con un **array** normal, puesto que va a ocupar menos memoria y son más rápidos.

### List
Funciona igual que un Array-List porque son de la misma familia. La lista es un poco más liviana.

Tiene casi las mismos métodos que un Array - List.

- Obtener una información de un elemento a través de su posición:
```java
String s = lstNombre.get(1);
```

- Obtener la posición de un determinado elemento:
```java
int posicion = lstNombre.indexOf("Isra");
```
- Colocar a un elemento en una posición en especial:
```java
lstNombre.set(0, "Luis");
```
- Conocer el tamaño de la lista:
```java
lstNombre.size();
```
- Podemos utilizarla para crear una lista de un  objeto:
```java
List<mujer> lstMujeres = new ArrayList<>();
```

***Hashtable***

Un **hashtable** es una estructura de datos que se utiliza para almacenar datos en una colección asociativa. Funciona asociando claves con valores. Utiliza una función de hash para calcular un índice que mapea la clave con un valor en la tabla hash.

Es muy útil para guardar y buscar información rápidamente.

 ---
## Doceava clase
    Fecha: 5 de diciembre del 2023
### Programación Orientada a Objetos - Parte 2

> **HASHTABLE:** Útil para aspectos de balanceo (podemos organizar información de acuerdo al tamaño de los nombres).

Mundo real ---> paradigma orientado a objetos ----> POO (JAVA)

**Objeto:** Mujer 

**Características:** Ver y saber lo que tiene.

- altura = 160 cm
- peso = 50 kg
- edad = 20 años
- nombre = Ana

> ***Dato:*** Valor, que si le asocio algo tiene información.

**Acciones:**

- cantar() --->	Para cantar necesito la boca, manos  
- correr()               
- bailar()                                
- Saltar(3)		
> **Parámetros:** Caracterizan la acción, le damos un fin.


***Tipos de dato***
- **primitivo**	---> stack
- **referencia** ---> heap
- **objeto** ---> heap

**Evento:** Ocurrencia, se establecen con gerundios.

escuch ANDO()

sinti ENDO()

***Ámbito***

Variables globales o locales

1. **public** ---> altura, peso, correr()
2. **private** ---> secreto, bañar()
3. **protected** ---> edad, cantar()
4. **friendly**

#### Ejemplo
**Tarjeta de crédito**
![imagen 12](12.png)

**Propiedades:**

tipo de tarjeta, nombre, fecha de caducidad, número de tarjeta, código de seguridad, saldo, cupo, clave

**Acciones:**

- retirar(cantidad)
- cambiarClave()
- consultarSaldo()
- pagar()

> Todas las **clases** tienen que ser  públicas.

**Personalizar variables:** Declarar variables

private String nroTarjeta

    No lo vas a a operar, por tanto es un String (ahorras memoria)
 ---
## Treceava clase
    Fecha: 6 de diciembre del 2023
### EJEMPLO POO (TARJETA DE CRÉDITO)
**PROPIEDADES**
1. Bosquejar, prototipar el prototipo (datos)

2. Describir que es cada cosa (nombre de datos)
3. Campos 

clave ---> May, Min, Char 

monto


**MÉTODOS** (verb)

- Pagar()
- CambiarClave(claveActual, clave nueva, claveConf)
- Consultar()					    
- Retirar(cantidad)

> Pueden devolver: void(), true/false o un mensaje.

**PROGRAMAR**

> Compilador ve la clase si está pública.

**Siempre en mayúscula la primera letra del nombre de la clase.**

***Técnica 1***

```java
public class TarjetaCredito {
	private String nombreUsuario;
	private String claveUsuario;
    ...
}
```
**setter:** escribir
```java
setN(int n)
	this.n = n;

public void setnombreUsuario(String nombreUsuario){
	if (nombreUsuario.equals(""))	//Valora la entrada
		this.nombreUsuario = "Usuario no definido"
	else 
		this.nombreUsuario = nombre.Usuario;
}
```

**getter:** leer
```java
getN()

public String (){
	return this.nombreUsuario.toUpperCase();
}
public void setClase(String claveUsuario){
	if (claveUsuario > 8)
	if (claveMinuscula)
	if (clave Mayúscula)
	this.claveUsuario = md5(claveUsuario)
}
```

**Variable, sin get o setter SOLO PROPIEDADES**

**Ejemplo Método**
```java
public String cambiarClaveUsuario (String claveUsuarioAnt, String claveUsuarioNew, String claveUsuarioNewRescrita){
	String observacion = "";	
	if (!claveUsuarioAnt.equals(get.claveUsuario()))
		observacion = "Su clave no es igual a la actual";
	if (!claveUsuarioNew.equals(claveUsuarioNewRescrita))
		observacion = "Su clave new es diferente a la anterior";
	if (!observacion.equals(""))
		setClaveUsuario(claveNueva)
	return (observacion.equals("") ? "All ok" : observacion);
		  //    condicional        +  si no   -  ---> Devuelve una variable
}
```
**Main**
```java
main(){
	TarjetaCredito tc = new TC();
	tc.tipoTarjetaCredito = "Bono";  //No puede defenderse
	tc.getTipoTC();
	//Aquí se genera la entrada y salida de datos
}
```
 ---
## Catorceava clase
    Fecha: 7 de diciembre del 2023
### Lenguaje Unificado de Modelado (UML)

1. ***Use Case***
- **Use case:** proceso = acción = verbo
- **Actor:** <sujeto/objeto/cosa> ---> afecta al sistema
- **Boundary:** Dominio - módulo
- **Dirección**
- **Jerarquía/herencia**
- <<**extends**>>**:** opcional
- <<**include**>>**:** obligatorio

**Ejemplo**

![imagen 12](13.png)

2. ***Diagramas de clases*** (interfaz, herencia)

|Nombre     |    
|-----------|
|Propiedades|  
|Métodos    |  

***Ámbito***

**"+"** public

**"-"** private

**"#"** protected

**Ejemplo completo**

<span style="color:red">Supermaxi</span> desea automatizar las <span style="color:blue">ventas</span> insitu para que el <span style="color:red">cliente</span> <span style="color:blue">pague</span> con <span style="color:red">tarjeta de crédito</span>.

***Use case***

![imagen 14](14.png)

***Diagrama de clase***

1. 

![imagen 15](15.png)

2. 

![imagen 16](16.png)

 ---
## Quinceava clase
    Fecha: 13 de diciembre del 2023
### Java project

Datos dinamicos se guardan en la RAM

**P.E (relaciones) - (MER)**

El Modelo de Entidad-Relación (MER) es una representación gráfica que describe las entidades ***(objetos o conceptos)*** dentro de un sistema, sus atributos y las relaciones entre estas entidades.

Los datos son estáticos, por lo que se guarda la información en el disco, también se los conoce como **datos muertos**.

![imagen 17](17.png)

Donde:

- **Primary Key:** Identifica de manera única cada fila en una tabla y no puede tener valores duplicados ni nulos.

- **Unique Key:** Asegura que los valores en un campo o conjunto de campos sean únicos para cada fila, pero puede haber múltiples claves únicas y permitir valores nulos.

- **Foreign Key:** Establece relaciones entre tablas, enlazando una columna de una tabla con la clave primaria de otra, garantizando la integridad referencial.

**Clusterización**

En análisis de datos y aprendizaje automático, la clusterización se refiere a un proceso donde se agrupan datos similares en conjuntos llamados "clusters". El objetivo es encontrar estructuras ocultas o patrones en los datos, agrupando objetos similares en el mismo cluster y objetos diferentes en clusters separados.

Existen de dos tipos:
- **logica:** Se centra en cómo se organizan y relacionan los datos a nivel lógico dentro de una base de datos. Esto implica la estructura, diseño y relación entre las tablas y entidades.
- **física:** Se refiere a cómo se almacenan y organizan los datos en el almacenamiento físico, como en discos duros, SSD u otros dispositivos de almacenamiento.

> Se trabaja de manera más rápida y efectiva con la clasteurización física.

**ID**

Crear un ID para cada objeto significa asignar un identificador único a cada instancia de una clase. Este identificador único ayuda a distinguir un objeto específico de otros dentro del programa.

Esto es particularmente útil cuando se trabaja con múltiples instancias de una misma clase y se necesita referenciar o realizar operaciones específicas con un objeto particular.

![imagen 18](18.png)

> Cuando se ocupa el id, se utilizan datos tipo ***primitivos***, los demás datos continuan siendo de tipo referencia.
 ---
## Clase # 16
    Fecha: 14 de diciembre del 2023
### Diagrama de caso de uso y diagrama de clases

Paso previo al codigo. No se permiten abreviaciones en los nombres de las variables.

**UML**

Permite hacer gráficos, y no centrarnos en el código

Hay de dos tipos:

1. Estaticos

- clases
- objetos
- componentes
- despliegue

2. Dinamicos

- **casos de uso** (modelar procesos)
- secuencia
- colaboracion
- estados
- actividades

**Diagramas de casos de uso**

> Solo para POO 

Me ayudan a representar requerimientos

- **Funcionales:** les otorga el giro de negocio (registoproductos, ventas, compra)
- **No funcionales:** tenemos que otorgarle al sistema (seguridad, encriptar)


c.nombre = xxx ----> pone en riesgo la info
c.setNombre() ----> tengo la posibilidad de hacer un control de la información 

campo de base, solo de lectura

 ---
## Clase # 17
    Fecha: 15 de diciembre del 2023
### Constructor

**super()**

Se utiliza para llamar al constructor de la clase padre desde el constructor de la clase hija, es decir lleva los parámetros al papá.

new ----> objeto, no necesariamente debemos utilizar constructores vacíos.

> Virtual Machine inyecta automaticamente un constructor a las clases si es que no existe ninguno.

Cuando el hijo dispara un super elimina lo que esta por defecto, y coloca el constructor creado.

Si el constructor de la clase padre no tiene argumentos, **super()** se coloca implícitamente en el constructor de la clase hija, llamando al constructor sin argumentos de la clase padre.

Por otra parte, si el constructor de la clase padre tiene argumentos, debes llamar explícitamente a **super()** con esos argumentos desde el constructor de la clase hija para inicializar la parte correspondiente de la clase padre.

Se puede tener varios constructores.

![imagen 19](19.png)

**Ejecución de herencia**

Primero se ejecuta el padre, luego el hijo.

> Tenemos que tener en cuenta que existen diferentes espacios de memoria para cualquier objeto que creemos cada vez que colocamos ***new***.

**Sobrecarga** (parametros) + **Polimorfismo** (múltiple) (forma)

La ***sobrecarga*** es un concepto que permite definir múltiples métodos con el mismo nombre en una clase, pero con diferentes listas de parámetros. 

Particularidad del lenguaje de poder tener el nombre, y pasarle varios parámetros: 

- saltar(){}
- saltar(int){}
- saltar (???){}

El ***polimorfismo*** permite que objetos de distintas clases sean tratados mediante una interfaz común. Esto significa que un objeto puede presentar comportamientos diferentes dependiendo del contexto en el que se utilice.
Ambos se complementan.

![imagen 20](20.png)

Tienen el mismo nombre del metodo, y algunos cambios del actuar en el método.

**Asociación de clases**

Describe la relación y la interacción entre dos o más clases.

```java
public empresa{            
    String nombre;       
    Cajero c1;           
}                        
public class Cajero{     
    public empresa e; 
}
```
**Código en POO-JAVA**

Existen: 

- clases 
- objetos
- **encapsulamiento:** llamo a presentar un método, no nos interesa que hace solo que se ejecute.
- **abstracción:** Definir propiedades, depende del conocimiento
- **especificaciones:** (herencia) arriba hacia abajo
- **generalización:** abajo hacia arriba
- evento - mensaje

 ---
## Clase # 18
    Fecha: 20 de diciembre del 2023
### Class

- Conceptual
- Especificación 
- Implementación

**Herencia**

***es un/una*** | ***son***

Ejemplo:

Un segmento es una figura.

Un circulo es una figura.

Quien interactua con el sistema y quien esta dentro del sistema.

## Clase # 19
    Fecha: 3 de enero del 2024

### Interfaces

**Atributos**

- **Público:** Esta abierto para toda clase.
- **Privado:** Solo se puede trabajar desde la misma clase.
- **Protegido:** Público pero a nivel de paquete. 

**Interfaces**

Parecida a una clase pero hueca, lleva la letra "I" antes de su nombre.

En una clase se puede implementar código dentro de un método, mientras que en una interfaz no.

> No se pueden instanciar.

Destinada a dar órdenes.

Se conocen como contrato/acuerdo, realización, implementación, firmar, interfaz, suscripción.
Permiten aplicar o definir patrones, comportamientos, muchas cosas en forma general. NO LOS IMPLEMENTA.

![imagen 21](21.png)

Se lo debe utilizar obligatoriamente en una clase que esté asociada. Si la interface tiene 3 métodos, la clase asociada también debe tener 3 métodos.

Esto se ocupa, por ejemplo, cuando se desea conectar a aplicaciones de la nube.

![imagen 22](22.png)

En la interfaz todo es público ylos atributos son estáticos y constantes. 

Por otro lado, una clase puede tener una o más interfaces.

> No tienen ningún constructor.

**Notaciones de una interface**

![imagen 25](25.png)

Cuando se representa con un círculo significa que no importa los métodos que se coloquen en esa interface.

![imagen 26](26.png)

**Se lee:** Window3 tiene un Clock3 y Clock3 implementa un Timer.

![imagen 27](27.png)

**Se lee:** Window1 implementa un Timer.

**Clase abstracta**

No permite instanciarse, pero puede implementar código y le puede heredar a la clase hija o sobreeescribir ese método con un overide. 

Se diseñan para ser heredadas.

**Diferencia entre clase abstracta y una interfaz**

La clase abstracta tiene código base, en cambio que una interface tiene solo métodos sin código. 

![imagen 23](23.png)

**Relaciones entre clases**

![imagen 24](24.png)

## Clase # 20
    Fecha: 5 de enero del 2024

### Asociación

Son relaciones entre clases en un diagrama de clases UML 

![imagen 28](28.png)

**Cardinalidad**

Número de partipaciones que yo tengo al momento de relacionar.

- 1 ---> solo uno 
- 0..1 ---> cero a uno 
- n ---> indica cuantas relaciones pueden haber 
- n..m ---> varios a varios 
- * ---> cero o más
- 0..* ---> cero o más 
- 1..* ---> uno o más

Van debajo de una línea.

Ejemplos:

![imagen 29](29.png)

***Se lee:*** Una persona tiene un color, un color tienen muchas personas.

![imagen 30](30.png)

Este ejemplo no tiene cardinalidad.

***Se lee:*** Un cliente tiene una cuenta, una cuenta tiene un dueño.

En código:

```java
public class Cliente {
    private String nombre;
    public CtaCte cuenta;
}
public class CtaCte {
    private Double saldo;
    public Cliente dueño;
}
```
![imagen 31](31.png)

Cuando existe una flecha, quiere decir que una clase está asociada con otra, no ambas a la vez.

![imagen 32](32.png)

***Se lee:*** Una persona tiene muchas mascotas de tipo perro. Un perro tiene un propietario.

```java
public class Persona {
    private String nombre;
    public ArrayList<Perro> mascotas = new ArrayList<>();
}
public class Perro {
    private String nombre;
    public Persona propietario;
}
```

Como se puede tener muchas mascotas, se utiliza un ArrayList.

**Relación de recursividad**

![imagen 33](33.png)

***Se lee:*** Una gente es querida por 1 o mucha gente. Una gente quiere a 1 o mucha gente.

```java
public class Gente {
    public ArrayList<Gente> esQueridaPor = new ArrayList<>(Gente Gente1);
    public ArrayList<Gente> quiereA = new ArrayList<>(Gente Gente1);
}
```