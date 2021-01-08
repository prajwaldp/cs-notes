class RandomizedSet {

    List<Integer> container;
    Map<Integer, Integer> valToIdx;
    Random rnd;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        container = new ArrayList<>();
        valToIdx = new HashMap<>();
        rnd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        }

        container.add(val);
        valToIdx.put(val, container.size() - 1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (valToIdx.containsKey(val)) {
            int toRemove = valToIdx.get(val);

            // Put the last element of the container in the `toRemove` position
            int lastElement = container.get(container.size() - 1);
            valToIdx.put(lastElement, toRemove);
            container.set(toRemove, lastElement);

            // Remove the last element
            container.remove(container.size() - 1);
            valToIdx.remove(val);

            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = rnd.nextInt(container.size());
        return container.get(randIdx);
    }
}
