#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int chave;
    int elemento;
}
t_elemento;

int hashIndex(int elemento, int m);
int hashInsert(int elemento,t_elemento hashVetor[], int m);
int hashSearch(t_elemento hashVetor[], int elemento, int m);
int hashRemove(t_elemento hashVetor[], int elemento, int m);

int main (){
int elemento;
int m, n, d, b;
scanf("%d", &m);
t_elemento *hashVetor = (t_elemento *)malloc(m * sizeof(t_elemento));   //cria o vetor da hash table e aloca a memoria necessaria

for (int i = 0; i < m; i++)
{
    hashVetor[i].chave = -1;
    hashVetor[i].elemento = -1;
}

scanf("%d", &n);

for (int i = 0; i < n; i++)
{
    scanf("%d", &elemento);
    hashInsert(elemento, hashVetor, m);
}

scanf("%d", &d);
int *remover = (int *)malloc(d *sizeof(int));
for (int i = 0; i < d; i++)
{
scanf("%d", &remover[i]);
}

for (int i = 0; i < d; i++)
{
   hashRemove(hashVetor, remover[i], m);
   
}

scanf("%d", &b);
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

int hashInsert(int elemento,t_elemento hashVetor[], int m){
    int index = hashIndex(elemento, m);
    
    for (int i = 0; i < m; i++)
    {
        if (hashVetor[i].chave == index && hashVetor[i].elemento != elemento)
        {
            index+=1;
        }
        
        if (hashVetor[i].chave == index && hashVetor[i].elemento == elemento){
            return 0;
        }
    }
    
    hashVetor[index].chave = index;
    hashVetor[index].elemento = elemento;

}

int hashSearch(t_elemento hashVetor[], int elemento, int m){
    int index = hashIndex(elemento, m);

    if (elemento == hashVetor[index].elemento)
    {
        return index;
    }
    
    else{
        return -1;
    }

}

int hashRemove(t_elemento hashVetor[], int elemento, int m){
    int pesquisa = hashSearch(hashVetor, elemento, m);
    if (pesquisa != -1)
    {
        hashVetor[pesquisa].elemento = -1;
    }
    return 0;
}
