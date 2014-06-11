#include <stdio.h>
#include <algorithm>
#include <cstring>
#include <cctype>
#include <string>

using namespace std;

int conv(char a) {
    string str = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    for(int i=0; i<str.size(); i++)
        if(str[i] == a)
            return i;
}

bool comp(char a, char b) {
    return conv(a) < conv(b);
}

int main() {
    int n;
    scanf("%d\n", &n);
    for(int i=0; i<n; i++) {
        char arr[100];
        gets(arr);
        sort(arr, arr+strlen(arr), comp);
        //puts(arr);
        do {
            puts(arr);
        } while(next_permutation(arr, arr+strlen(arr), comp));
    }
}
