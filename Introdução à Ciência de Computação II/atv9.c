#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int chave;
    int elemento;
}
t_elemento;

int hashIndex(int elemento, int m);
void hashInsert(int elemento,t_elemento hashVetor[], int m);
int hashSearch(t_elemento hashVetor[], int elemento, int m);
void hashRemove(t_elemento hashVetor[], int elemento, int m);

int main (){
int elemento;
unsigned int m, n, d, b;
scanf("%u", &m);
t_elemento *hashVetor = (t_elemento *)malloc(m * sizeof(t_elemento));   //cria o vetor da hash table e aloca a memoria necessaria

for (int i = 0; i < m; i++)
{
    hashVetor[i].chave = -1;
    hashVetor[i].elemento = -1;
}

scanf("%u", &n);

for (int i = 0; i < n; i++)
{
    scanf("%d", &elemento);
    if (elemento < 0)
    {
        return 0;
    }
    
    hashInsert(elemento, hashVetor, m);
}

scanf("%u", &d);
int *remover = (int *)malloc(d *sizeof(int));
for (int i = 0; i < d; i++)
{
scanf("%d", &remover[i]);
}

for (int i = 0; i < d; i++)
{
   hashRemove(hashVetor, remover[i], m);   
}

scanf("%u", &b);
int *busca = (int *)malloc(b *sizeof(int));
for (int i = 0; i < b; i++)
{
scanf("%d", &busca[i]);
}

for (int i = 0; i < b; i++)
{
    int resultado = hashSearch(hashVetor, busca[i], m);
    printf("%d ", resultado);
}

printf("\n"); 

free(hashVetor);
free(busca);
free(remover);

return 0;

}

int hashIndex(int elemento, int m){
    return (elemento % m);
}

void hashInsert(int elemento,t_elemento hashVetor[], int m){
    int index = hashIndex(elemento, m);
    
    for (int i = 0; i < m; i++)
    {
        if (hashVetor[i].chave == index && hashVetor[i].elemento != elemento)
        {
            index+=1;
        }
    }
    
    hashVetor[index].chave = index;
    hashVetor[index].elemento = elemento;

}

int hashSearch(t_elemento hashVetor[], int elemento, int m){
    int index = hashIndex(elemento, m);
    for (int i = 0; i < m; i++)
    {
        if (hashVetor[i].chave == index && hashVetor[i].elemento != elemento)
        {
            index+=1;
        }
    }

    if (elemento == hashVetor[index].elemento)
    {
        return index;
    }
    
        return -1;

}


void hashRemove(t_elemento hashVetor[], int elemento, int m){
    int pesquisa = hashSearch(hashVetor, elemento, m);
    if (pesquisa != -1)
    {
        hashVetor[pesquisa].elemento = -1;
    }
}
