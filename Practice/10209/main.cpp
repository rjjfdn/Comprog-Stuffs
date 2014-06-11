#include <stdio.h>
#include <math.h>

using namespace std;

int main() {
    double B, C, x, a, y, z;
    double PI = atan(1)*4;
    while(scanf("%lf", &a) != EOF) {
        B = PI/4.0;
        C = PI/3.0 - sqrt(3.0)/4.0;
        x = 1-B-B+C;
        x = a*a*x;
        y = a*a*(B-C)-x;
        z = a*a-4*x-4*y;
        printf("%.3f %.3f %.3f\n", z, 4*y, 4*x);
    }
}
