package br.ufrn.imd.rita_lino.tree;

import java.util.ArrayList;

public class TrieTree {
    private TrieNode root;
    static final int ALPHABET_SIZE = 127; //padrão ascii

    public TrieTree(){
        //fixme como iniciar a raiz?
    }

    public Boolean insertWord(String word){
       return null;
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
}
