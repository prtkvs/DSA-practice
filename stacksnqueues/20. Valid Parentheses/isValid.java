import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            // opening brackets ko pehle daal do to check closing brackets se pehle open hai ya nhi
            if (ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                // ya to opening iska pehle nhi tha ya to starting hi isse hai i.e empty earlier
                if (ch==')'){
                    if (stack.isEmpty() || stack.pop()!='('){   // pop since check krne ke baad remove bhi krdo fir aage se check ho paye
                        return false;
                    }
                }
                if (ch=='}'){
                    if (stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }
                if (ch==']'){
                    if (stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{([])}"));
    }
}