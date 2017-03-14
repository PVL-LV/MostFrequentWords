package ua.pvl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    //new code
    public Map<String,Integer> leftOnlyGivenNumberOfWords(Map<String, Integer> listOfWords, int numberOfWords) {

        int itemNum = numberOfWords;

        // code to left only necessary number of most frequent words in map


        for (int i = 0; i > itemNum; i++) {

        }


            return listOfWords;
    }
}
