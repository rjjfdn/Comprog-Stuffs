#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

char str[50];
char arr[220][50];
int num[220];
double sim[220];
char key[50];
int arrsize;

/*void bsort() {
    int i,j;
    for(i=0; i<arrsize; i++) {
        for(j=i+1; j<arrsize; j++) {
            if(cmp(arr[i], arr[j]) > 0) {
                char tmp[50];
                strcpy(tmp, arr[i]);
                strcpy(arr[i], arr[j]);
                strcpy(arr[j], tmp);
            }
        }
    }
}

int cmp(char arr1[50], char arr2[50]) {
    return strcmp(arr1, arr2);
}

void qsort(int first, int last) {
    int pivot, j, i;
    if(first < last) {
        pivot = first;
        i = first;
        j = last;
        while(i < j) {
            while(cmp(arr[i], arr[pivot]) <= 0 && i < last)
                i++;
            while(cmp(arr[j], arr[pivot]) > 0)
                j--;
            if(i < j) {
                char tmp[50];
                strcpy(tmp, arr[i]);
                strcpy(arr[i], arr[j]);
                strcpy(arr[j], tmp);
            }
        }
        char tmp[50];
        strcpy(tmp, arr[pivot]);
        strcpy(arr[pivot], arr[j]);
        strcpy(arr[j], tmp);
        qsort(first, j-1);
        qsort(j+1, last);
    }
}

int bsearch() {
    int first = 0;
    int last = arrsize-1;
    int middle = (first+last)/2;
    while(first <= last) {
        int cmp = strcmp(arr[middle], key);
        if(cmp < 0)
            first = middle+1;
        else if(cmp > 0)
            last = middle-1;
        else
            return middle;
    }
    return -1;
}*/

int conv(char ch) {
    switch(ch) {
    case 'a': case 'b': case 'c':
        return 1;
    case 'd': case 'e': case 'f':
        return 2;
    case 'g': case 'h': case 'i':
        return 3;
    case 'j': case 'k': case 'l':
        return 4;
    case 'm': case 'n': case 'o':
        return 5;
    case 'p': case 'q': case 'r':
        return 6;
    case 's': case 't': case 'u':
        return 7;
    case 'v': case 'w': case 'x':
        return 8;
    case 'y': case 'z':
        return 9;
    }
}

int cmp(char a[50], char b[50]) {
    char c[50];
    char d[50];
    int i;
    for(i=0; i<strlen(a); i++)
        c[i] = (char)(conv(a[i])+'0');
    for(i=0; i<strlen(b); i++)
        d[i] = (char)(conv(b[i])+'0');
    return strcmp(c, d);
}

