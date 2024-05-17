package opg4;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int i;

    public SearchableList(List<E> list){
        this.list = list;
    }

    @Override
    protected void init() {
        this.i = 0;
    }

    @Override
    protected boolean isEmpty() {
        return list.size() < i;
    }

    @Override
    protected E select() {
        return list.get(i);
    }

    @Override
    protected void split(E m) {
        i++;
    }
}