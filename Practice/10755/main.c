#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    int i;
    for(i=0; i<n; i++) {
        int x, y, z;
        scanf("%d%d%d", &x, &y, &z);
        long long matrix[x][y][z];
        int j, k, l, a, b, c;
        for(j=0; j<x; j++)
            for(k=0; k<y; k++)
                for(l=0; l<z; l++)
                    scanf("%lld", &matrix[j][k][l]);
        for(j=0; j<x; j++)
            for(k=0; k<y; k++)
                for(l=0; l<z; l++) {
                    if(j != 0)
                        matrix[j][k][l] += matrix[j-1][k][l];
                    if(k != 0)
                        matrix[j][k][l] += matrix[j][k-1][l];
                    if(l != 0)
                        matrix[j][k][l] += matrix[j][k][l-1];
                    if(j != 0 && k != 0)
                        matrix[j][k][l] -= matrix[j-1][k-1][l];
                    if(l != 0 && k != 0)
                        matrix[j][k][l] -= matrix[j][k-1][l-1];
                    if(j != 0 && l != 0)
                        matrix[j][k][l] -= matrix[j-1][k][l-1];
                    if(j != 0 && k != 0 && l != 0)
                        matrix[j][k][l] += matrix[j-1][k-1][l-1];
                }
        long max = -2000000000;
        for(j=0; j<x; j++)
            for(k=0; k<y; k++)
                for(l=0; l<z; l++)
                    for(a=0; a<x; a++)
                        for(b=0; b<y; b++)
                            for(c=0; c<z; c++) {
                                long long temp = matrix[a][b][c];
                                if(j != 0)
                                    temp -= matrix[j-1][b][c];
                                if(k != 0)
                                    temp -= matrix[a][k-1][c];
                                if(l != 0)
                                    temp -= matrix[a][b][l-1];
                                if(j != 0 && k != 0)
                                    temp += matrix[j-1][k-1][c];
                                if(l != 0 && k != 0)
                                    temp += matrix[a][k-1][l-1];
                                if(j != 0 && l != 0)
                                    temp += matrix[j-1][b][l-1];
                                if(j != 0 && k != 0 && l != 0)
                                    temp -= matrix[j-1][k-1][l-1];
                                if(max < temp)
                                    max = temp;
                            }
        if(i != 0)
            printf("\n");
        printf("%lld\n", max);
    }
}
