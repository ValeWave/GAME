public class Jinete extends Personaje {

    //Atributos unicos
    String genero;
    String dragon;

    // Constructor
    public Jinete(String nombre, int vida_hp, String genero, String dragon) {
        super(nombre, vida_hp);
        this.genero = genero;
        this.dragon = dragon;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida_hp() {
        return this.vida_hp;
    }
    
    // Metodos
    public void montar(Dragon dragon) {
        System.out.println(this.nombre + " monta a " + dragon.getNombre());
    }

    public boolean estaVivo() {
        return this.vivo; 
    }
}