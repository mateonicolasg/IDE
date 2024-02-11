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
    Fecha: 30 de enero del 2024
-------
### <span style="color:grey">Revisión prueba</span>

***Prototipado Exobot***

![imagen 48](48.png)

**Package**

Un "package" (paquete) es una forma de organizar y estructurar clases e interfaces relacionadas en un conjunto lógico. Los paquetes proporcionan un mecanismo para encapsular clases, interfaces, enumeraciones y subpaquetes, lo que ayuda a evitar conflictos de nombres y facilita la gestión y mantenimiento del código.

Cada vez que creo un objeto, se crean memorias separadas.

```java
public class IABOT {
    private String nombre;
    
    public IABOT(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

En el siguiente ejemplo, hay tres espacios de memoria diferentes, uno para cada objeto creado.

```java
public class App {
    public static void main(String[] args) throws Exception {
        IABOT ia1 = new IABOT("Pepe");
        IABOT ia2 = new IABOT("Juan");
        IABOT ia3 = new IABOT("Ana");
        System.out.println(ia1.getNombre());
        System.out.println(ia2.getNombre());
        System.out.println(ia3.getNombre());
    }
}
```

Para que se cree un objeto una sola vez se utiliza un constructor privado.

Si es que existe nulo la primera vez, se crea el espacio de memoria; las siguientes veces devuelve lo que ya se tiene creado en memoria.

```java
public class IABOT {
    private static String nombre;
    private static IABOT instancia;

    // Constructor privado
    private IABOT(){}

    public static IABOT getInstancia(String nombre){
        if (instancia == null){
            instancia = new IABOT();
            IABOT.nombre = nombre;
        }
        return instancia;
    }
```
> ***this.nombre*** se usa cuando nos referirnos a espacios dinámicos de memoria. Como en el ejercicio se necesita de un espacio común, se utilizan propiedades estáticas.

Para congelar el espacio de memoria se utiliza ***static***, es decir que el objeto solo se va a crear una sola vez y nadie podrá modificarlo.

Los getter y setter para propiedades estáticas también son estáticos.

> La ***interface*** obliga a que todo sea estático.

```java
public class App {
    public static void main(String[] args) throws Exception {
        IABOT ia1 = IABOT.getInstancia("Pepe");
        IABOT ia2 = IABOT.getInstancia("Ana"); 
        IABOT ia3 = IABOT.getInstancia("Juan"); 

        System.out.println(ia1.getNombre());
        System.out.println(ia2.getNombre());
        System.out.println(ia3.getNombre());
    }
}
```

Los ***espacios de memoria estáticos*** y ***espacios de memoria dinámicos*** son conceptos que se refieren a cómo se asigna y gestiona la memoria en un programa. 

**Espacios de memoria dinámicos**

Se refieren a áreas de memoria que se asignan y liberan en tiempo de ejecución según sea necesario. La memoria dinámica se gestiona a través de funciones o constructores específicos para la asignación y liberación de memoria.

**Espacios de memoria estáticos**

Se refieren a áreas de memoria que se asignan en tiempo de compilación y tienen un tamaño fijo durante la ejecución del programa. La memoria estática suele utilizarse para almacenar variables globales, variables estáticas y constantes.

![imagen 44](44.png)

Para que cualquier variable de un mismo tipo se enganche a un mismo espacio de memoria, se emplea el patrón de diseño ***Singleton***.

***Patrón Singleton***

Es un patrón de diseño creacional que se utiliza para garantizar que una clase tenga una sola instancia y proporciona un punto de acceso global a esa instancia. Este patrón es útil cuando se desea controlar estrictamente la creación de instancias de una clase y asegurarse de que solo exista una única instancia en todo el programa. 

Como se requieren crear Exobots a partir de un IABOT, se utiliza la ***herencia***.

![imagen 45](45.png)

Cuando se quiere construir el espacio h1, resulta que es hijo de P, por lo tanto debe construir a P. En otras palabras, cada que se quiera construir otro objeto de tipo H, este va a tratar de construir otro espacio de memoria para sí mismo y para su papá.

En código, esto se demuestra de la siguiente manera:

```java
public class Padre {
    private String nombre;

    public Padre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}

public class Hijo extends Padre {
    public Hijo(String nombre){
        super(nombre);
    }
}
```

Donde cada hijo tiene un padre diferente:

```java
public class App {
    public static void main(String[] args) throws Exception {
        Hijo h1 = new Hijo ("Pepe");
        Hijo h2 = new Hijo ("Juan");
        Hijo h3 = new Hijo ("Mario");

        System.out.println(h1.getNombre());
        System.out.println(h2.getNombre());
        System.out.println(h3.getNombre());
    }
}
```

Para el diseño del ejercicio, esto se debe ver de la siguiente manera.

![imagen 46](46.png)

Ejemplificando en un diagrama de clases, se vería de la siguiente forma:

![imagen 47](47.png)

Se utiliza protected (# o ~), lo que significa que ese método solo está visible para el proceso de herencia, cumpliendo que no se pueda colocar un ***new*** como paramámetro pero que siempre se permita crear nuevos Exobot.

Si se envía como parámetro un nulo (el Exoesqueleto sin Padre) debe quebrarse el código e impedir que se pueda realizar eso mediante un if.

A continuación, se presenta el ejemplo en código de este caso:

```java
public class IABOT {
    private IABOT(){}

