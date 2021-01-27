from collections import defaultdict
from typing import List


class Node:
    def __init__(self):
        self.children = defaultdict(Node)
        self.content = None


class FileSystem:
    def __init__(self):
        self.root = Node()

    def find(self, path: str) -> Node:
        curr = self.root
        if len(path) == 1:
            return curr

        for e in path.split('/')[1:]:
            curr = curr.children[e]

        return curr

    def ls(self, path: str) -> List[str]:
        curr = self.find(path)
        if curr.content:
            return path.split('/')[-1:]

        return sorted(curr.children.keys())

    def mkdir(self, path: str) -> None:
        self.find(path)

    def addContentToFile(self, filepath: str, content: str) -> None:
        curr = self.find(filepath)
        if curr.content:
            curr.content += content
        else:
            curr.content = content

    def readContentFromFile(self, filepath: str) -> str:
        curr = self.find(filepath)
        return curr.content
