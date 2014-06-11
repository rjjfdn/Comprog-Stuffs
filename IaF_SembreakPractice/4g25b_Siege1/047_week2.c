#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

int main() {
    freopen("week2.txt", "r", stdin);
    char ch;
    int k;
    FILE* file = fopen("047_week2.txt", "w");
    fclose(file);
    while(1) {
        scanf("%c", &ch);
        if(ch == '$')
            break;
        scanf("%d", &k);
        FILE* file = fopen("047_week2.txt", "a");
        fprintf(file, "#%d\n", k);
        int fx[25], gx[25], hx[25], px[50];
        int i;
        for(i=0; i<25; i++) {
            fx[i] = 0;
            gx[i] = 0;
            hx[i] = 0;
            px[i] = 0;
        }
        for(i=25; i<50; i++)
            px[i] = 0;
        for(i=0; i<3; i++) {
            while(1) {
                char inp[100];
                scanf("%s", inp);
                if(strcmp(inp, "@") == 0)
                    break;
                int coef, deg;
                sscanf(inp, "%dx%d", &coef, &deg);
                switch(i) {
                case 0:
                    fx[deg] = coef;
                    break;
                case 1:
                    gx[deg] = coef;
                    break;
                case 2:
                    hx[deg] = coef;
                    break;
                }
            }
        }
        int j;
        for(i=24; i>=0; i--) {
            for(j=24; j>=0; j--) {
                px[i+j] += fx[i]*gx[j];
            }
        }
        for(i=24; i>=0; i--)
            px[i] += hx[i];
        int check = 1;
        for(i=0; i<50; i++) {
            if(px[i] != 0) {
                check = 0;
                break;
            }
        }
        for(i=0; i<3; i++) {
            int d;
            scanf("%d\n", &d);
            if(check == 1) {
                fprintf(file, "zero polynomial\n");
                continue;
            }
            int ans = 0;
            while(1) {
                int ox[50];
                for(j=0; j<50; j++)
                    ox[j] = px[j];
                for(j=47; j>=0; j--)
                    ox[j] = ox[j] + (ox[j+1]*d);
                if(ox[0] == 0)
                    ans++;
                else break;
                for(j=0; j<48; j++)
                    px[j] = ox[j+1];
            }
            fprintf(file, "%d\n", ans);
        }
        fclose(file);
    }
}
