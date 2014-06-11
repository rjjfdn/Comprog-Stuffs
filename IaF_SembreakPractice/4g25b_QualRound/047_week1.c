#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
    freopen("week1.txt", "r", stdin);
    //freopen("047_week1.txt", "w", stdout);
    char ch;
    scanf("%c", &ch);
    int k;
    scanf("%d", &k);
    while(1) {
        if(ch == '$')
            break;
        FILE* file = fopen("047_week1.txt", "a");
        fprintf(file, "#%d\n", k);
        char s[1000];
        scanf("\ns=");
        gets(s);
        int n;
        scanf("n=%d\n", &n);
        char matrix[1000][1000];
        int idx = 0;
        while(1) {
            scanf("%s", matrix[idx]);
            if(matrix[idx][0] == '#' || matrix[idx][0] == '$') {
                ch = matrix[idx][0];
                k = 0;
                int i;
                for(i=1; i<1000; i++)
                    if(isdigit(matrix[idx][i]))
                        k = (k*10) + (int)(matrix[idx][i]-'0');
                break;
            }
            idx++;
        }
        int i;
        int maxval=0;
        char ans[strlen(s)-n+1][1000];
        int ansidx = 0;
        for(i=0; i<=strlen(s)-n; i++) {
            int j, q;
            int cnt = 0;
            for(j=0; j<idx; j++) {
                for(q=0; q<idx; q++) {
                    if(matrix[j][q] == s[i]) {
                        int xx[8] = {0,1,0,-1,1,1,-1,-1};
                        int yy[8] = {1,0,-1,0,1,-1,1,-1};
                        int l, m, o;
                        for(l=0; l<8; l++) {
                            int check = 0;
                            for(m=1; m<n; m++) {
                                if(j+(xx[l]*m) < 0 || j+(xx[l]*m) >= idx ||
                                   q+(yy[l]*m) < 0 || q+(yy[l]*m) >= idx) {
                                    check = 1;
                                    break;
                                }
                                if(s[i+m] != matrix[j+(xx[l]*m)][q+(yy[l]*m)]) {
                                    check = 1;
                                    break;
                                }
                            }
                            if(check == 0)
                                cnt++;
                        }
                    }
                }
            }
            int pal = 0;
            int e, f;
            for(e=0, f=strlen(s)-1; e<strlen(s); e++, f--) {
                if(s[e] != s[f]) {
                    pal = 1;
                    break;
                }
            }
            if(pal == 0)
                cnt /= 2;
            if(cnt == maxval) {
                int o;
                int c=0;
                for(o=i; o<i+n; o++)
                    ans[ansidx][c++] = s[o];
                ansidx++;
            }
            else if(cnt > maxval) {
                maxval = cnt;
                ansidx = 0;
                int o;
                int c=0;
                for(o=i; o<i+n; o++)
                    ans[ansidx][c++] = s[o];
                ansidx++;
            }
        }
        int w;
        for(w=0; w<ansidx; w++) {
            fprintf(file, "%s,", ans[w]);
        }
        fprintf(file, "%d\n", maxval);
        fclose(file);
    }
}
