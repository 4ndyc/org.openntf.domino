/* Generated By:JJTree&JavaCC: Do not edit this line. AtFormulaParser.java */
package de.foconis.test.formula;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import jline.ANSIBuffer;
import jline.ArgumentCompletor;
import jline.Completor;
import jline.ConsoleReader;
import jline.SimpleCompletor;
import jline.Terminal;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.formula.AtFormulaParser;
import org.openntf.domino.formula.AtFunction;
import org.openntf.domino.formula.AtFunctionFactory;
import org.openntf.domino.formula.EvaluateException;
import org.openntf.domino.formula.FormulaContext;
import org.openntf.domino.formula.ParseException;
import org.openntf.domino.formula.ast.Node;
import org.openntf.domino.formula.ast.SimpleNode;
import org.openntf.domino.formula.impl.NotImplemented;
import org.openntf.domino.thread.DominoThread;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Factory;

public class FormulaShell implements Runnable {
	private static  int count = 10000;
	Map<String, Node> astCache = new HashMap<String, Node>();
	private Database db;
	
	
	public static void main(final String[] args) {
		DominoThread thread = new DominoThread(new FormulaShell(), "My thread");
		thread.start();
	}

	public FormulaShell() {
		// whatever you might want to do in your constructor, but stay away from Domino objects
	}

	@Override
	public void run() {
		try {

			for (Fixes fix : Fixes.values())
			Factory.getSession().setFixEnable(fix, true);
			DominoUtils.setBubbleExceptions(true);
			
			// RPr: I use  "http://jline.sourceforge.net/" to emulate a shell to test my formula engine
			// I put jline-1.0.jar in jvm/lib/ext
			// In detail: I do not know exactly what I'm doing here... I just need a shell :) 

			ConsoleReader reader = new ConsoleReader();
			reader.setBellEnabled(false);
			//reader.setDebug(new PrintWriter(new FileWriter("writer.debug", true)));

			List<Completor> completors = new LinkedList<Completor>();

			// This code is responsible for autocompletion
			AtFunctionFactory funcFact = AtFunctionFactory.getInstance();
			Collection<AtFunction> funcs = funcFact.getFunctions().values();
			String[] autoComplete = new String[funcs.size()];
			int i = 0;
			for (AtFunction func : funcs) {
				if (func instanceof NotImplemented) {
					autoComplete[i++] = "NotImpl:" + func.getImage();
				} else {
					autoComplete[i++] = func.getImage() + "(";
				}
			}

			completors.add(new SimpleCompletor(autoComplete));
			reader.addCompletor(new ArgumentCompletor(completors));

			String line;
			// we want some more comfort
			File historyFile = new File("history.txt");
			reader.getHistory().setHistoryFile(historyFile);

			// now start the main loop
			System.out.println("This is the formula shell. Quit with 'q' !!! If you get a NullpointerException, terminate your server!");
			System.out.println("Session.convertMime is " + Factory.getSession().isConvertMime());
			while ((line = reader.readLine("$> ")) != null) {
				if (line.equalsIgnoreCase("q")) {
					break;
				}
				execute(line);
			}
			System.out.println("Bye.");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Factory.dumpCounters(true));
		Factory.terminate();
		System.out.println(Factory.dumpCounters(true));
	}

	private Document createDocument() {
		if (db == null) db = Factory.getSession().getDatabase("", "log.nsf");
		Document doc = db.createDocument();
		return doc;
	}
	private void fillDemoDoc(Map<String, Object> doc) {

		doc.put("myfield", new double[] { Math.random()*5.0 });
//		doc.put("text1", "This is a test string");
//		doc.put("text2", new String[] { "1", "2", "3" });
//
//		doc.put("int1", new int[] { 1 });
//		doc.put("int2", new int[] { 1, 2, 3 });
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("K1", "v1");
//		map.put("K2", "v2");
//		doc.put("mime1", map);

	}
	
	
	
	private List<Object> evaluateNTF(final String line, Map<String, Object> doc, boolean cacheAST) throws ParseException, EvaluateException {


		Node ast = null;
		if (cacheAST) ast = astCache.get(line);

		AtFormulaParser parser = AtFormulaParser.getInstance();
		if (ast == null) {
			ast = parser.Parse(line);
			if (cacheAST)astCache.put(line, ast);
		}

		
		FormulaContext ctx = new FormulaContext(doc, parser.getFormatter());

		return ast.evaluate(ctx);
	}


