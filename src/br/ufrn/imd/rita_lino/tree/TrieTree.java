package br.ufrn.imd.rita_lino.tree;

import java.util.ArrayList;
import java.util.List;

public class TrieTree {
    private TrieNode root =  null;
    static final int ALPHABET_SIZE = 127; //padrão ascii

    public TrieNode getRoot() {
        return root;
    }

    public TrieTree(){
        root = new TrieNode();
    }

    public Boolean insertWord(String word){
        return this.insertRoot(word);
    }

    private Boolean insertRoot(String word){
        Character letter = word.charAt(0);
        word = word.substring(1, word.length());
        TrieNode child = this.root.addChild(new TrieNode(letter));
        return child.insert(word);
    }


    public Boolean removeWord(String word){
        //TODO método de remoção
        if (existWord(word)){
            return true;
        }else{
            return true;
        }
    }

    public Boolean existWord(String word){
        return this.root.existWord(word);
    }

    //fixme retornar estrutura mais adequada
    public ArrayList<String> suggestWord(String prefix){
        //TODO autocompletar
        ArrayList<String> words = new ArrayList<>();
        words.clear();




        return words;
    }


    public void insertList(List<String> words){
        for(String word: words){
            this.insertWord(word);
        }
    }

}
