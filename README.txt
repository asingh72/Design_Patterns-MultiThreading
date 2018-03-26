## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[Number of threads] -Darg3="[words that need to be deleted]" -Darg4=[DEBUG_VALUE]

-----------------------------------------------------------------------
Tree and other data structures used

We have used AVL tree for storing words as in worst case AVL performs in 
O(logn) due to rebalancing of nodes in the tree whereas BST performs in 
O(n).

-----------------------------------------------------------------------

We have referred the code for AVL tree insertion and rotation from below 
Reference link:

http://www.sanfoundry.com/java-program-implement-avl-tree/