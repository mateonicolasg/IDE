## <center>**Escuela Politécnica Nacional**</center>
## <center>**Programación II - Segundo Bimestre**</center>
### **Autor:** Mateo Simbaña
------------
# <center>Notas de clase</center>

## Clase # 21
    Fecha: 12 de enero del 2024
### <span style="color:orange">Association</span>

**Relaciones entre clases**

Una clase puede estar involucrada en una o más relaciones con otras clases.

***Tipos de relación***

- **Asociación (sin flecha):** Hay dos clases que guardan relación, no se sabe quién tiene más peso que la otra (participa).
- **Asociación (con flecha):** Nos dice qué entidad debe contener a la otra entidad. 
- **Herencia:** Nos dice qué clase hereda características (atributos y métodos) de otra clase.
- **Interfaz:** También conocido como realización o implementación. Nos dice qué clase implementa una interfaz.
- **Dependencia:** Son una derivación de la asociación,pero implican dependencia. Más específica la situación, de que una clase debe estar dentro de otra. 
- **Agregación y composición**: Utilizadas para manejar colecciones y grados estrictos de cómo debe componerse un objeto y cuántas partes debe tener esa entidad.

***Notación***

![imagen 1](1.png)

**Implementación de interfaces**

La **interfaz** es como un jefe, aquella que da órdenes pero no hace nada mientras que la **clase abstracta** es como un líder, pues demuestra con sus acciones y les incita a las otras a que hagan lo mismo.

Por otro lado, las interfaces nos ayudan a manejar el comportamiento de las cosas.

Para nombrar a una interfaz, primero se debe colocar una I en mayúscula y luego el nombre de la intefaz, siguiendo la convención PascalCase.

![imagen 2](2.png)

**App** se utiliza para lanzar a flote nuestro giro de negocios, no es apropiado incluirla allí. Por lo tanto debe quedar fuera de todo, en otras palabras, debe estar suelta.

Por lo general, no debe tener atributos, a menos que sean variables globales de dirección de directorios, la base de datos, algo que sea propio de esa clase.

En los **Utilities** se crea una carpeta para documentación o diseño. 

***En código***

- Interfaz IPito:

```java
public interface IPito {
    public void pitar ();
}
```

- Interfaz IVolantes:

```java
public interface IVolante {
    public void girar();
}
```

- Clase Vehiculo:

```java
public class Vehiculo implements IPito {
    public void girar(){
        System.out.println("Se ha girado el vehiculo");
    }

    @Override
    public void pitar() {
        System.out.println("Vehiculo pitando");
    }    
}   
```

- Clase Coche:

```java
public class Coche extends Vehiculo implements IPito, IVolante {

    @Override   // Sobreescribe al método de IPito
    public void pitar() {
        System.out.println("Coche pitando");
    }

    @Override
    public void girar() {
        System.out.println("Coche girando");
    }
    
}
```

- Clase Barco:

```java
public class Barco extends Vehiculo implements IPito{

    @Override
    public void pitar() {
        System.out.println("Barco pitando");
    }
    
}
```

- Clase AppCiudad:

```java
public class AppCiudad {
    private String nombre;
    private Vehiculo oVehiculo;
    public Coche oCoche;
    private Barco oBarco;
    public Barco oTitanic;

    public Vehiculo getoVehiculo() {
        return oVehiculo;
    }
    public void setoVehiculo(Vehiculo oVehiculo) {
        this.oVehiculo = oVehiculo;
    }
    public Coche getoCoche() {
        return oCoche;
    }
    public void setoCoche(Coche oCoche) {
        this.oCoche = oCoche;
    }

    public void transitarCoche(){
        oCoche = new Coche();
        oCoche.pitar();
    }

    public void jugarVario(){
        ArrayList <Vehiculo> lista = new ArrayList<>();

        // Forma rápida de añadir elementos a la lista

        lista.add(new Coche());
        lista.add(new Barco());
        lista.add(new Barco());
        lista.add(new Barco());

        // Forma lenta de añadir elementos a la lista 

        // Coche oCoche1 = new Coche();
        // Barco oBarco1 = new Barco();
        // Coche oCoche2 = new Coche();
        // Barco oBarco2 = new Barco();
        // ...
        
        // lista.add(oCoche1);
        // lista.add(oCoche2);
        // lista.add(oBarco1);
        // lista.add(oBarco2);
        
        // Ventaja de utilizar una interfaz

        // oCoche1.pitar();
        // oBarco1.pitar();
        // oCoche2.pitar();
        // oBarco2.pitar();

        for (Vehiculo o : lista) {
            o.pitar();
        }
    }
}
```
**Ventaja de las interfaces**

Una ventaja de las interfaces es que podemos llamar a un mismo método (creado en una interfaz) de varios objetos que se encuentran en una lista y este va a tener un comportamiento diferente según la codificación que contenga en cada clase. 

El entorno de trabajo debe estar serializado en **UTF-8**.

***UTF-8***

UTF-8 es un estándar de codificación de caracteres Unicode que se ha vuelto dominante en muchos contextos debido a su eficiencia y compatibilidad con ASCII. Es ampliamente utilizado en sistemas operativos, bases de datos, páginas web y otras aplicaciones para manejar la diversidad de caracteres que existen en los diferentes idiomas y sistemas de escritura.

