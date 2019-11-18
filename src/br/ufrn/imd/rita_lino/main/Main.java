package br.ufrn.imd.rita_lino.main;


import br.ufrn.imd.rita_lino.util.ManipulationFile;

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
        Had
    }
}
