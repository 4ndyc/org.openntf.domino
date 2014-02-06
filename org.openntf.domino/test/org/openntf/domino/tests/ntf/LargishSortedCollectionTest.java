package org.openntf.domino.tests.ntf;

import java.util.ArrayList;
import java.util.List;

import lotus.domino.NotesFactory;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Session;
import org.openntf.domino.helpers.DocumentSorter;
import org.openntf.domino.thread.DominoThread;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Factory;

public class LargishSortedCollectionTest implements Runnable {
	public static void main(final String[] args) {
		DominoThread thread = new DominoThread(new LargishSortedCollectionTest(), "My thread");
		thread.start();
	}

	public LargishSortedCollectionTest() {
		// whatever you might want to do in your constructor, but stay away from Domino objects
	}

	@Override
	public void run() {
		Session session = this.getSession();
		Database db = session.getDatabase("", "events4.nsf");
		DocumentCollection coll = db.getAllDocuments();
		//		System.out.println("UNSORTED");
		for (Document doc : coll) {
			//			System.out.println(doc.getItemValueString("MainSortValue") + " " + doc.getLastModifiedDate().getTime());
		}

		List<String> criteria = new ArrayList<String>();
		//		criteria.add("@doclength");
		criteria.add("@modified");
		try {
			DocumentSorter sorter = new DocumentSorter(coll, criteria);
			//			System.out.println("SORTING...");
			System.out.println("Starting resort of " + coll.getCount() + " documents");
			long startTime = System.nanoTime();
			DocumentCollection sortedColl = sorter.sort();
			long endTime = System.nanoTime();
			System.out.println("Completed resort in " + ((endTime - startTime) / 1000000) + "ms");
			//			System.out.println("SORTED");
			//			for (Document doc : sortedColl) {
			//				System.out.println(doc.getItemValueString("MainSortValue") + " " + doc.getLastModifiedDate().getTime());
			//			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		//		View modView = db.getView("AllByLengthMod");
		//		long startTime = System.nanoTime();
		//		if (modView != null) {
		//			modView.refresh();
		//		}
		//		long endTime = System.nanoTime();
		//		System.out.println("Completed view build in " + ((endTime - startTime) / 1000000) + "ms");

	}

	protected Session getSession() {
		try {
			Session session = Factory.fromLotus(NotesFactory.createSession(), Session.class, null);
			return session;
		} catch (Throwable t) {
			DominoUtils.handleException(t);
			return null;
		}
	}
}
