package com.fei.user.study.sort;

/**
 * @author: zhangxinfei
 * create at:  2021/8/3  11:31 上午
 * @description: DFS（深度优先） BFS（广度优先）
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; //定点数组
    private int adjMat[][];      //领接矩阵
    private int nVerts;          //当前定点总数
    private StackX theStack;     //栈
    private Queue theQueue;      //队列


    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);

        System.out.print("visits:");
         theGraph.dfs();
//        theGraph.bfs();
        System.out.println();
    }

    // 构造图
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        theQueue = new Queue();
    }

    // 添加顶点
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // 添加边
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // 打印数组中v位置下的顶点名
    public void displayVertex(int v) {
        System.out.print(vertexList[v].lable);
    }

    // 获取和v邻接的未访问的顶点
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1){
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //重置，防止后边再次使用dfs
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }



}






class StackX {// 自定义栈
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        if (top == 0) {
            return -1;
        }
        return st[--top];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {// 入队
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {// 出队
        if (!isEmpty()) {
            return queArray[front++];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return (rear + 1 == front);
    }
}

class Vertex {
    public char lable;// 名字
    public boolean wasVisited;

    public Vertex(char lab) {
        lable = lab;
        wasVisited = false;
    }
}