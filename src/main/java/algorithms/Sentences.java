package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {
    private List<String> sentences = new ArrayList<>();

    public Sentences() {
        this.sentences = sentences;
    }

    public void addSentence(String sentence) {
        char firstLetter = sentence.charAt(0);
        char lastLetter = sentence.charAt(sentence.length() - 1);
        String punctuations = ".?!";
        if (!Character.isUpperCase(firstLetter)) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (lastLetter == '.' || lastLetter == '!' || lastLetter == '?') {
            sentences.add(sentence);
        } else {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }

    public String findLongestSentence(){
        String longestString  = sentences.get(0);
        if (sentences.isEmpty()) {
            throw new IllegalStateException();
        }

        for (String scopedSentence : sentences) {
            if (scopedSentence.length() > longestString.length()) {
                longestString = scopedSentence;
            }
        }
        return longestString;
    }

    public List<String> getSentences() {
        return sentences;
    }
}