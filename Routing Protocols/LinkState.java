import java.util.*;

public class LinkState
{
int index,cost;

public LinkState(int index,int cost)
{
this.index=index;
this.cost = cost;
}

public LinkState()
{

}

public static void main(String args[])
{

int n;

Scanner scan = new Scanner(System.in);
System.out.println("Enter the total no of nodes : ");

n=scan.nextInt();

int arr[][] = new int[n][n];

System.out.println("Enter the nodes and their cost : ");
int i,j;
for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
arr[i][j]=scan.nextInt();
}

}
System.out.println("\nThe Weighted matrix for the graph is :");
//char c;
for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{

System.out.print(arr[i][j]+" ");
}
System.out.println("");
}
System.out.println("Enter the source ");
int src = scan.nextInt();

LinkState R  = new LinkState();
R.linkState(arr,src);


}

int minDist(int dist[],boolean visited[])
{
int minDist = Integer.MAX_VALUE,minDistVertex=-1;

for(int i=0;i<dist.length;i++)
{
if(!visited[i] && (dist[i]<minDist))
{
minDist=dist[i];
   minDistVertex=i;
       }
}
return minDistVertex;
}

void linkState(int[][] graph,int source)
{
int count = graph.length;
boolean visited[] = new boolean[count];
int[] distance = new int[count];


for(int i =0;i<count;i++)
{
visited[i]=false;
distance[i]=Integer.MAX_VALUE;
}

distance[source]=0;
for(int i=0;i<count;i++)
{
int u = minDist(distance,visited);
visited[u]=true;

for(int v=0;v<count;v++)
{
if(!visited[v] && graph[u][v]!=0 && (distance[u]+graph[u][v]<distance[v]))
{
distance[v]=distance[u]+graph[u][v];
}
}
}
//System.out.println("Shortest path : \n");
System.out.print("Source\t\tDestination\t\tcost\n");
for (int i = 0;i<distance.length;i++)
{
System.out.println(source + "\t\t"+ i + "\t\t\t" + distance[i]);
}


ArrayList<LinkState> ar = new ArrayList<LinkState>();
        for(int i = 0;i<distance.length;i++)
        {
        ar.add(new LinkState(i,distance[i]));
        }
       
        System.out.println("\nShortest path : ");
        Collections.sort(ar,new SortbyCost());
       
        for (LinkState l :ar)
            System.out.print(l.index + " ");
}
    class SortbyCost implements Comparator<LinkState>
    {
public int compare(LinkState a , LinkState b)
{
return a.cost - b.cost;
//if (a.cost == b.cost)
   //return 0;
//else if (a.cost > b.cost)
//return 1;
//else
//return -1;
}
    }
}
