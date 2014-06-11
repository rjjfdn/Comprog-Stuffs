#include <stdio.h>
#include <vector>
#include <string>

using namespace std;

int n, sum, m;
int table[21];
vector<int> answer;

void backtrack(int temp, int index, int s) {
    if(index == m) {
        if(s > sum && s <= n) {
            sum = s;
            answer.clear();
            while(temp != 0) {
                index--;
                if(temp%2 == 1)
                    answer.push_back(table[index]);
                temp/=2;
            }
        }
        return;
    }
    backtrack((temp*2+1), index+1, s+table[index]);
    backtrack(temp*2, index+1, s);
}

int main() {
    while(scanf("%d", &n) != EOF) {
        scanf("%d", &m);
        for(int i=0; i<m; i++)
            scanf("%d", &table[i]);
        answer.clear();
        sum = 0;
        vector<int> temp;
        backtrack(0, 0, 0);
        for(int i=0; i<answer.size(); i++)
            printf("%d ", answer[i]);
        printf("sum:%d\n", sum);
    }
    return 0;
}
