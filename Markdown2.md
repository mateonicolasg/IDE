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
### <span style="color:lightgreen">Data</span>

***Escalabilidad***

La escalabilidad se refiere a la capacidad de un sistema o aplicación para manejar un aumento en la carga de trabajo o en la cantidad de usuarios sin comprometer su rendimiento, disponibilidad o calidad del servicio.

![imagen 74](74.png)

Existen dos tipos principales de escalabilidad en programación:

- **Escalabilidad vertical:** También conocida como "escalabilidad hacia arriba", implica aumentar la capacidad de recursos en una única máquina, como agregar más RAM, CPU o almacenamiento. Sin embargo, este enfoque tiene un límite físico y puede volverse prohibitivamente costoso o técnicamente difícil alcanzar niveles muy altos de escalabilidad.

- **Escalabilidad horizontal:** También llamada "escalabilidad hacia fuera", consiste en agregar más máquinas o nodos al sistema para distribuir la carga de trabajo. Este enfoque suele ser más sostenible y rentable a largo plazo, ya que permite una expansión más flexible y distribuida. La arquitectura de sistemas escalables horizontalmente se basa en la capacidad de dividir la carga entre múltiples instancias de la aplicación y coordinar su funcionamiento de manera eficiente.

**Arquitectura N-TIER**

El modelo N-Tier, también conocido como arquitectura de múltiples capas o arquitectura en capas, es un enfoque de diseño de software que divide una aplicación en diferentes capas o niveles lógicos, cada uno de los cuales realiza funciones específicas.

![imagen 75](75.png)

Las capas en un modelo N-Tier típicamente incluyen:

1. **Capa de Presentación (Frontend):** Esta es la capa con la que interactúa el usuario final. Se encarga de presentar la interfaz de usuario y recopilar la entrada del usuario. Puede consistir en interfaces de usuario web, aplicaciones móviles, aplicaciones de escritorio, etc.

2. **Capa de Lógica de Negocio (Backend):** También conocida como capa de lógica de aplicación, esta capa se encarga de procesar la lógica de negocio de la aplicación. Aquí se realizan operaciones como validación de datos, cálculos, acceso a datos y aplicaciones de reglas empresariales.

3. **Capa de Acceso a Datos:** Esta capa proporciona acceso a la base de datos u otras fuentes de datos. Se encarga de realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos y traducir los datos entre el formato utilizado en la aplicación y el formato utilizado en la base de datos.

Para enviar información a una base de datos, se necesita de un ***pipeline***, el cual permite la comunicación entre el cliente y el servidor. De modo que cada registro ingrese uno por uno a través de un solo canal a la base de datos, restringiendo el acceso de cualquier información al medio. Esto se lleva a cabo con la ayuda de dos componentes fundamentales:

- **connection (conexión):** Se refiere a la conexión establecida entre una aplicación y la base de datos. Esta conexión permite que la aplicación envíe consultas a la base de datos y reciba resultados. En JAVA se utiliza ***SqlLiteDataHelper.java***.

- **path (ruta):** Es la secuencia de tablas y relaciones que se siguen para acceder a los datos deseados. Para JAVA se ocupa un ***odbcdrive.jar***.

***SqlLiteDataHelper.java*** contiene una clase o un conjunto de clases que proporcionan funcionalidades para interactuar con una base de datos SQLite desde una aplicación Java. Por otra parte, ***odbcdrive.jar*** contiene el controlador JDBC (Java Database Connectivity) necesario para acceder a una base de datos a través del protocolo ODBC (Open Database Connectivity).

> Los controladores JDBC son bibliotecas Java que permiten a las aplicaciones Java interactuar con bases de datos utilizando el estándar JDBC. El protocolo ODBC, por otro lado, es una API que permite a las aplicaciones acceder a varias bases de datos utilizando un conjunto común de funciones.

![imagen 76](76.png)

***Ejemplo de un diagrama de arquitectura N-TIER***

![imagen 77](77.png)

***Pipeline***

Se ocupa el patrón Singleton para generar una sola tubería, es decir una sola conexión a la base de datos.

El código para el SqlLiteDataHelper es el siguiente:

```java
public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database//SEXO.sqlite";
    private static Connection conn = null;

    // Constructor
    
    protected SQLiteDataHelper (){}

    // Conexion

    protected static synchronized Connection openConnection () throws Exception {
        try {
            if (conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    // Desconectarse de la base

    protected static void closeConnection() throws Exception {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
```

Donde **throw** significa capturar el error para pasarlo a otra capa. A esto se lo conoce como un ***burbujeo de secciones***.

Además, **synchronized** significa que solo un hilo puede ejecutar ese método a la vez. Esto es útil para evitar problemas de concurrencia cuando varios hilos intentan acceder o modificar datos en la base de datos al mismo tiempo.

> Los ***hilos*** son secuencias de instrucciones que pueden ser ejecutadas de forma independiente dentro de un proceso. Un proceso puede contener uno o varios hilos, y cada hilo puede ejecutar un conjunto de instrucciones de manera concurrente con otros hilos del mismo proceso.

***DAC***

Componente de acceso a datos. Es el responsable de realizar las operaciones CRUD en una base de datos.

Por cada entidad que tiene la base de datos, se debe crear un DAC.

Ejemplo en código:

