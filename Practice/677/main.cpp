#include <stdio.h>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

int adjmat[15][15];
bool visited[15];
int counter;

void backtrack(string ans, int cur, int n, int start, int m) {
    for(int i=1; i<=n; i++) {
        if(adjmat[cur][i] == 1) {
            if(!visited[i]) {
                if(start+1 != m) {
                    visited[i] = true;
                    string str = static_cast<ostringstream*>( &(ostringstream() << i) )->str();
                    backtrack(ans+","+str, i, n, start+1, m);
                    visited[i] = false;
                }
                else {
                    cout << ans << "," << i << ")" << endl;
                    counter++;
                }
            }
        }
    }
}

int main() {
    int m, n, tmp, cases = 1;
    do {
        if(cases != 1)
            printf("\n");
        cases++;
        scanf("%d%d", &n, &m);
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                scanf("%d", &adjmat[i][j]);
        visited[1] = true;
        counter = 0;
        backtrack("(1", 1, n, 0, m);
        if(counter == 0)
            printf("no walk of length %d\n", m);
    } while(scanf("%d", &tmp) != EOF);
}

