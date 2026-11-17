// Estudiante: Michelle Ortiz

// Grafo no dirigido con Matriz de adyacencia.
public class GrafoNoDirigido {
    // Guarda las conexiones de las aristas: 1 significa que hay arista y 0 que no la hay.
    private final int[][] matriz;
    private final int cantidadVertices;

    public GrafoNoDirigido(int cantidadVertices) {
        // No se puede crear un grafo sin vértices.
        if (cantidadVertices <= 0) {
            throw new IllegalArgumentException(
                "El grafo debe tener al menos un vértice."
            );
        }

        this.cantidadVertices = cantidadVertices;
        // La matriz cuadrada tiene una fila y una columna por vértice.
        this.matriz = new int[cantidadVertices][cantidadVertices];
    }

    // Conecta dos vértices y guarda la conexión en ambos sentidos.
    public void agregarArista(int origen, int destino) {
        validarVertice(origen);
        validarVertice(destino);

        matriz[origen][destino] = 1;
        matriz[destino][origen] = 1;
    }

    // Indica si existe una conexión entre los dos vértices.
    public boolean hayArista(int origen, int destino) {
        validarVertice(origen);
        validarVertice(destino);
        return matriz[origen][destino] == 1;
    }

    // Devuelve cuántos vértices tiene el grafo.
    public int getCantidadVertices() {
        return cantidadVertices;
    }

    // Muestra la matriz de adyacencia en la consola.
    public void imprimirMatriz() {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    // Comprueba que el número del vértice pertenezca al grafo.
    public void validarVertice(int vertice) {
        if (vertice < 0 || vertice >= cantidadVertices) {
            throw new IllegalArgumentException(
                "Vértice fuera de rango: " + vertice
            );
        }
    }
}