package net.azib.java.students.t104607.homework;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * This class is to output the competition results in XML format
 *
 * @author 104607 IASM
 */
public class OutputXml {
	Logger LOG = Logger.getLogger(this.getClass());

	Document xml;
	private Element root;
	private Element record;
	private Element element;

	private void createDocument() throws ParserConfigurationException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
        xml = docBuilder.newDocument();
		root = xml.createElement("decathlon");
        xml.appendChild(root);
	}

	private void addElement(String name, String value) {
		element = xml.createElement(name);
		element.setTextContent(value);
		record.appendChild(element);
	}

	private void addEventElement(String sports, String result) {
		element = xml.createElement("event");
		Element event = xml.createElement("sports");
		event.setTextContent(sports);
		element.appendChild(event);
		event = xml.createElement("result");
		event.setTextContent(result);
		element.appendChild(event);
		record.appendChild(element);
	}

	void transformDocument(Writer out) throws TransformerException {
		xml.setXmlStandalone(true);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		//transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "decathlon.dtd");
		transformer.transform(new DOMSource(xml), new StreamResult(out));
	}

	void logInfo() {
		LOG.info("Using XML output");
	}

	/**
     * Show the competition results
     * <p>
     * @param outputStream stream to output the competition results
     * @param athletes list with athletes results
	 */
	public void save(OutputStream outputStream, List<Athlete> athletes) {
		logInfo();

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));

		try {
			createDocument();

			for (Athlete athlete : athletes) {
				record = xml.createElement("athlete");

				addElement("position",athlete.getPosition());
				addElement("score",Integer.toString(athlete.getScore()));
				addElement("name",athlete.getName());
				addElement("country",athlete.getCountry());
				addElement("birthday",athlete.getBirthday());

				addEventElement("sprint_100m",athlete.getSprint100m());
				addEventElement("long_jump",athlete.getLongJump());
				addEventElement("shot_put",athlete.getShotPut());
				addEventElement("high_jump",athlete.getHighJump());
				addEventElement("sprint_400m",athlete.getSprint400m());
				addEventElement("hurdles_110m",athlete.getHurdles110m());
				addEventElement("discus_throw",athlete.getDiscusThrow());
				addEventElement("pole_vault",athlete.getPoleVault());
				addEventElement("javelin_throw",athlete.getJavelinThrow());
				addEventElement("race_1500m",athlete.getRace1500m());

				root.appendChild(record);
			}

			transformDocument(out);
		} catch (ParserConfigurationException e) {
			LOG.error("Problem with parser configuration", e);
		} catch (TransformerException e) {
			LOG.error("Problem with transformer", e);
		} finally {
			IOUtils.closeQuietly(out);
		}

	}
}
