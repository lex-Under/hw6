package hw6;

import hw6.Trees.TreeNode;
import java.util.function.Consumer;

public class Client {

    public void handle(Iterable<TreeNode> struct,
            Consumer<TreeNode> handleProcedure) {
        handle(struct, handleProcedure, handleProcedure);
    }

    public void handle(Iterable<TreeNode> struct,
            Consumer<TreeNode> branchHandleProcedure,
            Consumer<TreeNode> leafHandleProcedure) {
        for (TreeNode node : struct) {
            if (node.isLeaf()) {
                leafHandleProcedure.accept(node);
            } else {
                branchHandleProcedure.accept(node);
            }
        }
    }

}
