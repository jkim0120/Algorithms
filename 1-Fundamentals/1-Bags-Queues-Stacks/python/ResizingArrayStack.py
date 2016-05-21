class ResizingArrayStack:
  def __init__(self):
    self._stack = []

  def is_empty(self):
    return len(self._stack) == 0

  def size(self):
    return len(self._stack)

  def push(self, item):
    self._stack.append(item)

  def pop(self):
    return self._stack.pop()

  def peek(self):
    return self._stack[-1]