    protected IABOT(IABOT ia) {
        if(ia != null)
            instancia = ia; 
    }
}

public class Exobot extends IABOT{
    public Exobot (IABOT ia){
        super(ia);
    }
}
```

```java
public static void main(String[] args) throws Exception {        
    IABOT ia1 = IABOT.getInstancia("Pepe");
    IABOT ia2 = IABOT.getInstancia("Ana"); 
    IABOT ia3 = IABOT.getInstancia("Juan"); 

    Exobot e1 = new Exobot(ia1);
    Exobot e2 = new Exobot(ia2);
    Exobot e3 = new Exobot(ia3);

    System.out.println(e1.getNombre());
    System.out.println(e2.getNombre());
    System.out.println(e3.getNombre());
}
}
```

Para la resolución del ejercicio todavía no está resuelto correctamente esta parte, puesto que se puede crear un Exobot con un Padre que apunte a otro espacio de memoria que no sea la de IABOT, de la siguiente manera:

```java
public static void main(String[] args) throws Exception {        
    IABOT ia1 = IABOT.getInstancia("Pepe");
    IABOT ia2 = IABOT.getInstancia("Ana"); 
    IABOT ia3 = IABOT.getInstancia("Juan"); 

    Exobot e1 = new Exobot(ia1);
    Exobot e2 = new Exobot(ia2);
    Exobot e3 = new Exobot(IABOT.getInstancia("tu mami Ucrania"));

    System.out.println(e1.getNombre());
    System.out.println(e2.getNombre());
    System.out.println(e3.getNombre());
}
```

## Clase # 29
    Fecha: 31 de enero del 2024
-------
### <span style="color:purple">Revisión prueba - parte 2</span>

Una condición del problema es que el Exobot tenga extremidades al igual que el humano (brazos, piernas, tronco y cabeza).

Para garantizar que tengan esas estructuras y que luego puedan hacer un match con un soldado, vamos a utilizar una interfaz.

> Las ***interfaces*** están diseñadas para generar comportamientos, más no estructuras. Sin embargo, las actualizaciones permiten que las interfaces tengan atributos, los cuales son estáticos (obligatorios) y constantes.

Validamos que tenga todas las partes del cuerpo a partir del siguiente código:

```java
public interface IHumanoExtremidad {
    public Boolean brazoIzquierdo   = true; 
    public Boolean brazoDerecho     = true;
    public Boolean piernaIzquierda  = true;
    public Boolean piernaDerecha    = true;
    public Boolean cabeza           = true;
    public Boolean tronco           = true;
}
```

En este caso, la clase Soldado implementa esta interface, lo mismo se debe hacer con Exobot.

```java
public class Soldado extends Humano implements IHumanoExtremidad {

    public Soldado(String nombre) {
        super(nombre);

        if (Soldado.brazoDerecho)
            System.out.println("Brazo derecho");
            
        if (Soldado.brazoIzquierdo)
            System.out.println("Brazo izquierdo");
        
        if (Soldado.piernaDerecha)
            System.out.println("Pierna derecha");
        
        if (Soldado.piernaIzquierda)
            System.out.println("Pierna izquierda");
        
        if (Soldado.cabeza)
            System.out.println("Cabeza");
        
        if (Soldado.tronco)
            System.out.println("Tronco");
    }
    
}
```

Para observar su funcionamiento realizamos un testing en App.

No es recomendable crear estas partes del cuerpo mediante variables para cada clase puesto que nadie puede garantizar que en realidad el objeto las posea.

Por otra parte, existen expertos en inglés y español, un mecatrónico, soldados; por ello creamos una clase Humano, de manera que hereden alguna cosa en común (como el nombre).

![imagen 49](49.png)

De igual manera, el problema menciona que en cada brazo podemos colocarle un arma al Exobot, en la mano izquieda una metralleta o una bazuca y en la mano izquierda un lanza fuegos o un láser, donde cada uno puede cargar una o ningún arma en cada brazo dependiendo de las habilidades que posea el Soldado.

El soldado va a adquirir alguna habilidad dependiendo de su suerte (lo que le dé Diosito al momento de crearse) a través de un algoritmo random.

```java
private boolean getHabilidadRandom(){
    int bias = 50;
    return (Math.random() * 100 < bias);
}
```

Este random genera números entre 0 y 1, donde existe un 50%  de que devuelva true o false. 

Registramos las habilidades del Soldado dentro del constructor.

```java
public Soldado(String nombre) {
    super(nombre);

    if (Soldado.brazoDerecho){
        setHabilidadBrazoDerecho(getHabilidadRandom());
        System.out.println("Brazo derecho: " + getHabilidadBrazoDerecho());
    }
        
    if (Soldado.brazoIzquierdo){
        setHabilidadBrazoIzquierdo(getHabilidadRandom());
        System.out.println("Brazo derecho: " + getHabilidadBrazoIzquierdo());
    }
    if (Soldado.piernaDerecha)
        System.out.println("Pierna derecha");
    
    if (Soldado.piernaIzquierda)
        System.out.println("Pierna izquierda");
    
    if (Soldado.cabeza)
        System.out.println("Cabeza");
    
    if (Soldado.tronco)
        System.out.println("Tronco");
}

