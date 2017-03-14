package ua.pvl;

import java.util.*;

public class MapSort {




    public static Map sortByValue(Map unsortedMap){
        List list = new LinkedList(unsortedMap.entrySet());

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public Map<String,Integer> leftOnlyGivenNumberOfWords(Map<String, Integer> listOfWords, int numberOfWords) {

        int itemNum = numberOfWords;

        Map<String, Integer> hm = listOfWords;

        for (int i = 0; i < (hm.size() - itemNum); i++) {
            for(Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Integer> entry = it.next();
                if (hm.size() - itemNum > i) {
                    it.remove();
                }
            }
        }
        return listOfWords;
    }
}
