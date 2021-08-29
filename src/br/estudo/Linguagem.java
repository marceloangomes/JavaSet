package br.estudo;

import java.util.*;

public class Linguagem{
    public static void main(String[] args) {

        Set<LinguagemFavorita> linguagensFavoritas = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Java", 1977, "IntelliJ"));
            add(new LinguagemFavorita("C#", 1994, "Visual Studio"));
            add(new LinguagemFavorita("JavaScript", 1993, "Code"));
        }};

        System.out.println("Ordem de Inserção: " + linguagensFavoritas);

        Set<LinguagemFavorita> linguagensFavoritasNatural= new TreeSet<>();
        linguagensFavoritasNatural.addAll(linguagensFavoritas);

        System.out.println("Ordem Natural: " + linguagensFavoritasNatural);

        Set<LinguagemFavorita> linguagensFavoritasAnoNome = new TreeSet<>(new ComparatorLFAnoNome());
        linguagensFavoritasAnoNome.addAll(linguagensFavoritas);
        System.out.println("Ordem Ano Inicio e Nome: " + linguagensFavoritasAnoNome);

        Set<LinguagemFavorita> linguagensFavoritasNomeAnoIde = new TreeSet<>(new ComparatorLFNomeAnoIde());
        linguagensFavoritasNomeAnoIde.addAll(linguagensFavoritas);
        System.out.println("Ordem Nome, Ano Inicio e Ide: " + linguagensFavoritasNomeAnoIde);

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {

    private String nome;
    private int anoCriacao;
    private String ide;

    public LinguagemFavorita() {
    }

    public LinguagemFavorita(String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return anoCriacao == that.anoCriacao && Objects.equals(nome, that.nome) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        var result = String.CASE_INSENSITIVE_ORDER.compare(this.getIde(),linguagemFavorita.getIde());
        return result;
    }
}

class ComparatorLFAnoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int result = Integer.compare(l1.getAnoCriacao(),l2.getAnoCriacao());
        if(result != 0) return result;
        return String.CASE_INSENSITIVE_ORDER.compare(l1.getNome(),l2.getNome());
    }
}

class ComparatorLFNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int result = String.CASE_INSENSITIVE_ORDER.compare(l1.getNome(),l2.getNome());
        if(result != 0) return result;
        result = Integer.compare(l1.getAnoCriacao(),l2.getAnoCriacao());
        if(result != 0) return result;
        return String.CASE_INSENSITIVE_ORDER.compare(l1.getIde(),l2.getIde());
    }
}
