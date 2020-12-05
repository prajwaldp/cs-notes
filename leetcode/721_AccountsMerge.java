class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        
        for (var rec: accounts) {
            String name = rec.get(0);
            
            for (int i = 1; i < rec.size(); i++) {
                String email = rec.get(i);
                emailToName.put(email, name);
                
                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                if (i == 1) continue;
                
                // build connections
                String prevEmail = rec.get(i - 1);
                graph.get(email).add(prevEmail);
                graph.get(prevEmail).add(email);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String email: emailToName.keySet()) {
            if (visited.contains(email)) continue;

            List<String> connectedComponent = new ArrayList<>();
            dfs(graph, email, visited, connectedComponent);
            Collections.sort(connectedComponent);
            connectedComponent.add(0, emailToName.get(email));
            res.add(connectedComponent);
        }

        return res;
    }

    void dfs(Map<String, Set<String>> graph, String email, Set<String> visited,
        List<String> component) {
        
        visited.add(email);
        component.add(email);
        
        for (String n: graph.get(email)) {
            if (visited.contains(n)) continue;
            dfs(graph, n, visited, component);
        }
    }
}
