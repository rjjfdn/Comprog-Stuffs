#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

int main() {
    freopen("week3.txt", "r", stdin);
    char ch;
    int k;
    FILE* file = fopen("047_week3.txt", "w");
    fclose(file);
    while(1) {
        scanf("%c", &ch);
        if(ch == '$')
            break;
        scanf("%d\n", &k);
    }
}
