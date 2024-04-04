import java.util.ArrayList;

public class DictionaryDoubleHashing <K, V> implements Dictionary<K, V> {
    private Entry<K,V>[] table;
    private int size;

   private final Entry DELETED = new Entry(null,null);

    public DictionaryDoubleHashing(int length) {
        table =  new Entry[length];
        size = 0;
    }
    public DictionaryDoubleHashing() {
        table = new Entry[10];
        size = 0;
    }

    @Override
    public V get(K key) {
        V value = null;
        int j = 0;
        int index = hashingExtended(key, j);
        boolean found = false;
        while (!found && j < size) {
            if (table[index].getKey().equals(key)){
                found = true;
                value = table[index].getValue();
            } else {
                j++;
                index = hashingExtended(key, j);
            }
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Value or Key is null.");
        }
        Entry<K, V> entry = new Entry(key, value);
        V oldValue = null;
        int j = 0;
        int index = hashingExtended(key, j);
        boolean inserted = false;
        while (!inserted) {
            if (table[index].equals(null)) {
                table[index] = entry;
                size++;
                inserted = true;
            } else if (table[index].getKey().equals(key)) {
                oldValue = table[index].getValue();
                table[index].setValue(value);
                inserted = true;
            } else {
                j++;
                index = hashingExtended(key, j);
            }
        }

        if (size/table.length >= 0.5) {
            reHash();
        }

        return oldValue;
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null.");
        }
        V oldValue = null;
        int j = 0;
        int index = hashingExtended(key, j);
        boolean removed = false;
        if (DELETED.getKey().equals(key)) {
            return oldValue;
        }

        while (!removed) {
            if (table[index].equals(null)) {
                removed = true;
            } else if (table[index].getKey().equals(key)) {
                oldValue = table[index].getValue();
                table[index] = null;
                size--;
                removed = true;
            } else {
                j++;
                index = hashingExtended(key, j);
            }
        }
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(K key) { // Bruges egentlig ikke men rar for at se hvordan hashCoden defineres
        return key.hashCode() % size;
    }
    private int hash2(K key) {
        return 7 - (key.hashCode() % 7);
    }
    private int hashingExtended(K key, int j) {
        return (key.hashCode() + j * hash2(key)) % size;
    }
    private ArrayList<Entry<K,V>> getEntries() {
        ArrayList<Entry<K,V>> entries = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!table[i].equals(null)) {
                entries.add(table[i]);
            }
        }
        return entries;
    }
    private void reHash() {
        ArrayList<Entry<K,V>> entries = getEntries();
        size = 0;
        table = new Entry[table.length * 2];
        for (Entry<K,V> entry : entries) {
            put(entry.getKey(), entry.getValue());
        }
    }

    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public String toString(){
            return "(" +key + " , " + value + ")";
        }
    }
}
