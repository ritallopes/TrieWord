package br.ufrn.imd.rita_lino.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;

public class TrieNode {
    private Boolean isWord = false;
    private HashMap<Character, TrieNode> children;
    private Character value = null;

    public TrieNode(){
        this.isWord = false;
        this.children = new HashMap<>();
        this.value = null;
    }

    public TrieNode(Character letter) {
        this.isWord = false;
        this.children = new HashMap<>();
        this.value = letter;
    }

    public Boolean isWord(){
        return isWord;
    }
    public void setIsWord(Boolean isWord){
        this.isWord = isWord;
    }
    public Character getValue(){ return this.value;}
    public HashMap<Character, TrieNode> getChildren() { return children; }
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
        TrieNode child = this.addChild(letter);
        if (word.length() == 1){
            child.setIsWord(true);
            return true;
        }else{
            word = word.substring(1, word.length());
            return child.insert(word);
        }

    }


    public TrieNode addChild(Character key) {
        if (this.children.containsKey(key)){
            return this.children.get(key);
        }
        this.children.put(key, new TrieNode(key));
        return this.children.get(key);
    }

    public Boolean existWord(String word) {
        Character letter = word.charAt(0);
        if (!children.containsKey(letter)){
            return false;
        }else {
            TrieNode child = children.get(letter);
            //caso base: ser a última letra, ser a letra que desejo e ser uma palavra
            if (word.length() <= 1){
                if (child.isWord()){
                    return true;
                }else{
                    return false;
                }
            }else {
                word = word.substring(1, word.length());
                return child.existWord(word);
            }
        }
    }



    public TrieNode searchNode(String word) {
        Character letter = word.charAt(0);
        TrieNode child = children.get(letter);

        if (child == null){
            return null;
        }else {

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
}
