import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String filename = "/home/viditjain5598/IdeaProjects/Guess_The_Movie/src/movies.txt";
        Scanner fileScanner = new Scanner(new File(filename));
        List<String> moviesList = new ArrayList<>();
        while(fileScanner.hasNextLine()){
            moviesList.add(fileScanner.nextLine());
        }
        String[] movies = moviesList.toArray(new String[0]);
        int rnd = new Random().nextInt(movies.length);
        String movie = movies[rnd];
        StringBuilder guessed = new StringBuilder("-".repeat(movie.length()));
        boolean found = false;
        int count = 0;
        for(int i=0; i<movie.length(); i++){
            if(movie.charAt(i) == ' ') guessed.setCharAt(i, ' ');
        }
        while (!found && count < 10){
            System.out.println("You are guessing: " + guessed + "\nYou have " + count + " wrong guesses");
            char guess = in.next().charAt(0);
            boolean pres = false;
            for(int i=0; i<movie.length(); i++){
                if(guess == movie.charAt(i)){
                    guessed.setCharAt(i, guess);
                    pres=true;
                }
            }
            if(!pres) count++;
            if(movie.equals(guessed.toString())) found=true;
        }
        if(found){
            System.out.println("You Guessed Correct!\n" + movie);
        }else{
            System.out.println("Better luck Next time");
        }

     /*   int randNum = (int) (Math.random() * 100) + 1;
        boolean found = false;
        int chances = 10;
        while (!found && chances > 0) {
            System.out.println("Enter your guess: ");
            int guess = in.nextInt();
            chances--;
            if (guess == randNum) {
                System.out.println("Nice guess!");
                found = true;
                //    break;
            } else if (guess < randNum) {
                System.out.println("Try Again... Go higher");
            } else {
                System.out.println("Try Again... Go lower");
            }
        }*/
    }
}
