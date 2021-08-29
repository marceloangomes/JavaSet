package br.estudo;
import java.util.*;

class Cores {
    public static void main(String[] args) {
        Set<Cor> arcoIris = new HashSet<>(){{
            add(new Cor("verde"));
            add(new Cor("azul"));
            add(new Cor("vermelho"));
            add(new Cor("Amarelo"));
        }};

        System.out.println("Exiba todas as cores uma abaixo da outra:");
        for (Cor cor:arcoIris) {
            System.out.println(cor);
        }

        System.out.println("A quantidade de cores que o arco iris tem: " + arcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<Cor> arcoIrisOrdenado;
        arcoIrisOrdenado = new TreeSet<Cor>(arcoIris);
        System.out.println(arcoIrisOrdenado);
        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        Set<Cor> arcoIrisMantemOrdem = new LinkedHashSet<>(){{
            add(new Cor("verde"));
            add(new Cor("azul"));
            add(new Cor("vermelho"));
            add(new Cor("Amarelo"));
        }};


        List list = new ArrayList(arcoIrisMantemOrdem);
        Collections.sort(list,Collections.reverseOrder());
        Set<Cor> arcoIrisInverso = new LinkedHashSet<Cor>(list);
        System.out.println(arcoIrisInverso);

        System.out.println("Exiba todas as cores que iniciarem com  'v'");
        for (Cor cor:arcoIris)
        {
            if(cor.getNome().startsWith("v"))
                System.out.println(cor.getNome());
        }
        System.out.println("Remova todas as cores que não iniciarem com  'v'");
        Iterator<Cor> itArcoIris = arcoIris.iterator();
        while(itArcoIris.hasNext()){
            if(!itArcoIris.next().getNome().startsWith("v"))
                itArcoIris.remove();
        }
        System.out.println(arcoIris);

        arcoIris.clear();

        System.out.println("A coleção está vazia: " + (arcoIris.isEmpty() ? "Sim":"Não"));





    }
}

class Cor implements Comparable<Cor>{
    private String nome;

    public Cor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public int compareTo(Cor cor) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.getNome(),cor.getNome());
    }


}


