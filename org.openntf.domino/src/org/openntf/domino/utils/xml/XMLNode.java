/**
 * 
 */
package org.openntf.domino.utils.xml;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.openntf.domino.utils.DominoUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author jgallagher
 * 
 */
public class XMLNode implements Map<String, Object>, Serializable {
	private static final long serialVersionUID = 2304991412510751453L;

	protected org.w3c.dom.Node node = null;
	private transient XPath xPath = null;
	private Map<String, Object> getResults = new HashMap<String, Object>();

	protected XMLNode() {
	}

	public XMLNode(final org.w3c.dom.Node node) {
		this.node = node;
	}

	public XMLNode selectSingleNode(final String xpathString) {
		XMLNodeList result = this.selectNodes(xpathString);
		return result.size() == 0 ? null : result.get(0);
	}

	public XMLNodeList selectNodes(final String xpathString) {
		try {
			NodeList nodes = (NodeList) this.getXPath().compile(xpathString).evaluate(node, XPathConstants.NODESET);
			XMLNodeList result = new XMLNodeList(nodes.getLength());
			for (int i = 0; i < nodes.getLength(); i++) {
				result.add(new XMLNode(nodes.item(i)));
			}

			return result;
		} catch (XPathExpressionException xee) {
			DominoUtils.handleException(xee);
			return null;
		}
	}

	public String getAttribute(final String attribute) {
		if (this.node == null) {
			return "";
		}
		NamedNodeMap attributes = this.node.getAttributes();
		if (attributes == null) {
			return "";
		}
		Node attr = attributes.getNamedItem(attribute);
		if (attr == null) {
			return "";
		}
		return attr.getTextContent();
	}

	public void setAttribute(final String attribute, final String value) {
		Node attr = this.node.getAttributes().getNamedItem(attribute);
		if (attr == null) {
			attr = getDocument().createAttribute(attribute);
		}
		attr.setNodeValue(value == null ? "" : value);
		this.node.getAttributes().setNamedItem(attr);
	}

	public String getNodeName() {
		return node.getNodeName();
	}

	public String getText() {
		if (node == null) {
			return "";
		}
		return node.getTextContent();
	}

	public void setText(final String text) {
		if (node == null) {
			return;
		}
		node.setTextContent(text);
	}

	public String getTextContent() {
		return this.getText();
	}

	public void setTextContent(final String textContent) {
		this.setText(textContent);
	}

	public String getNodeValue() {
		if (node == null) {
			return "";
		}
		return node.getNodeValue();
	}

	public void setNodeValue(final String value) {
		if (node == null) {
			return;
		}
		node.setNodeValue(value);
	}

	public XMLNode addChildElement(final String elementName) {
		Node node = this.getDocument().createElement(elementName);
		this.node.appendChild(node);
		return new XMLNode(node);
	}

	public XMLNode insertChildElementBefore(final String elementName, final XMLNode refNode) {
		Node node = this.getDocument().createElement(elementName);
		this.node.insertBefore(node, refNode.getNode());
		return new XMLNode(node);
	}

	public XMLNode getFirstChild() {
		Node node = this.getNode().getFirstChild();
		if (node != null) {
			return new XMLNode(node);
		}
		return null;
	}

	public XMLNode getParentNode() {
		Node node = this.getNode().getParentNode();
		if (node != null) {
			return new XMLNode(node);
		}
		return null;
	}

	public void removeChild(final XMLNode childNode) {
		this.getNode().removeChild(childNode.getNode());
	}

	public XMLNodeList getChildNodes() {
		return new XMLNodeList(getNode().getChildNodes());
	}

	public void removeChildren() {
		for (XMLNode child : this.getChildNodes()) {
			removeChild(child);
		}
	}

	public XMLNode getNextSibling() {
		Node node = this.getNode().getNextSibling();
		if (node != null) {
			return new XMLNode(node);
		}
		return null;
	}

	public void appendChild(final XMLNode node) {
		this.getNode().appendChild(node.getNode());
	}

	public void insertBefore(final XMLNode newChild, final XMLNode refChild) {
		this.getNode().insertBefore(newChild.getNode(), refChild.getNode());
	}

	public org.w3c.dom.Node getNode() {
		return this.node;
	}

	@Override
	public Object get(final Object arg0) {
		String path = String.valueOf(arg0);

		if (path.equals("nodeValue")) {
			return this.getNode().getNodeValue();
		} else if (path.equals("textContent")) {
			return this.getNode().getTextContent();
		}

		if (!this.getResults.containsKey(path)) {
			try {
				XMLNodeList nodes = this.selectNodes(path);
				if (nodes.size() == 1) {
					// this.getResults.put(path, nodes.get(0).getNode());
					this.getResults.put(path, nodes.get(0));
				} else {
					this.getResults.put(path, nodes);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.getResults.get(path);
	}

	public String getXml() throws IOException {

		StreamResult xResult = null;
		DOMSource source = null;

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			xResult = new StreamResult(new StringWriter());
			source = new DOMSource(this.node);
			// We don't want the XML declaration in front
			transformer.setOutputProperty("omit-xml-declaration", "yes");
			transformer.transform(source, xResult);
			return xResult.getWriter().toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	private XPath getXPath() {
		if (this.xPath == null) {
			xPath = XPathFactory.newInstance().newXPath();
		}
		return this.xPath;
	}

	private Document getDocument() {
		return this.node.getOwnerDocument();
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean containsKey(final Object arg0) {
		return false;
	}

	@Override
	public boolean containsValue(final Object arg0) {
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Set<String> keySet() {
		return null;
	}

	@Override
	public Object put(final String arg0, final Object arg1) {
		if (arg0.equals("nodeValue")) {
			this.getNode().setNodeValue(String.valueOf(arg1));
			return arg1;
		} else if (arg0.equals("textContent")) {
			this.getNode().setNodeValue(String.valueOf(arg1));
			return arg1;
		}
		return null;
	}

	@Override
	public void putAll(final Map<? extends String, ? extends Object> arg0) {
	}

	@Override
	public Object remove(final Object arg0) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Collection<Object> values() {
		return null;
	}
}