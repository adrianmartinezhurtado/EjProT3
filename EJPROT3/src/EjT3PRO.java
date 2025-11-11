import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class EjT3PRO {

    public void Ejercicio1(){
        int numeroSecreto = ThreadLocalRandom.current().nextInt(1, 51);
        int intentosMaximos = 7;
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Juego de Adivinar! ");
        System.out.println("He pensado un número entre 1 y 50. Tienes " + intentosMaximos + " intentos.");

        boolean haAcertado = false;

        for (int i = 1; i <= intentosMaximos; i++) {
            System.out.print("Intento " + i + ": Introduce tu número: ");
            int numeroUsuario = scanner.nextInt();

            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Felicidades! Has acertado el número en " + i + " intentos.");
                haAcertado = true;
                break;
            }
            else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número secreto es MAYOR. Vuelve a intentarlo.");
            } else {
                System.out.println("El número secreto es MENOR. Vuelve a intentarlo.");
            }
        }

        if (!haAcertado) {
            System.out.println("¡Oh no! Has agotado tus " + intentosMaximos + " intentos.");
            System.out.println("El número secreto era: " + numeroSecreto);
        }

        scanner.close();
    }
    public void Ejercicio2() {
        String[] palabras = {"TECLA", "PLUMA", "MANGO", "LIBRO", "FAROL", "REINA", "SONAR", "CARTA", "FUEGO", "NUBES"};
        int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, palabras.length);
        String palabraSecreta = palabras[indiceAleatorio];

        int intentosMaximos = 5;
        boolean haGanado = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al Wordle! Adivina la palabra de 5 letras.");

        for (int i = 1; i <= intentosMaximos; i++) {
            System.out.println("\n--- Intento " + i + " de " + intentosMaximos + " ---");
            System.out.print("Introduce tu palabra: ");

            String palabraUsuario = scanner.nextLine().toUpperCase();

            if (palabraUsuario.length() != 5) {
                System.out.println("Error: La palabra debe tener 5 letras. Pierdes un intento.");
                continue;
            }

            if (palabraUsuario.equals(palabraSecreta)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                haGanado = true;
                break;
            }

            int aciertos = 0;
            int aproximaciones = 0;

            boolean[] secretaUsada = new boolean[5];
            boolean[] usuarioUsada = new boolean[5];

            for (int j = 0; j < 5; j++) {
                if (palabraUsuario.charAt(j) == palabraSecreta.charAt(j)) {
                    aciertos++;
                    secretaUsada[j] = true;
                    usuarioUsada[j] = true;
                }
            }

            for (int j = 0; j < 5; j++) {
                if (usuarioUsada[j]) {
                    continue;
                }

                for (int k = 0; k < 5; k++) {
                    if (!secretaUsada[k] && palabraUsuario.charAt(j) == palabraSecreta.charAt(k)) {
                        aproximaciones++;
                        secretaUsada[k] = true;
                        break;
                    }
                }
            }

            int fallos = 5 - aciertos - aproximaciones;

            System.out.println(" -> Aciertos (Posición correcta): " + aciertos);
            System.out.println(" -> Aproximaciones (Letra correcta, pos. incorrecta): " + aproximaciones);
            System.out.println(" -> Fallos (Letra incorrecta): " + fallos);
        }

        if (!haGanado) {
            System.out.println("\n¡Has perdido! Te has quedado sin intentos.");
            System.out.println("La palabra secreta era: " + palabraSecreta);
        }

        scanner.close();
    }

}

