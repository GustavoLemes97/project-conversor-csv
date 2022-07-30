package com.trybe.conversorcsv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que converte arquivos CSV.
 */
public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados
   * na pasta de saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas   Pasta em que serão colocados os arquivos gerados no formato
   *                        requerido pelo subsistema.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou
   *                     gravar os arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    ArrayList<String> dadosDoArquivoFormatado;
    String[] estados = pastaDeEntradas.list();

    for (int indice = 0; indice < pastaDeEntradas.listFiles().length; indice += 1) {
      CsvReader csvReader = new CsvReader();
      dadosDoArquivoFormatado = csvReader.formatarArquivo(
              new File(pastaDeEntradas, estados[indice]));
      pastaDeSaidas.mkdir();
      CsvWriter csvWriter = new CsvWriter();
      csvWriter.gravarArquivo(dadosDoArquivoFormatado, new File(pastaDeSaidas, estados[indice]));
    }
  }
}