```java
public class DACSexo extends SQLiteDataHelper {
    public ResultSet getAllSexo () throws Exception {
        String query = "SELECT IdSexo, Nombre FROM Sexo"; 
        try {
            Connection conn = openConnection(); // jdbc:sqlite:data\\basedeDatos.db
            Statement stmt = conn.createStatement();  // CRUD: Select *
            return stmt.executeQuery(query); // Resultado
        } catch (Exception e) {
            throw e;
        }
    } 
}
```

> ***query*** significa consulta.

***query*** se prueba primero desde **</> Editor SQL** para verificar que esté bien escrito y luego lo pasamos al método de la clase DAC que hayamos creado.

```sql
-- database: C:\Users\Ryzen 3\OneDrive\Documentos\SEGUNDO SEMESTRE\PROGRAMACIÓN II\BASE\database\SEXO.sqlite
SELECT IdSexo, Nombre FROM Sexo;
```

Por otra parte, para comprobar que el método esté funcionando correctamente, lo probamos desde App.java como se muestra a continuación:

```java
public class App {
    public static void main(String[] args) throws Exception {
        DACSexo sexo = new DACSexo();
        ResultSet rs = sexo.getAllSexo();
        while (rs.next())
            System.out.println(rs.getString(1) + " " + rs.getString(2));
    }
}
```

> En Java, ***ResultSet*** es una interfaz que forma parte del paquete java.sql. Representa un conjunto de resultados obtenidos a partir de una consulta ejecutada en una base de datos relacional utilizando JDBC.

Para obtener la información de algunos registros con ciertas particularidades debemos modificar el query.

Por ejemplo, escribir "SELECT IdSexo, Nombre FROM Sexo WHERE IdSexo = 1" en vez de "SELECT IdSexo, Nombre FROM Sexo".

El query puede tener un formato más agradable y comprensible, como por ejemplo:

```java
        String query =      "SELECT IdSexo, Nombre "
                        +   "FROM Sexo "
                        +   "WHERE IdSexo = 1"; 
```

> Recordemos que si se desea evitar errores en la ejecución del código de una consulta es importante probar el query primero en **</> Editor SQL** para posteriormente colocarlo en un método de una clase DAC. 

## Clase # 36
    Fecha: 15 de febrero del 2024
-------
### <span style="color:brown">DAC</span>

**DAC**

Un DAC (Data Access Component) es un módulo de software que se utiliza para acceder y manipular datos en una aplicación. Estos componentes son una parte integral de muchas aplicaciones empresariales y de software, ya que permiten interactuar con bases de datos, sistemas de archivos, servicios web u otras fuentes de datos.

Algunas características comunes de los Data Access Components incluyen:

- **Conexión a la fuente de datos:** Proporcionan métodos para establecer conexiones con bases de datos, sistemas de archivos u otros sistemas de almacenamiento de datos.

- **Consultas y actualizaciones:** Permiten ejecutar consultas SQL u otras consultas específicas del tipo de fuente de datos para recuperar y modificar datos según sea necesario.

- **Mapeo de objetos-relacionales (ORM):** Algunos Data Access Components ofrecen capacidades de mapeo objeto-relacional, lo que permite a los desarrolladores trabajar con objetos de datos en lugar de consultas directas a la base de datos.

- **Transacciones:** Soportan transacciones para garantizar la integridad y la consistencia de los datos al realizar operaciones múltiples y relacionadas.

- **Optimización de consultas:** Proporcionan herramientas para optimizar el rendimiento de las consultas y minimizar el tiempo de acceso a los datos.

![imagen 78](78.png)

***DAO***

Un DAO (Data Access Object) es un patrón de diseño utilizado en programación para encapsular la lógica de acceso a una fuente de datos, como una base de datos, un archivo o un servicio web. El objetivo principal del patrón DAO es separar la lógica de acceso a datos de la lógica de negocio de una aplicación, lo que facilita el mantenimiento, la escalabilidad y la reutilización del código.

En nuestro caso, se ocupa para realizar el **CRUD**.

![imagen 79](79.png)

***DTO***

Un DTO (Data Transfer Object) es un objeto utilizado para transferir datos entre componentes de un sistema de software. Su propósito principal es encapsular un conjunto de datos y enviarlo de un lado a otro de manera eficiente y estructurada, sin incluir lógica de negocio adicional.

![imagen 80](80.png)

En código se representa de la siguiente manera:

```java
public interface IDAO <T> {
    public void create (T obj);

    // Existen dos formas para leer
    public T read(int id); // Leer un registro
    public List<T> readAll(); // Leer todos los registros

    public void update(T obj);

    // Existen dos formas para eliminar
    public void delete(int id); // Por Id
    public void delete (T obj);
}
```

> Algunos métodos, como el update o el delete, podrían devolver un boolean para que sea un escenario más inteligentes.


***Generic***

Los genéricos en programación son una característica que permite escribir código que puede trabajar con diferentes tipos de datos de manera segura y reutilizable. La idea principal detrás de los genéricos es la parametrización de tipos, lo que significa que puedes crear clases, interfaces y métodos que actúen sobre tipos específicos sin especificar esos tipos de antemano.

Es un tipo de comportamiento que otorga un nivel más alto de programación, la posibilidad de acoplarse a cualquier clase.

***Resumen***

![imagen 81](81.png)

***Borrado lógico***

Una manera más apropiada para eliminar registros de una tabla es mediante la utilización de un campo que defina el estado de todos los registros creados de dicha tabla.

Ejemplo de Estado: A (Activo) --> X (Eliminado)

