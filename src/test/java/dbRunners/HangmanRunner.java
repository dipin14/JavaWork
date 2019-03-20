package dbRunners;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;
import java.util.Random;

import com.dipin.hibernate.eclipse.postgresql.Car;
import com.dipin.hibernate.eclipse.postgresql.Words;
 
public class HangmanRunner {
     
    @Test
    public String crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        if(!read(session))
        {
        	create(session);
        }        
         
        //update(session);
        //read(session);
         
        //delete(session);
        //read(session);
        String word = readWord(session);
        session.close();
        return word;
    }
     
    private void delete(Session session) {
        System.out.println("Deleting word...");
        Words word = (Words) session.get(Words.class, "castaway");
         
        session.beginTransaction();
        session.delete(word);
        session.getTransaction().commit();
    }
     
    private void update(Session session) {
        System.out.println("Updating word...");
        Words swift = (Words) session.get(Words.class, "spiderman");
        swift.setWord("spiderman");
         
        session.beginTransaction();
        session.saveOrUpdate(swift);
        session.getTransaction().commit();
    }
 
    private void create(Session session) {
        System.out.println("Creating words...");
        Words thor = new Words();
        thor.setWord("thor");
         
        Words avengers = new Words();
        avengers.setWord("avengers");
        
        Words hangman = new Words();
        hangman.setWord("hangman");
        
        Words shawshankredemption = new Words();
        shawshankredemption.setWord("shawshank redemption");
        
        Words interstellar = new Words();
        interstellar.setWord("interstellar");
        
        Words inception = new Words();
        inception.setWord("inception");

        Words spiderman = new Words();
        spiderman.setWord("spiderman");
         
        session.beginTransaction();
        session.save(thor);
        session.save(avengers);
        session.save(hangman);
        session.save(shawshankredemption);
        session.save(interstellar);
        session.save(inception);
        session.save(spiderman);
        session.getTransaction().commit();
    }
     
    private boolean read(Session session) {
        Query q = session.createQuery("select _word from Words _word");     
        List<Words> words = q.list();
        
        boolean entityFlag = false;
         
        // System.out.println("Reading words...");
        // System.out.printf("%-30.30s%n", "Word");
        for (Words w : words) {
            // System.out.printf("%-30.30s%n", w.getWord());
            entityFlag = true;
        }
        return entityFlag;
    }
    
    private String readWord(Session session) {
    	Query q = session.createQuery("select _word from Words _word");
    	
    	Random rand = new Random();
    	int i=1,randomNumber = rand.nextInt(7);
        List<Words> words = q.list();
         
        // Reading random word
        for (Words w : words) {
        	if(i == randomNumber)
        	{
        		return w.getWord();
        	}
        	i++;
        }
        return null;
    }
}