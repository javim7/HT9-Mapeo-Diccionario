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
