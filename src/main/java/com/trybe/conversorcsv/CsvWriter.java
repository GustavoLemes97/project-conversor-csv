package com.trybe.conversorcsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe para escrever no arquivo CSV.
 */
public class CsvWriter {

  /**
   * Método que escreve no arquivo CSV.
   */
  public void gravarArquivo(ArrayList<String> dados, File arquivo) throws IOException {
    FileWriter escritorArquivo = new FileWriter(arquivo);
    BufferedWriter bufferedEscritor = new BufferedWriter(escritorArquivo);
    int indice = 0;

    while (indice < dados.size()) {
      bufferedEscritor.write(dados.get(indice));
      bufferedEscritor.flush();
      bufferedEscritor.newLine();
      indice += 1;
    }
  }
}
