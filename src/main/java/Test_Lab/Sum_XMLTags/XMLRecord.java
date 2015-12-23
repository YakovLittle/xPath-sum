package Test_Lab.Sum_XMLTags;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.InputSource;

public class XMLRecord {
	private String xrecord;
    private final String xpexpr;
    final static Logger log = Logger.getLogger(XMLRecord.class);
         
    XMLRecord() {
    	PropertyConfigurator.configure("log4j.properties");
    	xpexpr = "sum(//*[number(text())=number(text())])";
    }
    
	public double getSumbyXPath() {
		 double sum = 0; 
		 try {
			 InputSource xml = new InputSource(new StringReader(this.xrecord));
			 XPath xPath = XPathFactory.newInstance().newXPath();
			 XPathExpression expr = xPath.compile(this.xpexpr);
			 sum = Double.parseDouble(expr.evaluate(xml, XPathConstants.STRING).toString());
			 log.info("Total sum: "+sum+" for: "+this.xrecord);
		} catch (XPathExpressionException e) {
			log.warn("XML-Parse-error: sum cannot be calculated for \""+this.xrecord+"\"");
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		return sum;
	}

	public void setXRecord(String xmlline) {
		this.xrecord = xmlline;
	}
}
