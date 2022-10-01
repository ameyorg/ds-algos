import java.io.*;
import java.util.*;

class GFG {
static void addEdge(int[][] edges, int f, int s)
{
	edges[f][s] = 1;
}

static void printBFS(int[][] edges, int V, int start,
					int[] visited)
{
	if (V == 0)
	return;
	Queue<Integer> BFS = new LinkedList<Integer>();
	BFS.add(start);
	visited[start] = 1;
	while (!BFS.isEmpty()) {
	int data = BFS.poll();
	System.out.print(data + " ");
	for (int i = 0; i < V; i++) {
		if (edges[data][i] == 1) {
		if (visited[i] == 0) {
			BFS.add(i);
			visited[i] = 1;
		}
		}
	}
	}
}

static void bfsHelper(int[][] edges, int V)
{
	if (V == 0)
	return;
	int[] visited = new int[V];
	for (int i = 0; i < V; i++) {
	visited[i] = 0;
	}
	for (int i = 0; i < V; i++) {
	if (visited[i] == 0) {
		printBFS(edges, V, i, visited);
	}
	}
	System.out.println();
}

public static void main(String[] args)
{
	int V = 5;
	int E = 6;
	if (E == 0) {
	for (int i = 0; i < V; i++) {
		System.out.print(i + " ");
	}
	System.out.println();
	System.exit(0);
	}
	int[][] edges = new int[V][V];
	for (int i = 0; i < V; i++) {
	for (int j = 0; j < V; j++) {
		edges[i][j] = 0;
	}
	}

	addEdge(edges, 0, 4);
	addEdge(edges, 1, 2);
	addEdge(edges, 1, 3);
	addEdge(edges, 1, 4);
	addEdge(edges, 2, 3);
	addEdge(edges, 3, 4);

	bfsHelper(edges, V);
}
}
