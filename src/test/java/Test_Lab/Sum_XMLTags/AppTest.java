package Test_Lab.Sum_XMLTags;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {
	private XMLRecord xline;

	@BeforeClass
	void setUp() throws Exception {
		xline = new XMLRecord();
	}
	
	@DataProvider
    public Object[][] dataXMLrecord() {
        return new Object[][]{{"<Item><Name>Test</Name><Price>5.0</Price><Count>2.0</Count></Item>", 7.0},
        					  {"<Item><Name>15</Name><Price>-15</Price></Item>", 0.0},
        					  {"<Item <Name></Name><Price>-15</Price></Item>", 0.0},
        					  {" ", 0.0},
        					  {"<Items><Item><Name><![CDATA[Title]]></Name><Price>5</Price></Item><Item><Name>02</Name><Price>5.0</Price></Item></Items>", 12.0},
        					  {"<Items><Item><Name><![CDATA[10]]></Name><Price>-5</Price></Item><Item><Name>02</Name><Price>5.0</Price></Item></Items>", 12.0},
        					  {"<html><head><title>Test</title></head><body><Test>3</Test><div id=\"foo\"><h6>bug</h6><h6>9.5</h6><h6>3</h6><h6>5</h6></div></body></html>", 20.5}
        					 };
    }
	
	@Test(dataProvider = "dataXMLrecord")
    public void testCheckSum(String xmlrecord, double sumInTags) throws Exception {
		//Parse XML records and calculate sum of tags values
		xline.setXRecord(xmlrecord);
		Assert.assertEquals(xline.getSumbyXPath(), sumInTags);
    }
}