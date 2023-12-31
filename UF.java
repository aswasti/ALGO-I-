import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFind uf = new QuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
            else{
                System.out.println("Already connected" );
                for (int i = 0; i < uf.displayid().length; i++) {
                   System.out.print(uf.displayid()[i]);
                }
                
            }
        }
    }
}

class QuickFind {
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    public int[] displayid()
    {
        return id;
    }
}

class QuickUnionUF{
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
        
