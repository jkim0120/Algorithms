class Stack:
  def __init__(self):
    self._top = None
    self._counter = 0

  def is_empty(self):
    return self._top == None

  def size(self):
    return self._counter

  def push(self, item):
    old_top = self._top
    self._top = Node(item, old_top)
    self._counter += 1

  def pop(self):
    item = self._top._item
    self._top = self._top._nxt
    self._counter -= 1
    return item

  def peek(self):
    return self._top._item

class Node:
  def __init__(self, item, nxt):
    self._item = item
    self._nxt = nxt
