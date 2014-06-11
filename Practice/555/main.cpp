#include <cstdio>
#include <cstring>
#include <map>
#include <algorithm>

using namespace std;

map<char, int> suit, num;

bool comp(char* a, char* b) {
    if(a[0] != b[0])
        return a[0] - b[0];
    else
        return a[1] - b[1];
}

int main() {
    char ch[10];
    char deck1[104], deck2[104];
    suit['C'] = 0;
    suit['D'] = 1;
    suit['S'] = 2;
    suit['H'] = 3;
    num['2'] = 0;
    num['3'] = 1;
    num['4'] = 2;
    num['5'] = 3;
    num['6'] = 4;
    num['7'] = 5;
    num['8'] = 6;
    num['9'] = 7;
    num['T'] = 8;
    num['J'] = 9;
    num['Q'] = 10;
    num['K'] = 11;
    num['A'] = 12;
    while(true) {
        gets(ch);
        int start = 0;
        if(strcmp(ch, "#") == 0)
            break;
        else if(strcmp(ch, "W") == 0)
            start = 0;
        else if(strcmp(ch, "N") == 0)
            start = 1;
        else if(strcmp(ch, "E") == 0)
            start = 2;
        else if(strcmp(ch, "S") == 0)
            start = 3;
        int n=0, e=0, s=0, w=0;
        char ans[4][13][2];
        memset(deck1, 0, sizeof deck1);
        memset(deck2, 0, sizeof deck2);
        gets(deck1);
        gets(deck2);
        strcat(deck1, deck2);
        puts(deck1);
        for(int i=0; i<strlen(deck1); i+=2) {
            switch(start) {
            case 0:
                ans[start][n][0] = deck1[i];
                ans[start][n][1] = deck1[i+1];
                puts(ans[start][n]);
                printf("%c-%c-%d\n", deck1[i], deck1[i+1], strlen(ans[start][n]));
                n++;
                start = 1;
                break;
            case 1:
                ans[start][e][0] = deck1[i];
                ans[start][e][1] = deck1[i+1];
                e++;
                start = 2;
                break;
            case 2:
                ans[start][s][0] = deck1[i];
                ans[start][s][1] = deck1[i+1];
                s++;
                start = 3;
                break;
            default:
                ans[start][w][0] = deck1[i];
                ans[start][w][1] = deck1[i+1];
                w++;
                start = 0;
                break;
            }
        }
        printf("S:");
        for(int i=0; i<13; i++) {
            for(int j=i+1; j<13; j++) {
                if(comp(ans[2][i], ans[2][j]) > 0) {
                    char temp = ans[2][i][0];
                    ans[2][i][0] = ans[2][j][0];
                    ans[2][j][0] = temp;
                    temp = ans[2][i][1];
                    ans[2][i][1] = ans[2][j][1];
                    ans[2][j][1] = temp;
                }
            }
        }
        for(int i=0; i<13; i++) {
            printf(" %s", ans[2][i]);
        }
        printf("\nW:");
        for(int i=0; i<13; i++) {
            for(int j=i+1; j<13; j++) {
                if(comp(ans[3][i], ans[3][j]) > 0) {
                    char temp = ans[3][i][0];
                    ans[3][i][0] = ans[3][j][0];
                    ans[3][j][0] = temp;
                    temp = ans[3][i][1];
                    ans[3][i][1] = ans[3][j][1];
                    ans[3][j][1] = temp;
                }
            }
        }
        for(int i=0; i<13; i++) {
            printf(" %s", ans[3][i]);
        }
        printf("\nN:");
        for(int i=0; i<13; i++) {
            for(int j=i+1; j<13; j++) {
                if(comp(ans[0][i], ans[0][j]) > 0) {
                    char temp = ans[0][i][0];
                    ans[0][i][0] = ans[0][j][0];
                    ans[0][j][0] = temp;
                    temp = ans[0][i][1];
                    ans[0][i][1] = ans[0][j][1];
                    ans[0][j][1] = temp;
                }
            }
        }
        for(int i=0; i<13; i++) {
            printf(" %s", ans[0][i]);
        }
        printf("\nE:");
        for(int i=0; i<13; i++) {
            for(int j=i+1; j<13; j++) {
                if(comp(ans[1][i], ans[1][j]) > 0) {
                    char temp = ans[1][i][0];
                    ans[1][i][0] = ans[1][j][0];
                    ans[1][j][0] = temp;
                    temp = ans[1][i][1];
                    ans[1][i][1] = ans[1][j][1];
                    ans[1][j][1] = temp;
                }
            }
        }
        for(int i=0; i<13; i++) {
            printf(" %s", ans[1][i]);
        }
        printf("\n");
    }
}
