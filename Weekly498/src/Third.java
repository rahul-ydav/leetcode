import java.util.*;
public class Third {

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int size = n * m;
        int[] dist = new int[size];
        int[] clr = new int[size];

        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int[] s : sources) {
            int id = s[0] * m + s[1];
            dist[id] = 0;
            clr[id] = s[2];
            q.offer(id);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / m, c = cur % m;

            int di = dist[cur];
            int col = clr[cur];

            if (r + 1 < n) {
                int nid = (r + 1) * m + c;
                if (di + 1 < dist[nid]) {
                    dist[nid] = di + 1;
                    clr[nid] = col;
                    q.offer(nid);
                } else if (di + 1 == dist[nid] && col >= clr[nid]) {
                    clr[nid] = col;
                }
            }

            if (r - 1 >= 0) {
                int nid = (r - 1) * m + c;
                if (di + 1 < dist[nid]) {
                    dist[nid] = di + 1;
                    clr[nid] = col;
                    q.offer(nid);
                } else if (di + 1 == dist[nid] && col >= clr[nid]) {
                    clr[nid] = col;
                }
            }

            if (c + 1 < m) {
                int nid = r * m + (c + 1);
                if (di + 1 < dist[nid]) {
                    dist[nid] = di + 1;
                    clr[nid] = col;
                    q.offer(nid);
                } else if (di + 1 == dist[nid] && col >= clr[nid]) {
                    clr[nid] = col;
                }
            }

            if (c - 1 >= 0) {
                int nid = r * m + (c - 1);
                if (di + 1 < dist[nid]) {
                    dist[nid] = di + 1;
                    clr[nid] = col;
                    q.offer(nid);
                } else if (di + 1 == dist[nid] && col >= clr[nid]) {
                    clr[nid] = col;
                }
            }
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < size; i++) {
            res[i / m][i % m] = clr[i];
        }

        return res;
    }
}
