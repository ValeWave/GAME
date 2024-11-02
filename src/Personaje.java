import java.util.Random;

public class Personaje {

    Random random = new Random();

    protected String nombre;
    protected int vida_hp;
    protected boolean vivo; 

    // Constructor
    public Personaje(String nombre, int vida_hp) {
        this.nombre = nombre;
        this.vida_hp = vida_hp;
        this.vivo = vida_hp > 0; 
    }

    //getters 
    public String getNombre() {
        return nombre;
    }

    public int getVida_hp() {
        return vida_hp;
    }

    //Metodos
    public boolean isVivo() {
        return vivo;
    }

    public void recibirDano(int dano) {
        this.vida_hp -= dano;
        if (this.vida_hp <= 0) {
            this.vida_hp = 0;  
            this.vivo = false; // personaje desvivido
        }
    }

    public int probabilidad(){
        double random = Math.random();// generamos un numero al azar entre 0 y 1
        
        if(random < 0.8) {// el 80% de las veces

            return 80;

        } else {// el 20% restante

            return 20;
        }
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Vida: " + vida_hp);
    }
}


