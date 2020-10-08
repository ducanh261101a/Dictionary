package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    public Button btSearch;
    @FXML
    public Button speak;
    @FXML
    public TextField tfSearchedWord;

    @FXML
    public ListView<String> lvWords;

    @FXML
    public TextArea taMeaning;

    Map<String, String> dictionary = new HashMap<String, String>();


    public void initialize(URL location, ResourceBundle resources) {
        initializeWordList();
        btSearch.setOnMouseClicked(event -> {
            System.out.println("Search!!!");
            String searchedWord = tfSearchedWord.getText();
            if (searchedWord != null && searchedWord.equals("") == false) {
                System.out.println("Searched World: " + searchedWord);
                String wordMeaning = dictionary.get(searchedWord);
                TextSpeech speech= new TextSpeech();
                speech.Speech(searchedWord);
                taMeaning.setText(wordMeaning);
            }
        });
        speak.setOnMouseClicked(event -> {
            String searchedWord = lvWords.getSelectionModel().getSelectedItem();
            if (searchedWord != null && searchedWord.equals("") == false) {
                System.out.println("Searched World:efas " + searchedWord);
                //String wordMeaning = dictionary.get(searchedWord);
                TextSpeech speech= new TextSpeech();
                speech.Speech(searchedWord);
                return;
            }
        });

        lvWords.setOnMouseClicked(event -> {
            String searchedWord = lvWords.getSelectionModel().getSelectedItem();
            if (searchedWord != null && searchedWord.equals("") == false) {
                System.out.println("Searched World: " + searchedWord);
                String wordMeaning = dictionary.get(searchedWord);
                taMeaning.setText(wordMeaning);
            }
        });
    }
//    public void SpeechTest(String target_word){
//        TextSpeech speech= new TextSpeech();
//        speech.Speech(target_word);
//    }
    public void initializeWordList() {
        dictionary.put("hello", "Xin chao");
        dictionary.put("thank you", "Cam on");
        dictionary.put("america", "tin hieu he thong");
        dictionary.put("class", "Lop hoc");
        lvWords.getItems().addAll(dictionary.keySet());
    }
}
