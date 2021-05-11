
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.Set;

public class HashingMap<K extends Comparable<K>, V> implements Map<K, V> {

    private HashMap<K, V> stringMap=new HashMap<>();
    public boolean valor;

    @Override
    public V put(K key, V value) {
        return stringMap.put(key, value);
    }

    @Override
    public boolean containsKey(K key) {
        return stringMap.containsKey(key);
    }

    @Override
    public V get(K key) {
        valor = stringMap.containsKey(key);
        if (valor==true){
            Association<K, V> word = new Association<K, V>(key, null);
            word.setValue(stringMap.get(key));
            return word.getValue();
        }else {
            return null;
        }
    }

    //métodos necesarios para hacer el override de la clase
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return stringMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return stringMap.get(key);
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(java.util.Map<? extends K, ? extends V> m) {
    }

    @Override
    public void clear() {
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return null;
    }
}
