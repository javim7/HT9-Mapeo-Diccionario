import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    @Test
    void containsKey() {

        SplayTree<String, String> Splay= new SplayTree<>();

        String clave = "town";
        String valor = "pueblo";
        Splay.put(clave, valor);

        boolean expected = true;
        boolean result = Splay.containsKey(clave);

        assertEquals(expected, result);

    }

    @Test
    void put() {

        SplayTree<String, String> Splay= new SplayTree<>();

        String clave = "town";
        String valor = "pueblo";

        String expected = null;
        String result = Splay.put(clave,valor);

        assertEquals(expected, result);

    }
}