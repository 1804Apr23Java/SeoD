import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;

import com.revature.beans.Message;
import com.revature.beans.Vampire;
import com.revature.dao.MessageDao;
import com.revature.dao.MessageImpl;
import com.revature.dao.VampireDao;
import com.revature.dao.VampireImpl;

@Transactional
public class H2Test {

	/*
	 public List<Message> getAllMessages();
	
	public int insertMessage(Message m);  
	
	public List<Vampire> getAllVampires(); 
	
	public int insertVampire(Vampire v);
	
	 
	
	
	VampireDao vd = new VampireImpl();
	*/
	
	private MessageDao md = new MessageImpl();
	private VampireDao vd = new VampireImpl();
	
	
	@Test
	public void testGetAllMessage() {
		assertNotNull((md.getAllMessages()));
	}
	
	@Test
	public void testInsertMessages() {
		Message message = new Message("Dave", "Dave@gmail.com", "Hello");
		md.insertMessage(message);
		List<Message> cd = md.getAllMessages();
		System.out.println(cd);
		assertTrue(cd.get(0).getName().equals("Davel"));
	}
	
	@Test
	public void testInsertMessagesFalse() {
		Message message = new Message("Dave", "Dave@gmail.com", "Hello");
		md.insertMessage(message);
		List<Message> cd = md.getAllMessages();
		System.out.println(cd);
		assertFalse(cd.get(0).getName().equals("Ian"));
	}
	
	@Test
	public void testGetAllVampires() {
		assertNotNull((vd.getAllVampires()));
	}
	
	@Test
	public void testInsertVampire() {
		Vampire vampire = new Vampire("Dracula", 444, "Dracula 1897");
		vd.insertVampire(vampire);
		List<Vampire> cd = vd.getAllVampires();
		System.out.println(cd);
		assertTrue(cd.get(0).getName().equals("Dracula"));
	}
	
	@Test
	public void testInsertVampireFalse() {
		Vampire vampire = new Vampire("Dracula", 444, "Dracula 1897");
		vd.insertVampire(vampire);
		List<Vampire> cd = vd.getAllVampires();
		System.out.println(cd);
		assertFalse(cd.get(0).getName().equals("ifeowaf"));
	}

}
