public class App{
    public static void main(String[] args) {
        //Creamos un objeto de la clase mujer 
        
        mujer oMujer1, oMujer2; //Declaración 

        oMujer1 = new mujer("Ana"); //Instanciación
        
        System.out.println("---- Mujer 1 ----");
        //oMujer1.nombre = "Sofía";
        oMujer1.saludar();
        oMujer1.cantar();
        oMujer1.bailar();

        System.out.println("---- Mujer 2 ----");
        oMujer2 = new mujer("Juana");
        oMujer2.saludar();
        oMujer2.cantar();
        oMujer2.bailar();
    }
}