// Estudiante: Michelle Ortiz
import java.util.ArrayList;
import java.util.List;

// Implementa la búsqueda en profundidad usando llamadas recursivas.
public class BusquedaDFS {
    private final GrafoNoDirigido grafo; // Guarda el grafo que se va a recorrer.

    // Recibe el grafo que se va a recorrer.
    public BusquedaDFS(GrafoNoDirigido grafo) {
        this.grafo = grafo;
    }

    // Inicia el recorrido y devuelve los vértices en el orden visitado.
    public List<Integer> recorrer(int inicio) {
        grafo.validarVertice(inicio);
        boolean[] visitados = new boolean[grafo.getCantidadVertices()];
        List<Integer> recorrido = new ArrayList<>();
        recorrerRecursivamente(inicio, visitados, recorrido);
        return recorrido;
    }

    // Visita un vértice y luego explora sus vecinos no visitados.
    private void recorrerRecursivamente(
        int vertice,
        boolean[] visitados,
        List<Integer> recorrido
    ) {
        // Se marca antes de explorar para no volver a visitarlo.
        visitados[vertice] = true;
        recorrido.add(vertice);

        for (int vecino = 0; vecino < grafo.getCantidadVertices(); vecino++) {
            // Si hay conexión y el vecino es nuevo, continúa por ese camino.
            if (grafo.hayArista(vertice, vecino) && !visitados[vecino]) {
                recorrerRecursivamente(vecino, visitados, recorrido);
            }
        }
    }
}
