import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashingMapTest {


    @Test
    void containsKey() {

        HashingMap<String, String> Hashing= new HashingMap<>();

        String clave = "woman";
        String valor = "mujer";
        Hashing.put(clave, valor);

        boolean expected = true;
        boolean result = Hashing.containsKey(clave);

        assertEquals(expected, result);

    }

    @Test
    void put() {

        HashingMap<String, String> Hashing= new HashingMap<>();

        String clave = "woman";
        String valor = "mujer";
        String expected = null;

        String result = Hashing.put(clave, valor);

        assertEquals(expected, result);

    }

}