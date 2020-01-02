package br.ufrn.imd.rita_lino.test;

import br.ufrn.imd.rita_lino.tree.TrieNode;
import br.ufrn.imd.rita_lino.tree.TrieTree;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrieTreeTest {
    TrieTree tree;
    @org.junit.Before
    public void init() throws Exception {
        tree = new TrieTree();
    }


    @Test
    public void mustInsert(){
        ArrayList<String> word = new ArrayList<>();
        word.add("a");
        word.add("ama");
        word.add("amar");
        word.add("ameixa");
        word.add("oi");
        word.add("oito");

        tree.insertList(word);

        for (String w: word
        ) {
            assertTrue(tree.existWord(w));
        }
    }

    @Test
    public void mustRemove(){
        ArrayList<String> word = new ArrayList<>();
        word.add("a");
        word.add("ama");
        word.add("amar");
        word.add("ameixa");
        word.add("oi");
        word.add("oito");

        tree.insertList(word);

        tree.removeWord("a");
        assertFalse(tree.existWord("a"));
        tree.removeWord("amar");
        assertFalse(tree.existWord("amar"));


        word.remove("a");
        word.remove("amar");
        for (String w: word
        ) {
            assertTrue(tree.existWord(w));
        }
    }


    @Test
    public void mustSuggest(){
        ArrayList<String> word = new ArrayList<>();
        word.add("a");
        word.add("ama");
        word.add("amar");
        word.add("ame");
        word.add("ameixa");

        tree.insertList(word);

        assertArrayEquals(word.toArray(), tree.suggestWord("a").toArray());

        assertEquals(new String[]{"ame", "ameixa"}, tree.suggestWord("ame").toArray());
    }


}