#include <stdio.h>
#include <vector>
#include <cstring>
#include <string>
#include <iostream>

using namespace std;

typedef vector<int> vi;
#define LSOne(S) (S & (-S))

void ft_create(vi &ft, int n) {
    ft.assign(n+1, 0);
}

int ft_rsq(const vi &ft, int b) {
    int sum = 0;
    for(; b; b -= LSOne(b))
        sum += ft[b];
    return sum;
}

int ft_rsq(const vi &ft, int a, int b) {
    return ft_rsq(ft, b) - (a == 1 ? 0 : ft_rsq(ft, a-1));
}

void ft_adjust(vi &ft, int k, int v) {
    for(; k<(int)ft.size(); k+=LSOne(k))
        ft[k] += v;
}

int main() {
    int cases = 1;
    while(true) {
        int n;
        cin >> n;
        if(n == 0)
            break;
        vi ft;
        ft_create(ft, n);
        for(int i=0; i<n; i++) {
            int tmp;
            cin >> tmp;
            ft_adjust(ft, i+1, tmp);
        }
        if(cases != 1)
            printf("\n");
        printf("Case %d:\n", cases++);
        while(true) {
            string arrs;
            cin >> arrs;
            if(arrs == "END")
                break;
            int a, b;
            cin >> a >> b;
            //sscanf(arrs, "%c%d%d", &ch, &a, &b);
            if(arrs[0] == 'M') {
                printf("%d\n", ft_rsq(ft, a, b));
            }
            else {
                ft_adjust(ft, a, b-ft_rsq(ft, a, a));
            }
        }
    }
}
