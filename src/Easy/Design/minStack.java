import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);

        stack.pop();
        int min = stack.getMin();
        stack.pop();
        int y = stack.getMin();
        stack.pop();
        int z = stack.getMin();

    }
}

class MinStack {

    List<Integer> s1;
    List<Integer> s2;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new ArrayList();
        s2 = new ArrayList();
    }

    public void push(int x) {
        s1.add(x);
        if(s2.size() ==0) {
            s2.add(x);
        } else {
            // 注意這裏 若跟s2(minStack中有相同的值 也要放進去。。。)
            if(x <= s2.get(s2.size()-1)) s2.add(x);
        }
    }

    public void pop() {
        int top1 = s1.size() -1;
        int top2 = s2.size() -1;

        if(top1 >= 0) {
            int x = s1.get(top1);
            int y = s2.get(top2);
            if(x == y) {  // 注意 不行直接用 s1.get() == s2.get() 不然會有取出先後順序的問題
                s2.remove(top2);
            }
            s1.remove(top1);
        }
    }

    public int top() {
        int top1 = s1.size() -1;
        return s1.get(top1);
    }

    public int getMin() {
        int top2 = s2.size() -1;

        return s2.get(top2);
    }
}
