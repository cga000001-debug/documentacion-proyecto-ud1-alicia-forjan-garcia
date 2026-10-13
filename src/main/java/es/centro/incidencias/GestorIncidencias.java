package es.centro.incidencias;

import java.util.List;

/**
 * Gestiona las incidencias del centro y permite consultarlas,
 * filtrarlas y buscarlas por diferentes criterios.
 *
 * @author Profesor
 * @version 1.0
 */

public final class GestorIncidencias {

    /**
     * Lista de incidencias gestionadas por la aplicación.
     */
    private final List<Incidencia> incidencias;

    /**
     * Construye un gestor de incidencias e inicializa la lista
     * con varias incidencias de ejemplo.
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Devuelve la lista completa de incidencias.
     *
     * @return lista con todas las incidencias registradas
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Devuelve únicamente las incidencias que permanecen abiertas.
     *
     * @return lista de incidencias abiertas
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca las incidencias cuyo contenido coincide con el texto indicado.
     *
     * @param texto texto utilizado como criterio de búsqueda
     * @return lista de incidencias que coinciden con el texto
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca una incidencia a partir de su identificador.
     *
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param id identificador de la incidencia que se desea buscar
     * @return incidencia correspondiente al identificador indicado
     * @throws IncidenciaNoEncontradaException si no existe una incidencia
     *         con el identificador proporcionado
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }


    /**
     * Obtiene una incidencia por su identificador.
     *
     * Este método está obsoleto y se mantiene por compatibilidad.
     * Se recomienda utilizar {@link #buscarPorId(String)}, que informa
     * mediante una excepción cuando la incidencia no existe.
     *
     * @param id identificador de la incidencia que se desea obtener
     * @return incidencia encontrada o {@code null} si no existe
     * @deprecated Desde la versión 1.0.0. Utilizar {@link #buscarPorId(String)}.
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}
