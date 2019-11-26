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
    public Boolean hasChildren(){return !(this.children.isEmpty()); }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TrieNode)){
            return false;
        }
        return (((TrieNode)obj).getValue() == ((TrieNode)obj).getValue()) && (((TrieNode)obj).getChildren() == ((TrieNode)obj).getChildren());
    }



    public Boolean insert(String word) {
        if (word.length() == 0){//caso a palavra seja com apenas uma letra
            this.isWord = true;
            return true;
        }
        Character letter = word.charAt(0);
        TrieNode child = this.addChild(new TrieNode(letter));
        if (word.length() == 1){
            child.setIsWord(true);
            return true;
        }else{
            word = word.substring(1, word.length());
            return child.insert(word);
        }
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

    public TrieNode addChild(TrieNode child) {
        if (searchChild(child.value) == null){
            this.children.add(child);
        }
        return searchChild(child.value);
    }

    public Boolean existWord(String word) {
        Character letter = word.charAt(0);
        TrieNode child = this.searchChild(letter);

        if (child == null){
            return false;
        }else {
            //caso base: ser a última letra, ser a letra que desejo e ser uma palavra
            if (word.length() <= 1){
                if (child.getValue().equals(letter)){
                    if (child.isWord()){
                        return true;
                    }
                }
            }

            if (word.length() > 1) {
                word = word.substring(1,word.length());
                return child.existWord(word);
            }else{
                return false;
            }
        }
    }



    public TrieNode searchNode(String word) {
        Character letter = word.charAt(0);
        TrieNode child = this.searchChild(letter);

        if (child == null){
            return null;
        }else {
            //caso base: ser a última letra, ser a letra que desejo e ser uma palavra
            if (word.length() <= 1){
                if (child.getValue().equals(letter)){
                    return child;
                }
            }

            if (word.length() > 1) {
                word = word.substring(1,word.length());
                return child.searchNode(word);
            }else{
                return child;
            }
        }
    }

    public boolean removeWord(String word) {
        System.out.println(word);
        if (word.length() <=1){//caso base
            TrieNode child = searchChild(word.charAt(0));
            if (child.hasChildren()){
                child.setIsWord(false);
                return true;
            }else{
                this.children.remove(child);
                for (TrieNode node: children
                     ) {

                    System.out.println(node.getValue() +" "+node.isWord);

                }
                return true;
            }
        }else{
            return this.removeWord(word.substring(1, word.length()));
        }
    }
}
