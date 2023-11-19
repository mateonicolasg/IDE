public class mujer {
    
    //Atributos de la clase mujer
    private String nombre;
    private int edad;
    private float altura;

    //Constructor de la clase mujer
    public mujer (String nombre){
        this.nombre = nombre;
        this.edad = 19;
        this.altura = 1.50f;
    }
    
    //Métodos 
    public void saludar (){
        System.out.println("Hola, soy una mujer y me llamo " + nombre);
    }
    public void cantar (){
        System.out.println("Canto con una voz suave y melodiosa");
    }
    public void bailar (){
        System.out.println("Bailo con pasos elegantes  y lindos movimientos");
    }
}