Aquellos registros que tengan A en el campo Estado se mostrarán en las consultas, por el contrario los que posean X no aparecerán, es decir, permanecerán ocultos.

Esto lo hacemos con el propósito de que si en algún momento decidimos borrar la información, podamos recuperar la información sin ningún problema.

***Copycopyright***

Todos los Scripts deben tener un copyright en la parte superior. Como por ejemplo:

|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 17.feb.2k24
Script: Creacion de la tabla sexo + datos

***DAC en código***

Para el ejemplo se trabajará con la tabla/clase Sexo.

1. **Base de datos:** En un solo Script se coloca el DDL, DML y pruebas de consultas.

```sql
DROP TABLE IF EXISTS Sexo;
CREATE TABLE Sexo (
      IdSexo        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    , Nombre        VARCHAR(10) NOT NULL UNIQUE 
    , Estado        VARCHAR(1)  NOT NULL DEFAULT('A') 
    , Observacion   TEXT
    , FechaCrea     DATETIME    NOT NULL DEFAULT (datetime('now','localtime'))
    , FechaModifica DATETIME 
); 
---------------------------------------------------------------------
INSERT INTO SEXO (NOMBRE) VALUES 
  ("Femenino")
, ("Masculino")
, ("Hibrido");

SELECT * FROM SEXO;

SELECT IdSexo, Nombre
FROM SEXO
WHERE Estado = 'A' AND IdSexo = 2;

SELECT count(*)
FROM SEXO
WHERE Estado = 'A';
```

2. **DTO:** Se colocan los campos de la tabla como atributos con sus respectivos getter, setter, además se crea un constructor vacío y otro con todas las propiedades. Por último se realiza un Override al método ***toString*** para presentar todos los registros desde la terminal de manera fácil y efectiva.

```java
public class SexoDTO {
    private int    IdSexo;       
    private String Nombre;       
    private String Estado;       
    private String Observacion;  
    private String FechaCrea;    
    private String FechaModifica;

    public SexoDTO() {
    }

    public SexoDTO(int idSexo, String nombre, String estado, String observacion, String fechaCrea, String fechaModifica) {
        IdSexo = idSexo;
        Nombre = nombre;
        Estado = estado;
        Observacion = observacion;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public int getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(int idSexo) {
        IdSexo = idSexo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getObservacion() {
        return Observacion;
    }
    public void setObservacion(String observacion) {
        Observacion = observacion;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\nIdSexo:        " + getIdSexo()             
        + "\nNombre:        " + getNombre()             
        + "\nEstado:        " + getEstado()             
        + "\nObservacion:   " + getObservacion()   
        + "\nFechaCrea:     " + getFechaCrea()       
        + "\nFechaModifica: " + getFechaModifica();   
    }
}
```

3. **IDAO:** Similar al que se presentó anteriormente.

4. **DAO:** Se implementa IDAO y se modifican los métodos proporcionados por la interfaz (CRUD). 

```java
public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO>{
    ...
    @Override
    public List<SexoDTO> readAll() throws Exception {
        List <SexoDTO> lst = new ArrayList<>();
        String query = " SELECT IdSexo      "
                     + " , Nombre           "
                     + " , Estado           "
                     + " , Observacion      "
                     + " , FechaCrea        "
                     + " , FechaModifica    "
                     + " FROM SEXO          "
                     + " WHERE Estado = 'A' ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                SexoDTO s = new SexoDTO(  rs.getInt(1)       // Id
                                        , rs.getString(2)    // Nombre       
                                        , rs.getString(3)    // Estado       
                                        , rs.getString(4)    // Observacion  
                                        , rs.getString(5)    // FechaCrea    
                                        , rs.getString(6));  // FechaModifica
                lst.add(s);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public SexoDTO read(Integer id) throws Exception {
        SexoDTO oS = new SexoDTO();
        String query = " SELECT IdSexo      "
                     + " , Nombre           "
                     + " , Estado           "
                     + " , Observacion      "
                     + " , FechaCrea        "
                     + " , FechaModifica    "
                     + " FROM SEXO          "
                     + " WHERE Estado = 'A' AND IdSexo = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                oS = new SexoDTO(  rs.getInt(1)       // Id
                                        , rs.getString(2)    // Nombre       
                                        , rs.getString(3)    // Estado       
                                        , rs.getString(4)    // Observacion  
                                        , rs.getString(5)    // FechaCrea    
                                        , rs.getString(6));  // FechaModifica
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }
    ...
```

5. **Testing:** Probamos cada uno de los métodos que hemos implementado anteriormente, para verificar si funcionan.

```java
public class App {
    public static void main(String[] args) throws Exception {
        // Probando read()
        SexoDAO oS = new SexoDAO();
        System.out.println(oS.read(2).toString());
        // Probando readAll()
        for (SexoDTO s : oS.readAll()) {
             System.out.println(s.toString());
         }
    }
}
```

## Clase # 37
    Fecha: 16 de febrero del 2024
-------
### <span style="color:orange">BLL</span>

BLL (Capa de Lógica de Negocio) es una capa en la arquitectura de una aplicación de software que se encarga de implementar y gestionar la lógica de negocio o reglas de negocio de la aplicación. Esta capa contiene la lógica que define cómo se procesan y manipulan los datos de acuerdo con las reglas y requisitos específicos del dominio del negocio.

Siguiendo con el ***DAC***, para insertar, actualizar o eliminar algún registro debemos enviar parámetros como se observa a continuación:

![imagen 82](82.png)

En código:

