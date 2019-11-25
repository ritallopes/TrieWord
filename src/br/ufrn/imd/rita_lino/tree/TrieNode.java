package br.ufrn.imd.rita_lino.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class TrieNode {
    private Boolean isWord = false;
    private ArrayList<TrieNode> children = new ArrayList<>(); //fixme ver qual estrutura de dados usar
    private Character value = null;

    public TrieNode(){
        this.isWord = false;
        this.children.clear();
        this.value = null;
    }

    public TrieNode(Character letter) {
        this.value = letter;
    }

    public Boolean isWord(){
        return isWord;
    }
    public void setIsWord(Boolean isWord){
        this.isWord = isWord;
    }
    public Character getValue(){ return this.value;}
    public ArrayList<TrieNode> getChildren() { return children; }


    public Boolean insert(String word) {
        System.out.println(word);

        //nó folha: caso base
        if (word.length() <= 1){
            this.value = word.charAt(0);
            this.isWord = true;
            return true;
        }

        //inserindo no nó atual, filho do root?
        if (this.value == null){
            this.value = word.charAt(0);
            word = word.substring(1, word.length()-1);
        }



        Character letter = word.charAt(0);//pega a letra que corresponde ao nó que estamos procurando
        TrieNode child = searchChild(letter); //verifica se há um filho
        if (child == null){//se não houve um filho eu criarei
            child = new TrieNode(letter);
            children.add(child);
        }

        word = word.substring(1, word.length()-1);//reconfiguro minha palavra retirando a primeira letra, que foi inserido em meu filho

        return child.insert(word);
    }

    public TrieNode searchChild(Character value){
        if (this.children.isEmpty()){
            return null;
        }

        for (TrieNode node: children) {
            if (node.getValue() == value){
                return node;
            }
        }
        return null;
    }

    public void addChild(TrieNode child) {
        this.children.add(child);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TrieNode)){
            return false;
        }
        return (((TrieNode)obj).getValue() == ((TrieNode)obj).getValue()) && (((TrieNode)obj).getChildren() == ((TrieNode)obj).getChildren());
    }


}
