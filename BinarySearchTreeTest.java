package catchPlagiarist;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test for binary search tree!
 *
 *  @author lizzielitt
 *  @version Nov 15, 2015
 */
public class BinarySearchTreeTest extends TestCase
{

    // ~ Fields ................................................................

    private BinarySearchTree<String> bsTree;

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * set up here.
     */
    public void setUp() {
        bsTree = new BinarySearchTree<String>();
    }

    // ----------------------------------------------------------
    /**
     * testInsert method here.
     */

    /*
    public void testInsert() {
        bsTree.insert("hello");
        bsTree.insert("hey");
        bsTree.insert("hi");
        bsTree.insert("yes");
        bsTree.insert("no");

        Exception thrown = null;
        try
        {
            bsTree.insert("no");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof DuplicateItemException);
    }
    */


    // ----------------------------------------------------------
    /**
     * testRemove method here.
     */
     /*
    public void testRemove() {
        BinarySearchTree<String> bt = new BinarySearchTree<String>();
        bt.insert("one");
        bt.insert("two");
        bt.insert("turkey");
        assertNotNull(bt.find("one"));

        BinarySearchTree<String> treee = new BinarySearchTree<String>();
        treee.insert("apple");
        treee.insert("zebra");
        treee.insert("zen");
        assertNotNull(treee.find("zen"));



        bsTree.insert("ok");
        bsTree.insert("okay");
        bsTree.insert("k");
        bsTree.remove("ok");
        bsTree.remove("okay");
        assertNotNull(bsTree.find("k"));
        assertNull(bsTree.find("ok"));
        assertNull(bsTree.find("okay"));

        bsTree.insert("hey");
        bsTree.insert("hi");
        bsTree.insert("yes");
        bsTree.insert("no");

        bsTree.remove("no");
        assertNull(bsTree.find("no"));

        Exception thrown = null;
        try
        {
            bsTree.remove("no");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof ItemNotFoundException);

    }
    */

    // ----------------------------------------------------------
    /**
     * testFindMin method here.
     */
    public void testFindMin() {
        bsTree.insert("hi");
        bsTree.insert("how are you");
        bsTree.insert("what's up");

        assertEquals("hi", bsTree.findMin());

        bsTree.insert("apple");
        assertEquals("apple", bsTree.findMin());

        bsTree.makeEmpty();
        assertEquals(null, bsTree.findMin());
    }

    // ----------------------------------------------------------
    /**
     * testFindMax method here.
     */
    public void testFindMax() {
        bsTree.insert("hello");
        bsTree.insert("pickle");
        bsTree.insert("cupcake");

        assertEquals("pickle", bsTree.findMax());

        bsTree.insert("zen");
        assertEquals("zen", bsTree.findMax());

        bsTree.makeEmpty();
        assertEquals(null, bsTree.findMax());

    }

    // ----------------------------------------------------------
    /**
     * testFind method here.
     */
    public void testFind() {
        assertNull(bsTree.find("hi"));
        bsTree.insert("apple");
        bsTree.insert("banana");
        assertNotNull(bsTree.find("banana"));
    }

    // ----------------------------------------------------------
    /**
     * testMakeEmpty method here.
     */
    public void testMakeEmpty() {
        assertTrue(bsTree.isEmpty());
        bsTree.insert("cake");
        bsTree.insert("ice cream");
        assertFalse(bsTree.isEmpty());

        bsTree.makeEmpty();
        assertTrue(bsTree.isEmpty());

    }

    // ----------------------------------------------------------
    /**
     * test compareTrees method.
     */
    public void testCompareTrees() {
        BinarySearchTree<String> compare = new BinarySearchTree<String>();
        bsTree.insert("cake");
        bsTree.insert("pie");
        bsTree.insert("juce");
        bsTree.insert("cookie");
        bsTree.insert("apple");
        bsTree.insert("donut");
        bsTree.insert("coffee");

        compare.insert("cake");
        compare.insert("pie");
        compare.insert("juce");
        compare.insert("cookie");
        compare.insert("apple");
        compare.insert("coffee");
        compare.insert("doughnut");


        assertEquals(6, bsTree.compareTrees(compare));

    }

}