> La mayoría de software se desarrolla en inglés, por esa razón no se deben utilizar **tildes** o la **ñ** en nuestros trabajos.

**Cardinalidad**

La cardinalidad va en la parte inferior de las flechas y nos indica cuál es la asociación y la cantidad de objetos que el programador necesita emplear para resolver un tema.

**Forma adecuada de asignación en JAVA**

Para ello se ocupan los getter y setter.

```java
Coche oCoche;

public void setoCoche(Coche oCoche){
    this.oCoche = oCoche;
}

public void mostrarObjetos(){
    Coche c = new Coche();

    // oCoche = c;      x

    oCoche.setoCoche(c);  //getter y setter para pasar el objeto a la variable oCoche
}
```

## Clase # 22
    Fecha: 16 de enero del 2024
-------
### <span style="color:yellow">Herencia vs Interfaz vs Asociación</span>

**Herencia**

Permite pasar código de una clase papá a una clase hijo. A continuación se presenta un ejemplo: 

![imagen 3](3.png)

Donde existe una manera de agrupar todos esos objetos de ahí gracias a la herencia.

Se puede realizar una lista, ya sea de tipo ***Vehiculo*** o de tipo ***Objecto***, puesto que son hijos de la clase Vehiculo.

```java
ArrayList <Object> lst;  // Primera manera

ArrayList <V> lst;  // Segunda manera
```

Y se añaden los objetos que se requieran en la lista de la siguiente manera:

```java
    lst.add(new Coche);
    lst.add(new Barco);
    lst.add(new Moto);
    lst.add(new Tractor);
```
Con una lista de tipo Objeto se puede enlistar cualquier cosa, no hace falta la herencia, sin embargo nos quita opciones para realizar una programación más efectiva. Además, la lista de tipo Objeto es considerada una lista lenta dado que el lenguaje no sabe lo que se está agrupando y al momento de querer utilizarla se necesitan de más líneas de código o hasta puede colgarse el programa, por lo que hay que tener mucho cuidado si se desea optar por esta opción. 

Mediante la herencia se puede utilizar un ***Foreach*** para mostrar un método que han heredado las clases hijas. Por ejemplo:

```java
    for(Vehiculo v: lst){
        v.pitar();
    }
```

Solo la herencia nos garantiza que un método del papá esté en todas las clases hijas. Si no existe la herencia, no hay garantía de que exista ese método en todas las clases y por lo tanto no se podría utilizar un ***Foreach*** para llamar al método en común que poseen.

> Solo con los métodos de la herencia, utilizamos un ***Foreach***.

***Caso en el que no se utiliza una herencia***

Se presenta el mismo escenario, solo que esta vez no existe una clase padre.

![imagen 4](4.png)

Para crear una lista de esos objetos diferentes ocuparíamos un ArrayList de tipo Objeto, pero si quiero llamar al mismo método que tienen todos únicamente se lo haría por separado y realizando un cast, lo que implica más líneas de código y más tiempo.

En pocas palabras, no se puede realizar un ***Foreach*** para mostrar el método que comparten un conjunto de objetos.

**Interface**

La interface siempre comienza con una I y luego se coloca el nombre de la misma.

Una interfaz nos sirve para dar órdenes, mandos a las cosas. 

En el ejemplo que se puso de herencia hay un problema con el método pitar de la clase padre y es que las clases hijas pitan conforme el papá, algo que no debe pasar ya que algunos pueden hacerlo de una manera diferente.

Para solventar dicho problema se utiliza la interface debido a que nos ayuda a personalizar estos comportamientos.

![imagen 5](5.png)

De esta manera, la interface obliga a que las clases hijas implementen una forma diferente de pitar del papá.

Por otro lado, es importante recordar que si se quita la herencia no se puede generalizar el comportamiento que tienen los objetos. 

> Al combinar los conceptos se realizan códigos más elegantes y representativos.

**Asociación**

![imagen 6](6.png)

Como se puede observar en el ejemplo, una persona puede tener todo un conjunto de esos objetos. A este acontecimiento lo denominamos asociación. 

***App***

Lo que hace esta clase es lanzar un escenario desarrollado o **giro de negocio** a través de un método llamado main.

> El **giro de negocio** es una palabra técnica que se utiliza al construir software.

Por ende, esta clase no participa en el escenario y solo tiene 2 o 3 líneas de código.

Por otra parte, debe haber alguien que orqueste el giro de negocio y de ahí surge una clase App que contenga el programa y sea totalmente distinta a la mencionada anteriormente. Esta clase se va a encargar de ver quién se ejecuta primero, qué se lanza, cómo va a funcionar el giro de negocio.

![imagen 7](7.png)

Con la asociación se busca que cada clase tome su responsabilidad y que si se llegara a dañar algo pueda resolverse o modificarse de una manera sencilla.

***Cardinalidad***

Trata de la cantidad de veces que se requiere tener de algo. **Siempre** se la coloca debajo de las líneas y se la puede representar de las siguientes formas:

- 0
- 1
- 0...*   ----> *
- 1...*   ----> +
- n...*

