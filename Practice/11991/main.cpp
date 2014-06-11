#include <stdio.h>
#include <map>
#include <vector>
#include <iostream>

using namespace std;

vector<int> lst[1000010];

int main() {
    int n;
    while(scanf("%d", &n) != EOF) {
        int m;
        scanf("%d", &m);
        int arr[n];
        for(int i=0; i<n; i++)
            scanf("%d", &arr[i]);
        for(int i=0; i<=1000000; i++)
            lst[i].clear();
        for(int i=0; i<n; i++)
            lst[arr[i]].push_back(i+1);
        for(int i=0; i<m; i++) {
            int x, y;
            scanf("%d%d", &x, &y);
            if(lst[y].size() < x)
                printf("0\n");
            else
                printf("%d\n", lst[y][x-1]);
        }
    }
}
