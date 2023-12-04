#include <stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 128

char* concatstr(char* read1, char* read2);
int compstring(char* read1, char* read2, int size);
char* melhoroverlap(char** conjuntoreads, int n);
int permutacao(int n);
int overlapsize(char* read1, char* read2);
char* overlapstring(char* read1, char* read2, int size);
char* maiorstr (char* read1, char* read2);
char* checksufix(char* read1, int size); 

int r1, r2;

int main (){
int n;
scanf("%d", &n);
char **conjuntoreads = (char **)malloc(n * sizeof(char*));

int j = 0;
for (int i = 0; i < n; i++)
{
    char *reads = (char *)malloc(MAX * sizeof(char));
    scanf("%s", reads);
    int tamreads = strlen(reads);
    conjuntoreads[i] = (char *)malloc(tamreads * sizeof(char));
    strcpy(conjuntoreads[i], reads);
}

    printf("%s\n", melhoroverlap(conjuntoreads, n));
    

for (int i = 0; i < n; i++)
{
    free(conjuntoreads[i]);
}

return 0;

}

int compstring(char* read1, char* read2, int size){
char* sufixo = (char *)malloc((size+1) * sizeof(char));
for (int i = 0; i < size; i++)
{
    sufixo[i] = read1[i+(strlen(read1)-size)];
}

if (strncmp(sufixo, read2, size) == 0)
{
    return 1;
}

return -1;
}

char* maiorstr (char* read1, char* read2){
    if (strlen(read1)<strlen(read2))
    {
       return read1;   }
    
return read2;
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

char* concatstr(char* read1, char* read2){
int tamnovo = strlen(read1) + strlen(read2) + 1;
char* novastr = (char*)malloc(tamnovo * sizeof(char));

for (int i = 0; i < strlen(read1); i++)
{
    novastr[i] = read1[i];
}

for (int i = 0; i < strlen(read2); i++)
{
    novastr[i+strlen(read1)] = read2[i];
}

return novastr;
}

char* overlapstring(char* read1, char* read2, int size){
int tamfinal = strlen(read1) + strlen(read2) + 1;
char* combinacao = (char *)malloc(tamfinal * sizeof(char));
char* auxstr1 = checksufix(read1, size);
char* auxstr2 = checksufix(read2, size);

//read1 como parametro
int prfx1 = strncmp(read1, read2, size);
int sfx1 = strncmp(auxstr1, read2, size);
//read2 como parametro    
int prfx2 = strncmp(read2, read1, size);
int sfx2 = strncmp(auxstr2, read1, size);
//printf("%d\n%d\n",prfx1, sfx2);

    if (prfx1 == 0)
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

    else if (size == 0)
    {    
    combinacao = concatstr(read1,read2);
    }

        else if (sfx2 == 0)
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


    else if (sfx1 == 0)
     {
        //printf("%d\n", fixo);
        for (int i = 0; i < strlen(read1); i++)
        {
            combinacao[i] = read1[i];
        }
        
        for (int i = 0; i < strlen(read2)-size; i++)
        {
            combinacao[i+(strlen(read1))] = read2[i+size];
        }

    }

    
    else{
        combinacao = maiorstr(read1, read2);
    }

    return combinacao;
}

char* melhoroverlap(char** conjuntoreads, int n){
    int moverlap = 0;
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

    return overlapstring(conjuntoreads[r1], conjuntoreads[r2], moverlap);
}

char* checksufix(char* read1, int size){
char* nstr = (char *)malloc((size+1)*sizeof(char));
int aux = strlen(read1)-size;

for (int i = 0; i <= size; i++)
{
    nstr[i] = read1[i+aux];
}

//printf("%s\n", nstr);
return nstr;
}
