import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
//        SafeStates sf = new SafeStates();
//        List<Integer> res = sf.eventualSafeNodes(graph);
//        System.out.println("result:: "+res.toString());


//        String a = "112";
//        RemoveKdigits402 rk = new RemoveKdigits402();
//        String resrk = rk.removeKdigits("112", 1);

//        System.out.println("result resrk: "+resrk);

//        Lt464Sec lt = new Lt464Sec();
//        Supplier<String> s = () -> "result: "+lt.canIWin(10, 11);
//        System.out.println(s.get());

//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        Lt4 lt = new Lt4();
//        Supplier<String> s = () -> "result: "+lt.findMedianSortedArrays(nums1, nums2);
//        System.out.println(s.get());


        //Lt3620
//        int[][] edges = {{1,4,62},{3,4,86},{1,3,37},{2,4,81},{2,3,84},{0,1,70},{1,2,69},{0,2,23}};
//        boolean[] online = {true,true,true,true,true};
//
//        Lt3620 lt = new Lt3620();
//        int res = lt.findMaxPathScore(edges, online, 131);
//
//        System.out.println("res:: "+res);


        //Lt1526
//        int[] target = {1,2,3,2,1};
//        Lt1526 lt1526 = new Lt1526();
//
//        int res = lt1526.minNumberOperations(target);
//        System.out.println("res: "+res);

        //Lt47;
//        int[] nums = {1, 1, 2};
//        Lt47 lt47 = new Lt47();
//        List<List<Integer>> res = lt47.permuteUnique(nums);
//        for(List<Integer> list : res){
//            System.out.println(list.toString());
//        }

//        Lt10
//        String s = "ab";
//        String p = ".*";
//        Lt10 lt10 =  new Lt10();
//        boolean result = lt10.isMatch(s, p);
//        System.out.println("result: "+result);

//        Lt522
//        String[] strs = {"aaa","aaa","aa"};
//        Lt522 lt = new Lt522();
//        int res = lt.findLUSlength(strs);
//        System.out.println("res: "+res);

//        Lt1012
//        Lt1012 lt1012 = new Lt1012();
//        int res = lt1012.numDupDigitsAtMostN(100);
//        System.out.println("res: "+res);

//        Lt1590
        int[] nums = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        Lt1590 lt1590 = new Lt1590();
        int res = lt1590.minSubarray(nums, 26);
        System.out.println("res: "+res);
    }
}