```java
public class SexoDAO extends SQLiteDataHelper implements IDAO<SexoDTO>{

    @Override
    public boolean create(SexoDTO entity) throws Exception {
        String query = "INSERT INTO SEXO (Nombre) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<SexoDTO> readAll() throws Exception {
        ...
    }

    @Override
    public SexoDTO readBy (Integer id) throws Exception {
        ...
    }

    @Override
    public boolean update(SexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE SEXO SET Nombre = ?, FechaModifica = ? WHERE IdSexo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3  , entity.getIdSexo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE SEXO SET Estado = ? WHERE IdSexo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
}
```

> Para no desgastar demasiado la lógica de programación con el update, es mejor mandar a actualizar todos los campos de un registro con este método.

Realizamos un Testing en App para verificar su  correcto funcionamiento:

```java
public class App {
    public static void main(String[] args) throws Exception {
        SexoDTO s = new SexoDTO();
        s.setIdSexo(3);
        s.setNombre("Hibrido");
        s.setFechaModifica("2023-02-17 20:50:11"); // La fecha se coloca automáticamente, no se puede engañar al sistema

        SexoDAO oS = new SexoDAO();
        // oS.create(s);   
        oS.update(s);   
        System.out.println(oS.readBy(3).toString());
    }
}
```

> Con un método llamado ***recover*** podemos recuperar los datos eliminados de manera lógica.

Existe un grave error mientras aplicamos la arquitectura N-TIER, puesto que se puede romper la estructura de capas y violar sus principios.

No se puede transitar de una capa a cualquier otra porque se tiene un orden en específico. Desde la GUI se puede acceder a la BLL y desde la BLL se puede acceder a la DAC, este es el orden que obligatoriamente debe cumplir nuestro diseño.  

![imagen 83](83.png)

Una vez probada toda la DAC, seguimos con la BLL:

```java
public class SexoBL {
    private SexoDTO sexo;
    private SexoDAO sDAO = new SexoDAO();

    public SexoBL() {}

    public List<SexoDTO> getAll() throws Exception {
        return sDAO.readAll();
    }
    public SexoDTO getBy(int idSexo) throws Exception {
        sexo = sDAO.readBy(idSexo);
        return sexo;
    }
    public boolean add (String nombre) throws Exception {
        sexo = new SexoDTO();
        sexo.setNombre(nombre);
        return sDAO.create(sexo);
    }
    public boolean update (int idSexo, String nombre) throws Exception {
        sexo = new SexoDTO();
        sexo.setIdSexo(idSexo);
        sexo.setNombre(nombre);
        return sDAO.update(sexo);
    }
    public boolean delete (int idSexo) throws Exception {
        return sDAO.delete(idSexo);
    }
}
```

De igual manera, realizamos pruebas en App para comprobar que todo esté en ok:

```java
public class App {
    public static void main(String[] args) throws Exception {
        SexoBL sBL = new SexoBL();
        sBL.update(5,"Macho Alfa");
        sBL.delete(5);
        for (SexoDTO s : sBL.getAll()) {
            System.out.println(s.toString());
        }
    }
}
```

**GUI**

Se crea una carpeta denominada ***CustomerControl*** para generalizar o estandarizar los componentes de una aplicación, es decir personalizar controles que se van a utilizar dentro del programa.

Por otro lado, JAVA tiene una paqueterías: AWT (uno de los primeros componentes que se crearon), JAVA Swing, JAVA FX.

Nosotros vamos a trabajar con JAVA Swing, que tiene toda la paquetería necesaria integrada.

![imagen 84](84.png)

A continuación, se presentan algunos de los componentes más comunes proporcionados por Swing:

- **JFrame:** Es el contenedor principal de una aplicación Swing. Representa la ventana principal de la aplicación y puede contener otros componentes, como paneles, botones, cuadros de texto, etc.

- **JPanel:** Es un contenedor liviano que se utiliza para organizar y agrupar otros componentes. Los paneles se pueden agregar a un JFrame para dividir la interfaz de usuario en secciones lógicas.

- **JButton:** Es un botón que el usuario puede hacer clic para realizar alguna acción. Puede contener texto, iconos o ambas cosas.

- **JLabel:** Es un componente utilizado para mostrar texto o imágenes en la interfaz de usuario. Se utiliza comúnmente para proporcionar etiquetas descriptivas o informativas.

- **JTextField:** Es un campo de texto de una sola línea donde el usuario puede ingresar y editar texto.

- **JTextArea:** Es un área de texto de múltiples líneas que permite al usuario ingresar y editar texto de manera más extensa que un JTextField.

- **JComboBox:** Es un componente desplegable que muestra una lista de opciones y permite al usuario seleccionar una de ellas.

- **JCheckBox:** Es un componente que representa una casilla de verificación que puede estar marcada o desmarcada por el usuario.

- **JRadioButton:** Es un botón de opción que representa una opción exclusiva en un grupo de opciones. Los usuarios pueden seleccionar una de varias opciones de radio en un grupo.

- **JList:** Es un componente que muestra una lista de elementos y permite al usuario seleccionar uno o varios elementos de la lista.

A través de la herencia podemos utilizar todos estos componentes.

***ActionListener***

También conocido como los "escuchadores", es una interfaz que se utiliza para manejar eventos de acción generados por componentes de la interfaz de usuario, como botones, menús desplegables, elementos de lista, entre otros.

El método ***ActionPerformed*** es el único punto de entrada para invocar los clics que el usuario haga y determinar la acción que se debe realizar después.

