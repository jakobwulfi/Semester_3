package opg4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Holme","Skåde", "Viby", "Beder", "Stautrup",
                "Engdal", "Forældreskolen", "Malling"));
        SearchPattern searcher = new SearchableList<>(list);
        System.out.println(searcher.search("Malling"));
        System.out.println(searcher.search("Riisskov"));
        System.out.println();

        System.out.println("Binary");
        SearchPattern binary = new SearchableListBinary(list);
        System.out.println(binary.search("Malling"));
        System.out.println(binary.search("Riisskov"));
    }
}
