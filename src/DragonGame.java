import java.util.Scanner;

public class DragonGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcionJinete1;
        int opcionJinete2;
        
        // Creación de jinetes y dragones
        Jinete[] jinetes = new Jinete[6];
        jinetes[0] = new Jinete("Hipo", 100, "Masculino", "Chimuelo");
        jinetes[1] = new Jinete("Astrid", 100, "Femenino", "Tormenta");
        jinetes[2] = new Jinete("Patán", 100, "Masculino", "Colmillo");
        jinetes[3] = new Jinete("Brutacio", 100, "Masculino", "Eructo y Guácara");
        jinetes[4] = new Jinete("Brutilda", 100, "Femenino", "Eructo y Guácara");
        jinetes[5] = new Jinete("Patapez", 100, "Masculino", "Albóndiga");

        Dragon[] dragones = new Dragon[6];
        dragones[0] = new Dragon("Chimuelo", 100, 15, "Disparos de Plasma", 22);
        dragones[1] = new Dragon("Tormenta", 100, 13, "Espinas Venenosas", 20);
        dragones[2] = new Dragon("Colmillo", 100, 15, "Explosiones", 19);
        dragones[3] = new Dragon("Eructo y Guácara", 100, 12, "Ruedas de Fuego", 18);
        dragones[4] = new Dragon("Eructo y Guácara", 100, 12, "Ruedas de Fuego", 18);
        dragones[5] = new Dragon("Albóndiga", 100, 8, "Piedras fundidas", 17);


        System.out.println(";\r\n" + //
        "██████╗ ██╗███████╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗██╗██████╗  ██████╗ ███████╗\r\n" + //
        "██╔══██╗██║██╔════╝████╗  ██║██║   ██║██╔════╝████╗  ██║██║██╔══██╗██╔═══██╗██╔════╝\r\n" + //
        "██████╔╝██║█████╗  ██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║██║██║  ██║██║   ██║███████╗\r\n" + //
        "██╔══██╗██║██╔══╝  ██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║██║  ██║██║   ██║╚════██║\r\n" + //
        "██████╔╝██║███████╗██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║██║██████╔╝╚██████╔╝███████║\r\n" + //
        "╚═════╝ ╚═╝╚══════╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝╚═╝╚═════╝  ╚═════╝ ╚══════╝\r\n" + //
        "                                                                                    \r\n" + //
        "");

        // Selección de personajes por parte de los jugadores
        // Mostrar opciones de jinetes
        System.out.println("Jugador 1, elige tu Jinete (número del 1 al " + jinetes.length + "):");
        for (int i = 0; i < jinetes.length; i++) {
        System.out.println((i + 1) + ". " + jinetes[i].getNombre() + " con dragón " + jinetes[i].dragon);
        }

        opcionJinete1 = scanner.nextInt() - 1;
        
        do {
            System.out.println("Jugador 2, elige tu Jinete (no puedes elegir el mismo):");
            for (int i = 0; i < jinetes.length; i++) {
                if (i != opcionJinete1) {
                    System.out.println((i + 1) + ". " + jinetes[i].getNombre() + " con dragón " + jinetes[i].dragon);
                }
            }
        opcionJinete2 = scanner.nextInt() - 1;
        } while (opcionJinete2 == opcionJinete1);

        // Inicializar personajes
        Jinete jinete1 = jinetes[opcionJinete1];
        Jinete jinete2 = jinetes[opcionJinete2];
        Dragon dragon1 = dragones[opcionJinete1];
        Dragon dragon2 = dragones[opcionJinete2];

        System.out.println("Jugador 1 eligió: " + jinete1.getNombre() + " con dragón " + dragon1.getNombre());
        System.out.println("Jugador 2 eligió: " + jinete2.getNombre() + " con dragón " + dragon2.getNombre());

        boolean turnoJugador1 = true;
        while (jinete1.estaVivo() && jinete2.estaVivo()) {
            System.out.println("¿Qué deseas hacer?");

                    if (turnoJugador1) {
                        System.out.println("\nTurno del Jugador 1:");
                        System.out.println("1. Atacar");
                        System.out.println("2. Usar ataque especial");
                        System.out.println("3. Curar");
                        System.out.println("4. Volar/Esquivar");
                
                        int accion = scanner.nextInt();

                        switch (accion) {
                            case 1:
                                dragon1.atacar(jinete2);
                                break;
                            case 2:
                                dragon1.ataqueEspecial(jinete2);
                                break;
                            case 3:
                                dragon1.curar(jinete1, dragon1);
                                break;
                            case 4:
                                dragon1.volar(jinete1, dragon2);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }

                    } else {
                        System.out.println("\nTurno del Jugador 2:");
                        System.out.println("1. Atacar");
                        System.out.println("2. Usar ataque especial");
                        System.out.println("3. Curar");
                        System.out.println("4. Volar/Esquivar");
                        int accion = scanner.nextInt();

                        switch (accion) {
                            case 1:
                                dragon2.atacar(jinete1);
                                break;
                            case 2:
                                dragon2.ataqueEspecial(jinete1);
                                break;
                            case 3:
                                dragon2.curar(jinete2, dragon2);
                                break;
                            case 4:
                                dragon2.volar(jinete2, dragon1);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    }

                // Mostrar información de ambos
                jinete1.mostrarInfo();
                jinete2.mostrarInfo();
                
        turnoJugador1 = !turnoJugador1;  // Cambiar de turno
        }

        // Resultado final
        if (jinete1.estaVivo()) {
            System.out.println("¡Jugador 1 ha ganado la batalla!");
        } else {
            System.out.println("¡Jugador 2 ha ganado la batalla!");
        }

        scanner.close();
    }
}
