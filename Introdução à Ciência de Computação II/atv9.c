#include <stdio.h>
#include <stdlib.h>

#define VAZIO -1

typedef struct {
    int chave;
    int elemento;
}
t_elemento;

typedef struct {
    t_elemento *tabela;
    int tamanho;
} hashtable;

int hashIndex(int elemento, int m);
void inicializarHash(hashtable *tabela,int m);
void hashInsert(hashtable *hashT, int elemento);
int hashSearch(hashtable *hashT, int elemento);
void hashRemove(hashtable *hashT, int elemento);

int main (){
int elemento;
unsigned int m, n, d, b;
scanf("%u", &m);
hashtable hashT;

inicializarHash(&hashT, m);

scanf("%u", &n);
for (int i = 0; i < n; i++)
{
    scanf("%d", &elemento);
    if (elemento < 0)
    {
        return 0;
    }
    
    hashInsert(&hashT, elemento);
}

scanf("%u", &d);
int *remover = (int *)malloc(d *sizeof(int));
for (int i = 0; i < d; i++)
{
scanf("%d", &remover[i]);
}

for (int i = 0; i < d; i++)
{
   hashRemove(&hashT, remover[i]);   
}

scanf("%u", &b);
int *busca = (int *)malloc(b *sizeof(int));
for (int i = 0; i < b; i++)
{
scanf("%d", &busca[i]);
}

for (int i = 0; i < b; i++)
{
    int resultado = hashSearch(&hashT, busca[i]);
    printf("%d ", resultado);
}

printf("\n"); 

free(hashT.tabela);
free(busca);
free(remover);

return 0;

}

int hashIndex(int elemento, int m){
    return elemento % m;
}

void inicializarHash(hashtable *hashT, int m){
    hashT->tabela = (t_elemento *)malloc(m * sizeof(t_elemento));
    hashT->tamanho = m;
    
    for (int i = 0; i < m; i++)
    {
       hashT->tabela[i].chave = VAZIO;
       hashT->tabela[i].elemento = VAZIO;
    }

}

void hashInsert(hashtable *hashT, int elemento){
    int index = hashIndex(elemento, hashT->tamanho);
    
    for (int i = 0; i < hashT->tamanho; i++)
    {
        if (hashT->tabela[i].chave == index && hashT->tabela[i].elemento != elemento)
        {
             index = hashIndex(index+1, hashT->tamanho);
        }   
    }
       
    hashT->tabela[index].chave = index;
    hashT->tabela[index].elemento = elemento;

}

int hashSearch(hashtable *hashT, int elemento){
    int index = hashIndex(elemento, hashT->tamanho);
    for (int i = 0; i < hashT->tamanho; i++)
    {
        if (hashT->tabela[i].chave == index && hashT->tabela[i].elemento != elemento)
        {
            index = hashIndex(index+1, hashT->tamanho);
        }
    }
    
    if (elemento == hashT->tabela[index].elemento)
    {
        return index;
    }

    return -1;

}

void hashRemove(hashtable *hashT, int elemento){
    int pesquisa = hashSearch(hashT, elemento);
    if (pesquisa != -1)
    {
        hashT->tabela[pesquisa].elemento = VAZIO;
    }
}

