package base.stacktest;


import java.util.Stack;

public class Solution {
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//    public void push(int node) {
//        stack1.push(node);
//    }
//    public int pop() {
//        int temp;
//        while(!stack1.empty()){
//            temp = stack1.pop();
//            stack2.push(temp);
//        }
//        int res = stack2.pop();
//        while(!stack2.empty()){
//            temp = stack2.pop();
//            stack1.push(temp);
//        }
//        return res;
//    }



//    in 栈用来处理入栈（push）操作，
//    out 栈用来处理出栈（pop）操作。
//    一个元素进入 in 栈之后，出栈的顺序被反转。
//    当元素要出栈时，需要先进入out 栈，
//    此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序
//    是相同的，先进入的元素先退出，这就是队列的顺序。

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();
    }

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.push(5);
        solution.push(1);
        solution.push(3);
        solution.push(4);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}