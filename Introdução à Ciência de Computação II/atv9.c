#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
    unsigned int chave;
    unsigned int elemento;
} t_elemento;

int hashIndex(unsigned int chave, int m);
void hashInsert(unsigned int chave, unsigned int elemento, t_elemento *hashVetor, int m);


int main (){
unsigned int chave, elemento;
int m, n, d, b;
scanf("%d", &m);
t_elemento *hashVetor = (t_elemento *)malloc(m * sizeof(t_elemento));   //cria o vetor da hash table e aloca a memoria necessaria
scanf("%d", &n);
for (int i = 0; i < n; i++)
{
    scanf("%u", &chave);
    scanf("%u", &elemento);
    hashInsert(chave, elemento, hashVetor, m);
}

for (int i = 0; i < m; i++){
    printf("%d %u\n", i, hashVetor[i].elemento);
}

return 0;

}

void hashInsert(unsigned int chave, unsigned int elemento, t_elemento *hashVetor, int m){

    int index = hashIndex(chave, elemento);
    
    hashVetor[index].chave = chave;
    hashVetor[index].elemento = elemento;

}


int hashIndex(unsigned int chave, int m){
    return (chave % m);
}