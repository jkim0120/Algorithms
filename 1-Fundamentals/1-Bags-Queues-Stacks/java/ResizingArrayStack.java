import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] stack = (Item[]) new Object[1];
  private int counter = 0;

  public boolean isEmpty() {
    return counter == 0;
  }

  public int size() {
    return counter;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];

    for (int i = 0; i < counter; i++)
      temp[i] = stack[i];

    stack = temp;
  }

  public void push(Item item) {
    if (counter == stack.length)
      resize(2 * stack.length);
    stack[counter++] = item;
  }

  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack is empty!");

    Item item = stack[--counter];
    stack[counter] = null;

    if (counter > 0 && counter < stack.length / 4)
      resize(stack.length / 2);

    return item;
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack is empty!");

    return stack[counter - 1];
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = counter;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return stack[--i];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