***n*** se refiere a la cantidad mínima que se necesita de ese atributo.

***Casos de asociaciones***

- **Primer caso**

![imagen 8](8.png)

Significa que App puede llamar a AppCiudad o AppCiudad puede llamar a App.

Estas relaciones van en la parte de atributos de cada clase. Por ejemplo:

```java
public class AppCiudad{
    //Atributos
    private String nombre;
    public App xyz;  //Se puede poner cualquier nombre
}
```
- **Segundo caso**

En la siguiente imagen se especifica el nombre que se le quiere dar al atributo y también existe una restricción, puesto que App puede llamar a AppCiudad pero AppCiudad no puede llamar a App.

![imagen 9](9.png)

En código se vería así:

```java
public class App{
    //Atributos
    public AppCiudad lanzaAplicacion;  //Se coloca el nombre señalado en el diagrama de clases
}
```

> Debemos recordar que el nombre de un atributo o una variable debe estar sustantivado, no puede ser un verbo.

- **Tercer caso**

Para evitarse una línea en el diagrama de clases se realiza lo siguiente:

![imagen 10](10.png)

Pero resulta que AppCiudad no debería llamar a App y al no ser un atributo de esa clase tenemos que eliminar esa línea de código.

**Transformar en código un diagrama de clases**

Tenemos que seguir los siguientes pasos:

1. Verificar que estén creadas las clases.
2. Verificar que las clases tengan todos sus atributos o propiedades.
3. Centrarse en la relación, si no existe entonces tenemos que crearla.

***Ejemplos***

1. **Primer ejemplo**

![imagen 11](11.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco bxy;  // No se especifica el nombre del atributo
}

public class Barco {
    public AppCiudad cxz; // No se especifica el nombre del atributo
}
```
2. **Segundo ejemplo**

![imagen 12](12.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco b; // Se especifica el nombre del atributo
}

public class Barco {
    public AppCiudad c; // Se especifica el nombre del atributo
}
```

3. **Tercer ejemplo**

![imagen 13](13.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco b; // Se especifica el nombre del atributo
}

public class Barco {
    // public AppCiudad c;
}
```

4. **Cuarto ejemplo**

![imagen 14](14.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco b; // Se especifica el nombre del atributo
    public Moto m; // Se especifica el nombre del atributo
}

public class Barco {
    // public AppCiudad c;
}

public class Moto{

}
```

5. **Quinto ejemplo**

Atributo con línea:

![imagen 15](15.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco b; // Se especifica el nombre del atributo
    public Moto m; // Se especifica el nombre del atributo
    private Barco oB; // Se especifica el nombre del atributo
}

public class Barco {
    // public AppCiudad c;
}

public class Moto{

}
```

6. **Sexto ejemplo**

Atributo sin línea:

![imagen 16](16.png)

En código:

```java
public class AppCiudad {
    private String nombre;
    public Barco b; // Se especifica el nombre del atributo
    public Moto m; // Se especifica el nombre del atributo
    private Barco oB; // Se especifica el nombre del atributo
}

public class Barco {
    // public AppCiudad c;
}

public class Moto{

}
```

**Diferencia entre una propiedad y una variable**

```java
public class AppCiudad {
    public App a; // propiedad