	public String col1(Object o) {
		ANSIBuffer ab = new ANSIBuffer();
		return ab.cyan(o.toString()).toString();
	}
	public String col2(Object o) {
		ANSIBuffer ab = new ANSIBuffer();
		return ab.red(o.toString()).toString();
	}	
	private void execute(final String line) {
		// TODO Auto-generated method stub

		List<Object> ntf = null;
		long ntfTime = 0;
		List<Object> lotus = null;
		long lotusTime = 0;
		long time = 0; 
		
		
		Document ntfDoc = createDocument();
		Document lotusDoc = createDocument();
		Map<String, Object> ntfMap1 = new HashMap<String, Object>();
		Map<String, Object> ntfMap2 = new HashMap<String, Object>();

		fillDemoDoc(ntfDoc);
		fillDemoDoc(lotusDoc);
		fillDemoDoc(ntfMap1);
		fillDemoDoc(ntfMap2);

//		try {
//			lotus.domino.Session rawSession = Factory.toLotus(Factory.getSession());
//			time = System.nanoTime();
//			for (int i = 0; i < count; i++) {
//				lotus = rawSession.evaluate(line);
//			}
//			lotusTime = System.nanoTime() - time;
//			System.out.println(col2("LOTUS:\t...executed " + count + " times in " + lotusTime + " ms. (context: null, RAW session)"));
//			System.out.println("LOTUS:\t" + dump(lotus));
//		} catch (Exception e) {
//			System.out.println("LOTUS failed! "+ e.getMessage());
//		}
//		
//		
//		try {
//			time = System.nanoTime();
//			for (int i = 0; i < count; i++) {
//				lotus = Factory.getSession().evaluate(line);
//			}
//			lotusTime = System.nanoTime() - time;
//			System.out.println(col2("LOTUS:\t...executed " + count + " times in " + lotusTime + " ms. (context: null, OpenNTF session)"));
//			System.out.println("LOTUS:\t" + dump(lotus));
//		} catch (Exception e) {
//			System.out.println("LOTUS failed! "+ e.getMessage());
//		}
		
		try {

			time = System.nanoTime();

			for (int i = 0; i < count; i++) {
				lotusDoc = createDocument();
				fillDemoDoc(lotusDoc);
				lotus = Factory.getSession().evaluate(line, lotusDoc);
			}
			
			lotusTime = System.nanoTime() - time;
			System.out.println(col2("LOTUS:\t...executed " + count + " times in " + lotusTime + " ms. (context: Document)"));
			System.out.println("LOTUS:\t" + dump(lotus));
		} catch (Exception e) {
			System.out.println("LOTUS failed! "+ e.getMessage());
		}
		
		try {
			// Test 1
			time = System.nanoTime();
			
			for (int i = 0; i < count; i++) {
				ntfDoc = createDocument();
				fillDemoDoc(ntfDoc);
				ntf =evaluateNTF(line, ntfDoc, false);
			}
			
			ntfTime = System.nanoTime() - time;
			System.out.println(col1("NTF\t...executed " + count + " times in " + ntfTime + " ms. "+vs(ntfTime, lotusTime) + " (context: Document, ast-cache: off)"));
			System.out.println("NTF:\t" + dump(ntf));

			// Test 2
			time = System.nanoTime();
			for (int i = 0; i < count; i++) {
				ntfDoc = createDocument();
				fillDemoDoc(ntfDoc);
				ntf =evaluateNTF(line, ntfDoc, true);
			}
			ntfTime = System.nanoTime() - time;
			System.out.println(col1("NTF\t...executed " + count + " times in " + ntfTime + " ms. "+vs(ntfTime, lotusTime) + " (context: Document, ast-cache: on)"));
			System.out.println("NTF:\t" + dump(ntf));
			
			
			// Test 3
			time = System.nanoTime();
			
			for (int i = 0; i < count; i++) {
				ntfMap1 = new HashMap<String, Object>();
				fillDemoDoc(ntfMap1);
				ntf =evaluateNTF(line, ntfMap1, false);
			}
			
			ntfTime = System.nanoTime() - time;
			System.out.println(col1("NTF\t...executed " + count + " times in " + ntfTime + " ms. "+vs(ntfTime, lotusTime) + " (context: HashMap, ast-cache: off)"));
			System.out.println("NTF:\t" + dump(ntf));
			
			// Test 4
			time = System.nanoTime();
			
			for (int i = 0; i < count; i++) {
				ntfMap2 = new HashMap<String, Object>();
				fillDemoDoc(ntfMap2);
				ntf = evaluateNTF(line, ntfMap2, true);
			}
	
			ntfTime = System.nanoTime() - time;
			System.out.println(col1("NTF\t...executed " + count + " times in " + ntfTime + " ms. "+vs(ntfTime, lotusTime) + " (context: HashMap, ast-cache: on)"));
			System.out.println("NTF:\t" + dump(ntf));
		} catch (Exception e) {
			System.out.println("NTF failed!");
			e.printStackTrace();
		}


		
		// Comparing the two things
		try {


			boolean differs = false;

			if (ntf.size() == lotus.size()) {
				for (int i = 0; i < ntf.size(); i++) {
					Object a = ntf.get(i);
					Object b = lotus.get(i);
					if (a == null && b == null) {

					} else if (a == null || b == null) {
						differs = true;
						break;
					} else if (a instanceof Number && b instanceof Number) {
						if (Double.compare(((Number) a).doubleValue(), ((Number) b).doubleValue()) != 0) {
							differs = true;
							break;
						}
					} else if (!a.equals(b)) {
						differs = true;
						break;
					}
				}
			} else {
				differs = true;
			}
			if (compareList(ntf, lotus)) {
				System.out.println("Formula Results are different!");
			} else {
				System.out.println("Formula Results are equal :) :)");
			}
			
			if (ntfDoc.entrySet().equals(lotusDoc.entrySet())) {
				System.out.println("Documents are equal :) :)");
				for (Entry<String, Object> entry : ntfDoc.entrySet()) {
					System.out.println("\t" + entry);
				}
			} else {
				System.out.println("Documents are different! NTF Document vs LotusDocument:");
				Set<String> keys = new HashSet<String>();
				keys.addAll(ntfDoc.keySet());
				keys.addAll(lotusDoc.keySet());
				for (String key : keys) {
					Vector ntfVal = ntfDoc.getItemValue(key);
					Vector lotusVal = lotusDoc.getItemValue(key);
					if (ntfVal == null && lotusVal == null) {
						// equal
					} else if (ntfVal == null || lotusVal == null || !ntfVal.equals(lotusVal)) {
						System.out.println(key + "\t" + ntfVal + "\t <> " + lotusVal);
					}

				}

			}
		
		} catch (Exception e) {
			System.out.println("DOMINO failed!");
			e.printStackTrace();
		}
	}
	
