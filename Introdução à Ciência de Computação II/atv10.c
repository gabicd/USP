#include <stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 16

char* acharoverlap(char** conjuntoreads, int n, char* overlap);
int overlapsize(char* read1, char* read2);
char* overlapstring(char* read1, char* read2, int size, char* overlap);
char* superstring(char* read1, char* read2, char* overlap, int size);
char* maiorstr (char* read1, char* read2);

int r1, r2;

int main (){
int n;
int t_ov;
scanf("%d", &n);
char **conjuntoreads = (char **)calloc(n, sizeof(char*));

for (int i = 0; i < n; i++)
{    
    conjuntoreads[i] = (char *)calloc(MAX, sizeof(char));
}

for (int i = 0; i < n; i++)
{    
    scanf("%s", conjuntoreads[i]);  
}
    
    char *auxstr = (char*)calloc(MAX, sizeof(char));
    char *strfinal;

        auxstr = acharoverlap(conjuntoreads, n, auxstr);
        t_ov = overlapsize(conjuntoreads[r1], conjuntoreads[r2]);
        strfinal = superstring(conjuntoreads[r1], conjuntoreads[r2], auxstr, t_ov);

    printf("%s\n", strfinal);
    
    for (int i = 0; i < n; i++)
    {
       if (conjuntoreads[i] != NULL)
       {
            free(conjuntoreads[i]);        
       }
        
    }
    
    free(strfinal);
    free(auxstr);
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

char* overlapstring(char* read1, char* read2,int size, char* overlap){
int t1 = strlen(read1)+1;
int t2 = strlen(read2)+1;
int k = 0;
int chartcomp[t1][t2];


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

char* acharoverlap(char** conjuntoreads, int n, char* overlap){
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
    overlap = overlapstring(conjuntoreads[r1], conjuntoreads[r2], moverlap, overlap);
    return overlap;
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
int t1 = strlen(read1);
int t2 = strlen(read2);
int tamnovo = strlen(read1) + strlen(read2) + 2;
char* sstr = (char*)calloc(tamnovo, sizeof(char));
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
        for (int i = 0; i < t1; i++)
        {
            sstr[i] = read1[i];
        }

        for (int i = 0; i < t2; i++)
        {
            sstr[i+t1] = read2[i];
        }
    }
    
    else
    {
        sstr = maiorstr(read1, read2);
    }

    return sstr;
}
