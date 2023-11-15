#include <stdio.h>
#include <stdlib.h>

int pesquisar(int *vetor, int l, int r, int pesquisa);
void ShellSort(int v[], int n);

int main (){
int n, k;
scanf("%d", &n);
int *vetor = (int *)malloc(n * sizeof(int));

for (int i = 0; i < n; i++)
{
    scanf("%d", &vetor[i]);
}

ShellSort(vetor, n);

scanf("%d", &k);
int *pesquisa = (int *)malloc(k * sizeof(int));

for (int i = 0; i < k; i++)
{
    scanf("%d", &pesquisa[i]);
}

    for (int i = 0; i < k; i++)
    {
        pesquisar(vetor, 0, n-1, pesquisa[i]);
    }

    free(vetor);
    free(pesquisa); 

    return 0;

}

int pesquisar(int *vetor, int l, int r, int pesquisa){
    	while (l <= r) {
		int m = l + (r - l) / 2;

		if (vetor[m] == pesquisa)
			return puts("1");

		if (vetor[m] < pesquisa)
			l = m + 1;

		else
			r = m - 1;
	}

	return puts("0");
}

void ShellSort(int v[], int n)
{

    int gap = 1;

    while (gap <= n)
    {
        gap *= 2;
    }

    gap = (gap / 2) - 1;

    while (gap > 0)
    {
        for (int i = gap; i < n; i++)
        {
            int x = v[i];
            int j = i - gap;

            while (j >= 0)
            {
                if( v[j] <= x )
                {                    
                    break;
                }

                v[j + gap] = v[j];
                j -= gap;
            }

            v[j + gap] = x;
            
        }

        gap /= 2;
    }
}