    iniciar(){
        App a = new App(); // variable
    }
}
```

![imagen 17](17.png)

Cuando se manejan los objetos dentro de un método, se pierden las relaciones iniciales y no las vamos a poder ver hasta que se ejecute el método. Además, todas las variables colocadas dentro de un método son temporales, por lo que desaparecerán cuando se lean otras líneas del código.

En cambio que las propiedades están vigentes durante toda la ejecución del programa, por lo cual se destruirán cuando se termine el mismo.

***Importancia del Constructor***

Para crear o inicializar los objetos que forman parte de las propiedades de una clase y ocuparlos dentro de los métodos de esa misma clase sin perder su información durante el funcionamiento del programa se utiliza el **constructor**.

En código se lo representa de este modo:

```java
public class AppCiudad {
    private String nombre;
    private Vehiculo oVehiculo;
    public Coche oCoche;
    private Barco oBarco;
    public Barco oTitanic;
    // Constructor
    public AppCiudad(String nombre, Vehiculo oVehiculo, Coche oCoche, Barco oBarco, Barco oTitanic) {
        this.nombre = nombre;
        this.oVehiculo = oVehiculo;
        this.oCoche = oCoche;
        this.oBarco = oBarco;
        this.oTitanic = oTitanic;
    }
}
```
Es importante recalcar que el constructor puede tener distintas modificaciones, asimismo puede haber más de un constructor dentro de la clase.

## Clase # 23
    Fecha: 17 de enero del 2024
-------
### <span style="color:pink">Association - Workshop</span>

El objetivo es crear a los animales vertebrados, ya que todos se extinguieron, dentro de un lugar conocido como Morthal. Para ello seguimos los siguientes pasos:

1. Primero utilizamos una clase general, llamada Vertebrado, la cual no se puede instanciar puesto que requerimos de animales.

Tenemos dos opciones, crear una clase abstracta o una interface, como una interface maneja solamente constantes tomamos la decisión de ocupar una clase abstracta.

![imagen 18](18.png)

2. Luego tenemos que clasificar a los animales que vamos a crear en 5 grandes grupos (clases), los cuales van a heredar de la clase Vertebrado: aves, mamíferos, reptiles, anfibios y peces. Estas tampoco se pueden instanciar ya que no es nuestro fin.

Igualmente tenemos dos opciones, crear interfaces o clases abstractas, si utilizamos interfaces podemos mutar a los animales.

![imagen 19](19.png)

Algo que no queremos, por tanto también son clases abstractas.

![imagen 20](20.png)

> Las interfaces son como **poderes** que nosotros podemos otorgar a objetos, en este caso a los animales.

3. En este momento ya podemos crear a los animales (clases), aquellos van a heredar de cualquiera de los 5 grupos planteados y cada uno puede realizar diferentes acciones que lleven a cabo por naturaleza. Por tal motivo, esas acciones son consideradas interfaces.

![imagen 22](22.png)

4. Para crear un animal híbrido o imaginario podemos implementarle varias habilidades como volar, nadar, etc.

![imagen 21](21.png)

5. Necesitamos colocar a los animales dentro de un hábitat, por lo que creamos una clase **orquesta** denominada Morthal.

![imagen 23](23.png)

6. Por último, mediante una clase **App** presentamos todo el escenario o el giro de negocio. Para esto, solamente se necesitan unas pocas líneas de código.

```java
public class App {
    private Morthal m;
    public static void main(String[] args) throws Exception {
        m = new Morthal();
        m.crear();
    }
}
```

## Clase # 24
    Fecha: 18 de enero del 2024
-------
### <span style="color:red">Composición y agregación</span>

**Composición**

La composición es un principio de diseño que permite crear objetos complejos al combinar otros objetos más simples. En lugar de heredar propiedades y comportamientos de una clase, la composición implica crear instancias de otras clases y utilizarlas como componentes dentro de una nueva clase.

Hay objetos que forman parte de algo, estas partes pueden ser internas. Además, son necesarias u obligatorias para que un objeto exista.

En ***código*** la composición obliga a un objeto a crearse con esas propiedades mediante el constructor.

Por ejemplo, un carro necesita de un motor para poder crearse y funcionar correctamente.

![imagen 24](24.png)

**Agregación**

La agregación es otro tipo de relación entre clases que implica la conexión de objetos, pero en este caso, la relación es más débil que la relación de composición. En la agregación, un objeto puede estar compuesto por otros objetos, pero la vida útil de los objetos agregados no depende del objeto que los contiene.

Parecido a la composición, solo que estos objetos pueden formar parte de otro o no (no es obligatorio), consideradas como partes externas o un ***caparazón***.

En este caso el constructor puede estar vacío.

![imagen 25](25.png)

Ambas relaciones son utilizadas para ***inyectar dependencias*** en ciertos objetos.

> Sabemos que existe una composición o agregación si es coherente decir: un objeto **"es parte de"** otro objeto.

**Ejemplos de agregación y composición**

1. **Persona**

- ***Relación de agregación***: Una persona no puede existir sin corazón, dos pulmones y un cerebro, por tanto existe una relación de **composición** de la persona con estos órganos (objetos).

- ***Relación de composición***: Una persona nace sin cabello y mientras crece lo va desarrollando, por ende existe una relación de **agregación** entre la persona con su cabello (objeto).

- ***Relación de alta dependencia***: Una persona necesita alimentarse para poder sobrevivir, por tal razón existe fuerte o **alta dependencia** entre la persona con su alimento.

- ***Relación de baja dependencia***: Una persona puede o no llevar ropa puesta, por consiguiente se observa una débil o **baja dependencia** entre la persona con su ropa.

![imagen 26](26.png)

***Ejemplo de estas relaciones en código***

```java
public class Persona{
    Cerebro c;
    Ropa vestido;
    Alimento a;
    Cabello cab;

    // Constructor
    public Persona (){
        c = new Cerebro(); // Composición
    }

