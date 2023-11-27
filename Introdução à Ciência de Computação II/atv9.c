#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int chave;
    unsigned int elemento;
}
t_elemento;

int hashIndex(unsigned int elemento, int m);
int hashInsert(unsigned int elemento,t_elemento hashVetor[], int m);
int hashSearch(t_elemento hashVetor[], unsigned int elemento);

int main (){
unsigned int elemento;
int m, n, d, b;
scanf("%d", &m);
t_elemento *hashVetor = (t_elemento *)malloc(m * sizeof(t_elemento));   //cria o vetor da hash table e aloca a memoria necessaria

for (int i = 0; i < m; i++)
{
    hashVetor[i].chave = -1;
    hashVetor[i].elemento = 0;
}

scanf("%d", &n);

for (int i = 0; i < n; i++)
{
    scanf("%u", &elemento);
    hashInsert(elemento, hashVetor, m);
}

for (int i = 0; i < m; i++){
    printf("%d %u\n", i, hashVetor[i].elemento);
}

return 0;

}

int hashIndex(unsigned int elemento, int m){
    return (elemento % m);
}

int hashInsert(unsigned int elemento,t_elemento hashVetor[], int m){
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