## Clase # 38
    Fecha: 21 de febrero del 2024
-------
### <span style="color:fuchsia">GUI - parte 1</span>

La **GUI** (Interfaz Gráfica de Usuario) es un tipo de interfaz que permite a los usuarios interactuar con dispositivos electrónicos a través de elementos gráficos como iconos, botones y ventanas, en contraposición a la línea de comandos.

![imagen 85](85.png)

***Splash***

Un "splash" o "splash screen" es una ventana gráfica que aparece brevemente al inicio de una aplicación o programa para mostrar el logotipo de la aplicación, información sobre la versión, mensajes de carga o cualquier otro contenido relevante mientras la aplicación se está cargando en segundo plano.

***SPA***

SPA (Single Page Application) es un término que se utiliza para describir aplicaciones web que funcionan dentro de una única página y no requieren recargar la página entera durante el uso normal. En lugar de cargar páginas nuevas desde el servidor, las SPA cargan solo los datos necesarios y actualizan dinámicamente la página utilizando Java.

![imagen 86](86.png)

***Tabla localidad***

Una tabla de localidades en una base de datos se utiliza típicamente para almacenar información sobre diferentes áreas geográficas, como ciudades, pueblos, estados, países, etc. Estas tablas pueden ser parte de una base de datos más grande que gestiona datos relacionados con ubicaciones geográficas, como una base de datos de clientes, una aplicación de seguimiento de pedidos o cualquier sistema que necesite asociar datos con ubicaciones geográficas específicas.

Ejemplo:

![imagen 87](87.png)

A continuación, se presenta el código de la tabla localidad en sqlite y en las primeras dos capas de la arquitectura N-TIER:

- En sqlite:

```sql
DROP TABLE IF EXISTS LocalidaEstructura;
CREATE TABLE LocalidaEstructura (
     IdLocalidaEstructura         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidaEstructuraPadre    INTEGER     REFERENCES  LocalidaEstructura (IdLocalidaEstructura)
    ,Nombre                       VARCHAR(10) NOT NULL 
    ,Estado                       VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea                    DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica                DATETIME
); 

INSERT INTO LocalidaEstructura (IdLocalidaEstructuraPadre, Nombre) VALUES 
(NULL,"Pais"),      -- 1
(1,"Provincia"),    -- 2    
(2,"Canton");       -- 3

DROP TABLE IF EXISTS Localida;
CREATE TABLE Localida (
     IdLocalida             INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdLocalidaPadre        INTEGER     REFERENCES  Localida (IdLocalida)
    ,IdLocalidaEstructura   INTEGER     REFERENCES  LocalidaEstructura (IdLocalidaEstructura)
    ,Nombre                 VARCHAR(10) NOT NULL 
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
); 
--------------------------------------------------------------
INSERT INTO Localida (IdLocalidaPadre, IdLocalidaEstructura, Nombre) VALUES 
(NULL,1,"Euador"),
(1,2,"Pichincha"),
(1,2,"Loja"),
(1,2,"Azuay"),
(2,3,"Quito"),
(3,3,"Loja"),
(4,3,"Cuenca");

SELECT * FROM LocalidaEstructura WHERE Estado = "A";
SELECT * FROM localida WHERE Estado = "A";
SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo
FROM localida               lo 
JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura
WHERE   lo.Estado = "A"
AND     le.Estado = "A";

SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo
FROM localida               lo 
JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura
WHERE   lo.Estado = 'A'
AND     le.Estado = 'A'
AND     upper(le.Nombre) = upper('cantón');

SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo FROM localida               lo  JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura WHERE   lo.Estado = 'A'  AND     le.Estado = 'A'  AND     upper(le.Nombre) = 'CANT?N'
```
> Es mejor utilizar **VARCHAR** para datos tipo text pequeños, de manera que nadie pueda poner cualquier día un libro en ese campo.

***JOIN***

Se refiere a una operación que combina filas de dos o más tablas basándose en una condición relacionada. Esta operación es fundamental para consultar datos de múltiples tablas simultáneamente y obtener resultados completos y útiles.

Dos tablas se unen mediante un Pk de una tabla, el cual pasa a ser un Fk de otra tabla.

- En DAC:

***DTO***

```java
public class LocalidadDTO {
    private Integer LocalidaId;
    private String  Localida;
    private String  LocalidaTipo;
    
    public LocalidadDTO(){}
    public LocalidadDTO(Integer localidaId, String localida, String localidaTipo) {
        LocalidaId = localidaId;
        Localida = localida;
        LocalidaTipo = localidaTipo;
    }
    public Integer getLocalidaId() {
        return LocalidaId;
    }
    public void setLocalidaId(Integer localidaId) {
        LocalidaId = localidaId;
    }
    public String getLocalida() {
        return Localida;
    }
    public void setLocalida(String localida) {
        Localida = localida;
    }
    public String getLocalidaTipo() {
        return LocalidaTipo;
    }
    public void setLocalidaTipo(String localidaTipo) {
        LocalidaTipo = localidaTipo;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n LocalidaId  : " + getLocalidaId() 
        + "\n Localida    : " + getLocalida() 
        + "\n LocalidaTipo: " + getLocalidaTipo() ;
    }
}
```

***DAO***

