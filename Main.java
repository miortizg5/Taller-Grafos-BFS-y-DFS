public class Main {
    public static void main(String[] args) {
        // Creación de un grafo no dirigido con 5 vértices.
        GrafoNoDirigido grafo = new GrafoNoDirigido(5);

        // Agrega las conexiones.
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);

        // Crea los dos algoritmos de recorrido
        BusquedaDFS dfs = new BusquedaDFS(grafo);
        BusquedaBFS bfs = new BusquedaBFS(grafo);

        // Muestra la matriz y los recorridos iniciando en el vértice 0.
        System.out.println("Matriz de adyacencia:");
        grafo.imprimirMatriz();

        System.out.println("DFS desde 0: " + dfs.recorrer(0));
        System.out.println("BFS desde 0: " + bfs.recorrer(0));
    }
}