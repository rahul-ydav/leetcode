
import java.util.*;

enum Outcome {
    WIN, LOSS, DRAW
}

class Player {
    public int playerId;
    public String username;

    public Player(int playerId, String username) {
        this.playerId = playerId;
        this.username = username;
    }
}

class MatchResult {
    public int playerId;
    public int opponentId;
    public Outcome outcome;
    public int score;
    public int timestamp;

    public MatchResult(int playerId, int opponentId, Outcome outcome, int score, int timestamp) {
        this.playerId = playerId;
        this.opponentId = opponentId;
        this.outcome = outcome;
        this.score = score;
        this.timestamp = timestamp;
    }
}

class PlayerStats {
    public int totalMatches;
    public int wins;
    public double winRate;

    public PlayerStats(int totalMatches, int wins, double winRate) {
        this.totalMatches = totalMatches;
        this.wins = wins;
        this.winRate = winRate;
    }
}

class GameManager {
    public Map<Integer, Player> players;
    public List<MatchResult> matchResults;

    public GameManager() {
        players = new HashMap<>();
        matchResults = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.put(player.playerId, player);
    }

    public PlayerStats getPlayerStatistics(int playerId) {
        List<MatchResult> playerMatches = new ArrayList<>();
        for (MatchResult m : matchResults) {
            if (m.playerId == playerId) {
                playerMatches.add(m);
            }
        }

        int totalMatches = 0;
        for (MatchResult m : playerMatches) {
            totalMatches++;
        }

        int wins = 0;
        for (MatchResult m : playerMatches) {
            if (m.outcome == Outcome.WIN) {
                wins++;
            }
        }

        double winRate;
        if (totalMatches > 0) {
            winRate = (double) wins / totalMatches;
        } else {
            winRate = 0.0;
        }

        return new PlayerStats(totalMatches, wins, winRate);
    }
}

public class QC1 {
    public static void main(String[] args) {
        testGetPlayerStatistics();
        System.out.println("All Tests Passed!");
    }

    public static void testGetPlayerStatistics() {
        System.out.println("Running testGetPlayerStatistics");
        GameManager gm = new GameManager();
        gm.addPlayer(new Player(1, "player1"));
        gm.addPlayer(new Player(2, "player2"));

        gm.matchResults.add(new MatchResult(1, 2, Outcome.WIN,  80, 1000));
        gm.matchResults.add(new MatchResult(1, 2, Outcome.LOSS, 50, 2000));
        gm.matchResults.add(new MatchResult(1, 2, Outcome.DRAW, 60, 3000));
        gm.matchResults.add(new MatchResult(1, 2, Outcome.WIN,  90, 4000));

        PlayerStats stats = gm.getPlayerStatistics(1);
        assert stats.totalMatches == 4 :
                "totalMatches should be 4, was " + stats.totalMatches;
        assert stats.wins == 2 :
                "wins should be 2, was " + stats.wins;
        assert Math.abs(stats.winRate - 0.5) < 1e-4 :
                "winRate should be 0.5, was " + stats.winRate;

        gm.matchResults.add(new MatchResult(2, 1, Outcome.DRAW, 60, 1000));
        gm.matchResults.add(new MatchResult(2, 1, Outcome.DRAW, 60, 2000));

        PlayerStats stats2 = gm.getPlayerStatistics(2);
        assert stats2.totalMatches == 2 :
                "totalMatches should be 2, was " + stats2.totalMatches;
        assert stats2.wins == 0 :
                "wins should be 0, was " + stats2.wins;
        assert Math.abs(stats2.winRate - 0.0) < 1e-4 :
                "winRate should be 0.0, was " + stats2.winRate;
    }
}