import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ps = prevSmaller(heights);
        int[] ns = nextSmaller(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currArea =  (ns[i]-ps[i]-1)*heights[i];
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }

    private int[] prevSmaller(int[] a) {
        int[] ps = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty() && a[s.peek()]> a[i]){
                s.pop();
            }
            if (s.isEmpty()){
                ps[i]= -1;
            }else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }
    private int[] nextSmaller(int[] b) {
        int[] ns = new int[b.length];
        Stack<Integer> s = new Stack<>();
        for (int i = b.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && b[s.peek()] >= b[i]) {   // >= since here we are traversing from back
                s.pop();
            }
            if (s.isEmpty()) {
                ns[i] = b.length;   // we cannot use 9 since it will give wrong answer (obviously because length of array indices will change according to question)
            } else {
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;
    }
}   