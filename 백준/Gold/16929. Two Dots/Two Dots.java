import java.util.*;
public class Main {

    static int n;
    static int m;
    static char[][] graph;
    static boolean[][]visited;
    static int [][] dist;

    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};

    public static boolean dfs(int x, int y, int count, char color){
        if(visited[x][y]){
            if(count - dist[x][y] >= 4) return true;
            else return false;
        }
        visited[x][y] = true;
        dist[x][y] = count;

        for(int i =0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(0<= nx && nx<n && 0<=ny && ny <m ) {
                if(graph[nx][ny]==color){
                    if (dfs(nx, ny, count+1, color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new char[n][m];
        visited = new boolean[n][m];
        for(int i =0; i<n; i++){
            graph[i] = sc.next().toCharArray();
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<m ; j++){
                if(!visited[i][j]){
                    dist = new int[n][m];
                    boolean ok = dfs(i,j,1,graph[i][j]);

                    if(ok){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");
    }
}