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
        TrieNode child = this.root.addChild(letter);
        word = word.substring(1, word.length());
        return child.insert(word);
    }


    public boolean removeWord(String word){
        if (existWord(word)){
            this.removeNode(word , this.root.getChildren().get(word.charAt(0)));
            return true;
        }else{
            return false;
        }
    }

    private boolean removeNode(String word, TrieNode node){
        if (word.length() ==1){
            if (node.hasChildren()){
                node.setIsWord(false);
                return false;
            }else{
                return true;
            }
        }else{
            if(node.getChildren().containsKey(word.charAt(1))){
                boolean retorno = removeNode(word.substring(1, word.length()), node.getChildren().get(word.charAt(1)));
                if (retorno){
                    node.getChildren().remove(word.charAt(1));

                    if (!(node.isWord()) && node.getChildren().isEmpty()){
                        return true;
                    }else{
                        return false;
                    }

                }else{
                    return false;
                }
            }else{
                return false;
            }

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
        ArrayList<String> words = new ArrayList<>();
        if (prefixNode ==null){
            return words;
        }


        words = navigateSufix(prefixNode);

        int index = 0;
        for (String word: words) {
            words.set(index, prefix + word.substring(1, word.length()));
            index++;
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
            for (Character key : prefixNode.getChildren().keySet()) {
                ArrayList<String> sufixsChild = navigateSufix(prefixNode.getChildren().get(key));
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
