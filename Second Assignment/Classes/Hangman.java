package eg.edu.alexu.csd.datastructure.hangman.cs_59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements IHangman{
    public String[] dictionary;
    public int maxWrongGuesses;
    private char[] randomSecretWord,estimaatedSecretWord;
    private int numOfWrongGuesses=0,numOfRightCharacters=0;

    public String[] readArrayFromFile(String file)throws FileNotFoundException {
        int count=0;
        Scanner s1 = null;
        s1 = new Scanner(new File(file));
        if (s1==null){
            throw new FileNotFoundException("thre is no file");
        }
        while(s1.hasNextLine())
        {
            count++;
            s1.next();
        }
        String[] words = new String[count];
        s1=new Scanner(new File(file));
        for (int i =0 ; i<count ; i++)
        {
            words[i]=s1.next();
        }
        return words;
    }

    public String getEstimaatedSecretWord(){
        return String.valueOf(estimaatedSecretWord);
    }


    /**
     *  Set the dictionary
     *  @param words: an array of words
     */
    public void setDictionary(String[] words){
        dictionary=words;
    }

    /**
     *  Pick a random secret word from the dictionary and returns it
     *  @return secret word or null
     */
    public String selectRandomSecretWord(){
        int rnd = new Random().nextInt(dictionary.length);
        randomSecretWord=dictionary[rnd].toCharArray();
        estimaatedSecretWord=dictionary[rnd].toCharArray();
        for(int i=0;i<estimaatedSecretWord.length;i++)
        {
            estimaatedSecretWord[i]='-';
        }
        return dictionary[rnd];
    }

    /**
     *  Receive a new user guess, and verify it against the secret word.
     *  @param c
     *  case insensitive user guess.
     *  If c is NULL then ignore it and do no change
     *  @return * secret word with the remaining hidden characters (use ’-’ instead
     *  of unsolved characters), or return NULL if user reached max wrong
     *  guesses.
     */
    public String guess(Character c) throws Exception{
        if (c==null) {
            return String.valueOf(estimaatedSecretWord);
        }
        else if(!((c>= 'a' && c<= 'z') || (c>= 'A' && c<= 'Z')))
        {
            System.out.println("this character is taken");
            return String.valueOf(estimaatedSecretWord);
        }
        else
        {
            int count = 0;
            for (int i = 0; i < randomSecretWord.length; i++) {
                if ((randomSecretWord[i] >= 'a' && randomSecretWord[i] <= 'z') || (randomSecretWord[i] >= 'A' && randomSecretWord[i] <= 'Z')) {
                    count++;
                }
            }
            if (count != randomSecretWord.length ) {
                throw new Exception("it is buggy secret word");
            }
            else {
                count = 0;
                for (int i = 0; i < estimaatedSecretWord.length; i++) {
                    if (estimaatedSecretWord[i] == Character.toUpperCase(c)||estimaatedSecretWord[i] == Character.toLowerCase(c)) {
                        count++;
                    }
                }
                if (count!=0)
                {
                    System.out.println("this character is taken");
                    return String.valueOf(estimaatedSecretWord);
                }
                else {
                    count = 0;
                    for (int i = 0; i < randomSecretWord.length; i++) {
                        if (randomSecretWord[i] == Character.toUpperCase(c) || randomSecretWord[i] == Character.toLowerCase(c)) {
                            estimaatedSecretWord[i] = randomSecretWord[i];
                            count++;
                        }
                    }
                    if (count == 0) {
                        numOfWrongGuesses++;
                        System.out.println("wrong choice");
                    } else {
                        numOfRightCharacters += count;
                        System.out.println("right choice");
                    }
                    if (numOfWrongGuesses >= maxWrongGuesses) {
                        System.out.println("you lost");
                        return null;
                    }
                    else {
                        if (numOfRightCharacters != randomSecretWord.length) {
                            return String.valueOf(estimaatedSecretWord);
                        } else {
                            System.out.println("you win");
                            return null;
                        }
                    }
                }
            }
        }
    }
    /**
     *  Set the maximum number of wrong guesses
     *  @param max
     *  maximum number of wrong guesses, If it is NULL, then assume it 1
     */
    public void setMaxWrongGuesses(Integer max){
        //if the integer was negative it will consider max =1 .
        if(max==null||max<=0){
            maxWrongGuesses=1;
        }
        else {
            maxWrongGuesses = max;
        }
    }

}
