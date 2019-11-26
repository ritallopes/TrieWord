package br.ufrn.imd.rita_lino.main;


import br.ufrn.imd.rita_lino.tree.TrieNode;
import br.ufrn.imd.rita_lino.tree.TrieTree;
import br.ufrn.imd.rita_lino.util.ManipulationFile;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathFileWords = args[0];
        String prefix = args[1];
        String countWordString = args[2];

        Integer countWord = null;
        try{
            countWord = Integer.parseInt(countWordString);
        }catch (NumberFormatException nfe){
            countWord = -1;
        }


        ManipulationFile file = new ManipulationFile(pathFileWords);

        TrieTree tree = new TrieTree();
        ArrayList<String> words = file.readWords();
        tree.insertList(words);
        for (TrieNode c: tree.getRoot().getChildren()) {
            System.out.println(c.getValue()+" "+ c.isWord());
        }


        System.out.println(tree.existWord("a"));
        System.out.println(tree.existWord("amar"));
        System.out.println(tree.existWord("ameixa"));
        System.out.println(tree.removeWord("amar"));
        System.out.println(tree.existWord("a"));
        System.out.println(tree.existWord("amar"));
        System.out.println(tree.existWord("ameixa"));


//        for (TrieNode node: tree.getRoot().getChildren().get(2).getChildren()
//             ) {
//
//            System.out.println(node.getValue());
//            System.out.println(node.isWord());
//
//        }

    }
}
