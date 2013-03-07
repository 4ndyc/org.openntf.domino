package org.openntf.domino.impl;

import java.util.Vector;

import lotus.domino.DocumentCollection;
import lotus.domino.NotesException;
import lotus.domino.ViewColumn;
import lotus.domino.ViewEntry;
import lotus.domino.ViewEntryCollection;
import lotus.domino.ViewNavigator;

import org.openntf.domino.utils.DominoUtils;

public class View extends Base<org.openntf.domino.View, lotus.domino.View> implements org.openntf.domino.View {

	public View(lotus.domino.View delegate) {
		super(delegate);
	}

	@Override
	public int FTSearch(String query) {
		try {
			return getDelegate().FTSearch(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearch(String query, int maxDocs) {
		try {
			return getDelegate().FTSearch(query, maxDocs);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query) {
		try {
			return getDelegate().FTSearchSorted(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, int column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, String column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int FTSearchSorted(String query, int maxDocs, String column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query) {
		try {
			return getDelegate().FTSearchSorted(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public void clear() {
		try {
			getDelegate().clear();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public ViewColumn copyColumn(int sourceColumn) {
		try {
			return getDelegate().copyColumn(sourceColumn);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn copyColumn(int sourceColumn, int destinationIndex) {
		try {
			return getDelegate().copyColumn(sourceColumn, destinationIndex);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn copyColumn(String sourceColumn) {
		try {
			return getDelegate().copyColumn(sourceColumn);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn copyColumn(String sourceColumn, int destinationIndex) {
		try {
			return getDelegate().copyColumn(sourceColumn, destinationIndex);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn copyColumn(ViewColumn sourceColumn) {
		try {
			if (sourceColumn instanceof org.openntf.domino.ViewColumn) {
				return getDelegate().copyColumn(((org.openntf.domino.ViewColumn) sourceColumn).getDelegate());
			}
			return getDelegate().copyColumn(sourceColumn);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn copyColumn(ViewColumn sourceColumn, int destinationIndex) {
		try {
			if (sourceColumn instanceof org.openntf.domino.ViewColumn) {
				return getDelegate().copyColumn(((org.openntf.domino.ViewColumn) sourceColumn).getDelegate(), destinationIndex);
			}
			return getDelegate().copyColumn(sourceColumn, destinationIndex);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn createColumn() {
		try {
			return getDelegate().createColumn();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn createColumn(int position) {
		try {
			return getDelegate().createColumn(position);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn createColumn(int position, String columnTitle) {
		try {
			return getDelegate().createColumn(position, columnTitle);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn createColumn(int position, String columnTitle, String formula) {
		try {
			return getDelegate().createColumn(position, columnTitle, formula);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection createViewEntryCollection() {
		try {
			return getDelegate().createViewEntryCollection();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNav() {
		try {
			return getDelegate().createViewNav();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNav(int cacheSize) {
		try {
			return getDelegate().createViewNav(cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFrom(Object entry) {
		try {
			return getDelegate().createViewNavFrom(entry);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFrom(Object entry, int cacheSize) {
		try {
			return getDelegate().createViewNavFrom(entry, cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromAllUnread() {
		try {
			return getDelegate().createViewNavFromAllUnread();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromAllUnread(String userName) {
		try {
			return getDelegate().createViewNavFromAllUnread(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName) {
		try {
			return getDelegate().createViewNavFromCategory(categoryName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName, int cacheSize) {
		try {
			return getDelegate().createViewNavFromCategory(categoryName, cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromChildren(Object entry) {
		try {
			return getDelegate().createViewNavFromChildren(entry);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromChildren(Object entry, int cacheSize) {
		try {
			return getDelegate().createViewNavFromChildren(entry, cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry) {
		try {
			return getDelegate().createViewNavFromDescendants(entry);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry, int cacheSize) {
		try {
			return getDelegate().createViewNavFromDescendants(entry, cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavMaxLevel(int level) {
		try {
			return getDelegate().createViewNavMaxLevel(level);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewNavigator createViewNavMaxLevel(int level, int cacheSize) {
		try {
			return getDelegate().createViewNavMaxLevel(level, cacheSize);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getAliases() {
		try {
			return (Vector<String>) getDelegate().getAliases();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public DocumentCollection getAllDocumentsByKey(Object key) {
		try {
			return getDelegate().getAllDocumentsByKey(key);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public DocumentCollection getAllDocumentsByKey(Object key, boolean exact) {
		try {
			return getDelegate().getAllDocumentsByKey(key, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys) {
		try {
			return getDelegate().getAllDocumentsByKey(keys);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys, boolean exact) {
		try {
			return getDelegate().getAllDocumentsByKey(keys, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllEntries() {
		try {
			return getDelegate().getAllEntries();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) {
		try {
			return getDelegate().getAllEntriesByKey(key);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		try {
			return getDelegate().getAllEntriesByKey(key, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) {
		try {
			return getDelegate().getAllEntriesByKey(keys);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) {
		try {
			return getDelegate().getAllEntriesByKey(keys, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllReadEntries() {
		try {
			return getDelegate().getAllReadEntries();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllReadEntries(String userName) {
		try {
			return getDelegate().getAllReadEntries(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllUnreadEntries() {
		try {
			return getDelegate().getAllUnreadEntries();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntryCollection getAllUnreadEntries(String userName) {
		try {
			return getDelegate().getAllUnreadEntries(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getBackgroundColor() {
		try {
			return getDelegate().getBackgroundColor();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return 0;
	}

	@Override
	public Document getChild(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getChild(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getChild(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewColumn getColumn(int columnNumber) {
		try {
			return getDelegate().getColumn(columnNumber);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		try {
			return getDelegate().getColumnCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getColumnNames() {
		try {
			return (Vector<String>) getDelegate().getColumnNames();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector getColumnValues(int column) {
		try {
			return getDelegate().getColumnValues(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<ViewColumn> getColumns() {
		try {
			return (Vector<ViewColumn>) getDelegate().getColumns();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public DateTime getCreated() {
		try {
			return new DateTime(getDelegate().getCreated());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getDocumentByKey(Object key) {
		try {
			return new Document(getDelegate().getDocumentByKey(key));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getDocumentByKey(Object key, boolean exact) {
		try {
			return new Document(getDelegate().getDocumentByKey(key, exact));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Document getDocumentByKey(Vector keys) {
		try {
			return new Document(getDelegate().getDocumentByKey(keys));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Document getDocumentByKey(Vector keys, boolean exact) {
		try {
			return new Document(getDelegate().getDocumentByKey(keys, exact));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntry getEntryByKey(Object key) {
		try {
			return getDelegate().getEntryByKey(key);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public ViewEntry getEntryByKey(Object key, boolean exact) {
		try {
			return getDelegate().getEntryByKey(key, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ViewEntry getEntryByKey(Vector keys) {
		try {
			return getDelegate().getEntryByKey(keys);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ViewEntry getEntryByKey(Vector keys, boolean exact) {
		try {
			return getDelegate().getEntryByKey(keys, exact);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getEntryCount() {
		try {
			return getDelegate().getEntryCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public Document getFirstDocument() {
		try {
			return new Document(getDelegate().getFirstDocument());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getHeaderLines() {
		try {
			return getDelegate().getHeaderLines();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public String getHttpURL() {
		try {
			return getDelegate().getHttpURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getLastDocument() {
		try {
			return new Document(getDelegate().getLastDocument());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public DateTime getLastModified() {
		try {
			return new DateTime(getDelegate().getLastModified());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getLockHolders() {
		try {
			return (Vector<String>) getDelegate().getLockHolders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public String getName() {
		try {
			return getDelegate().getName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getNextDocument(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getNextDocument(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getNextSibling(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getNextSibling(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getNextSibling(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public String getNotesURL() {
		try {
			return getDelegate().getNotesURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getNthDocument(int n) {
		try {
			return new Document(getDelegate().getNthDocument(n));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Database getParent() {
		try {
			return new Database(getDelegate().getParent());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getParentDocument(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getParentDocument(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getParentDocument(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getPrevDocument(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getPrevDocument(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public Document getPrevSibling(lotus.domino.Document doc) {
		try {
			if (doc instanceof Document) {
				return new Document(getDelegate().getPrevSibling(((Document) doc).getDelegate()));
			}
			return new Document(getDelegate().getPrevSibling(doc));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getReaders() {
		try {
			return (Vector<String>) getDelegate().getReaders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getRowLines() {
		try {
			return getDelegate().getRowLines();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public String getSelectionFormula() {
		try {
			return getDelegate().getSelectionFormula();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public String getSelectionQuery() {
		try {
			return getDelegate().getSelectionQuery();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public int getSpacing() {
		try {
			return getDelegate().getSpacing();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public int getTopLevelEntryCount() {
		try {
			return getDelegate().getTopLevelEntryCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	@Override
	public String getURL() {
		try {
			return getDelegate().getURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public String getUniversalID() {
		try {
			return getDelegate().getUniversalID();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public String getViewInheritedName() {
		try {
			return getDelegate().getViewInheritedName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	@Override
	public boolean isAutoUpdate() {
		try {
			return getDelegate().isAutoUpdate();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isCalendar() {
		try {
			return getDelegate().isCalendar();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isCategorized() {
		try {
			return getDelegate().isCategorized();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isConflict() {
		try {
			return getDelegate().isConflict();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isDefaultView() {
		try {
			return getDelegate().isDefaultView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isEnableNoteIDsForCategories() {
		try {
			return getDelegate().isEnableNoteIDsForCategories();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isFolder() {
		try {
			return getDelegate().isFolder();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isHierarchical() {
		try {
			return getDelegate().isHierarchical();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isModified() {
		try {
			return getDelegate().isModified();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isPrivate() {
		try {
			return getDelegate().isPrivate();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isProhibitDesignRefresh() {
		try {
			return getDelegate().isProhibitDesignRefresh();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isProtectReaders() {
		try {
			return getDelegate().isProtectReaders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean isQueryView() {
		try {
			return getDelegate().isQueryView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lock() {
		try {
			return getDelegate().lock();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lock(boolean provisionalOk) {
		try {
			return getDelegate().lock(provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lock(String name) {
		try {
			return getDelegate().lock(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalOk) {
		try {
			return getDelegate().lock(name, provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean lock(Vector names) {
		try {
			return getDelegate().lock(names);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		try {
			return getDelegate().lock(names, provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lockProvisional() {
		try {
			return getDelegate().lockProvisional();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public boolean lockProvisional(String name) {
		try {
			return getDelegate().lockProvisional(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean lockProvisional(Vector names) {
		try {
			return getDelegate().lockProvisional(names);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	@Override
	public void markAllRead() {
		try {
			getDelegate().markAllRead();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void markAllRead(String userName) {
		try {
			getDelegate().markAllRead(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void markAllUnread() {
		try {
			getDelegate().markAllUnread();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void markAllUnread(String userName) {
		try {
			getDelegate().markAllUnread(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void refresh() {
		try {
			getDelegate().refresh();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void remove() {
		try {
			getDelegate().remove();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void removeColumn() {
		try {
			getDelegate().removeColumn();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void removeColumn(int column) {
		try {
			getDelegate().removeColumn(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void removeColumn(String column) {
		try {
			getDelegate().removeColumn(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void resortView() {
		try {
			getDelegate().resortView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void resortView(String column) {
		try {
			getDelegate().resortView(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void resortView(String column, boolean ascending) {
		try {
			getDelegate().resortView(column, ascending);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setAliases(String alias) {
		try {
			getDelegate().setAliases(alias);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setAliases(Vector aliases) {
		try {
			getDelegate().setAliases(aliases);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setAutoUpdate(boolean flag) {
		try {
			getDelegate().setAutoUpdate(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setBackgroundColor(int color) {
		try {
			getDelegate().setBackgroundColor(color);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setDefaultView(boolean flag) {
		try {
			getDelegate().setDefaultView(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setEnableNoteIDsForCategories(boolean flag) {
		try {
			getDelegate().setEnableNoteIDsForCategories(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setName(String name) {
		try {
			getDelegate().setName(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setProhibitDesignRefresh(boolean flag) {
		try {
			getDelegate().setProhibitDesignRefresh(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setProtectReaders(boolean flag) {
		try {
			getDelegate().setProtectReaders(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setReaders(Vector readers) {
		try {
			getDelegate().setReaders(readers);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setSelectionFormula(String formula) {
		try {
			getDelegate().setSelectionFormula(formula);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setSelectionQuery(String query) {
		try {
			getDelegate().setSelectionQuery(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void setSpacing(int spacing) {
		try {
			getDelegate().setSpacing(spacing);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	@Override
	public void unlock() {
		try {
			getDelegate().unlock();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * New methods
	 */

	@Override
	public Document getDocument() {
		Database parent = this.getParent();
		return parent.getDocumentByUNID(this.getUniversalID());
	}
}
