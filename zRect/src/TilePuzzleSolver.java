import java.util.*;

public class TilePuzzleSolver {

    public static List<List<String>> solve(List<String> start, List<String> end) {
        if (start == null || end == null || start.size() != end.size()) {
            return Collections.emptyList();
        }

        if (start.equals(end)) {
            return Collections.singletonList(start);
        }

        Queue<List<String>> queue = new LinkedList<>();
        Map<List<String>, List<String>> parentMap = new HashMap<>();

        queue.add(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            List<String> current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(parentMap, end);
            }

            for (List<String> nextState : getValidNextStates(current)) {
                if (!parentMap.containsKey(nextState)) {
                    parentMap.put(nextState, current);
                    queue.add(nextState);
                }
            }
        }

        return Collections.emptyList();
    }

    private static List<List<String>> getValidNextStates(List<String> state) {
        List<List<String>> nextStates = new ArrayList<>();
        int n = state.size();

        for (int i = 0; i < n; i++) {
            String tile = state.get(i);

            if ("R".equals(tile)) {
                if (i + 1 < n && "_".equals(state.get(i + 1))) {
                    nextStates.add(swap(state, i, i + 1));
                }
                if (i + 2 < n && "B".equals(state.get(i + 1)) && "_".equals(state.get(i + 2))) {
                    nextStates.add(swap(state, i, i + 2));
                }
            } else if ("B".equals(tile)) {
                if (i - 1 >= 0 && "_".equals(state.get(i - 1))) {
                    nextStates.add(swap(state, i, i - 1));
                }
                if (i - 2 >= 0 && "R".equals(state.get(i - 1)) && "_".equals(state.get(i - 2))) {
                    nextStates.add(swap(state, i, i - 2));
                }
            }
        }
        return nextStates;
    }

    private static List<String> swap(List<String> original, int i, int j) {
        List<String> copy = new ArrayList<>(original);
        String temp = copy.get(i);
        copy.set(i, copy.get(j));
        copy.set(j, temp);
        return copy;
    }

    private static List<List<String>> reconstructPath(Map<List<String>, List<String>> parentMap, List<String> end) {
        LinkedList<List<String>> path = new LinkedList<>();
        List<String> current = end;
        while (current != null) {
            path.addFirst(current);
            current = parentMap.get(current);
        }
        return path;
    }

    public static void main(String[] args) {
        List<String> start1 = Arrays.asList("R", "_", "B", "B");
        List<String> end1   = Arrays.asList("B", "_", "B", "R");
        System.out.println("Example 1 Result:\n" + solve(start1, end1) + "\n");
    }
}