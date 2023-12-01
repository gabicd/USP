#include <stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 128

int permutacao(int n);
int overlapsize(char* read1, char* read2);
char* overlapstring(char* read1, char* read2, int size);
char* maiorstr (char* read1, char* read2);

int main (){
int n;
scanf("%d", &n);
char **conjuntoreads = (char **)malloc(n * sizeof(char*));
int np = permutacao(n);
int *qovps = (int *)malloc(np * sizeof(int));

int j = 0;
for (int i = 0; i < n; i++)
{
    char *reads = (char *)malloc(MAX * sizeof(char));
    scanf("%s", reads);
    int tamreads = strlen(reads);
    conjuntoreads[i] = (char *)malloc(tamreads * sizeof(char));
    strcpy(conjuntoreads[i], reads);
}

int moverlap = 0;
int r1, r2;
for (int i = 0; i < n; i++)
{
    for (int j = i+1; j < n; j++)
    {
        if(overlapsize(conjuntoreads[i], conjuntoreads[j])> moverlap){
            moverlap = overlapsize(conjuntoreads[i], conjuntoreads[j]);
            r1=i;
            r2 =j;
        }
        
    }
}

printf("%s\n", overlapstring(conjuntoreads[r1], conjuntoreads[r2],moverlap));


for (int i = 0; i < n; i++)
{
    free(conjuntoreads[i]);
}

return 0;

}

char* maiorstr (char* read1, char* read2){
    if (strlen(read1)<strlen(read2))
    {
       return read1;   }
    
return read2;
}

int permutacao(int n){
int np = n;

for (int i = n-1; i > 0; i--)
{
    np = np *i;
}

return np;
}

int overlapsize(char* read1, char* read2){

int chartcomp[strlen(read1)][strlen(read2)];
int maxover = 0;

for (int i = 0; i <= strlen(read1); i++)
{
    for (int j = 0; j <= strlen(read2); j++)
    {
         if (i == 0 || j == 0) {
                chartcomp[i][j] = 0;
            } else if (read1[i - 1] == read2[j - 1]) {
                chartcomp[i][j] = chartcomp[i - 1][j - 1] + 1;
                maxover = (chartcomp[i][j] > maxover) ? chartcomp[i][j] : maxover;
            } else {
                chartcomp[i][j] = 0;
    }
    
}

}

return maxover;
}

char* overlapstring(char* read1, char* read2, int size){
int tamfinal = strlen(read1) + strlen(read2) + 1;
char* combinacao = (char *)malloc(tamfinal * sizeof(char));

int fixo = strncmp(read1, read2, size);
    if (fixo == 0)
    {
        for (int i = 0; i < strlen(read2); i++)
        {
            combinacao[i] = read2[i];
        }
        
        for (int i = 0; i < strlen(read1)-size; i++)
        {
            combinacao[i+(strlen(read2))] = read1[i+size];
        }
    }
    
    else{
        for (int i = 0; i < strlen(read1); i++)
        {
            combinacao[i] = read1[i];
        }
        
        for (int i = 0; i < strlen(read2)-size; i++)
        {
            combinacao[i+(strlen(read1))] = read2[i+size];
        }

    }

    return combinacao;
}
