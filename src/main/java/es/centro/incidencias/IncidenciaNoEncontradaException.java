package es.centro.incidencias;

/**
 * Excepción que se produce cuando no se encuentra una incidencia
 * con el identificador especificado.
 *
 * @author Profesor
 * @version 1.0
 */
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * Construye una excepción indicando que no existe una incidencia
     * con el identificador proporcionado.
     *
     * @param id identificador de la incidencia que no se ha encontrado
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}