public Boolean getHabilidadBrazoIzquierdo() {
    return habilidadBrazoIzquierdo;
}
```

> Si el constructor tiene restricciones (parámetros) y no existen getter y setter para cada atributo, entonces debemos colocar estos cambios obligatoriamente dentro del diagrama de clases.

Además, el Exobot tiene la habilidad de aprender inglés y español, IABOT no le transmite estos conocimientos, solo le transmite la habilidad de que él pueda aprender estos idiomas. Por lo que Exobot tiene que escuchar a los expertos y de esta manera, el traje puede traducir estos idiomas y dar a entender al Soldado ruso lo que le quieren decir otras personas. 

En otras palabras, como esa habilidad se adquiere bajo un entrenamiento van a venir técnicos de inglés y español, le van a hablar al Exabot y el tiene una interfaz de aprendizaje.

Volviendo con el Exobot, primero debe tener una matriz para crearse. Segundo, solo puede integrar un arma en cada brazo, si utilizamos un set para cada arma existiría un problema puesto que el Exobot podría quedarse sin armas o podrían obligarle a tener dos armas en un solo brazo, que le es imposible. 

Para resolver esto, vamos a hacer uso de la generalización. Como a la final debemos ponerle un arma al brazo puedo crear un método sobrecargado que se llame setArma y le pase la metralleta o la bazuca, pero da el mismo problema que se mencionó anteriormente, lo ideal es que exista un solo método que se llame setArma con un parámetro que reciba cualquiera de las dos armas. Para hacer esto sin sobrecarga utilizamos una interfaz o una clase abstracta.

![imagen 50](50.png)

En este caso, se usará una clase abstracta para las armas del brazo izquierdo:

```java
public abstract class ArmaIzquierda {
    private String tipo;

