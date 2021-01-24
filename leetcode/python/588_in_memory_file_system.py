from collections import defaultdict
from enum import Enum


class FileType(Enum):
    TEXT_FILE = 1
    DIRECTORY = 2


class INode:
    def __init__(self, name: str, filetype: FileType):
        self.name = name
        self.filetype = filetype
        self.content: str = ''
        self.children dict[str, INode] = dict()

    def read(self):
        if self.filetype == FileType.DIRECTORY:
            return self._read_directory()

        return self._read_text_file()

    def _read_directory(self) -> List[str]:
        return [child.name for child in self._children]

    def _read_text_file(self) -> str:
        return self.content

    def add_directory(self, name: str):
        if self.filetype == FileType.TEXT_FILE:
            raise Exception(msg=f'{self.name} is not a directory')
        self._children.append(INode(name, FileType.DIRECTORY))

    def add_text_file(self, name: str):
        if self.filetype == FileType.TEXT_FILE:
            raise Exception(msg=f'{self.name} is not a directory')
        self._children.append(INode(name, FileType.TEXT_FILE))


class FileSystem:
    def __init__(self):
        self.root = INode('', FileType.DIRECTORY)

    def ls(self, path: str) -> List[str]:
        curr = self.root

        for part in path.split('/'):
            if curr.name != part:
                raise Exception(msg=f'ls {path} - {curr.name} does not exist')

            curr = curr.goto()


    def mkdir(self, path: str) -> None:
        pass

    def addContentToFile(self, filepath: str, content: str) -> None:
        pass

    def readContentFromFile(self, filepath: str) -> str:
        pass