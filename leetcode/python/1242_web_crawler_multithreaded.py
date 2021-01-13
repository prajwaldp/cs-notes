# """
# This is HtmlParser's API interface.
# You should not implement it, or speculate about its implementation
# """
#class HtmlParser(object):
#    def getUrls(self, url):
#        """
#        :type url: str
#        :rtype List[str]
#        """

from collections import defaultdict
from concurrent.futures import ThreadPoolExecutor
from queue import Queue
from threading import Thread, Lock
from typing import List


class HtmlParser:
    def __init__(self):
        urls = [
            "http://news.yahoo.com",
            "http://news.yahoo.com/news",
            "http://news.yahoo.com/news/topics/",
            "http://news.google.com",
            "http://news.yahoo.com/us"
        ]

        links = [[2,0],[2,1],[3,2],[3,1],[0,4]]

        self.g = defaultdict(list)

        for link in links:
            u, v = [urls[i] for i in link]
            self.g[u].append(v)
            self.g[v].append(u)

    def getUrls(self, url):
        return self.g[url]


class Solution:
    def __init__(self):
        self.html_parser: HtmlParser = None
        self.q = Queue()
        self.done = set()
        self.done_lock = Lock()
        self.start_hostname: str = None

    def crawl(self, start_url: str, html_parser: HtmlParser) -> List[str]:
        self.html_parser = html_parser
        self.start_hostname = self.get_hostname(start_url)
        self.q.put(start_url)
        self.done.add(start_url)

        workers: List[Thread] = list()
        for _ in range(8):
            t = Thread(target=self.worker, daemon=True)
            t.start()
            workers.append(t)

        self.q.join()

        for _ in range(8):
            self.q.put(None)

        for t in workers:
            t.join()

        return list(self.done)

    def worker(self):
        while True:
            url = self.q.get()
            if url is None:
                return

            for u in self.html_parser.getUrls(url):
                if u in self.done or self.get_hostname(u) != self.start_hostname:
                    continue

                self.done_lock.acquire()
                if u not in self.done:
                    self.done.add(u)
                    self.q.put(u)
                self.done_lock.release()

            self.q.task_done()

    def get_hostname(self, url: str):
        start = len('http://')
        i = start
        while i < len(url) and url[i] != '/':
            i += 1
        return url[start:i]


class SolutionAlt:
    def crawl(self, url, parser):
        start_hostname = url.split('/')[2]
        q = Queue()
        seen = set()
        seen_lock = Lock()

        q.put(url)
        seen.add(url)

        def worker():
            try:
                while True:
                    url = q.get(timeout=0.015)
                    for u in parser.getUrls(url):
                        if u not in seen and u.split('/')[2] == start_hostname:
                            seen_lock.acquire()
                            if u not in seen:
                                seen.add(u)
                                q.put(u)
                            seen_lock.release()
                    q.task_done()
            except:
                pass

        with ThreadPoolExecutor(max_workers=8) as executor:
            for i in range(8):
                executor.submit(worker)

        return list(seen)


if __name__ == '__main__':
    parser = HtmlParser()
    soln = SolutionAlt()
    print(soln.crawl("http://news.yahoo.com/news/topics/", parser))