```java
public class LocalidadDAO extends SQLiteDataHelper  {
    
    public LocalidadDTO readBy(Integer id) throws Exception {
        LocalidadDTO oS = new LocalidadDTO();
        String query =
         " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
        +" FROM localida               lo "
        +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
        +" WHERE   lo.Estado = 'A' "
        +" AND     le.Estado = 'A' "
        +" AND     lo.IdLocalida = "+ id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                oS = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                    ,rs.getString(2)            // Localida             
                                    ,rs.getString(3) );         // LocalidaTipo         
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return oS;
    }

    public List<LocalidadDTO> readAll() throws Exception {
        List <LocalidadDTO> lst = new ArrayList<>();
        String query =
        " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
       +" FROM localida               lo "
       +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
       +" WHERE   lo.Estado = 'A' "
       +" AND     le.Estado = 'A' ";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                LocalidadDTO s = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                                ,rs.getString(2)            // Localida             
                                                ,rs.getString(3) );         // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }

    public List<LocalidadDTO> readAllEstructura(String tipo)  throws Exception {
        List <LocalidadDTO> lst = new ArrayList<>();
        String query =
        " SELECT lo.IdLocalida LocalidaId, lo.Nombre Localida, le.Nombre LocalidaTipo"
       +" FROM localida               lo "
       +" JOIN LocalidaEstructura     le ON lo.IdLocalidaEstructura = le.IdLocalidaEstructura"
       +" WHERE   lo.Estado = 'A' "
       +" AND     le.Estado = 'A' "
       +" AND     lower(le.Nombre) = " + ((tipo.equals("Provincia"))
                                        ? "'Provincia'".toLowerCase() 
                                        : "'Cantón'".toLowerCase());
        System.out.println(query);                                    
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                LocalidadDTO s = new LocalidadDTO(rs.getInt(1)              // LocalidaId
                                                ,rs.getString(2)            // Localida             
                                                ,rs.getString(3) );         // LocalidaTipo  
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e;    //new AppException(e, getClass(), "getAllSexo()");
        }
        return lst; 
    }
}
```

Al ser una tabla virtual, estructura temporal que cambia en tiempo de ejecución, no necesita implementar de IDAO y tener todos los métodos CRUD.

- En BL:

```java
public class LocalidadBL {
    private LocalidadDAO lDAO= new LocalidadDAO();
    
    public LocalidadBL() {}

    public List<LocalidadDTO> getAll() throws Exception{
        return lDAO.readAll();
    }
    
    public List<LocalidadDTO> getAllProvincia() throws Exception{
        return lDAO.readAllEstructura("Provincia");
    }
    
    public List<LocalidadDTO> getAllCanton() throws Exception{
        return lDAO.readAllEstructura("Cantón");
    }

    public LocalidadDTO getById(int id) throws Exception{
        return lDAO.readBy(id);
    }
}
```

Verificamos el funcionamiento del código en App:

```java
public class App {
    public static void main(String[] args) throws Exception {
        LocalidadBL lbl = new LocalidadBL();
        for (LocalidadDTO l : lbl.readAll()) {
            System.out.println(l.toString());
        }

       //Presentar solo las provincias 
        for (LocalidadDTO l : lbl.getAllProvincia()) {
            System.out.println(l.toString());
        }
    }
}
```

Para empezar a codificar la capa UserInterface, se crean las siguientes carpetas:

1. **Form:** Corresponde a los paneles con los que se va a trabajar para el proyecto.
2. **CustomerControl:** Concierne a los botones personalizados por parte del programador.
3. **Resource:** Está relacionada con los iconos e imagenes externas que deseamos mostrar o utilizar.

***Splash***

```java
public abstract class SplashScreenForm   {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;

    public static void show() {
        URL imageURL = SplashScreenForm.class.getResource("/UserInterface/Resource/Img/Splah.png");
        icoImagen  = new ImageIcon(imageURL);
        lblSplash  = new JLabel(icoImagen);
        
        prbLoaging = new JProgressBar(0, 100);
        prbLoaging.setStringPainted(true);
        
        frmSplash = new JFrame("Splash Screen");
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoaging, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmSplash.setLocationRelativeTo(null); // Centrar en la pantalla
       
        frmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}

```

> Se coloca abstract puesto que solo debe presentarse una vez y para que tampoco se creen objetos splash por cualquier parte.

Para las propiedades o atributos de cada clase de esta capa se requiere trabajar con estándares de programación, por ejemplo:

```java
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;
```

![imagen 88](88.png)

```java
public class MainForm extends JFrame{
    JPanel pnlMenu, pnlContainer;
 
    public MainForm(String tilteApp){
        setTitle(tilteApp);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlMenu = createMenuPanel();
        pnlContainer = new LoginPanel();
        //createImagePanel();

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlContainer, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel pnlMenu = new JPanel();
        pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("Opción 1");
        JButton button2 = new JButton("Opción 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 1
                JOptionPane.showMessageDialog(MainForm.this, "Seleccionaste Opción 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción 2
                JOptionPane.showMessageDialog(MainForm.this, "Seleccionaste Opción 2");
            }
        });

        pnlMenu.add(button1);
        pnlMenu.add(button2);

        return pnlMenu;
    }

    private JPanel createImagePanel() {
        JPanel pnlContainer = new JPanel();

        // Asegúrate de tener una imagen llamada "sample_image.jpg" en la misma carpeta que tu código
        String imagePath = "/UserInterface/Resource/Img/Splah.png";

        try {
            URL imageURL = SplashScreenForm.class.getResource("/UserInterface/Resource/Img/IABot.png");
            ImageIcon imageIcon = new ImageIcon(imageURL); //new ImageIcon(new File(imagePath).getCanonicalPath());
            JLabel label = new JLabel(imageIcon);
            pnlContainer.add(label,BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pnlContainer;
    }   
}
```
MainForm sin panel:

