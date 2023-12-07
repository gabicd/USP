#include <stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 128

char* acharoverlap(char** conjuntoreads, int n);
int overlapsize(char* read1, char* read2);
char* overlapstring(char* read1, char* read2, int size);
char* superstring(char* read1, char* read2, char* overlap, int size);
char* concatstr(char* read1, char* read2);
char* maiorstr (char* read1, char* read2);

int r1, r2;

int main (){
int n;
int t_aux;
int t_ov;
scanf("%d", &n);
char **conjuntoreads = (char **)calloc(n, sizeof(char*));
int* tamreads = (int *)calloc(n, sizeof(int));
char *reads = (char *)calloc(MAX, sizeof(char));


for (int i = 0; i < n; i++)
{    
    scanf("%s", reads);
    tamreads[i] = strlen(reads);
    conjuntoreads[i] = (char *)calloc((tamreads[i]+1), sizeof(char));
    strncpy(conjuntoreads[i], reads, tamreads[i]);
}

    free(reads);
    free(tamreads); 
    
    char *auxstr;
    char* strfinal;

        auxstr = acharoverlap(conjuntoreads, n);
        t_ov = overlapsize(conjuntoreads[r1], conjuntoreads[r2]);
        strfinal = superstring(conjuntoreads[r1], conjuntoreads[r2], auxstr, t_ov);
        
    printf("%s\n", strfinal);
    
    for (int i = 0; i < n; i++)
    {
        conjuntoreads[i] = NULL;
        free(conjuntoreads[i]);
    }
    
    free(strfinal);
    free(conjuntoreads);

return 0;

}

int overlapsize(char* read1, char* read2){
int t1 = strlen(read1)+1;
int t2 = strlen(read2)+1;
int chartcomp[t1][t2];
int maxover = 0;


for (int i = 0; i < t1; i++)
{
    for (int j = 0; j < t2; j++)
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

char* overlapstring(char* read1, char* read2,int size){
int t1 = strlen(read1)+1;
int t2 = strlen(read2)+1;
int k = 0;
int chartcomp[t1][t2];
char* overlap = (char*)malloc((size+1)*sizeof(char));

for (int i = 0; i < t1; i++)
{
    for (int j = 0; j < t2; j++)
    {
         if (i == 0 || j == 0) {
                chartcomp[i][j] = 0;
            } else if (read1[i - 1] == read2[j - 1]) {
                chartcomp[i][j] = chartcomp[i - 1][j - 1] + 1;
                if (chartcomp[i][j] == size)
                {
                    int aux = i-size;
                    for (k; k < size; k++)
                    {
                        overlap[k] = read1[aux];
                        aux++;
                    }
                }
            } else {
                chartcomp[i][j] = 0;
        }
   }
}

return overlap;
}

char* acharoverlap(char** conjuntoreads, int n){
    int moverlap = 0;    
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if(overlapsize(conjuntoreads[i], conjuntoreads[j]) > moverlap){
                    moverlap = overlapsize(conjuntoreads[i], conjuntoreads[j]);
                    r1=i;
                    r2 =j;
                }
                
            }
        }
  
    return overlapstring(conjuntoreads[r1], conjuntoreads[r2], moverlap);
}

char* concatstr(char* read1, char* read2){
int t1 = strlen(read1);
int t2 = strlen(read2);
int tamnovo = t1 + t2 + 2;
char* novastr = (char*)malloc(tamnovo * sizeof(char));

for (int i = 0; i < t1; i++)
{
    novastr[i] = read1[i];
}

for (int i = 0; i < t2; i++)
{
    novastr[i+t1] = read2[i];
}

return novastr;
}

char* maiorstr (char* read1, char* read2){
int t1 = strlen(read1);
int t2 = strlen(read2);

    if (t1<t2)
    {
       return read1;   }
    
return read2;
}

char* superstring(char* read1, char* read2, char* overlap, int size){
int tamnovo = strlen(read1) + strlen(read2) + 2;
char* sstr = (char*)malloc(tamnovo * sizeof(char));
int p1 = strncmp(read1, overlap, size); //read1 prefixo e read2 sufixo
int p2 = strncmp(read2, overlap, size); //read2 prefixo e read1 sufixo

    if (p1 == 0)
    {
        for (int i = 0; i < strlen(read2); i++)
        {
            sstr[i] = read2[i];
        }

        for (int i = 0; i < strlen(read1)-size; i++)
        {
            sstr[i+strlen(read2)] = read1[i+size];
        }
    
    }

    else if (p2 == 0)
    {
        for (int i = 0; i < strlen(read1); i++)
        {
            sstr[i] = read1[i];
        }

        for (int i = 0; i < strlen(read2)-size; i++)
        {
            sstr[i+strlen(read1)] = read2[i+size];
        }
    
    }

    else if (size == 0)
    {
        sstr = concatstr(read1, read2);
    }
    
    else
    {
        sstr = maiorstr(read1, read2);
    }

    return sstr;
}
