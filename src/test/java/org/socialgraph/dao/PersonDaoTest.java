package org.socialgraph.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.socialgraph.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Tests the person dao
 * 
 * 
 * @author driedtoast
 *
 */
public class PersonDaoTest extends AbstractDaoTest {

	@Autowired
	private PersonDao personDao;
	
	/**
	 * Tests a create
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPersonCreate() throws Exception {
		Person obj = new Person();
		obj.setDisplayName("bob ");
		obj.setAboutMe("who");
		personDao.savePerson(obj);
		Assert.assertNotNull(obj.getId());
		
	}

	/**
	 * Get a display name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPersonGetByDisplayName() throws Exception {
		Person obj = new Person();
		obj.setDisplayName("bob");
		obj.setAboutMe("who");
		personDao.savePerson(obj);
		Long id = obj.getId();
		Assert.assertNotNull(id);
		
		Person person = personDao.getByDisplayName("bob");
		Assert.assertNotNull(person);
			
	}
		
	
	/**
	 * Get a display name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAll() throws Exception {
		Person obj = new Person();
		obj.setDisplayName("bob");
		obj.setAboutMe("who");
		personDao.savePerson(obj);
		Long id = obj.getId();
		Assert.assertNotNull(id);
		
		List<Person> people = personDao.getAllUsers();
		Assert.assertNotNull(people);
		Assert.assertTrue(people.size() > 0);
	}
	
	/**
	 * Test remove
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRemovePerson() throws Exception {
		Person obj = new Person();
		obj.setDisplayName("bob5");
		obj.setAboutMe("who");
		personDao.savePerson(obj);
		Long id = obj.getId();
		Assert.assertNotNull(id);
		
		// make sure id is there
		Person person = personDao.getById(id);
		Assert.assertNotNull(person);
		
		personDao.deleteNode(id);
		
		// assert id is not there
		person = personDao.getById(id);
		Assert.assertNull(person);
		
		
	}
	
}
