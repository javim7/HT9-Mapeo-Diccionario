import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class HashingMapTest {

    @Test
    void put() {

        HashMap<String, String> stringMap=new HashMap<>();

        String clave = "woman";
        String valor = "mujer";

        String result = stringMap.put(clave, valor);

        assertEquals("mujer", result);

    }

    @Test
    void containsKey() {
    }

    @Test
    void get() {
    }
}