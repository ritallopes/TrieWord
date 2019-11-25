package br.ufrn.imd.rita_lino.util;

import java.io.*;
import java.util.ArrayList;

public class ManipulationFile {

    private String path;

    public ManipulationFile(String path){
        this.path = path ;
    }

    /**
     * função readWords() separa as palavras que estão separadas
     * no arquivo por \n.
     * */
    public ArrayList<String> readWords(){
        ArrayList<String> words = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(this.path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(bufferedReader.ready()){
                words.add(bufferedReader.readLine());
            }
            bufferedReader.close();
            fileReader.close();
        }catch (FileNotFoundException ef){
            words.clear();
            System.out.println("Arquivo "+path+" não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo!");
        }
        return words;
    }
}

