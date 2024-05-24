package opg5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSequence<E> implements Sequence<E> {
    private List<E> list = new ArrayList<>();
    @Override
    public void add(E obj) {
        list.add(obj);
    }

    @Override
    public void addAll(Sequence<E> s) {
        Iterator<E> iterator = s.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    @Override
    public E head() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Sequence is empty");
        }
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public void tail() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Sequence is empty");
        }
        list.remove(0);
    }
}
