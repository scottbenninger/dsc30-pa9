/*
 * Name: Scott Benninger
 * PID: A16991954
 */

import java.util.*;

/**
 * Implementation for Problem F
 *
 * @author Scott Benninger
 * @since 03/19/2024
 */

public class PandaCache {
    class Node {
        int pandaNum;
        int zoneNum;
        Node prev;
        Node next;

        public Node(int pandaNum, int zoneNum) {
            this.pandaNum = pandaNum;
            this.zoneNum = zoneNum;
        }

    }
    private int capacity;
    private HashMap<Integer, Node> pandaCache;
    private Node head;
    private Node tail;


    public PandaCache(int capacity) {
        this.capacity = capacity;
        pandaCache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int pandaID) {
        if (!pandaCache.containsKey(pandaID)) {
            return -1;
        }
        Node myNode = pandaCache.get(pandaID);
        myNode.prev.next = myNode.next;
        myNode.next.prev = myNode.prev;
        myNode.prev = head;
        myNode.next = head.next;
        head.next.prev = myNode;
        head.next = myNode;
        return myNode.zoneNum;
    }

    public void set(int pandaNum, int zoneNum) {
        if (pandaCache.containsKey(pandaNum)) {
            Node myNode = pandaCache.get(pandaNum);
            myNode.zoneNum = zoneNum;
            myNode.prev.next = myNode.next;
            myNode.next.prev = myNode.prev;
            myNode.prev = head;
            myNode.next = head.next;
            head.next.prev = myNode;
            head.next = myNode;
        } else {
            Node newNode = new Node(pandaNum, zoneNum);
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            pandaCache.put(pandaNum, newNode);
            if (pandaCache.size() > capacity) {
                Node deletedNode = tail.prev;
                deletedNode.prev.next = tail;
                tail.prev = deletedNode.prev;
                pandaCache.remove(deletedNode.pandaNum);
            }
        }
    }

}