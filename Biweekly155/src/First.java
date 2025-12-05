import java.util.*;
import java.util.stream.Collectors;

public class First {
    public String findCommonResponse(List<List<String>> responses) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<responses.size(); i++){
            Set<String> currSet = new HashSet<>();
            for(int j=0; j<responses.get(i).size(); j++){
                if(!currSet.contains(responses.get(i).get(j))) {
                    currSet.add(responses.get(i).get(j));
                    hm.put(responses.get(i).get(j), hm.getOrDefault(responses.get(i).get(j), 0) + 1);
                }
            }
        }

        int res = 0;

        String ans = "";

        for(String st : hm.keySet()){
            if(hm.get(st)>res){
                ans = st;
            }
        }

        return ans;

//        List<List<String>> result = responses.stream()
//                .map(innerList -> innerList.stream()
//                        .distinct()
//                        .collect(Collectors.toList()))
//                .toList();
//
//        List<String> result2 = responses.stream()
//                .flatMap(innerList -> innerList.stream().distinct())
//                .distinct() // remove duplicates across all lists
//                .toList();
//        return "";
    }
}
