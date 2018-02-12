package catchPlagiarist;
//-------------------------------------------------------------------------
/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo() method.
 * ** copied code from programming assignment 12 with some modification
 *
 * @param <T> The type of data element contained in the node.
 *
 * @author Mark Allen Weiss (with modifications by John Lewis)
 * @author Lizzie Litt
 * @version 11.15.15
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{
    //~ Instance/static variables .............................................

    /**
     * the root of the tree
     */
    public BinaryNode<T> root;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Constructs an empty tree.
     */
    public BinarySearchTree()
    {
        root = null;

    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * get root method here.
     * @return root the root
     */
    public BinaryNode<T> getRoot() {
        return root;
    }
    // ----------------------------------------------------------
    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert(T x)
    {
        root = insert(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Remove the specified value from the tree.
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove(T x)
    {
        root = remove(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Find the smallest item in the tree.
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin()
    {
        return elementAt(findMin(root));
    }


    // ----------------------------------------------------------
    /**
     * Find the largest item in the tree.
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax()
    {
        return elementAt(findMax(root));
    }


    // ----------------------------------------------------------
    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x)
    {
        return elementAt(find(x, root));
    }


    // ----------------------------------------------------------
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }


    // ----------------------------------------------------------
    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return (root == null);
    }


    // ----------------------------------------------------------
    /**
     * Internal method to get element value stored in a tree node, with
     * safe handling of null nodes.
     * @param node the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<T> node)
    {
        return (node == null) ? null : node.getElement();
    }


    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     * @param x the item to insert.
     * @param node the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws DuplicateItemException if x is already present.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node)
    {
        if (node == null)
        {
            return new BinaryNode<T>(x);
        }
        else if (x.compareTo(node.getElement()) < 0)
        {
            node.setLeft(insert(x, node.getLeft()));
        }
        else if (x.compareTo(node.getElement()) > 0)
        {
            node.setRight(insert(x, node.getRight()));
        }
        else
        {
//            try
//            {
//                throw new Exception(x.toString());
//            }
//            catch (Exception e)
//            {
//
//                e.printStackTrace();
//            }
        }
        return node;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     * @param x the item to remove.
     * @param node the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws exception if x is not found.
     */
    public BinaryNode<T> remove(T x, BinaryNode<T> node)
    {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<T> result = node;

        // If there's no more subtree to examine
        if (node == null)
        {
            try
            {
                throw new Exception(x.toString());
            }
            catch (Exception e)
            {

                e.printStackTrace();
            }
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getElement()) < 0)
        {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getElement()) > 0)
        {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else
        {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null)
            {
                BinaryNode<T> tempNode = findMin(node.getLeft());
                node.setElement(tempNode.getElement());
                node.setLeft(findMin(node.getLeft()));

            }
            // If there is only one child on the left
            else if (node.getLeft() != null)
            {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else
            {
                result = node.getRight();
            }
        }
        return result;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the smallest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> node)
    {
        if (node == null) {
            return node;
        }
        else if (node.getLeft() == null) {
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the largest item in a subtree.
     * @param node the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.getRight() == null)
        {
            return node;
        }
        else
        {
            return findMax(node.getRight());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param node the node that roots the tree.
     * @return node containing the matched item.
     */
    public BinaryNode<T> find(T x, BinaryNode<T> node)
    {
        if (node == null)
        {
            return null;    // Not found
        }
        else if (x.compareTo(node.getElement()) < 0)
        {
            // Search in the left subtree
            return find(x, node.getLeft());
        }
        else if (x.compareTo(node.getElement()) > 0)
        {
            // Search in the right subtree
            return find(x, node.getRight());
        }
        else
        {
            return node;    // Match
        }
    }

    // ----------------------------------------------------------
    /**
     * compareTrees compares two trees to see how many nodes are the same
     * @param tree a bst
     * @param node a binnode
     * @return the number of same nodes between both trees
     */
    private int compareTrees(BinarySearchTree<T> tree, BinaryNode<T> node)
    {
        int count = 0;
        if (node == null) {
            return 0;
        }

        if(tree.find(node.getElement()) != null) {
            count++;

        }
        return count + (compareTrees(tree, node.getLeft())
            + compareTrees(tree, node.getRight()));

    }

    // ----------------------------------------------------------
    /**
     * compares two trees.
     * @param tree the tree to compare to
     * @return count
     */
    public int compareTrees(BinarySearchTree<T> tree) {
        return compareTrees(tree, root);
    }

}
