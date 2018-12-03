
package modelo;


public class Excepciones {
    public static class CorredorYaInscrito extends Exception {

        public CorredorYaInscrito(String mensaje) {
            super(mensaje);
        }
    }

    public static class NoSeAdmitenMasParticipantes extends Exception {

        public NoSeAdmitenMasParticipantes(String mensaje) {
            super(mensaje);
        }
    }

    public static class CorredorRegistradoCarreras extends Exception {

        public CorredorRegistradoCarreras(String mensaje) {
            super(mensaje);
        }
    }
}