int search(char bigram[50][2], char bgram[2], int size) {
    int i;
    for(i=0; i<size; i++) {
        if(bigram[i][0] == bgram[0] && bigram[i][1] == bgram[1])
            return i;
    }
    return -1;
}

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
        memset(str, 0, sizeof str);
        memset(num, 0, sizeof num);
        memset(sim, 0, sizeof sim);
        memset(key, 0, sizeof key);
        int q;
        for(q=0; q<220; q++)
            memset(arr[q], 0, sizeof arr[q]);
        FILE* file = fopen("047_week3.txt", "a");
        fprintf(file, "#%d\n", k);
        gets(str);
        arrsize = 0;
        int i,j,k;
        for(i=0; i<strlen(str); i++) {
            int cur = conv(str[i]);
            for(j=i+1; j<strlen(str); j++) {
                if(cur+conv(str[j]) <= 10) {
                    for(k=i; k<=j; k++)
                        arr[arrsize][k-i] = str[k];
                    num[arrsize] = cur+conv(str[j]);
                    arrsize++;
                    cur += conv(str[j]);
                }
                else break;
            }
        }
        for(i=0; i<arrsize; i++) {
            int bgramsize = 0;
            char bgram[50][2];
            int cgramsize = 0;
            char cgram[50][2];
            for(k=0; k<strlen(str)-1; k++) {
                char b[2];
                b[0] = str[k];
                b[1] = str[k+1];
                int idx1 = search(bgram, b, bgramsize);
                if(idx1 < 0) {
                    bgram[bgramsize][0] = b[0];
                    bgram[bgramsize][1] = b[1];
                    bgramsize++;
                }
                int idx2 = search(cgram, b, cgramsize);
                if(idx2 < 0) {
                    cgram[cgramsize][0] = b[0];
                    cgram[cgramsize][1] = b[1];
                    cgramsize++;
                }
            }
            int agramsize = 0;
            char agram[50][2];
            int count = 0;
            for(k=0; k<strlen(arr[i])-1; k++) {
                char b[2];
                b[0] = arr[i][k];
                b[1] = arr[i][k+1];
                int idx1 = search(agram, b, agramsize);
                if(idx1 < 0) {
                    agram[agramsize][0] = b[0];
                    agram[agramsize][1] = b[1];
                    agramsize++;
                }
                int idx2 = search(cgram, b, cgramsize);
                if(idx2 >= 0 && idx1 < 0) {
                    count++;
                }
            }
            sim[i] = (2.0*count)/(agramsize+bgramsize);
        }
        for(i=0; i<arrsize; i++) {
            for(j=i+1; j<arrsize; j++) {
                if(sim[i] < sim[j]) {
                    char tmp[50];
                    strcpy(tmp, arr[i]);
                    strcpy(arr[i], arr[j]);
                    strcpy(arr[j], tmp);
                    int tmp2 = num[i];
                    num[i] = num[j];
                    num[j] = tmp2;
                    double tmp3 = sim[i];
                    sim[i] = sim[j];
                    sim[j] = tmp3;
                }
                else if(sim[i] == sim[j]) {
                    if(num[i] > num[j]) {
                        char tmp[50];
                        strcpy(tmp, arr[i]);
                        strcpy(arr[i], arr[j]);
                        strcpy(arr[j], tmp);
                        int tmp2 = num[i];
                        num[i] = num[j];
                        num[j] = tmp2;
                        double tmp3 = sim[i];
                        sim[i] = sim[j];
                        sim[j] = tmp3;
                    }
                    else if(num[i] == num[j]) {
                        if(cmp(arr[i], arr[j]) < 0) {
                            char tmp[50];
                            strcpy(tmp, arr[i]);
                            strcpy(arr[i], arr[j]);
                            strcpy(arr[j], tmp);
                            int tmp2 = num[i];
                            num[i] = num[j];
                            num[j] = tmp2;
                            double tmp3 = sim[i];
                            sim[i] = sim[j];
                            sim[j] = tmp3;
                        }
                        else if(cmp(arr[i], arr[j]) == 0) {
                            if(strcmp(arr[i], arr[j]) > 0) {
                                char tmp[50];
                                strcpy(tmp, arr[i]);
                                strcpy(arr[i], arr[j]);
                                strcpy(arr[j], tmp);
                                int tmp2 = num[i];
                                num[i] = num[j];
                                num[j] = tmp2;
                                double tmp3 = sim[i];
                                sim[i] = sim[j];
                                sim[j] = tmp3;
                            }
                        }
                    }
                }
            }
        }
        if(arrsize == 0) {
            fprintf(file, "none\n");
            fclose(file);
            continue;
        }
        fprintf(file, "%d %s %.3f [", num[0], arr[0], sim[0]);
        fprintf(file, "%d", conv(arr[0][0]));
        for(j=1; j<strlen(arr[0]); j++)
            fprintf(file, " %d", conv(arr[0][j]));
        fprintf(file, "]\n");
        for(i=1; i<arrsize; i++) {
            if(sim[i] != sim[0])
                break;
            if(strcmp(arr[i], arr[i-1]) == 0)
                continue;
            fprintf(file, "%d %s %.3f [", num[i], arr[i], sim[i]);
            fprintf(file, "%d", conv(arr[i][0]));
            for(j=1; j<strlen(arr[i]); j++)
                fprintf(file, " %d", conv(arr[i][j]));
            fprintf(file, "]\n");
        }
        fclose(file);
    }
}
