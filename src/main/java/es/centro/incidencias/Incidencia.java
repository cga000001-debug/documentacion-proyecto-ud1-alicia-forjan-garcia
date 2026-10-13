package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incidencia registrada en el sistema de gestión
 * de incidencias del centro.
 *
 * Contiene información sobre su identificador, título, prioridad
 * y estado de resolución.
 *
 * @author Profesor
 * @version 1.0
 */
public final class Incidencia {

    /**
     * Identificador único de la incidencia.
     */
    private final String id;
    /**
     * Título o descripción breve de la incidencia.
     */
    private final String titulo;
    /**
     * Nivel de prioridad de la incidencia.
     */
    private final String prioridad;
    /**
     * Indica si la incidencia permanece abierta.
     */
    private final boolean abierta;

    /**
     * Crea una incidencia con los datos especificados.
     *
     * @param id identificador de la incidencia
     * @param titulo título o descripción breve de la incidencia
     * @param prioridad nivel de prioridad de la incidencia
     * @param abierta {@code true} si la incidencia está abierta;
     *                {@code false} en caso contrario
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Obtiene el identificador de la incidencia.
     *
     * @return identificador de la incidencia
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el título de la incidencia.
     *
     * @return título de la incidencia
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la prioridad de la incidencia.
     *
     * @return nivel de prioridad de la incidencia
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Comprueba si la incidencia permanece abierta.
     *
     * @return {@code true} si está abierta; {@code false} si está cerrada
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Comprueba si el identificador o el título de la incidencia
     * contienen el texto indicado.
     *
     * La comparación no distingue entre mayúsculas y minúsculas.
     *
     * @param texto texto que se desea buscar
     * @return {@code true} si el identificador o el título contienen
     *         el texto indicado; {@code false} en caso contrario
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}
