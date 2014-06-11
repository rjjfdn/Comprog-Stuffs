#include<iostream>
#include<algorithm>
#include<stdio.h>
#include<string>

using namespace std;

int main() {
    freopen("pj.in", "r", stdin);
    string word;
    while(cin >> word) {
        int num;
        cin >> num;
        int count = 1;
        int check = 0;
        cout << word << " " << num << " = ";
        do {
            if(num == count) {
                cout << word << endl;
                check = 1;
            }
            count++;
        } while(next_permutation(word.begin(), word.end()));
        if(check == 0)
            cout << "No permutation" << endl;
    }
    return 0;
}
