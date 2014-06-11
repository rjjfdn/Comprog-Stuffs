#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

int main() {
    freopen("week4b.txt", "r", stdin);
    char ch;
    int k;
    FILE* file = fopen("047_week4b.txt", "w");
    fclose(file);
    int arr[] = {2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 113, 131, 197, 199, 311, 337, 373, 719, 733, 919, 971, 991, 1193, 1931, 3119, 3779, 7793, 7937, 9311, 9377, 11939, 19391, 19937, 37199, 39119, 71993, 91193, 93719, 93911, 99371};
    int size = 39;
    while(1) {
        scanf("%c", &ch);
        if(ch == '$')
            break;
        scanf("%d\n", &k);
        FILE* file = fopen("047_week4b.txt", "a");
        fprintf(file, "#%d\n", k);
        int cnt;
        scanf("%d\n", &cnt);
        int i;
        for(i=0; i<size; i++) {
            if(arr[i] >= cnt)
                break;
        }
        fprintf(file, "%d\n", i);
        fclose(file);
    }
}
