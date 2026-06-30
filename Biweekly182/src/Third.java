import java.util.*;

class Solution {

    int encode(int x, int y, int z) {
        return x * 49 + y * 7 + z;
    }

    int[] decode(int v) {
        return new int[]{
                v / 49,
                (v / 7) % 7,
                v % 7
        };
    }

    public int minGenerations(int[][] points, int[] target) {

        int targetId = encode(target[0], target[1], target[2]);
        boolean[] seen = new boolean[343];
        List<Integer> all = new ArrayList<>();
        for (int[] p : points) {
            int id = encode(p[0], p[1], p[2]);
            if (id == targetId) return 0;
            if (!seen[id]) {
                seen[id] = true;
                all.add(id);
            }
        }

        int gen = 0;

        while (true) {
            gen++;
            List<Integer> newlyAdded = new ArrayList<>();
            int size = all.size();
            for (int i = 0; i < size; i++) {

                int[] a = decode(all.get(i));
                for (int j = i + 1; j < size; j++) {
                    int[] b = decode(all.get(j));

                    int nx = (a[0] + b[0]) / 2;
                    int ny = (a[1] + b[1]) / 2;
                    int nz = (a[2] + b[2]) / 2;

                    int nid = encode(nx, ny, nz);
                    if (seen[nid]) continue;
                    if (nid == targetId) {
                        return gen;
                    }

                    seen[nid] = true;
                    newlyAdded.add(nid);
                }
            }

            if (newlyAdded.isEmpty()) {
                return -1;
            }

            all.addAll(newlyAdded);
        }
    }
}