![imagen 90](90.png)

MainForm con panel:

![imagen 89](89.png)

## Clase # 39
    Fecha: 22 de febrero del 2024
-------
### <span style="color:gray">GUI - parte 2</span>

***Formulario***

Un formulario es una ventana o pantalla que contiene controles y elementos de interfaz de usuario, como botones, cuadros de texto, etiquetas, casillas de verificación, etc. Los formularios son la base sobre la cual se construye la interfaz de usuario de una aplicación. Son la ventana principal o secundaria en la que los usuarios interactúan con la aplicación.

***Panel***

Un panel es un contenedor que se utiliza para organizar y agrupar otros controles y elementos de la interfaz de usuario dentro de un formulario. Los paneles se utilizan para crear diseños más complejos y organizados, permitiendo dividir la ventana principal en áreas más pequeñas y controladas.

***Tipos de distribuciones***

1. **Distribución en horizontal:** La distribución en horizontal en una GUI (Interfaz Gráfica de Usuario) se refiere a la disposición de elementos o componentes de la interfaz de usuario a lo largo de un eje horizontal. En otras palabras, los elementos se colocan uno al lado del otro en una línea horizontal.

2. **Tipo acordeón:** Un diseño tipo "acordeón" en una GUI se refiere a un estilo de disposición en el que los elementos se muestran de forma plegada y se expanden o colapsan según la interacción del usuario. Este diseño se asemeja a un acordeón musical, donde una sección se expande mientras que otras se contraen.

3. **Distribución en vertical:** La distribución en vertical en una GUI (Interfaz Gráfica de Usuario) se refiere a la disposición de elementos o componentes de la interfaz de usuario a lo largo de un eje vertical. En otras palabras, los elementos se colocan uno encima del otro, formando una columna vertical.

4. **Grillado:**  O gridding, se refiere al proceso de organizar y alinear elementos de la interfaz de usuario en una cuadrícula o rejilla. Este enfoque de diseño se utiliza comúnmente para garantizar que los elementos de la interfaz de usuario estén alineados de manera uniforme y ordenada.

![imagen 91](91.png)

En customer control se pueden personalizar los elementos que se van a ocupar en todos los paneles, obteniendo una generalización o un estándar de esos componentes y del programa como tal, por ejemplo:

- MatButton
- MatLabelText
- MatStyle 
- MatTextBox

Ejemplo en código:

```java
public class PatStyle {
    public static final Color COLOR_FONT = new Color(191,120,82);
    public static final Color COLOR_FONT_LIGHT = new Color(100,100,100);
    public static final Color COLOR_CURSOR = Color.black;
    public static final Color COLOR_BORDER = new Color(50,50,50);
    public static final Font FONT = new Font("JetBrainsMono", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("JetBrainsMono", Font.BOLD | Font.PLAIN, 14);
    public static final Font FONT_SMALL = new Font("JetBrainsMono", Font.BOLD | Font.PLAIN, 14);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;
    
    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);
}
```

```java
public class PatLabel extends JLabel{
    public PatLabel(){
        customizeComponent();
    }

    public PatLabel (String text){
        setText(text);
        customizeComponent();
    }

    private void customizeComponent (){
        setCustomizeComponent(getText(), PatStyle.FONT, PatStyle.COLOR_FONT_LIGHT, PatStyle.ALIGNMENT_LEFT);
    }

    public void setCustomizeComponent(String text, Font font, Color color, int alignment){
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);;
    }
}
```

![imagen 92](92.png)

**Conexión de BL con GUI**

***Paginación:*** Se refiere a una técnica utilizada para dividir y presentar grandes conjuntos de datos de manera organizada y manejable, especialmente en aplicaciones que muestran listas o tablas de datos.

Ejemplo en código:

