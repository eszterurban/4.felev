package puzzle.solver;

import puzzle.state.PuzzleState;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public class BreadthFirstSearch {

    public Optional<Node> search(PuzzleState state) {
        Deque<Node> open = new LinkedList<Node>();
        var seen = new HashSet<Node>();
        var start = new Node(state);
        open.add(start);
        seen.add(start);
        while (! open.isEmpty()) {
            var selected = open.pollFirst();
            if (selected.getState().isGoal()) {
                return Optional.of(selected);
            }
            while (selected.hasNextChild()) {
                Node nextChild = selected.nextChild().get();
                if (! seen.contains(nextChild)) {
                    open.offerLast(nextChild);
                    seen.add(nextChild);
                }
            }
        }
        return Optional.empty();
    }

    public void printPathTo(Node node) {
        node.getParent().ifPresent(parentNode -> printPathTo(parentNode));
        System.out.println(node);
    }

    public static void main(String[] args) {
        var bfs = new BreadthFirstSearch();
        var result = bfs.search(new PuzzleState());
        result.ifPresentOrElse(
                node -> bfs.printPathTo(node),
                () -> System.out.println("No solution found")
        );
    }

}
