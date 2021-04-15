package samsungTest;

import java.util.Arrays;

interface Stack{
	boolean isEmpty();
    boolean isFull();
    void push(char item);
    char pop();
    char peek();
    void clear();
}

public class ArrayStack implements Stack{
	
	private int top;
    private int stackSize;
    private char stackArr[];
    
	public ArrayStack(int stackSize) {
		// 스택 포인터 초기화
		this.top = -1;
		this.stackSize = stackSize;		// 스택 사이즈 설정
		this.stackArr = new char[this.stackSize];	// 스택 배열 생성
	}
	
	
	// 스택이 비어있다면?
	@Override
	public boolean isEmpty() {
		// 포인터가 -1이면 비어있다는 의미
		return (top == -1);
	}
	
	// 스택이 가득찬 상태인지 확인
	@Override
	public boolean isFull() {
		// 포인터가 끝점이라면 꽉찬 상태
		return (top == this.stackSize-1);
	}

	@Override
	public void push(char item) {
		if(isFull()) {
			System.out.println("stack is Full");
		}else {
			stackArr[++top] = item;
			//System.out.println("InsertItem: " + item);
		}
	}

	@Override
	public char pop() {
		if(isEmpty()) {
			System.out.println("stack is Empty");
			return 0;
		}else {
			//System.out.println("DeleteItem: " + stackArr[top]);
			return stackArr[top--];
		}
		
	}

	@Override
	public char peek() {
		
		if(isEmpty()) {
			System.out.println("stack is Empty");
			return 0;
		}else {
			//System.out.println("PeekItem: " + stackArr[top]);
			return stackArr[top];
		}
	}

	@Override
	public void clear() {
		if(isEmpty()) {
			System.out.println("stack is already Empty");
		}else {
			top = -1;
			stackArr = new char[this.stackSize];
			//System.out.println("stack is clear");
		}
	}

	// 스택에 저장된 모든 데이터를 출력
    public void printStack() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements : ");
            for(int i=0; i<=top; i++) {
                System.out.print(stackArr[i] + " ");
            }
            System.out.println();
        }
    }

	
	public static void main(String[] args) {
		int stackSize = 5;
		ArrayStack arrayStack = new ArrayStack(stackSize);
		
		arrayStack.push('A');
		arrayStack.printStack();
		arrayStack.push('B');
		arrayStack.printStack();
		arrayStack.push('C');
		arrayStack.printStack();
		arrayStack.peek();
		arrayStack.pop();
		arrayStack.printStack();
		arrayStack.push('D');
		arrayStack.printStack();
	
	}
}