    public ArmaIzquierda(String tipo){
        this.tipo = tipo;
        System.out.println(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void disparar(int cantidadBalas){
        for (int i = 0; i < cantidadBalas; i++) {
            System.out.println(" * ");
        }
    }
}
```

Para que no exista un problema semántico y que cuando otra persona quiera modificar el código entienda lo que está pasando, es recomendable nombrar las clases por secciones, es decir utilizar prefijos para agruparlas, por ejemplo ArmaBazuca y ArmaMetralleta heredan de ArmaIzquierda.

```java
public class ArmaBazuca extends ArmaIzquierda{

    public ArmaBazuca(String tipo) {
        super(tipo);
    }
    
}

public class ArmaMetralleta extends ArmaIzquierda {

    public ArmaMetralleta(String tipo) {
        super(tipo);
    }
    
}
```

## Clase # 30
    Fecha: 1 de febrero del 2024
-------
### <span style="color:green">Revisión prueba - parte 3</span>

> Sin necesidad de crear un paquete, con gramática también puedo agrupar clases.

Para que funcione el **o** se necesita de una clase abstracta o una interfaz, la cual se convierte en un **bypass** o un filtro para luego ingresar a otras clases.

```java
public class BrazoIzquierdo {

    private ArmaIzquierda arma;

    public void setArma(ArmaIzquierda arma){
        this.arma = arma;
    }
}
```
De esta manera garantizamos que el brazo izquierdo solo tenga un arma izquierda y no una mezcla de armas izquierdas o derechas.

> Si en el digrama de clases solo se coloca el tipo de variable, quiere decir que podemos ponerle cualquier nombre a esa variable.

Para validar esto, nos dirigimos a Exobot.

Primero verificamos que está activo su brazo izquierdo, como implementa las extremidades del Humano ya lo tiene; luego vamos a realizar un código que indique lo que puede hacer con este brazo:

```java
public class Exobot extends IABOT implements IHumanoExtremidad{

    private FuentePoder eFuentePoder;
    private TurboReactor eTurboReactor;
    private BrazoDerecho eBrazoDerecho;
    private BrazoIzquierdo eBrazoIzquierdo;
    private Pierna ePiernaDerecha;
    private Pierna ePiernaIzquierda;

    public Exobot (IABOT iaBot){
        super(iaBot);
        eTurboReactor = new TurboReactor();
        eBrazoDerecho = new BrazoDerecho();
        ePiernaDerecha = new Pierna();
        ePiernaIzquierda = new Pierna();

        if(Exobot.brazoDerecho)
            System.out.println("Brazo derecho");
        if(Exobot.brazoIzquierdo){
            eBrazoIzquierdo = new  BrazoIzquierdo();
            boolean soldadoHabilidadBrazoIzquierdo = false;

            if(soldadoHabilidadBrazoIzquierdo)
                eBrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61"));
            else
                eBrazoIzquierdo.setArma(new ArmaBazuca("Bazuca Antitanque"));
        }

    }
}

```

También podemos mandar a disparar el arma según la cantidad de balas que tenga mediante la siguiente línea de código:

```java
eBrazoIzquierdo.getArma().disparar(30);
```

Si en algún momento yo quiero saber que arma se colocó en el brazo izquierdo, empleamos el método ***toString*** puesto que todos los objetos creados podrían ir a parar a un toString.

Cada vez que creamos un objeto, Java le da como un identificado único para que él al interno no se confunda y no los vaya a sobreescribir o a pisar un objeto con otro objeto, por tal motivo aparecen números extraños cuando se llama al toString que se tenía por defecto.

> Si no se coloca un método toString dentro de la clase, por defecto  el compilador java genera uno para nosotros.

Para que sea más expresivo este método se realiza un ***override***.

```java
public abstract class ArmaIzquierda {
    @Override
    public String toString(){
        return  "Esto es una "
                +this.getClass().getName()+" de tipo: "
                +this.getTipo();
    }
}

```

> El **toString** se utiliza generalmente para realizar cualquier tipo de Testing.

Cada vez que creamos una variable apunta a algo, eso significa que en algún momento a través de la variable podemos ingresar a la información que estamos apuntando.

```java
eBrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61"));

eBrazoIzquierdo.setArma(new ArmaBazuca("Bazuca Antitanque"));
```

Con estas líneas podemos perder las referencias, es decir que le damos el arma al Exobot porque no me interesa después saber por el arma. En consecuencia, si en algún momento se necesita saber el estado del arma no hay forma de acceder a ella puesto que no existe una variable de acceso.

Entonces al realizarlo de esa manera, nos ahorramos líneas de código pero si a futuro se necesita acceder a esas referencias debemos analizar donde quedaron contenidas, lo que puede resultar muy complicado algunas veces; en este caso el arma queda contenida dentro del brazo izquierdo, por lo que de alguna forma la puedo recuperar.

**Beneficio de la clase abstracta**

La clase abstracta me permite hacer generalizaciones, es decir que puedo crear un arma tipo ArmaIzquierda (la cual es abstracta) mediante clases que la heredan (ArmaMetralleta y ArmaBazuca).  

```java
ArmaIzquierda m = new ArmaMetralleta("Metralleta");
ArmaIzquierda  b = new ArmaBazuca("Bazuca");
eBrazoIzquierdo.setArma(m);
eBrazoIzquierdo.setArma(b);
```

Esto se realizó de manera más abstracta en el constructor del Exobot. El mecanismo aplicado es el más óptimo, ya que es recomendable no crear variables u objetos que no vamos a utilizar, evitando un gasto de memoria innecesario.

> Cuando se tiene una buena estructura del programa, si se requiere hacer algún cambio a futuro no habrá dificultad e inclusive nos ahorraremos tiempo.

- **Sonar:** Es una herramienta a la cual podemos pasarle un código y esta detecta duplicados, errores en el estilo del código, entre otras cosas.

- **Profile:** Es una configuración que se le puede poner a VS Code para validar que el código esté limpio y cumpla con todos los requerimientos.

> Documentar es una buena práctica de programación, comentar el código no lo es, al menos que sea necesario para una parte que sea compleja de entender.

```java
/*
 * <b> Exabot </b> exoesqueleto cyberbot
 * @param iaBot
*/
public Exobot (IABOT iaBot){}
```

Ahora nos enfocamos en el Mecatronico, el cual es el encargado de tomar un Soldado, un exoesqueleto y ensamblar al Exobot con supervisión de la IABOT. El código se muestra a continuación:

```java
public class Mecatronico extends Humano {

    public Mecatronico(String nombre) {
        super(nombre);
    }

    public void ensamblar(Soldado soldado, Exobot exobot, IABOT iaBot){
        System.out.println(soldado.getHabilidadBrazoIzquierdo());

        exobot.unirseSoldado(soldado);
    }
}
```

Como el exoesqueleto se une con el Soldado durante el ensamblado del Exobot, se añade el siguiente método a la clase Exobot:

```java
public void unirseSoldado(Soldado soldado) {
    if(Exobot.brazoIzquierdo && eBrazoIzquierdo != null){
        if(soldado.getHabilidadBrazoIzquierdo())
            eBrazoIzquierdo.setArma(new ArmaMetralleta("Metralleta MK61"));
        else
            eBrazoIzquierdo.setArma(new ArmaBazuca("Bazuca antitanque"));
        
        eBrazoIzquierdo.getArma().disparar(30);
        System.out.println(eBrazoIzquierdo.getArma().toString());
    }
}
```

Finalmente creamos Whiterum, quien es el orquestador del programa (presenta todo el escenario planteado). Como no tiene relaciones con otras clases, no debemos tener atributos en esa clase, solamente creamos variables dentro de sus métodos.

```java
public class Whiterun {
    public void iniciar() {
        IABOT iaBot = IABOT.getInstancia("IA-RUSA");
        Mecatronico mecatronico = new Mecatronico("Mecatronico");
        Soldado s1 = new Soldado("Juan");
        Exobot e1 = new Exobot(iaBot);

        mecatronico.ensamblar(s1, e1, iaBot);
    }
}
```

## Clase # 31
    Fecha: 2 de febrero del 2024
-------
### <span style="color:orange">Introducción a Base de Datos</span>

**Persistencia**

Permite el almacenamiento de la información, guardar la data.

**Modelado Entidad Relación (MER)**

Es un enfoque para diseñar bases de datos relacionales de manera visual. Fue propuesto por Peter Chen en la década de 1970 y se ha convertido en una herramienta estándar en el diseño de bases de datos. El modelo MER utiliza conceptos como entidades, atributos y relaciones para representar la estructura lógica de la base de datos.

![imagen 51](51.png)

**Reglas para ejecutar el CRUD - "Normalizar"** 

CRUD es un acrónimo que representa las operaciones básicas realizadas en la gestión de datos en un sistema de base de datos o en cualquier tipo de almacenamiento de información. Cada letra en "CRUD" corresponde a una de estas operaciones:

- **Crear (Create):** La operación de "Crear" implica la creación de nuevos registros o elementos en la base de datos. En el contexto de una aplicación, esto podría significar agregar nuevos datos a una tabla o crear nuevos registros en un sistema.

- **Leer (Read):** La operación de "Leer" implica la recuperación de información existente de la base de datos. Esto se logra mediante consultas que permiten seleccionar y mostrar datos almacenados en el sistema.

- **Actualizar (Update):** La operación de "Actualizar" implica la modificación de registros existentes en la base de datos. Los datos existentes se pueden modificar o actualizar según sea necesario.

- **Eliminar (Delete):** La operación de "Eliminar" implica la eliminación de registros o datos existentes en la base de datos. Los registros seleccionados se eliminan de manera permanente o se marcan como inactivos, dependiendo de la implementación específica.

1. ***Relación 1 a 1 o 1...1***

"Divide y vencerás"

Se requiere de un **Pk**.

**Primary key (Pk)**

La "primary key" (clave primaria) en una base de datos es un concepto importante que se refiere a un campo o conjunto de campos en una tabla que sirve para identificar de manera única cada registro en esa tabla. 

> Lo más recomendable es que para cada tabla se cree un ***id***, de modo que no pueda repetirse este Pk y que si una persona se equivoca registrando sus datos no exista ningún inconveniente después.

Para ejemplificar este caso se utiliza a una persona:

![imagen 52](52.png)

![imagen 53](53.png)

- **Diagrama relacional:**

![imagen 58](58.png)

**Principio atómico**

Significa que cuando realizas varias acciones (como agregar, actualizar o eliminar datos), todas esas acciones deben ocurrir completamente o ninguna de ellas. No puede haber una situación a medias. Este principio asegura que la base de datos permanezca en un estado consistente incluso si ocurre algún problema, ya que todas las operaciones de una transacción se deshacen si algo sale mal. Es como si todas las acciones se consideraran "todo o nada". Esto ayuda a mantener la integridad de los datos en la base de datos.

2. ***Relación 1 a muchos o 1...****

Se requiere de un **Pk** y un **Fk**.

**Foreign Key (Fk)**

Una "foreign key" (clave foránea o clave externa) en una base de datos relacional es un campo o conjunto de campos en una tabla que establece una relación entre dos tablas. La clave foránea se utiliza para vincular los datos de una tabla (tabla hija o secundaria) con los datos de otra tabla (tabla principal o padre) mediante la referencia a la clave primaria de la tabla principal.

> Los ***Fk*** pueden repetirse.

![imagen 54](54.png)

![imagen 55](55.png)

- **Diagrama relacional:**

![imagen 59](59.png)


3. ***Relación muchos a muchos***

Tiene la forma **Pk1**, **Fk1**,**Pk2**, **Fk2**.

![imagen 56](56.png)

![imagen 57](57.png)

- **Diagrama relacional:**

![imagen 60](60.png)

Debemos verificar si cada sección es en verdad una tabla o solo son campos que se agregan a una tabla existente.

En el ejemplo existen varias maneras de colocar el sexo y la raza de la mascota, si un día realizamos una consulta de estos campos pasaríamos un largo tiempo buscando la información de todos los animales registrados. Por tal razón, estos datos son tablas que estaban siendo disfrazadas por campos. 

Entonces corrigiendo los errores se vería de la siguiente manera: 

![imagen 61](61.png)

- **Diagrama relacional:**

![imagen 62](62.png)

## Clase # 32
    Fecha: 6 de febrero del 2024
-------
### <span style="color:orange">Normalización</span>

También conocida como ***modelo lógico*** o MER.

El modelo lógico es el resultado de una normalización que permite agrupar campos en tablas relacionadas entre sí y evitar redundancia de datos.

Existen tres tipos:

1. 1...1 (Pk, Pk)

2. 1...* (Pk, Fk)

3. *... * (Pk, Fk, Fk, Pk)

Donde cada uno posee ***atomicidad***, validando que los datos estén en forma adecuada.

Para normalizar una base de datos debemos seguir estos pasos:

1. Identificar las tablas y atributos que van a ser parte de nuestra BD.
2. Dividir estas entidades en tablas.
3. Establecer claves primarias y foráneas para establecer relación entre ellas.
4. Proporcionar un nombre descriptivo a las columnas.

Las tablas tienen una parte horizontal y otra vertical.

![imagen 63](63.png)

El ***Id*** es una columna común a todas las tablas, sirve como identificador único para clusterizar, de modo que nos ayuda a organizar, no permite repetidos y hace que el proceso de búsqueda sea más rápido en algunos casos.

**Modelo relacional**

El modelo relacional en bases de datos es un enfoque para organizar y estructurar la información en una base de datos. Fue propuesto inicialmente por Edgar F. Codd en la década de 1970 y se ha convertido en uno de los modelos más utilizados para la gestión de datos.

En el modelo relacional, los datos se organizan en tablas bidimensionales llamadas relaciones. Cada tabla está compuesta por filas y columnas, donde cada fila representa una instancia individual de los datos y cada columna representa un atributo o campo específico de esos datos. Las relaciones entre las tablas se establecen mediante la coincidencia de valores en columnas comunes, lo que se conoce como claves primarias y claves foráneas.

Las principales características del modelo relacional incluyen:

- **Estructura tabular:** Los datos se organizan en tablas, lo que facilita la visualización y comprensión de la estructura de la base de datos.

- **Integridad referencial:** Las relaciones entre las tablas se gestionan mediante el uso de claves primarias y foráneas, lo que garantiza la coherencia y la integridad de los datos.

- **Independencia física de los datos:** El modelo relacional permite separar la forma en que se almacenan los datos de la forma en que se accede a ellos, lo que facilita la gestión y el mantenimiento de la base de datos.

- **Operaciones relacionales:** El modelo relacional proporciona un conjunto de operaciones estándar para manipular y consultar los datos, como selección, proyección, unión y diferencia.

![imagen 64](64.png)

> En la mayoría de los campos los números se pueden repetir, las palabras no; por esa razón se utiliza un Id. Además, los nombres de los campos van en singular.

***Equivalencia muchos a muchos***

![imagen 65](65.png)

***Proceso de borrado***

![imagen 66](66.png)

Cuando se hace un borrado de tablas, primero se eliminan los hijos y luego el papá, contrario a crear.

> Todas las tablas deben tener un campo **FechaCrea**, **FechaModifica** y el **Id** del usuario que las modifica.

![imagen 67](67.png)

**Modelo físico**

***Lenguaje de Definición de Datos (DDL)***

Se refiere a un conjunto de comandos o instrucciones que se utilizan para definir y gestionar la estructura de una base de datos y sus objetos asociados. Esto incluye la creación, modificación y eliminación de tablas, índices, vistas, esquemas, restricciones y otros elementos de la base de datos.

Ejemplo: 

![imagen 68](68.jpg)

> Siempre arrancamos con el nombre de la tabla. 

Utilizamos ***references*** para un Fk.

> Para tener un código limpio y legible igualmente se hace uso de la identación (tabulado).

Con **drop** se elimina una tabla.

***Lenguaje de Definición de Datos (DML)***

Se refiere a un conjunto de comandos o instrucciones utilizados para manipular los datos almacenados en una base de datos. A diferencia de DDL (Data Definition Language), que se utiliza para definir y gestionar la estructura de la base de datos y sus objetos, DML se centra en las operaciones relacionadas con los datos mismos, como la inserción, modificación, eliminación y consulta de datos.

Aquí se pone en práctica el **CRUD**, de la siguientr manera:

- **Create:** Insert into ... values(...)

Ejemplo:

```sql
Insert into Sexo ( IdSexo
                    , Nombre
                    , Observación
                    , FechaCrea
                    , FechaModifica
);

values ( 1
        , "Hombre"
        , ""
        , 06/02/2024
        , null
);

values ( 2
        , "Mujer"
        , ""
        , Date("NOW")
        , null
);
```
> El ***trigger*** controla los datos para que se evite poner cualquier cosa en los campos.

- **Read:** Select * from... where..

Ejemplo:

Para seleccionar toda la tabla:

```sql
Select * from Sexo;
```

Para seleccionar algunos campos de la tabla:

```sql
Select Nombre, FechaCrea from Sexo;
```

Para seleccionar específicamente una columna de la tabla:

```sql
Select * from Sexo where IdSexo = 1;
```

Para seleccionar varias columnas de la tabla:

```sql
Select * from Sexo where IdSexo < 4;
```

o

```sql
Select * from Sexo where IdSexo = 1 OR IdSexo = 2;
```

- **Update:** Update .. set ... where...

Para actualizar todo el campo de una tabla:

```sql
Update Sexo set Nombre = "HOMBRE"
```

Para actualizar una columna de un campo de una tabla:

```sql
Update Sexo set Nombre = "HOMBRE" where IdSexo = 4;
```

- **Delete:** Delete from...

```sql
Delete from Sexo where IdSexo = 4;
```

## Clase # 33
    Fecha: 7 de febrero del 2024
-------
### <span style="color:cyan">Ejercicio normalización - parte 1</span>

**PoliTinder**

Es una aplicación que se encarga de registrar la información de sus usuarios, el tipo de relación que tienen entre ellos, citas acordadas y el envío de un presente de un usuario a otro, ya sea de manera presencial o virtual.

![imagen 71](71.png)

***Diagrama relacional***

![imagen 69](69.png)

***Registros de cada tabla***

![imagen 70](70.png)

Aunque una tabla tenga pocos registros, eso me ayuda a caracterizar otras tablas más complejas.

***Jerarquía***

La jerarquía en una base de datos, específicamente en el contexto de la estructura de datos, se refiere a la organización de los elementos de datos en diferentes niveles. Una jerarquía en una base de datos puede representarse de varias formas, dependiendo de la estructura y el diseño de la base de datos.

Ejemplo básico de una jerarquía en una base de datos:

- **Base de datos:** La base de datos es el nivel más alto de la jerarquía y puede contener múltiples conjuntos de datos o tablas.

- **Tabla:** Dentro de una base de datos, hay tablas que contienen los datos organizados en filas y columnas. Cada tabla tiene un nombre único y está diseñada para almacenar un tipo específico de datos.

- **Campos/Columnas:** Los campos o columnas son los elementos individuales dentro de una tabla que representan atributos o características de los datos. Cada campo tiene un nombre y un tipo de datos asociado.

- **Filas/Registros:** Las filas o registros son instancias individuales de datos dentro de una tabla. Cada fila representa una entrada única en la tabla y contiene valores para cada campo correspondiente.

***Jerarquía dentro de una misma tabla (Herencia)***

Se da cuando tenemos un diagrama relacional de la siguiente forma:

![imagen 72](72.png)

Representación en formato tabular:

| IdUbicacion | IdJerarquia | Nombre    |
|-------------|-------------|-----------|
| 1           | -           | Ecuador   |
| 2           | -           | Colombia  |
| 3           | 1           | Costa     |
| 4           | 1           | Sierra    | 
| 5           | 1           | Oriente   | 
| 6           | 4           | Pichincha | 
| 7           | 4           | Loja      | 
| 8           | 6           | Quito     | 

## Clase # 34
    Fecha: 8 de febrero del 2024
-------
### <span style="color:pink">Ejercicio normalización - parte 2</span>

Creamos nuevas carpetas en nuestro workspace:

- **database:** Almacena las tablas con sus respectivos registros creados.
- **Design:** Etapa de diseño, lugar donde se realiza el diagrama relacional.
- **Script:** Aquí se crea el DDL Y EL DML.

> La extensión de los archivos en database es **.sqlite** y en Script es **.sql**. 

***Diagrama relacional modo pro***

![imagen 73](73.png)

***Scripts***

En los Scripts siempre debe haber un encabezado, como por ejemplo:

/*
copyRyght 2024 ...
...
..
*/

Antes de ejecutar el DDL o el DML, primero debemos conectar  a la base de datos SQLite creada en la carpeta database.

- **DDL_PoliTinder**

```sql
-- database: ../database/POLITINDER.sqlite
/*
copyRyght 2024 ...
...
..
*/
-- DROP TABLE RegaloTipo;
DROP TABLE IF EXISTS RegaloTipo;
DROP TABLE IF EXISTS PersonaRol;
DROP TABLE IF EXISTS PersonaSexo;
DROP TABLE IF EXISTS Regalo;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Relacion;
DROP TABLE IF EXISTS RelacionTipo;
DROP TABLE IF EXISTS Cita;
DROP TABLE IF EXISTS RegaloEnvio;

-- Catalogo

CREATE TABLE RegaloTipo (
    IdRegaloTipo    INTEGER PRIMARY KEY AUTOINCREMENT
    , Nombre        TEXT NOT NULL UNIQUE 
    , Observacion   TEXT
    , FechaCrea     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica DATETIME  
);
CREATE TABLE PersonaRol (
    IdPersonaRol         INTEGER PRIMARY KEY AUTOINCREMENT
    , IdPersonaRol_Padre INTEGER REFERENCES PersonaRol (IdPersonaRol)
    , Nombre             TEXT NOT NULL UNIQUE 
    , Observacion        TEXT
    , FechaCrea          DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica      DATE 
);
CREATE TABLE PersonaSexo (
    IdPersonaSexo   INTEGER PRIMARY KEY AUTOINCREMENT
    , Nombre        TEXT NOT NULL UNIQUE 
    , Observacion   TEXT
    , FechaCrea     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica DATE 
);
CREATE TABLE Regalo (
    IdRegalo        INTEGER PRIMARY KEY AUTOINCREMENT
    , IdRegaloTipo  INTEGER NOT NULL REFERENCES  RegaloTipo(IdRegaloTipo)
    , Nombre        TEXT NOT NULL UNIQUE 
    , Precio        REAL 
    , Stock         INTEGER
    , Observacion   TEXT
    , FechaCrea     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica DATE 
);
CREATE TABLE Persona (
    IdPersona       INTEGER PRIMARY KEY AUTOINCREMENT
    , IdPersonaRol  INTEGER NOT NULL REFERENCES PersonaRol(IdPersonaRol)
    , IdPersonaSexo INTEGER NOT NULL REFERENCES PersonaSexo(IdPersonaSexo)
    , Cedula        TEXT NOT NULL
    , Nombre        TEXT NOT NULL
    , Observacion   TEXT
    , FechaCrea     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica DATE
);
CREATE TABLE Relacion (
    IdRelacion              INTEGER PRIMARY KEY AUTOINCREMENT
    , IdRelacionTipo        INTEGER REFERENCES RelacionTipo (IdRelacionTipo)
    , IdPersona1            INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , IdPersona2            INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , FechaInicioRelacion   DATE NOT NULL
    , Observacion           TEXT
    , FechaCrea             DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica         DATE 
);
CREATE TABLE RelacionTipo (
    IdRelacionTipo  INTEGER PRIMARY KEY AUTOINCREMENT
    , Nombre        TEXT NOT NULL UNIQUE 
    , Observacion   TEXT
    , FechaCrea     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica DATE 
);
CREATE TABLE Cita(
    IdCita              INTEGER PRIMARY KEY AUTOINCREMENT
    , IdPersona1        INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , IdPersona2        INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , FechaCita         DATE NOT NULL
    , Observacion       TEXT
    , FechaCrea         DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica     DATE 
);
CREATE TABLE RegaloEnvio (
    IdRegaloEnvio       INTEGER PRIMARY KEY AUTOINCREMENT
    , IdRegalo          INTEGER  NOT NULL REFERENCES Regalo (IdRegalo)
    , IdPersonaEnvia    INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , IdPersonaRecibe   INTEGER NOT NULL REFERENCES Persona (IdPersona)
    , Observacion       TEXT
    , FechaEnvio        DATE NOT NULL
    , FechaCrea         DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FechaModifica     DATE 
);
```

***UNIQUE*** ayuda a controlar a que no se repitan los datos en una columna.

> Se crean primero los padres y luego los hijos.

Para borrar una tabla existen dos métodos:

1. Elimina la tabla directamente, si no existe entonces el programa se cuelga.

```sql
DROP TABLE Regalo;
```

2. Es un borrado más inteligente puesto que verifica si existe la tabla y luego la elimina, sin embargo si existe una mala escritura en el nombre de la tabla no avisa y puede confundir al DVA.

```sql
DROP TABLE IF EXISTS Regalo;
```

Para que una persona no pueda tener una relación consigo mismo se acude a un ***constraint***.

Un ***constraint*** (restricción o "constrain" en inglés) es una regla que se define para imponer ciertas condiciones o restricciones sobre los datos que se pueden almacenar en una tabla. Estas restricciones aseguran la integridad y la consistencia de los datos en la base de datos.

> Para ejecutar todo el DDL o el DML hay que aplastar varias veces F5, para comprobar que esté funcionando correctamente la base de datos.

- **DML_PoliTinder**

```sql
-- database: ../database/POLITINDER.sqlite
INSERT INTO RegaloTipo (
    Nombre       
    , Observacion  
) VALUES (
    "VIRTUAL"
    , "Regalo Virtual para pruebas"
);
INSERT INTO RegaloTipo (
    Nombre       
    , Observacion    
) VALUES (
    "Presencial"
    , "Regalo Presencial para pruebas"
);
```

## Clase # 35
    Fecha: 14 de febrero del 2024
-------
### <span style="color:lightgreen"></span>

## Clase # 36
    Fecha: 15 de febrero del 2024
-------
### <span style="color:orange"></span>

## Clase # 37
    Fecha: 16 de febrero del 2024
-------
### <span style="color:orange"></span>