	private String dump(List<Object> lotus) {
		// TODO Auto-generated method stub
		int width = Terminal.getTerminal().getTerminalWidth()-20;
		String s = lotus.toString();
		if (s.length()>width) {
			s = s.substring(0, width)+"... (l=" + width + ")";
		}
		
		return s;
		
	}

	private String vs(long ntfTime, long lotusTime) {
		if (ntfTime < 2) {
			return "Unbelievable faster than lotus";
		}
		return String.format("%.2f times faster than lotus", (double)lotusTime / (double)ntfTime);
		
	}

	private boolean compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
		return false;
	}
	private boolean compareList(List<Object> list1, List<Object> list2) {
		boolean differs = false;

		if (list1.size() == list2.size()) {
			for (int i = 0; i < list1.size(); i++) {
				Object a = list1.get(i);
				Object b = list2.get(i);
				if (a == null && b == null) {

				} else if (a == null || b == null) {
					differs = true;
					break;
				} else if (a instanceof Number && b instanceof Number) {
					if (Double.compare(((Number) a).doubleValue(), ((Number) b).doubleValue()) != 0) {
						differs = true;
						break;
					}
				} else if (!a.equals(b)) {
					differs = true;
					break;
				}
			}
		} else {
			differs = true;
		}
		return differs;
	}
}
