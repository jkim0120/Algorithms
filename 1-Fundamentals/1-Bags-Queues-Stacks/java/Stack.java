public class Stack<Item> implements Iterable<Item> {
  private Node top = null;
  private int counter = 0;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return counter;
  }

  public void push(Item item) {
    Node oldTop = top;
    top = new Node();
    top.item = item;
    top.next = oldTop;
    counter++;
  }

  public void pop() {
    item = top.item;
    top = top.next;
    counter--;
    return item;
  }
}