#include <algorithm>
#include <cstdio>

using namespace std;

int main() {
    freopen("try.out", "w", stdout);
    char ch[3];
    gets(ch);
    do {
        printf("\"");
        printf("%s", ch);
        printf("\",");
    } while(next_permutation(ch, ch+4));
}
