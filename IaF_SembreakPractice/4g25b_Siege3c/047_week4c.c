#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

char decrypt(char enc) {
    char ch = (char)(((int)enc-(int)'a'-12+26)%26 + (int)'a');
}

int main() {
    FILE* file2 = fopen("dictionary.txt", "r");
    char dict[75][75];
    int didx = 0;
    while(1) {
        char tmp[75];
        fscanf(file2, "%s", tmp);
        if(strcmp(tmp, "$") == 0)
            break;
        int i;
        for(i=0; i<strlen(tmp); i++)
            tmp[i] = decrypt(tmp[i]);
        strcpy(dict[didx], tmp);
        didx++;
    }
    fclose(file2);
    freopen("week4c.txt", "r", stdin);
    char ch;
    int k;
    FILE* file = fopen("047_week4c.txt", "w");
    fclose(file);
    while(1) {
        scanf("%c", &ch);
        if(ch == '$')
            break;
        scanf("%d\n", &k);
        FILE* file = fopen("047_week4c.txt", "a");
        fprintf(file, "#%d\n", k);
        char temp[50];
        scanf("%s\n", temp);
        int i, j, l;
        char ans[75][75];
        int aidx = 0;
        for(i=0; i<didx; i++) {
            int check = 0;
            for(j=0; j<strlen(dict[i]); j++) {
                int chk = 0;
                for(l=0; l<strlen(temp); l++) {
                    if(dict[i][j] == temp[l]) {
                        chk = 1;
                        break;
                    }
                }
                if(chk == 0) {
                    check = 1;
                    break;
                }
            }
            if(check == 0) {
                strcpy(ans[aidx], dict[i]);
                aidx++;
            }
        }
        for(i=0; i<aidx; i++) {
            for(j=i+1; j<aidx; j++) {
                if(strcmp(ans[i], ans[j]) > 0) {
                    char teemp[75];
                    strcpy(teemp, ans[i]);
                    strcpy(ans[i], ans[j]);
                    strcpy(ans[j], teemp);
                }
            }
        }
        if(aidx == 0)
            fprintf(file, "NONE\n");
        else {
            for(i=0; i<aidx; i++)
                fprintf(file, "%s\n", ans[i]);
        }
        fclose(file);
    }
}
