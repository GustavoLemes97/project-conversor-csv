package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe para ler e manipular o arquivo CSV.
 */
public class CsvReader {
  private ArrayList<String> dadosDoArquivo = new ArrayList<String>();

  private void lerArquivo(File arquivo) throws IOException {
    FileReader leitorArquivo = new FileReader(arquivo);
    BufferedReader bufferedLeitor = new BufferedReader(leitorArquivo);

    String conteudoLinha = bufferedLeitor.readLine();

    while (conteudoLinha != null) {
      dadosDoArquivo.add(conteudoLinha);
      conteudoLinha = bufferedLeitor.readLine();
    }
  }

  private String formatarNome(String nome) {
    return nome.toUpperCase();
  }

  private String formatarData(String data) {
    String pattern = "dd/MM/yyyy";
    LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern(pattern));

    return date.toString();
  }

  private String formatarCpf(String cpf) {
    final String regex = "^(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(cpf);
    matcher.find();

    return matcher.group(1) + "."
            + matcher.group(2) + "."
            + matcher.group(3) + "-"
            + matcher.group(4);
  }

  /**
   * Método que formata o arquivo lido.
   */
  public ArrayList<String> formatarArquivo(File arquivo) throws IOException {
    lerArquivo(arquivo);
    for (int indice = 1; indice < dadosDoArquivo.size(); indice += 1) {
      String[] dados = dadosDoArquivo.get(indice).split(",");
      dados[0] = formatarNome(dados[0]);
      dados[1] = formatarData(dados[1]);
      dados[3] = formatarCpf(dados[3]);
      dadosDoArquivo.set(indice, String.join(",", dados));
    }

    return dadosDoArquivo;
  }
}
