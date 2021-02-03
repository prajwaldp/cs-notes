from collections import deque


class Codec:
    def serialize(self, root):
        def dfs(root):
            if root is None:
                return

            preorder.append(root.val)
            preorder.append(len(root.children))
            for child in root.children:
                dfs(child)

        preorder = []
        dfs(root)
        return ','.join(map(str, preorder))

    def deserialize(self, data):
        if data == '':
            return None

        q = deque(data.split(','))
        return self.__deserialize_helper(q)

    def __deserialize_helper(self, q):
        root = Node(int(q.popleft()), [])
        num_children = int(q.popleft())

        for _ in range(num_children):
            root.children.append(self.__deserialize_helper(q))

        return root
