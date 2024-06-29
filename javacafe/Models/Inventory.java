package javacafe.Models;

import java.io.*;

/**
 * Defini o inventário com a quantidade de cada ítem
 */
public class Inventory {
    private int nCapuccino;
    private int nLatte;
    private int nMate;
    private int nEspressoF;
    private int nEspresso;
    private int nCookie;
    private int nBrownie;

    public Inventory() throws IOException {
        loadInventory();
    }


    public int getInventory(int item) {
        switch (item) {
            case 0:
                return nCapuccino;
            case 1:
                return nLatte;
            case 2:
                return nMate;
            case 3:
                return nEspressoF;
            case 4:
                return nEspresso;
            case 5:
                return nCookie;
            case 6:
                return nBrownie;
        }
        return 0;
    }


    /**
     * Retorna a quantidade de itens na linha do arquivo Inventory.txt passada
     *
     * @param line String
     * @return int n
     */
    private int getNFromLine(String line) {
        return Integer.parseInt(line.split(":")[1]);
    }


    /**
     * <p>
     * Executa a leitura do aquivo inventory.txt e retorna a quantidade de cada ítem
     * </p>
     *
     * @return retorna um vetor com a quantidade de cada item. [0] = capuccino [1] = latte [2] = mate [3] = espresso forte [4] = espresso [5] = cookie [6] = brownie
     * @throws IOException
     */
    private int[] readInventoryFile() throws IOException {
        int[] vec = new int[7];
        BufferedReader br = new BufferedReader(new FileReader("files/inventory.txt"));
        for (int i = 0; i < 7; i++) {
            String string = br.readLine();
            int n = getNFromLine(string);
            vec[i] = n;
        }

        return vec;
    }

    private void loadInventory() throws IOException {
        int[] v = readInventoryFile();
        nCapuccino = v[0];
        nLatte = v[1];
        nMate = v[2];
        nEspressoF = v[3];
        nEspresso = v[4];
        nCookie = v[5];
        nBrownie = v[6];
    }


    /**
     * Adiciona ou subtrai 1 unidade do item especificado.
     *
     * @param product: 0 = capuccino | 1 = latte | 2 = mate | 3 = espresso forte | 4 = espresso | 5 = cookie | 6 = brownie
     * @param opt:    0 = subtrair | 1 = adicionar
     * @return 1 se for possivel subtrair ou 0 se o inventário estiver cheio
     */
    public int update(int product, int opt) throws IOException {
        if (opt == 0) {
            if (getInventory(product) < 0) {
                System.out.println("ESTOQUE DO ITEM " + product + " VAZIO!");
                return 0;
            }
            switch (product) {
                case 0:
                    nCapuccino--;
                    break;
                case 1:
                    nLatte--;
                    break;
                case 2:
                    nMate--;
                    break;
                case 3:
                    nEspressoF--;
                    break;
                case 4:
                    nEspresso--;
                    break;
                case 5:
                    nCookie--;
                    break;
                case 6:
                    nBrownie--;
                    break;
            }
        }
        else if (opt == 1) {
            switch (product) {
                case 0:
                    nCapuccino++;
                    break;
                case 1:
                    nLatte++;
                    break;
                case 2:
                    nMate++;
                    break;
                case 3:
                    nEspressoF++;
                    break;
                case 4:
                    nEspresso++;
                    break;
                case 5:
                    nCookie++;
                    break;
                case 6:
                    nBrownie++;
                    break;
            }
        }

        writeInventory();
        return 1;
    }

    private String formatText() {
        String text = "";
        text = text.concat("capuccino:" + String.valueOf(nCapuccino) + "\n");
        text = text.concat("latte:" + String.valueOf(nLatte) + "\n");
        text = text.concat("mate:" + String.valueOf(nMate) + "\n");
        text = text.concat("espresso f:" + String.valueOf(nEspressoF) + "\n");
        text = text.concat("espresso:" + String.valueOf(nEspresso) + "\n");
        text = text.concat("cookie:" + String.valueOf(nCookie) + "\n");
        text = text.concat("brownie:" + String.valueOf(nBrownie) + "\n");
        return text;
    }

    private void writeInventory() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("files/inventory.txt", false));
        String text = formatText();
        bw.write(text);
        bw.close();
    }

}