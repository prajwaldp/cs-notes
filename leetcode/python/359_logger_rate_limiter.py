class Logger:
    def __init__(self):
        self.last_printed_at = dict()

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed
        """

        if message not in self.last_printed_at or self.last_printed_at[message] + 10 <= timestamp:
            self.last_printed_at[message] = timestamp
            return True

        return False
