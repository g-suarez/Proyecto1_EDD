
package proyecto1_edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 *
 * @author Gabriella
 */
public class Grafo {
    private Lista almacenes;
    public Grafo(Lista almacenes){
        this.almacenes = almacenes;
        
    }
        public void mostrar() {
        Graph graph = new SingleGraph("Almacenes");

        graph.setStrict(false);
        graph.setAutoCreate(true);
        graph.display();
        
        graph.setAutoCreate(true);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        graph.setAttribute("ui.stylesheet", "node { size-mode: fit; shape: rounded-box; fill-color: white; stroke-mode: plain; padding: 3px, 2px; }edge { shape: blob; size: 3px; fill-color: #444; }");
        Nodo aux = almacenes.getpFirst();
        do{
            
            graph.addEdge(aux.getEdges()[0]+aux.getEdges()[1], aux.getEdges()[0], aux.getEdges()[1]).setAttribute("length",aux.getEdges()[2] );
            if(aux.getEdges().length > 3){
                graph.addEdge(aux.getEdges()[3]+aux.getEdges()[4], aux.getEdges()[3], aux.getEdges()[4]).setAttribute("length",aux.getEdges()[5]);
            }
        for(Node node : graph){
                node.setAttribute("ui.label", node.getId());
            }
            aux = aux.getSiguiente();
        
            
    }while (aux != null);

       
       }
}