    public Persona(Alimento a){
        this.a = a; // Alta dependencia
    } 
    // Métodos
    public void crecer(){
        cab = new Cabello; // Agregación
    }
}
```

2. **Ave**

- ***Relación de agregación***: Una ave no puede existir sin pico, por lo que existe una relación de **composición** de la ave con el pico.

- ***Relación de composición***: Un ave nace sin plumas y mientras crece las va adquiriendo, por tal motivo existe una relación de **agregación** entre el ave con sus plumas (objeto).

- ***Relación de baja dependencia***: Un ave, en este caso el CorreCamino, puede tomar agua si observa a un Pato en el cielo dirigiéndose a un lago o río, si no la ve no va a pasar nada. De manera que se establece una débil o **baja dependencia** entre el CorreCamino con un Pato.

![imagen 27](27.png)

***Ejemplo de la relación de baja dependencia en código***

```java
public class CorreCamino{
    // Métodos
    public void beberAgua(Pato p){
        if (p == null){
            // no toma agua
        }
        else{
            // sigue a p (Pato)
        }
    }
}
```
**Ejemplo de uso de las interfaces**

Si existe demasiada ***sobrecarga*** sobre un método, se puede mejorar el código con una interface. De la siguiente manera:

![imagen 28](28.png)

Tenemos un Pato que tiene una relación de baja dependencia con ciertos alimentos, el CorreCamino puede comer varias cosas y para cada una de ellas tendríamos sobrecargar el método comer. Por otra parte, no hay nada que le impida comer cosas que no son para un CorreCamino en la vida real, como una PoliBurguer y eso no tiene mucho sentido. 

En consecuencia, se tiene que mejorar el código y esto lo podemos lograr mediante una interface, como se muestra a continuación:

![imagen 29](29.png)

En este caso, CorreCamino implementa IComidaCorreCamino para determinar si puede comer o no cierta comida. De tal forma que, logramos que el CorreCamino no pueda comer cualquier alimento (como la PoliBurguer), evitamos la sobrecarga del método comer y menoramos las líneas de código, haciéndolo más simple y limpio.

## Clase # 25
    Fecha: 19 de enero del 2024
-------
### <span style="color:purple">Asociación y archivos</span>

**Asociación**

- **Herencia - interface - abstracción:** Representan organización, jerarquía, clasificación.
- **Asociación:** Se utiliza para establecer relaciones.

Esto se realiza cuando queremos que un objeto pertenezca y tenga ciertas cualidades o características.

![imagen 30](30.png)

En cualquier programa siempre buscamos baja dependencia, ya que genera flexibilidad para que este no se cuelgue o bloquee si se modifica o actualiza en cualquier momento.

![imagen 31](31.png)

En este caso para que la clase León no tenga demasiada sobrecarga en su método comer, se procede a clasificar su comida mediante el uso de una ***interface***.

![imagen 32](32.png)

Con ICarne conseguimos clasificar la comida del León y la interface tiene un método digerir puesto que existe una diferencia entre el tiempo o la facilidad en la que el León pueda comer cada animal; es decir, no es lo mismo que el León coma un Pato a que coma una Tortuga.

```java
public class Morthal{
    private Leon l;
    l = new Leon();

    l.comer(Hierba h); X  // Como la clase Hierba no implementa ICarne, el programa no le va a permitir comer al Leon Hierba

    l.comer(Pato p); // Leon puede comerse a un Pato ya que Pato implementa ICarne
}
```

Como León puede comer una variedad de carne en su día a día, podemos utilizar un ***ArrayList*** de tipo ***ICarne*** y mediante un forache presentar esta acción sin tener que llamar al método comer varias veces dentro del código para cada alimento que sea capaz de comer Leon.

```java
public class Morthal{
    Leon l = new Leon();
    Hierba h = new Hierba();
    Pato p = new Pato();
    CorreCamino c = new CorreCamino();
    Tortuga t = new Tortuga();

    // Sin ArrayList
    l.comer(p);
    l.comer(c);
    l.comer(t);
    l.comer(h); X // Hierba no implementa ICarne, por lo que Leon no puede comer ese tipo de alimento

    // Con ArrayList
    ArrayList<ICarne> lst = new ArrayList<>(); 
    lst.add(new Pato());
    lst.add(new CorreCamino());
    lst.add(new Tortuga());

