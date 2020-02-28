package eg.edu.alexu.csd.datastructure.hangman.cs_59;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanTest {

    @org.junit.jupiter.api.Test
    void testReadArrayFromFile() throws IOException
    {
        Hangman h = new Hangman();
        String file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\Google10,000EnglishWord.txt";
        String[] dictionary = h.readArrayFromFile(file);
        assertNotNull(dictionary);
    }

    @org.junit.jupiter.api.Test
    void testSetDictionary() throws IOException {
        Hangman h = new Hangman();
        String file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\Google10,000EnglishWord.txt";
        String[] dictionary = h.readArrayFromFile(file);
        h.setDictionary(dictionary);
        assertNotNull(h.dictionary);
    }

    @org.junit.jupiter.api.Test
    void testSelectRandomSecretWord() throws Exception {
        Hangman h = new Hangman();
        String[] dictionary = h.readArrayFromFile("C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\Google10,000EnglishWord.txt");
        h.setDictionary(dictionary);
        String random = h.selectRandomSecretWord();
        assertNotNull(random);
    }

    @org.junit.jupiter.api.Test
    void testGuess() throws Exception {
        //right choice
        Hangman h = new Hangman();
        String file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\Google10,000EnglishWord.txt";
        String[] dictionary = h.readArrayFromFile(file);
        h.setDictionary(dictionary);
        h.setMaxWrongGuesses(4);
        String random = h.selectRandomSecretWord();
        assertNotNull(random);
        int rnd = new Random().nextInt(random.length());
        assertNotNull(h.guess(random.charAt(rnd)));
        //taken character
        assertEquals(h.getEstimaatedSecretWord(),h.guess(random.charAt(rnd)));
        //NOT character
        assertEquals(h.getEstimaatedSecretWord(),h.guess('*'));
        //return the estimated secret word
        assertEquals(h.getEstimaatedSecretWord(), h.guess(null));
        //buggy word
        Hangman i = new Hangman();
        file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\buggy Words.txt";
        dictionary = i.readArrayFromFile(file);
        i.setDictionary(dictionary);
        i.setMaxWrongGuesses(8);
        String rando = i.selectRandomSecretWord();
        assertNotNull(random);
        int rn = new Random().nextInt(random.length());
        assertThrows(Exception.class, () -> i.guess(rando.charAt(rn)));
        //wrong choice
        file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\chechWrongChar.txt";
        dictionary = i.readArrayFromFile(file);
        i.setDictionary(dictionary);
        i.setMaxWrongGuesses(8);
        i.selectRandomSecretWord();
        assertEquals(i.getEstimaatedSecretWord(),i.guess('A'));
        //loosing
        i.setMaxWrongGuesses(1);
        assertEquals(null,i.guess('A'));
        //winning
        file = "C:\\\\Users\\\\pc\\\\Documents\\\\intellij projects\\\\Hangman Game\\\\src\\\\eg\\\\edu\\\\alexu\\\\csd\\\\datastructure\\\\hangman\\\\cs_59\\\\checkRightChar.txt";
        dictionary = i.readArrayFromFile(file);
        i.setDictionary(dictionary);
        i.setMaxWrongGuesses(3);
        random= i.selectRandomSecretWord();
        assertNotNull(random);
        //right choice (althogh it is upper case)
        assertNotNull(i.guess('m'));
        assertNull(i.guess('o'));
    }

    @org.junit.jupiter.api.Test
    void testSetMaxWrongGuesses() throws Exception{
        Hangman h = new Hangman();
        h.setMaxWrongGuesses(4);
        assertEquals(4,h.maxWrongGuesses);
        h.setMaxWrongGuesses(0);
        assertEquals(1,h.maxWrongGuesses);
        h.setMaxWrongGuesses(null);
        assertEquals(1,h.maxWrongGuesses);
        h.setMaxWrongGuesses(-5);
        assertEquals(1,h.maxWrongGuesses);
        h.setMaxWrongGuesses(1000);
        assertEquals(1000,h.maxWrongGuesses);
    }
}
