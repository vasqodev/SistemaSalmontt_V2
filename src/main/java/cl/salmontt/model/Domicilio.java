package  cl.salmontt.model;

public class Domicilio {
    private String comuna;
    private String calle;
    private int numero;

    public  Domicilio(String comuna, String calle, int numero) {
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return calle + " #" + ", " + comuna;
    }
   
}