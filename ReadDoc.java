package catchPlagiarist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * This class will read a directory. It will read the files with a scanner
 * and put the ngrams for each file into a bst. There will be one bst for each
 * file. Each bst will be put into an array list so they may be compared.
 * The compareTrees will compare the amount of same word sequences between
 * each file and print the results.
 *
 * @author lizzielitt
 * @version Nov 17, 2015
 */
public class ReadDoc
{
    private int numSequence;
    private String DirectoryName;
    private int copied;
    private ArrayList<BinarySearchTree<Integer>> arrList;


    // ----------------------------------------------------------
    /**
     * Create a new ReadDoc object.
     * @param directoryName is the name of the directory
     * @param numbOfSequences is the number of sequences which will print
     * @param common number of n-gram sequences in common
     */
    public ReadDoc(String directoryName, String numbOfSequences, String common)
    {
        DirectoryName = directoryName;

        try
        {
            numSequence = Integer.parseInt(numbOfSequences);

            if (numSequence < 1) {
                System.out.println("input a number sequence greater than 0!");
            }

        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

        try
        {
            copied = Integer.parseInt(common);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------
    /**
     * read a files from folder asked for in the argument. Converts strings to
     * ints then put into new bst for each file. Puts each bst into arraylist
     * @throws FileNotFoundException when file isn't found
     * @throws IOException for IO exception
     */

    public void readDir()
    {
        arrList = new ArrayList<BinarySearchTree<Integer>>();
        File directory = new File(DirectoryName);

        try
        {

            for (File file : directory.listFiles())
            {
                // create new BST for each file and read files
                BinarySearchTree<Integer> bst1 =
                    new BinarySearchTree<Integer>();
                FileReader fileRead = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileRead);
                String line;
                LinkedList<String> list = new LinkedList<String>();

                while ((line = bufferedReader.readLine()) != null)
                {
                    Scanner scan = new Scanner(line);
                    while (scan.hasNext())
                    {
                        if (list.size() == numSequence)
                        {
                            String stringList = "";
                            for (int i = 0; i < list.size(); i++)
                            {
                                stringList += list.get(i);

                            }
                            // print ngram word sequences and convert to int
                            // System.out.println(stringList);
                            // System.out.println(stringList.hashCode());

                            // insert ints into tree
                            bst1.insert(stringList.hashCode());

                            // find and set file names
                            bst1.find(stringList.hashCode(), bst1.getRoot())
                                .setFileName(file.getName());

                            list.remove();

                        }
                        list.add(scan.next());

                    }
                    scan.close();

                }
                arrList.add(bst1);
                bufferedReader.close();

            }

        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("File not found!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    // ----------------------------------------------------------
    /**
     * compareTrees compares each tree (which holds ngrams for each file) in the
     * array list against each other to check for number of similarities.
     */
    public void compareTrees()
    {
        // nested for loops to go thru array and compare each tree to all others
        for (int i = 0; i < arrList.size(); i++)
        {
            for (int j = i + 1; j < arrList.size(); j++)
            {
                // print #copies and file names for matches >= input m-gram
                // if there are none, nothing is printed
                if (arrList.get(i).compareTrees(arrList.get(j)) >= copied)
                {
                    int copies = arrList.get(i).compareTrees(arrList.get(j));

                    System.out.println(
                        copies + ": " + arrList.get(i).getRoot().getFileName()
                            + " & " + arrList.get(j).getRoot().getFileName());
                }
            }

        }

    }

}
