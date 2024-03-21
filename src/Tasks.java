/*
 * Name: Scott Benninger
 * PID: A1699195
 */

import java.util.*;

/**
 * Tasks.java implementation
 *
 * @author Scott Benninger
 * @since 03/19/2024
 */

public class Tasks {

    /**
     * Question A implementation
     * @param entries the array
     * @return true if there are any duplicates in the array,
     * and false otherwise
     */
    public static boolean raffleChecker(int[] entries) {
        HashSet<Integer> mySet = new HashSet<>();
        for (int i : entries) {
            if (mySet.contains(i)) {
                return true;
            }
            mySet.add(i);
        }
        return false;
    }

    // List Node class provided for reference
    public static class Node {
        Node next;
        String name;
        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * Question B implementation helps find middle element of a list
     * in a single loop by having one list go twice as fast as
     * the other list
     * @param head the head of the list
     * @return the middle node
     */
    public static String middleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node one = head;
        Node two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one.name;
    }

    /**
     * TODO: Question C
     * @param newMessage
     * @param oldMessage
     * @return
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
        int[] oldMessageCount = new int[26];
        for (char i : oldMessage.toCharArray()) {
            oldMessageCount[i - 'A']++;
        }
        for (char i : newMessage.toCharArray()) {
            int index = i - 'A';
            if (oldMessageCount[index] == 0) {
                return false;
            }
            oldMessageCount[index]--;
        }

        return true;
    }

    /**
     * Question D
     * @param buyers an array of buyer
     * @param k the number of most frequent customers
     * @return array of size k that contains the names of the
     * most frequent customers
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        Map<String, Integer> customerCounter = new HashMap<>();
        for (String cust : buyers) {
            customerCounter.put(cust, customerCounter.getOrDefault(cust,
                    0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> customerQueue = new
                PriorityQueue<>(
                (x, y) -> y.getValue() - x.getValue());

        for (Map.Entry<String, Integer> cust : customerCounter.entrySet()) {
            customerQueue.offer(cust);
        }
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = customerQueue.poll().getKey();
        }
        return result;
    }

}
