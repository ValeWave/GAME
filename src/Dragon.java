public class Dragon extends Personaje {
    // Atributos únicos
    int poderDeAtaque;
    String ataqueEspecial;
    int poderAtaqueEspecial;

    // Constructor
    public Dragon(String nombre, int vida_hp, int poderDeAtaque, String ataqueEspecial, int poderAtaqueEspecial) {
        super(nombre, vida_hp);
        this.poderDeAtaque = poderDeAtaque;
        this.ataqueEspecial = ataqueEspecial;
        this.poderAtaqueEspecial = poderAtaqueEspecial;
    }

    //getters
    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getPoderAtaqueEspecial() {
        return poderAtaqueEspecial;
    }

    // Metodos
    public void atacar(Jinete oponente) {
        oponente.recibirDano(this.poderDeAtaque);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " y reduce su vida a " + oponente.getVida_hp());
    }


    public void volar(Jinete jugador, Dragon oponente) {
        if (probabilidad() == 80) { 
            int danoReducido = oponente.getPoderDeAtaque() / 2; 
            jugador.recibirDano(danoReducido);
            System.out.println(this.nombre + " vuela y esquiva parcialmente el ataque de " + oponente.getNombre());
        } else {
            System.out.println(this.nombre + " vuela y esquiva en el momento el ataque de " + oponente.getNombre());
        }
    }

    public void ataqueEspecial(Jinete oponente) {
        oponente.recibirDano(this.poderAtaqueEspecial);
        System.out.println(this.nombre + " usa su ataque especial: " + ataqueEspecial + " y causa " + poderAtaqueEspecial + " de daño a " + oponente.getNombre() + "!");
    }

    public void curar(Jinete jugador, Dragon dragon) {
        if (probabilidad() == 80) { 
            int curacion = dragon.getPoderDeAtaque() / 2;  // Basar la curación en la mitad del poder de ataque del dragón
            jugador.vida_hp += curacion;
            System.out.println(this.nombre + " se cura parcialmente y aumenta " + curacion + " puntos de vida.");
        } else {
            System.out.println("¡El daño ha sido grave y no has podido curarte!");
        }
    }

    public boolean estaVivo() {
        return this.vivo; 
    }
}