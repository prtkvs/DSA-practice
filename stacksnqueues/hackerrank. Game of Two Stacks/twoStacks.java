import java.util.*;

class twoStacks {
    static int twoStacks(int x, int[] a, int[] b) {
        return twoStacks(x, a, b, 0, 0) - 1;
    }

    private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {
        if (sum > x) {
            return count;
        }

        if (a.length == 0 || b.length == 0) {
            return count;
        }

        int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + a[0], count + 1);

        return Math.max(ans1, ans2);
    }

    class Main {
        public static void main(String[] args) {
            twoStacks stacks = new twoStacks();
            int[] first = {4, 2, 4, 6, 1};
            int[] second = {2, 1, 8, 5};
            System.out.println(stacks.twoStacks(16, first, second));
        }
    }
}


