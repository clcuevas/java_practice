public class LinkedList {
  private int length = 0;
  LinkNode head;

  public void printList() {
    LinkNode n = head;

    System.out.print("[ ");
    while (n != null) {
      System.out.print(n.element + " ");
      n = n.next;
    }
    System.out.print("]");
    System.out.println("\n");
  }

  // Add a new node to the beginning of a Link List
  public void insertFront(int element) {
    LinkNode new_node = new LinkNode(element);

    // Make the existing head the next element
    // in the new_node's pointer
    new_node.next = head;
    // Make the new_node the new head of the
    // LinkedList
    head = new_node;
  }

  // Add a node at a specified position in a Linked List
  public void insertAfter(LinkNode prev_node, int element) {
    if (prev_node == null) {
      System.out.println("Cannot insert Node after a null node");
      return;
    }

    // Create new_node for node being inserted
    LinkNode new_node = new LinkNode(element);

    // Assign the pointer of prev_node to the new_node
    new_node.next = prev_node.next;
    // Assign new_node as the prev_node new pointer
    prev_node.next = new_node;
  }

  // Add a node at the end of a Linked List
  public void insertEnd(int element) {
    LinkNode new_node = new LinkNode(element);
    LinkNode n = head;

    if (n == null) {
      head = new_node;
      return;
    }

    while (n != null) {
      if (n.next == null) {
        n.next = new_node;
        return;
      }
      n = n.next;
    }
  }

  // TEST OUR CODE IN HERE!!
  public static void main(String[] args) {
    // Start with an empty list
    LinkedList list = new LinkedList();

    list.head = new LinkNode(1);
    LinkNode second = new LinkNode(2);
    LinkNode third = new LinkNode(3);

    list.head.next = second;
    second.next = third;

    // The above creates a Link List that is similar to the below:
    /*
     *       list.head      second          third
     *        |             |             |
     *    +-----+------+    +-----+------+    +-----+------+
     *    |  1  |   o------>  |  2  |   o------>  |  3  | null |
     *    +-----+------+    +-----+------+    +-----+------+
     *
     */

    list.printList();
    list.insertFront(4);
    list.printList();

    list.insertEnd(5);
    list.printList();
  }
}
