#include <iostream>
#include <stdio.h>
#include <math.h>
#include <algorithm>

using namespace std;

int main() {
    unsigned long long n;
    cin >> n;
    unsigned long long arr[n];
    unsigned long long ans = 0;
    for(int i=0; i<n; i++) {
        cin >> arr[i];
        ans += arr[i];
    }
    sort(arr, arr+n);
    int x = (int)(log(n)/log(4));
    int j=0;
    for(int i=n-1; i>=max(0ULL, n-(int)(pow(4, x-1))); i--) {
        ans += arr[i] * (x - (int)(ceil(log(j+1)/log(4))));
        j++;
    }
    cout << ans;
}
