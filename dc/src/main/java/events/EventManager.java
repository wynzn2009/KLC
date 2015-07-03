package events;

import java.util.Date;

import org.hibernate.Session;

import util.HibernateUtil;

public class EventManager {
	private void creataAndStoreEvent(String title,Date theDate){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		Event e = new Event();
		e.setTitle(title);
		e.setDate(theDate);
		session.save(e);
		session.getTransaction().commit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventManager m = new EventManager();
		if(args[0].equals("store")){
			m.creataAndStoreEvent("My", new Date());
		}
		HibernateUtil.getSessionFactory().close();
	}

}
