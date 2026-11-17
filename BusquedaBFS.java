// Estudiante: Michelle Ortiz
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Implementa la búsqueda en anchura usando una cola FIFO.
public class BusquedaBFS {
    private final GrafoNoDirigido grafo; // Guarda el grafo que se va a recorrer.

    // Recibe el grafo que se va a recorrer.
    public BusquedaBFS(GrafoNoDirigido grafo) {
        this.grafo = grafo;
    }

    // Recorre el grafo por niveles desde el vértice indicado.
    public List<Integer> recorrer(int inicio) {
        grafo.validarVertice(inicio);
        boolean[] visitados = new boolean[grafo.getCantidadVertices()];
        List<Integer> recorrido = new ArrayList<>();
        Queue<Integer> cola = new ArrayDeque<>();

        // Marca y agrega el inicio para que no se encole otra vez.
        visitados[inicio] = true;
        cola.add(inicio);

        // Procesa los vértices en el orden en que entraron a la cola.
        while (!cola.isEmpty()) {
            int actual = cola.remove();
            recorrido.add(actual);

            for (int vecino = 0; vecino < grafo.getCantidadVertices(); vecino++) {
                // Marca al descubrir y encola cada vecino solo una vez.
                if (grafo.hayArista(actual, vecino) && !visitados[vecino]) {
                    visitados[vecino] = true;
                    cola.add(vecino);
                }
            }
        }

        return recorrido;
    }
}
