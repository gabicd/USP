#include <stdio.h>
#include <stdlib.h>
int pesquisar(int *vetor, int pesquisa, int n);

int main (){
int n, k;
scanf("%d", &n);
int *vetor = (int *)malloc(n * sizeof(int));

for (int i = 0; i < n; i++)
{
    scanf("%d", &vetor[i]);
}

scanf("%d", &k);
int *pesquisa = (int *)malloc(k * sizeof(int));

for (int i = 0; i < k; i++)
{
    scanf("%d", &pesquisa[i]);
}

for (int i = 0; i < k; i++)
{
   pesquisar(vetor, pesquisa[i], n);
}

    free(vetor);
    free(pesquisa); 

    return 0;

}

int pesquisar(int *vetor, int pesquisa, int n){
    int i = 0;

	while (i != n) {
		if (vetor[i] == pesquisa){
			return puts("1");
            break;
        }

		i++;
	}
	return puts("0");
}