    for (ICarne carne: lst)  
        l.comer(carne);
}
```

**Archivos**

Los archivos desempeñan un papel esencial en la programación al proporcionar un medio para almacenar, recuperar y manipular datos de manera persistente, lo que resulta crucial para el funcionamiento efectivo de muchas aplicaciones y sistemas.

***Archivos .csv y .txt***

La principal diferencia radica en la estructura y el propósito de los datos que contienen. Los archivos CSV son más adecuados para representar datos tabulares, mientras que los archivos de texto pueden contener datos de cualquier formato.

***Manejadores de archivos***

Nos permiten manejar un archivo, es decir crearlo o eliminarlo.

- **FileReader:** Es utilizado para leer un archivo.
- **BufferedReader:** Conocido como *** tubería***, es utilizado para hacer los flujos de lectura de un archivo, es decir nos permite entrar al archivo y leer el flujo de información o los caracteres que se encuentren ahí.

***Introducción a try-catch***

Son bloques de código que proporcionan un mecanismo para manejar excepciones de manera controlada, evitando que el programa se bloquee o se cierre abruptamente en caso de un error. Permite que el programa continúe su ejecución normalmente o realice acciones específicas de recuperación después de manejar la excepción. Esto es especialmente útil en situaciones donde no se puede prever o evitar completamente la posibilidad de errores durante la ejecución del programa.

***Código whatever para leer archivos***

```java
public ArrayList <Persona> getFile(){
    final String SEPARADOR = ";";
    final String ARCHIVO = "dataFile\\personas.csv";
    ArrayList<Persona> personas = new ArrayList<>();
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;

    try{
        fileReader = new FileReader (ARCHIVO);
        bufferedReader = new BufferedReader (fileReader);
        String linea;
        while ((linea = bufferedReader.readLine() != null)){
            String[] personaComoArreglo = linea.split(SEPARADOR);
            personas.add(new Persona(   personaComoArreglo[0],
                                        personaComoArreglo[1],
                                        Integer.valueOf(personaComoArreglo[2])));
        }
    } catch (IOException e){
        System.out.println("Excepcion leyendo archivo: " + e.getMessage());
    } finally {
        try {
            if (fileReader != null)
                fileReader.close();
            if (bufferedReader != null)
                bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Excepcion cerrando: " + e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    return personas;
}
```

***Código pro de patmic para leer archivos***

```java
public ArrayList <Persona> getPersonaFile(){
    ArrayList<Persona> personas = new ArrayList<>();
    final String ARCHIVO   = "dataFile\\personas.csv",
                 SEPARADOR = ";";
    try{
        List<String> allLines = Files.readAllLines(Paths.get(ARCHIVO));
        for (String line : allLines){
            String[] personaFile = line.split(SEPARADOR);
            personas.add(new Persona(   personaFile[0],
                                        personaFile[1],
                                        Integer.valueOf(personaFile[2])));
        }
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return personas;
}
```

Para presentar la lista de personas se puede utilizar un for o un foreach.

> Como la información de la clase está siendo tomada desde una base (un archivo) y colocada directamente en un constructor, no es necesario que las propiedades tengan el método setter().

***Política de JAVA POO***

Una de ellas menciona que todos los objetos deben poderse convertir a String para hacer una especie de testeo y comprobar que todos sus atributos estén llenos. Ejemplo de una clase Persona:

```java
@Override
public String toString () {
    return "Nombre: " + this.nombre + " ,edad: " + this.edad + " ,direccion: " + this.direccion;
}
```

Por tanto, todas las clases deben tener un toString.

Como toda la información está en modo texto, en modo plano se utiliza un **@Override** para poder sobreescribir a la clase y decir que salga esta información cuando se la llame.

## Clase # 26
    Fecha: 23 de enero del 2024
-------
### <span style="color:cyan">Interfaz - asociación</span>

Una **interfaz** o una **herencia** se utiliza para determinar generalidades, lo que nos permite agrupar distintas cosas.

Una acción especial se la puede definir a través de la interfaz, por lo general, o mediante un método por parte de la herencia.

El UML proporciona varias formas de mostrar la implementación de la interfaz, como se observa a continuación:

![imagen 33](33.png)

***Clock1*** implementa y proporciona la interfaz ***Timer***.

![imagen 34](34.png)

***Window*** usa la interfaz ***Timer***, es decir requiere una interface.

![imagen 35](35.png)

La notación **lollipop** indica que ***Clock3*** implementa y proporciona la interfaz ***Timer***, mientras que la notación **socket** indica que ***Window3*** tiene una dependencia con la interfaz ***Timer*** cuando eso colabora con un ***Clock3***.

![imagen 36](36.png)

La línea de dependencia indica que ***Window2*** tiene una dependencia con la interfaz ***Timer*** cuando eso colabora con un ***Clock2***.

Para relacionar un objeto que contenga una interfaz con otro objeto, también existe la cardinalidad para representar este comportamiento.

Existen los siguientes tipos de relación con cardinalidad:

- Bidireccional con multiplicidad 0..1 o 1
- Direccional con multiplicidad 0..1 o 1
- Bidireccional con multiplicidad *
- Múltiples líneas de relación
- Relación de recursividad

> Cuando se ocupa * en las relaciones, significa que debemos utilizar listas.

![imagen 37](37.png)

Esta imagen quiere decir que se tiene una ***Entidad1*** que implementa una interfaz o un comportamiento y la ***Entidad2*** le dice "yo te necesito, pero necesito que hagas ciertas cosas", esto para que ambas estén en común acuerdo.

Hay dos maneras para representar la implementación (interfaz) en el UML:

![imagen 38](38.png)

Y dos maneras para representar el objeto que tiene que utilizar esa implementación:

![imagen 39](39.png)

En código se vería de la siguiente forma:

```java
public class Pintor {
    public void colorear (IColoreable objeto, Color color){
        objeto.cambiaColor(color);
    }
}
```

Y en el código principal (App) tenemos lo siguiente:

```java
public class App {
    public static void main(String[] args) throws Exception {
        Persona persona = new Persona();
        Automovil automovil = new Automovil();
        Animal animal = new Animal();
        Color rojo = new Color();
        Pintor pintor = new Pintor ();

        pintor.colorear (persona, rojo);
        pintor.colorear (animal, rojo);
        pintor.colorear (automovil, rojo);
    }
}
```

**Herencia múltiple**

Java no permite la herencia múltiple de clases directamente, y esto se debe a consideraciones de diseño y para evitar problemas asociados con la ambigüedad y la complejidad que puede surgir. 

En lugar de la herencia múltiple de clases, Java utiliza una aproximación basada en ***interfaces*** para abordar algunos de los problemas asociados. Las interfaces permiten que una clase implemente múltiples interfaces, proporcionando así una forma de lograr ciertos aspectos de la herencia múltiple sin los problemas potenciales.

***Ejemplo de herencia múltiple***

![imagen 40](40.png)

***Ejemplo de herencia múltiple en JAVA POO***

![imagen 41](41.png)

**Ejemplo**

Se requiere crear un programador full stack, que sepa base de datos, programación orientada a objetos, programación estructurada e interfaces gráficas.

***Use Case***

![imagen 42](42.png)

***Diagrama de clases***

![imagen 43](43.png)

***En código***

Desde App:

```java
public class App {
    public static void main(String[] args) throws Exception {
        DevFullStack dev = new DevFullStack("Mateo","Simbana",19);
        ExpertoUIUX eUIUX = new ExpertoUIUX();
        ExpertoBaseDato eBD = new ExpertoBaseDato();
        ExpertoProgramacionEstructurada ePE = new ExpertoProgramacionEstructurada();
        ExpertoProgramacionOrientadaObjeto ePOO = new ExpertoProgramacionOrientadaObjeto();

        ePOO.ensenar(dev);
        ePE.ensenar(dev);
        eBD.ensenar(dev);
        eUIUX.ensenar(dev);
    }
}
```

## Clase # 27
    Fecha: 24 de enero del 2024
-------
### <span style="color:brown">Práctica</span>

Interfaces es lo que yo voy a pasar de un lado a otro para no generar errores en los programas y que el código se vea más simple.

Continuando con el ejercicio anterior, se solicita guardar una marca para saber lo que ha aprendido Developer Full Stack.

Para ello tenemos 4 métodos diferentes:

1. **Primer escenario**

```java
public class DevFullStack extends Persona implements IAlumnoProgramacionEstructurada, IAlumnoProgramacionOrientadaObjeto, IAlumnoUIUX, IAlumnoBaseDato {

    private String conocimientoAdquirido;

    public DevFullStack(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        conocimientoAdquirido = "";
    }

    @Override
    public String aprenderDisenoUIUX() {
        conocimientoAdquirido += "Diseno UIUX";
        return "Aprendiendo Diseno UIUX";
    }

    @Override
    public String aprenderDisenoProgramacionOrientadaObjeto() {
        conocimientoAdquirido += "Diseno Programacion Orientada Objeto";
        return "Aprendiendo Diseno Programacion Orientada Objeto";
    }

    @Override
    public String aprenderDisenoProgramacionEstructurada() {
        conocimientoAdquirido += "Diseno Programacion Estructurada";
        return "Aprendiendo Diseno Programacion Estructurada";
    }

    @Override
    public String aprenderDisenoBaseDato() {
        conocimientoAdquirido += "Diseno Base Dato";
        return "Aprendiendo Diseno Base Dato";
    }

    public void aprendi(){
        System.out.println("El desarrollador ha aprendido");
        System.out.println(conocimientoAdquirido);
    }
}
```
Esta no es una manera óptima de resolver el problema puesto que solamente tiene que aparecer una vez la materia que ya aprendió el Developer.

> El constructor está diseñado para inicializar las propiedades o atributos de una clase u otorgarles un valor inicial, de modo que podamos controlar errores que se presenten en la ejecución del programa.

2. **Segundo escenario**

Presenta un código más elegante, sin embargo, sigue teniendo el mismo problema del primer caso.

```java
public class DevFullStack extends Persona implements IAlumnoProgramacionEstructurada, IAlumnoProgramacionOrientadaObjeto, IAlumnoUIUX, IAlumnoBaseDato {

    private ArrayList<String> conocimientos;

    public DevFullStack(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        conocimientos = new ArrayList<>();
    }

    @Override
    public String aprenderDisenoUIUX() {
        conocimientos.add("Diseno UIUX");
        return "Aprendiendo Diseno UIUX";
    }

    @Override
    public String aprenderDisenoProgramacionOrientadaObjeto() {
        conocimientos.add("Diseno Programacion Orientada Objeto, ");
        return "Aprendiendo Diseno Programacion Orientada Objeto";
    }

    @Override
    public String aprenderDisenoProgramacionEstructurada() {
        conocimientos.add("Diseno Programacion Estructurada, ");
        return "Aprendiendo Diseno Programacion Estructurada";
    }

    @Override
    public String aprenderDisenoBaseDato() {
        conocimientos.add("Diseno Base Dato, ");
        return "Aprendiendo Diseno Base Dato";
    }

    public void aprendi(){
        System.out.println("El desarrollador ha aprendido");
        for (String conocimiento : conocimientos) {
            System.out.print(conocimiento);
        }
    }
}
```

3. **Tercer Escenario**

```java
public class DevFullStack extends Persona implements IAlumnoProgramacionEstructurada, IAlumnoProgramacionOrientadaObjeto, IAlumnoUIUX, IAlumnoBaseDato {

    private ArrayList<String> conocimientos;

    public DevFullStack(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        conocimientos = new ArrayList<>();
    }

    @Override
    public String aprenderDisenoUIUX() {
        agregarAprendizaje("Diseno UIUX");
        return "Aprendiendo Diseno UIUX";
    }

    @Override
    public String aprenderDisenoProgramacionOrientadaObjeto() {
        agregarAprendizaje("Diseno Programacion Orientada Objeto");
        return "Aprendiendo Diseno Programacion Orientada Objeto";
    }

    @Override
    public String aprenderDisenoProgramacionEstructurada() {
        agregarAprendizaje("Diseno Programacion Estructurada");
        return "Aprendiendo Diseno Programacion Estructurada";
    }

    @Override
    public String aprenderDisenoBaseDato() {
        agregarAprendizaje("Diseno Base de Dato");
        return "Aprendiendo Diseno Base Dato";
    }

    public void aprendi(){
        System.out.println("El desarrollador ha aprendido");
        for (String conocimiento : conocimientos) {
            System.out.print(conocimiento + ", ");
        }
    }

    private void agregarAprendizaje(String conocimiento){
        boolean bandera = false;
        for (String c : conocimientos) {
            if (c.equals(conocimiento)){
                bandera = true;
            }
        }
        if (!bandera)
            conocimientos.add(conocimiento);
    }
}
```

Puede ser útil ocupar un método para una lista pequeña, ya que el programa no va a demorar tanto en reconocer si el Developer ya adquirió el conocimiento de cierta materia y no se está repitiendo. No obstante, para una lista extensa no es eficiente solventar el problema de esta manera debido a la cantidad de líneas que debe recorrer el método para identificar que no exista ninguna repetición de la materia aprendida. 

Una técnica que permita hacer esto de forma más rápida y efectiva es utilizando un ***break*** o por medio de un ***HashTable*** o ***HashMap***.

**HashTable y HashMap**

Estos términos se refieren a estructuras de datos que permiten almacenar y recuperar elementos utilizando una clave. Aunque ambos tienen funcionalidades similares, existen algunas diferencias entre ellos.

Ambos tienen un key y un value. Esto significa que yo puedo definir una marca y un valor a esa marca. Además, evita que una marca sea reemplazada si ya está cargada, por lo que nos ayuda a proteger información.

***HashTable***

- **Sincronización:** A diferencia de HashMap, HashTable es sincronizado. Esto significa que es seguro para operaciones en entornos multi-hilo, pero también puede tener un rendimiento inferior en comparación con HashMap en situaciones donde la sincronización no es necesaria.

- **Nulls:** Tanto las claves como los valores en un HashTable no pueden ser nulos. Intentar agregar o recuperar valores nulos resultará en una excepción NullPointerException.

- **Herencia de la clase Dictionary:** HashTable es una subclase de la clase más antigua Dictionary.

***HashMap***

- **No Sincronizado:** A diferencia de HashTable, HashMap no es sincronizado por defecto. Esto significa que, en general, es más eficiente en situaciones donde la sincronización no es un problema. Sin embargo, si se requiere sincronización, se puede lograr mediante la utilización de Collections.synchronizedMap().

- **Permite Nulos:** A diferencia de HashTable, HashMap permite claves y valores nulos. Se pueden tener claves y valores nulos en un HashMap.

> **HashTable** como hace una validación para que no se repita la información es más lento, mientras que **HashMap** también valida pero como nos permite ingresar nulos puede tener alguna ventaja.

4. **Escenario ideal**

```java
public class DevFullStack extends Persona implements IAlumnoProgramacionEstructurada, IAlumnoProgramacionOrientadaObjeto, IAlumnoUIUX, IAlumnoBaseDato {

    Hashtable<Integer, String> aprendizajes;

    public DevFullStack(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        aprendizajes = new Hashtable<>();
    }

    @Override
    public String aprenderDisenoUIUX() {
        aprendizajes.put(1,"Diseno UIUX");
        return "Aprendiendo Diseno UIUX";
    }

    @Override
    public String aprenderDisenoProgramacionOrientadaObjeto() {
        aprendizajes.put(2,"Diseno Programacion Orientada Objeto");
        return "Aprendiendo Diseno Programacion Orientada Objeto";
    }

    @Override
    public String aprenderDisenoProgramacionEstructurada() {
        aprendizajes.put(3,"Diseno Programacion Estructurada");
        return "Aprendiendo Diseno Programacion Estructurada";
    }

    @Override
    public String aprenderDisenoBaseDato() {
        aprendizajes.put(4,"Programacion Base Dato");
        return "Aprendiendo Diseno Base Dato";
    }
    // Programación Lambda
    public void aprendi(){
        System.out.println("El desarrollador ha aprendido");
        aprendizajes.forEach((k,v)->{
            System.out.print(v + ", ");
        });
    }
}
```

Como un HasTable guarda dos valores a la vez no se puede ocupar un ***foreach*** debido a que este solo puede presentar un valor en cada corrida, no dos. Por tal motivo, utilizamos **programación lambda**.

**Programación Lambda**

Es una forma de programación rápida, la cual permite un código más conciso y expresivo.

Java ha sido un lenguaje que siempre daba las iniciativas en normativas o formas de ver nuevas estructuras para programar, por ejemplo las listas, que son un ***generic***.

Un ***generic*** facilita tener una lista de cualquier cosa T (String, Integer, Objeto). Luego C# y otros lenguajes de programación fueron implementando el tema de generic.

Después de un tiempo, apareció otro modo para acortar la programación a través de la programación lambda. Esta fue implementada directamente por C# y en las últimas versiones de Java ya la pusieron en funcionamiento.

## Clase # 28
    Fecha: 26 de enero del 2024
-------
### <span style="color:grey"></span>



## Clase # 29
    Fecha:  de enero del 2024
-------
### <span style="color:purple"></span>

## Clase # 30
    Fecha:  de enero del 2024
-------
### <span style="color:purple"></span>