package opg4;

import java.util.List;

public class SearchableListBinary <E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int left;
    private int right;

    public SearchableListBinary(List<E> list){
        this.list = list;
    }

    @Override
    protected void init() {
        this.left = 0;
        this.right = list.size()-1;
    }

    @Override
    protected boolean isEmpty() {
        return left > right;
    }

    @Override
    protected E select() {
        return list.get((left + right)/2);
    }

    @Override
    protected void split(E m) {
        E k = select();
        int middle = (left + right)/2;
        if (m.compareTo(k) > 0) {
            right = middle -1;
        } else {
            left = middle + 1;
        }
    }
}
