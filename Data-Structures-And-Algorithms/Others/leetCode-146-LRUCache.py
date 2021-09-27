class LRUCache:

    def __init__(self, capacity: int):
        self.s = capacity
        self.ref = OrderedDict()

    def get(self, key: int) -> int:
        if key in self.ref:
            val = self.ref[key]
            del self.ref[key]
            self.ref[key] = val
            return self.ref[key]
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.ref:
            del self.ref[key]
        elif self.s == len(self.ref):
            self.ref.popitem(last=False)
        self.ref[key] = value


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
