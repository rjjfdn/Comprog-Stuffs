#include <cstdio>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

bool comp(pair<int, pair<int, int> > first, pair<int, pair<int, int> > second) {
    if(first.first != second.first)
        return first.first - second.first;
    else
        return first.second.first - second.second.first;
}

int main() {
    int n,m;
    while(true) {
        scanf("%d", &n); // != EOF
        scanf("%d", &m);
        if(n == 0 && m == 0)
            break;
        int arr[n];
        for(int i=0; i<n; i++)
            arr[i] = i;
        vector< pair<int, pair<int, int> > > friends;
        vector< pair<int, pair<int, int> > > enemies;
        for(int i=0; i<m; i++) {
            int x, y, z;
            scanf("%d%d%d", &x, &y, &z);
            if(z >= 0)
                friends.push_back(make_pair(min(x, y), make_pair(max(x, y), z)));
            else
                enemies.push_back(make_pair(min(x, y), make_pair(max(x, y), -z)));
        }
        sort(friends.begin(), friends.end(), comp);
        sort(enemies.begin(), enemies.end(), comp);
        int counter = 0;
        do {
            bool check = true;
            for(int i=0; i<friends.size(); i++) {
                int x = friends[i].first;
                int y = friends[i].second.first;
                int z = friends[i].second.second;
                int diff = abs(arr[x] - arr[y]);
                if(diff > z) {
                    check = false;
                    break;
                }
            }
            if(!check)
                continue;
            for(int i=0; i<enemies.size(); i++) {
                int x = enemies[i].first;
                int y = enemies[i].second.first;
                int z = enemies[i].second.second;
                int diff = abs(arr[x] - arr[y]);
                if(diff < z) {
                    check = false;
                    break;
                }
            }
            if(check)
                counter++;
        } while(next_permutation(arr, arr+n));
        printf("%d\n", counter);
    }
}
