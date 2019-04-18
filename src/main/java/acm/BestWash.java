package acm;

import java.util.*;

/**
 * @author kuangjunlin
 */
public class BestWash {
    /**
     * 给定两个大小相等的数组 A 和 B，
     * A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
     *
     * 返回 A 的任意排列，使其相对于 B 的优势最大化。
     * 输入：A = [12,24,8,32], B = [13,25,32,11]
     * 输出：[24,32,8,12]
     */

    /**
     * 方法：贪心
     * 思路
     *
     * 如果 A 中最小的牌 a 能击败 B 中最小的牌 b，那么我们应当将它们配对。
     * 否则， a 将无益于我们的比分，因为它无法击败任何牌。
     *
     * 我们为什么要在 a > b 时将 a 和 b 配对呢？
     * 这是因为此时在 A 中的每张牌都比 b 要大，所以不管我们在 b 前面放置哪张牌都可以得分。
     * 我们可以用手中最弱的牌来与 b 配对，这样会使 A 中剩余的牌严格地变大，因此会有更多得分点。
     *
     * 算法
     *
     * 我们可以根据上面的思路来创造一种贪心算法。
     * 目前在 B 中要被击败的最小的牌将始终是 b = sortedB[j]。
     * 对于在 sortedA 中的每张卡 a，要么 a 能够击败牌 b（将 a 放入 assigned[b]），
     * 要么把 a 扔掉（将 a 放入 remaining）。
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortA = A.clone();
        Arrays.sort(sortA);
        int[] sortB = B.clone();
        Arrays.sort(sortB);

        Map<Integer, Deque<Integer>> assign = new HashMap<>();
        for (int b : B) {
            assign.put(b, new LinkedList<>());
        }

        Deque<Integer> remain = new LinkedList<>();

        int j = 0;
        for(int a : sortA){
            if (a > sortB[j]){
                assign.get(sortB[j++]).add(a);
            }else {
                remain.add(a);
            }
        }

        int[] result = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            if (assign.get(B[i]).size() > 0){
                result[i] = assign.get(B[i]).pop();
            }else {
                result[i] = remain.pop();
            }
        }
        return result;
    }
}
