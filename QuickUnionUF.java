public class QuickUnionUF{
  private int[] id;

  //Set id of the object to itself
  public QuickUnionUF(int N)
  {
    id = new int[N];
    for (int i = 0; i< N; i++)
    {
      id[i] = i;
    }
  }

  private int root(int i)
  {
    // Chase parent pointers until reach root id[i] is parent while i is child
    // if i == if[i] return child ie i only
    // if i != id[i], set i as child of parent id[i]
    while(i != id[i]) i = id[i];
    return i;
  }

  private boolean connected(int p, int q)
  {
    // Check if p and q have the same root
    return root(p) == root(q);
  }

  public void union(int p, int q)
  {
    //change root of p to point to root of q
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }
        
