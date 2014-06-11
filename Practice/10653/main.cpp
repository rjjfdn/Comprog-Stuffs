#include <queue>
#include <cstdio>

using namespace std;

int main() {
    while(true) {
        int x, y;
        scanf("%d%d", &x, &y);
        if(x == 0 && y == 0)
            break;
        int matrix[x][y];
        int n;
        scanf("%d", &n);
        for(int i=0; i<x; i++)
            for(int j=0; j<y; j++)
                matrix[i][j] = 0;
        for(int i=0; i<n; i++) {
            int m, o;
            scanf("%d%d", &m, &o);
            for(int j=0; j<o; j++) {
                int p;
                scanf("%d", &p);
                matrix[m][p] = 1;
            }
        }
        int sx, sy, tx, ty;
        scanf("%d%d%d%d", &sx, &sy, &tx, &ty);
        queue<int> qx;
        queue<int> qy;
        queue<int> qc;
        qx.push(sx);
        qy.push(sy);
        qc.push(0);
        matrix[sx][sy] = 1;
        while(qx.size() != 0) {
            int xx = qx.front();
            int yy = qy.front();
            int cc = qc.front();
            qx.pop(); qy.pop(); qc.pop();
            if(xx == tx && yy == ty) {
                printf("%d\n", cc);
                break;
            }
            int xxx[4] = {0,1,0,-1};
            int yyy[4] = {1,0,-1,0};
            for(int i=0; i<4; i++) {
                if(xx+xxx[i] >= 0 && xx+xxx[i] < x)
                    if(yy+yyy[i] >= 0 && yy+yyy[i] < y)
                        if(matrix[xx+xxx[i]][yy+yyy[i]] != 1) {
                            matrix[xx+xxx[i]][yy+yyy[i]] = 1;
                            qx.push(xx+xxx[i]);
                            qy.push(yy+yyy[i]);
                            qc.push(cc+1);
                        }
            }
        }
    }
}
