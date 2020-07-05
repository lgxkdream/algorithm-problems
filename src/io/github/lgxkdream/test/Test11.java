package io.github.lgxkdream.test;

import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test11 {

    public static void main(String[] args) throws Exception {
        new WorkerThread().start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            // handle here exception
        }

        System.out.println("Main Thread ending");


    }

    private Node findNextNode(Node root, Node node) {
        mid(root);
        for(int i = 0; i < nodeList.size() - 1;i++) {
            if (nodeList.get(i) == node) {
                return nodeList.get(i + 1);
            }
        }
        return null;
    }

    private List<Node> nodeList = new ArrayList<>();

    private void mid(Node node) {
        if (node == null) {
            return;
        }
        mid(node.left);
        nodeList.add(node);
        mid(node.right);
    }
    class Node {
        Node left;
        Node right;
    }


}

class WorkerThread extends Thread {

    public WorkerThread() {
        // When false, (i.e. when it's a user thread), the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread), the Worker thread terminates when the main thread terminates.
        setDaemon(false);
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Worker " + count++);

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                // handle exception here
            }
        }
    }
}
