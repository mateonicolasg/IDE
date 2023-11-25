public class Bucles {
    // Declaramos las propiedades que vamos a utilizar en el bucle for, while, doWhile
    private int nroTerminos;
    
    // Constructor
    public Bucles(int nroTerminos){
     this.nroTerminos = nroTerminos;
    }

    //Mandarina
    public void showFor(){
        System.out.println("Ejecutando ciclo For");
        for (int i = 0; i < nroTerminos; i++) {
            System.out.println("For : " + i);
        }
    //Medio macho
        int contadorWhile = 0;
        while(contadorWhile < nroTerminos){
            System.out.println("While " + contadorWhile++);
        };
    // Macho
        System.out.println("Ejecutando ciclo DoWhile");
        int contadorDoWhile = 0;
        do{
            System.out.println("DoWhile " + contadorDoWhile++);
        }while(contadorDoWhile < nroTerminos);
    }

    public static void main(String[] args) {
        // Bucles oBucles = new Bucles(5);
        // oBucles.showFor ();

        // Tipos de datos primitivos  --> Variables
        byte bin = 0;
        boolean b= true;
        char c = 'a';
        c =54; //Numero ASCII
        short edad = 3278;
        int num = 20;
        
        //cast (implícito o explícito)
        long l = 10L; //explícito
        float f = 10f; //explícito 
        double d = 10d;

        // Tipos de datos referencia --> Propiedades
        String cad = "Hola mateonicolasg";
        Long ll = 123L;
        Integer n = 23;
        Double dbl = 23.23;
        Float ff = 13.2f;
        Boolean boo = false;
        Character ch = 'x';
        String [] arr = {"uno", "dos", "tres"};

        //cast explícito
        ll = (long)n;
        dbl = (double)ff;

        //cast implícito
        n = n / 2; //11.5   

        //Conversiones (fuerza bruta)
        cad = n.toString();
        cad = ff.toString();    
        n = Integer.parseInt(cad);

        //Tipos de datos Objeto 
        // Persona oPersona = new Persona ("Juan", 23);
        // Mujer oMujer = new Mujer();
    }
}