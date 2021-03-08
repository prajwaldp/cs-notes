class Node:
    def __init__(self, key=-1, val=-1, next=None):
        self.key = key
        self.val = val
        self.next = next


class MyHashMap:
    SIZE = 1103

    def __init__(self):
        self.data = [Node() for _ in range(self.__class__.SIZE)]

    def _hashcode(self, key):
        return key % self.__class__.SIZE

    def put(self, key, val):
        head = self.data[self._hashcode(key)]
        while head.next:  # using a dummy head here
            if head.next.key == key:
                head.next.val = val
                return
            head = head.next

        head.next = Node(key, val)

    def get(self, key):
        head = self.data[self._hashcode(key)]
        while head.next:  # using a dummy head here
            if head.next.key == key:
                return head.next.val
            head = head.next

        return -1

    def remove(self, key):
        head = self.data[self._hashcode(key)]
        while head.next:
            if head.next.key == key:
                toremove = head.next
                head.next = toremove.next
                toremove.next = None
                return

            head = head.next
