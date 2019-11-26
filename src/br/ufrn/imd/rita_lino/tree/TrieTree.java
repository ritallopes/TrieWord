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
        if (existWord(word)){
            this.root.removeWord(word);
            return true;
        }else{
            return false;
        }
    }

    public Boolean existWord(String word){
        return this.root.existWord(word);
    }

    private TrieNode searchNode(String word){
        return this.root.searchNode(word);
    }

    public ArrayList<String> suggestWord(String prefix){
        TrieNode prefixNode = this.root.searchNode(prefix);

        ArrayList<String> words = navigateSufix(prefixNode);

        for (String word: words) {
            System.out.println(prefix+word.substring(1, word.length()));
        }

        return words;
    }

    private ArrayList<String> navigateSufix(TrieNode prefixNode) {
        String newPrefix="";
        ArrayList<String> sufixs = new ArrayList<>();

        newPrefix += prefixNode.getValue();

        if (prefixNode.isWord()){
            sufixs.add(newPrefix);
        }

        if(!prefixNode.hasChildren()){
            return sufixs;
        }else{
            for (TrieNode child: prefixNode.getChildren()) {
                ArrayList<String> sufixsChild = navigateSufix(child);
                for (String sufix: sufixsChild) {
                    sufixs.add(newPrefix.concat(sufix));
                }
            }
            return sufixs;
        }
    }


    public void insertList(List<String> words){
        for(String word: words){
            this.insertWord(word);
        }
    }

}