```java
public class PatPnlSexo extends JPanel implements ActionListener{
    private Integer idSexo, idMaxSexo;
    private SexoBL  sexoBL  = null;
    private SexoDTO   sexo  = null;

    public PatPnlSexo() throws Exception{
        setGridBagLayout();
        loadData();
        showData();
        showTable();

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
        btnGuardar.addActionListener(this);

        // Otra forma de poner escuchadores
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   btnNuevoClick(e);   }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnEliminarClick(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }   
            }
        });
    }
    
    private void loadData() throws Exception {
        idSexo      = 1;
        sexoBL      = new SexoBL();
        sexo        = sexoBL.getBy(idSexo);
        //idMaxSexo   = sexoBL.getMaxIdSexo();
    }

    private void showData() {
        boolean sexoNull = (sexo == null);
        txtIdSexo.setText((sexoNull) ? " " : sexo.getIdSexo().toString());            
        txtNombre.setText((sexoNull) ? " " : sexo.getNombre());
        //lblTotalReg.setText(idSexo.toString() + " de " + idMaxSexo.toString());
    }

    private void btnNuevoClick(ActionEvent e) {
        sexo = null;
        showData();
    } 
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!sexoBL.delete(sexo.getIdSexo()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!", "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
    private void btnGuardarClick(ActionEvent e) throws HeadlessException, Exception {
        boolean sexoNull = (sexo == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (sexoNull)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            loadData();
            showData();
            showTable();
        }
    } 

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[sexoBL.getAll().size()][3];  
        int index = 0;
        for(SexoDTO s : sexoBL.getAll()) {
            data[index][0] = s.getIdSexo();
            data[index][1] = s.getNombre();
            data[index][2] = s.getEstado();
            index++;
        }
        
        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        //table.setBorder(border);
        // pnlTabla.setBorder( BorderFactory.createTitledBorder(
        //                     BorderFactory.createEtchedBorder(), " SEXO ", TitledBorder.CENTER, TitledBorder.TOP));
      
        pnlTabla.removeAll();
        pnlTabla.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
          
                int col = 0;
                int row = table.getSelectedRow();
                String strIdSexo = table.getModel().getValueAt(row, col).toString();

                idSexo = Integer.parseInt(strIdSexo);
                try {
                    sexo    = sexoBL.getBy(idSexo);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + strIdSexo);
            }
        });
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idSexo  = 1;
        if(e.getSource() == btnAnt  &&  (idSexo>1) )
            idSexo--;
        if(e.getSource() == btnSig  &&  (idSexo<idMaxSexo))
            idSexo++;
        if(e.getSource() == btnFin)
            idSexo = idMaxSexo;
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private PatLabel  
            lblTitulo  = new PatLabel("SEXO"          ),
            lblIdSexo  = new PatLabel("Codigo:      " ),
            lblNombre  = new PatLabel("Descripción: " ),
            lblTotalReg= new PatLabel("  0 de 0  "    );
    private PatTextBox  
            txtIdSexo  = new PatTextBox (),
            txtNombre  = new PatTextBox ();
    private PatButton  
            btnIni     = new PatButton(" |< "), 
            btnAnt     = new PatButton(" << "),            
            btnSig     = new PatButton(" >> "),
            btnFin     = new PatButton(" >| ");
    private PatButton
            btnNuevo   = new PatButton("Nuevo"),            
            btnGuardar = new PatButton("Guardar"),
            btnCancelar= new PatButton("Cancelar"),
            btnEliminar= new PatButton("Eliminar");
    private JPanel 
            pnlTabla   = new JPanel(),
            pnlBtnCRUD = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
            line       = new LineBorder(Color.lightGray),
            margin     = new EmptyBorder(5, 5, 5, 5),
            border     = new CompoundBorder(line, margin);
    
/************************
 * Customize : Form
 ************************/ 
    public void setGridBagLayout(){
        //setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        txtIdSexo.setEnabled(false);
        
        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(new PatLabel(" Page: [ "));      
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(new PatLabel(" ] "));      
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Panel.CRUD
        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        // GridBagConstraints.Separación entre componentes
        gbc.insets=new Insets(5,5,5,5);    
        
        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=3;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 1;       gbc.gridx=0;   
        gbc.gridwidth=1;                     
        add(new JLabel("■ Sección de datos: "), gbc);                 

        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   //| celdas a unir
        gbc.ipady = 150;                   //| tamaño alto
        gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        pnlTabla.add(new Label("Loading data..."));
        //pnlTabla.setBorder(border);
        add(pnlTabla, gbc);
        
        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;
        
        gbc.gridy = 3;       gbc.gridx=0;   
        gbc.gridwidth=3;  
        add(pnlBtnPage, gbc);  

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
        add(new JLabel("■ Sección de registro: "), gbc);  

        gbc.gridy = 5;       gbc.gridx=0;     add(lblIdSexo,  gbc);   
        gbc.gridy = 5;       gbc.gridx=1;     add(txtIdSexo,  gbc);   

        gbc.gridy = 6;       gbc.gridx=0;     add(lblNombre, gbc);        
        gbc.gridy = 6;       gbc.gridx=1;     add(txtNombre, gbc);
        gbc.gridy = 6;       gbc.gridx=2;     add(new JLabel("*"), gbc);  

        gbc.gridy = 7;       gbc.gridx=0;
        gbc.gridwidth=3;
        gbc.insets    = new Insets(30,0,0,0); 
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }

}
```

![imagen 94](94.png)

**Manejo de excepciones**

El manejo de excepciones es un concepto fundamental en la programación que se refiere a la forma en que un programa detecta, informa y maneja situaciones excepcionales o inesperadas que pueden ocurrir durante su ejecución. Estas situaciones pueden incluir errores de programación, condiciones imprevistas, fallos en el hardware o cualquier otro evento que pueda causar que el programa no funcione correctamente.

La gestión de errores es una capa vertical, puesto que se pueden presentar en el DAC, BL o GUI. En este caso los errores deben guardarse en un archivo y presentar un mensaje especial para el usuario, ya que no debemos dar toda la información del error o de los errores al usuario, el cual puede ser un hacker.

![imagen 95](95.png)

***LOG***

El "LOG" (registro) se refiere al registro de información sobre las excepciones que ocurren durante la ejecución de un programa. Cuando una excepción es lanzada, es importante registrar detalles relevantes sobre la excepción para el análisis posterior y la resolución de problemas.

En una capa llamada Framework, se diseña la manera de gestionar las excepciones.

Ejemplo de un manejo de excepciones:

```java
public class PatException extends Exception {

    public PatException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN IABot para el lOG] " + clase +"."+ metodo +" : "+ e );
    }
    
    @Override
    public String getMessage(){
        return "no seas sapo :)";
    }
}
```



## Clase # 40
    Fecha: 23 de febrero del 2024
-------
### <span style="color:turquoise"></span>


