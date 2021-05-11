/**
 * @author Mariono Reyes
 * @author Javier Mombiela
 *
 * Factory.java esta es la clase eque se utilizo
 * para poder poder seleccionar la implementacion
 * del mapa a utilizar.
 *
 * */

public class Factory<K extends Comparable<K>, V> {
    public java.util.Map<K, V> getMap(int mapType) {
        switch (mapType) {
            case 1:
                return new SplayTree<K, V>();
            case 2:
                return new HashingMap<K, V>();
            default:
                return null;
        }
    }
}
