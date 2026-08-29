//
//import java.util.*;
//
//enum Outcome {
//    WIN, LOSS, DRAW
//}
//
//class Player {
//    public int playerId;
//    public String username;
//
//    public Player(int playerId, String username) {
//        this.playerId = playerId;
//        this.username = username;
//    }
//}
//
//class MatchResult {
//    public int playerId;
//    public int opponentId;
//    public Outcome outcome;
//    public int score;
//    public int timestamp;
//
//    public MatchResult(int playerId, int opponentId, Outcome outcome, int score, int timestamp) {
//        this.playerId = playerId;
//        this.opponentId = opponentId;
//        this.outcome = outcome;
//        this.score = score;
//        this.timestamp = timestamp;
//    }
//}
//
//class PlayerStats {
//    public int totalMatches;
//    public int wins;
//    public double winRate;
//
//    public PlayerStats(int totalMatches, int wins, double winRate) {
//        this.totalMatches = totalMatches;
//        this.wins = wins;
//        this.winRate = winRate;
//    }
//}
//
//class GameManager {
//    public Map<Integer, Player> players;
//    public List<MatchResult> matchResults;
//
//    public GameManager() {
//        players = new HashMap<>();
//        matchResults = new ArrayList<>();
//    }
//
//    public void addPlayer(Player player) {
//        players.put(player.playerId, player);
//    }
//
//
//    public void addMatchResult(MatchResult matchResult){
//        if(players.containsKey(matchResult.playerId)) {
//            matchResults.add(matchResult);
//        }
//    }
//
//    public List<List<Integer>> getRecentForm(int n){
//        List<List<Integer>> result = new ArrayList<>();
//        if(n<1) return result;
//
//        matchResults.sort((MatchResult m1, MatchResult m2) -> m2.timestamp - m1.timestamp);
//        for(Integer playerId : players.keySet()) {
//            int count = 0;
//            int points = 0;
//            for(MatchResult m : matchResults) {
//                if(m.playerId == playerId) {
//                    count++;
//                    if(m.outcome == Outcome.WIN) {
//                        points += 3;
//                    }
//                    else if(m.outcome == Outcome.DRAW) {
//                        points++;
//                    }
//                }
//                if(count == n)  break;
//            }
//            if(count==n){
//                result.add(new ArrayList<>(List.of(playerId, points)));
//            }
//        }
//
//        result.sort((o1, o2) -> {
//            if (o1.get(1).equals(o2.get(1))) {
//                return Integer.compare(o1.get(0), o2.get(0));
//            }
//            return Integer.compare(o2.get(1), o1.get(1));
//        });
//        return result;
//    }
//}
//
//public class QC4 {
//    public static void main(String[] args) {
//        testGetRecentForm_case1();
//        testGetRecentForm_case2();
//        System.out.println("All Tests Passed!");
//    }
//
//
//    static void testGetRecentForm_case1() {
//        System.out.println("Running testGetRecentForm_case1");
//        GameManager gm = new GameManager();
//        for (int pid : new int[]{1, 2, 3, 4}) {
//            gm.addPlayer(new Player(pid, "player" + pid));
//        }
//
//        // player 1: W W W -> 9 points
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN, 80, 1000));
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN, 80, 2000));
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN, 80, 3000));
//
//        // player 2: W D L -> 4 points
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.WIN,  80, 1000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.DRAW, 80, 2000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.LOSS, 80, 3000));
//
//        // player 3: 4 matches, last 3 = L L W -> 3 points
//        // older DRAW at timestamp 500 is outside the window and ignored
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.LOSS, 80, 1000));
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.WIN,  80, 3000));
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.DRAW, 80,  500));
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.LOSS, 80, 2000));
//
//        // player 4: only 2 matches, n=3 -> excluded
//        gm.addMatchResult(new MatchResult(4, 1, Outcome.WIN, 80, 1000));
//        gm.addMatchResult(new MatchResult(4, 1, Outcome.WIN, 80, 2000));
//
//        List<List<Integer>> result = gm.getRecentForm(3);
//        assert result.equals(Arrays.asList(
//                Arrays.asList(1, 9),
//                Arrays.asList(2, 4),
//                Arrays.asList(3, 3)
//        )) : "Expected [[1, 9], [2, 4], [3, 3]]";
//
//        // n=0 -> empty list
//        assert gm.getRecentForm(0).isEmpty() : "Expected empty list for n=0";
//    }
//
//    static void testGetRecentForm_case2() {
//        System.out.println("Running testGetRecentForm_case2");
//        GameManager gm = new GameManager();
//        for (int pid : new int[]{2, 1, 3, 4}) {
//            gm.addPlayer(new Player(pid, "player" + pid));
//        }
//
//        // player 1: 4 matches, last 3 = W W W -> 9 points
//        // older WIN at timestamp 500 is outside the window and ignored
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  80,  500));
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  80, 1000));
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  80, 2000));
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  80, 3000));
//
//        // player 2: exactly 3 matches, W W W -> 9 points
//        // tied with player 1 on points, tiebreak by playerId -> player 1 ranks higher
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.WIN, 80, 1000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.WIN, 80, 2000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.WIN, 80, 3000));
//
//        // player 3: only 2 matches, n=3 -> excluded
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.WIN, 80, 1000));
//        gm.addMatchResult(new MatchResult(3, 1, Outcome.WIN, 80, 2000));
//
//        // player 4: exactly 3 matches, L L L -> 0 points, included
//        gm.addMatchResult(new MatchResult(4, 1, Outcome.LOSS, 80, 1000));
//        gm.addMatchResult(new MatchResult(4, 1, Outcome.LOSS, 80, 2000));
//        gm.addMatchResult(new MatchResult(4, 1, Outcome.LOSS, 80, 3000));
//
//        List<List<Integer>> result = gm.getRecentForm(3);
//        // player 3 excluded - only 2 matches
//        // player 1 and 2 tied on 9 points, player 1 wins tiebreak (lower id)
//        // player 4 included with 0 points
//        assert result.equals(Arrays.asList(
//                Arrays.asList(1, 9),
//                Arrays.asList(2, 9),
//                Arrays.asList(4, 2)
//        )) : "Expected [[1, 9], [2, 9], [4, 0]]";
//    }
//}