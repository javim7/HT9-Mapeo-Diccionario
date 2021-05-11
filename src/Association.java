//Referencia de la clase Association
// A class for binding key/value pairs.
// (c) 1998,2001 duane a. bailey

import java.util.Map;

/*
 * </pre>
 * @version $Id: Association.java 34 2007-08-09 14:43:44Z bailey $
 * @author, 2001 duane a. bailey
 */

public class Association<K,V> implements MapEntry<K,V>
{
    /**
     * The immutable key.  An arbitrary object.
     */
    protected K theKey; // the key of the key-value pair
    /**
     * The mutable value.  An arbitrary object.
     */
    protected V theValue; // the value of the key-value pair

    protected V theValue2; // the value of the key-value pair

    /*
      for example:
      Association<String,Integer> personAttribute =
         new Assocation<String,Integer>("Age",34);
     */
    /**
     * Constructs a pair from a key and value.
     *
     * @pre key is non-null
     * @post constructs a key-value pair
     * @param key A non-null object.
     * @param value A (possibly null) object.
     */
    public Association(K key, V value)
    {
        
        theKey = key;
        theValue = value;
    }

    Map<K, V> diccionario;
    public Association(Map<K, V> diccionario) {
        this.diccionario = diccionario;
    }


    /**
     * Constructs a pair from a key; value is null.
     *
     * @pre key is non-null
     * @post constructs a key-value pair; value is null
     * @param key A non-null key value.
     */
    public Association(K key)
    {
        this(key,null);
    }

    /**
     * Standard comparison function.  Comparison based on keys only.
     *
     * @pre other is non-null Association
     * @post returns true iff the keys are equal
     * @param other Another association.
     * @return true iff the keys are equal.
     */
    public boolean equals(Object other)
    {
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    /**
     * Standard hashcode function.
     *
     * @post return hash code association with this association
     * @return A hash code for association.
     * @see Hashtable
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }
    
    /**
     * Fetch value from association.  May return null.
     *
     * @post returns value from association
     * @return The value field of the association.
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Checks if a word is in the dictionary
     * @param englishWord word in English
     * @return boolean if it contains the word
     */
    public boolean containsWord(K englishWord) {

        if(diccionario.get(englishWord) != null){
            return true;
            
        } else {
            return false;
        }
    }

    /**
     * Gets the word in Spanish from an English word
     * @param englishWord word in english
     * @return the word in Spanish of word in english with asterisks if not found
     */
    public String getSpanishWord(K englishWord) {

        if(containsWord(englishWord)) {
            return (String) diccionario.get(englishWord);

        } else {
            return "*" + englishWord.toString() + "* ";
        }
    }

    /**
     * Fetch key from association.  Should not return null.
     *
     * @post returns key from association
     * @return Key of the key-value pair.
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Sets the value of the key-value pair.
     * 
     * @param english palabra en ingles.
     * @param spanish palabra en espanol
     * 
     */
    public void addEntry(K english, V spanish) {
        diccionario.put(english, spanish);
    }

    /**
     * Sets the value of the key-value pair.
     *
     * @post sets association's value to value
     * @param value The new value.
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * Standard string representation of an association.
     *
     * @post returns string representation
     * @return String representing key-value pair.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append(" ("+getKey()+", "+getValue() + ") ");
        return s.toString();
    }
    /*
...
*/
}
