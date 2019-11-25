package br.ufrn.imd.rita_lino.tree;

import java.util.ArrayList;
import java.util.List;

public class TrieTree {
    private TrieNode root =  null;
    static final int ALPHABET_SIZE = 127; //padrão ascii

    public TrieTree(){
        root = new TrieNode();
    }

    public Boolean insertWord(String word){
        return this.insertRoot(word);
    }

    private Boolean insertRoot(String word){
        Character letter = word.charAt(0);

        TrieNode child = this.root.searchChild(letter); //verifica se há um filho

        if (child == null){
            child = new TrieNode();
            this.root.addChild(child);
        }

        return child.insert(word);
    }


    public Boolean removeWord(String word){
        return null;
    }

    public Boolean existWord(String word){
        return null;
    }

    //fixme retornar estrutura mais adequada
    public ArrayList<String> suggestWord(String prefix){
        ArrayList<String> words = new ArrayList<>();
        words.clear();

        return words;
    }


    public void insertList(List<String> words){
        for(String word: words){
            System.out.println(word);
            this.insertWord(word);
        }
    }

}
