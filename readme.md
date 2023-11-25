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
```s