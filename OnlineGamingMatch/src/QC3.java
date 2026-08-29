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
//class HeadToHead {
//    int winsPlayer1;
//    int winsPlayer2;
//    int draws;
//    int totalMatches;
//    Outcome lastResult;
//    Integer lastMatchTimestamp;
//
//    HeadToHead(int winsPlayer1, int winsPlayer2, int draws,
//               int totalMatches, Outcome lastResult, Integer lastMatchTimestamp) {
//        this.winsPlayer1 = winsPlayer1;
//        this.winsPlayer2 = winsPlayer2;
//        this.draws = draws;
//        this.totalMatches = totalMatches;
//        this.lastResult = lastResult;
//        this.lastMatchTimestamp = lastMatchTimestamp;
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
//    public void addMatchResult(MatchResult matchResult){
//        if(players.containsKey(matchResult.playerId)) {
//            matchResults.add(matchResult);
//        }
//    }
//
//
//    public HeadToHead getHeadToHead(int playerId1, int playerId2){
//        int player1Wins = 0;
//        int player2Wins = 0;
//        int draws = 0;
//        int totalMatches = 0;
//        Outcome lastMatchResult = null;
//        Integer lastMatchTimestamp = null;
//        for(MatchResult m : matchResults) {
//            if(m.playerId == playerId1 && m.opponentId == playerId2) {
//                totalMatches++;
//                if(m.outcome == Outcome.WIN) {
//                    player1Wins++;
//                }
//                else if(m.outcome == Outcome.LOSS) {
//                    player2Wins++;
//                }
//                else if(m.outcome == Outcome.DRAW) {
//                    draws++;
//                }
//                if(lastMatchTimestamp == null || lastMatchTimestamp < m.timestamp) {
//                    lastMatchTimestamp = m.timestamp;
//                    lastMatchResult = m.outcome;
//                }
//            }
//        }
//
//        return new HeadToHead(player1Wins, player2Wins, draws, totalMatches, lastMatchResult, lastMatchTimestamp);
//    }
//}
//
//public class QC3 {
//    public static void main(String[] args) {
//        testGetHeadToHead();
//        System.out.println("All Tests Passed!");
//    }
//
//    static void testGetHeadToHead() {
//        System.out.println("Running testGetHeadToHead");
//        GameManager gm = new GameManager();
//        gm.addPlayer(new Player(1, "player1"));
//        gm.addPlayer(new Player(2, "player2"));
//        gm.addPlayer(new Player(3, "player3"));
//
//        // match 4 - player1 wins (most recent)
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  85, 4000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.LOSS, 65, 4000));
//
//        // match 1 - player1 wins
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.WIN,  80, 1000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.LOSS, 50, 1000));
//
//        // match 2 - player2 wins
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.LOSS, 60, 2000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.WIN,  90, 2000));
//
//        // match 3 - draw
//        gm.addMatchResult(new MatchResult(1, 2, Outcome.DRAW, 70, 3000));
//        gm.addMatchResult(new MatchResult(2, 1, Outcome.DRAW, 70, 3000));
//
//
//        HeadToHead h2h = gm.getHeadToHead(1, 2);
//        assert h2h.winsPlayer1 == 2 : "Expected 2";           // match 1 + match 4
//        assert h2h.winsPlayer2 == 1 : "Expected 1";           // match 2 only
//        assert h2h.draws == 1 : "Expected 1";                  // match 3 only
//        assert h2h.totalMatches == 4 : "Expected 4";           // all 4 matches
//        assert h2h.lastResult == Outcome.WIN : "Expected WIN"; // match 4 was a WIN for player1
//        assert h2h.lastMatchTimestamp == 4000 : "Expected 4000";
//
//        // from player2's perspective
//        HeadToHead h2hReverse = gm.getHeadToHead(2, 1);
//        assert h2hReverse.winsPlayer1 == 1 : "Expected 1";              // player2 won match 2
//        assert h2hReverse.winsPlayer2 == 2 : "Expected 2";              // player1 won match 1 + 4
//        assert h2hReverse.draws == 1 : "Expected 1";
//        assert h2hReverse.totalMatches == 4 : "Expected 4";
//        assert h2hReverse.lastResult == Outcome.LOSS : "Expected LOSS"; // match 4 was a LOSS   for player2
//        assert h2hReverse.lastMatchTimestamp == 4000 : "Expected 4000";
//
//        // players who have never faced each other — unchanged
//        HeadToHead h2hEmpty = gm.getHeadToHead(1, 3);
//        assert h2hEmpty.totalMatches == 0 : "Expected 0";
//        assert h2hEmpty.winsPlayer1 == 0 : "Expected 0";
//        assert h2hEmpty.winsPlayer2 == 0 : "Expected 0";
//        assert h2hEmpty.draws == 0 : "Expected 0";
//        assert h2hEmpty.lastResult == null : "Expected null";
//        assert h2hEmpty.lastMatchTimestamp == null : "Expected null";
//    }
//}