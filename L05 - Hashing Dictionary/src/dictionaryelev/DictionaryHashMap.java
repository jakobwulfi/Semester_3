package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static int N = 13;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<K, V>();
        }
    }

    @Override
    public V get(K key) {
        //TODO
        return null;
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return false;
    }

    @Override
    public V put(K key, V value) {
        // TODO
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }

}
