# Introduction #

This project involves both heavy XML parsing and XML writing. To aid the XML writing, we built a set of classes, around a Decorator Pattern, which allows us to control the structure of the XML files written, and to make changes by simply implementing an interface.


# Basics #

At the core of this system, we find the **IField** interface;

```
public interface IField {
	
	public static String __IFIELD_IDENTATION__ = "   ";
	
	public String getFieldTag();
	public void setFieldTag(String tag);
	public void toXML(XmlSerializer serializer);
}
```

Any class which implements this Interface, can be added to the XML file. The basic idea is that each and every field must know how to write iself, so in the toXML(...) method, the serializer is given to the class. This is forms the base of the system.

To write these fields to XML, we have the IXMLWriter and TextXMLWriter:

```
public interface IXMLWriter {

	public String WriteXML(List<IField> fields);
}
```

```
public class TextXMLWriter implements IXMLWriter {

	//@Override
	public String WriteXML(List<IField> fields) {
		XmlSerializer serializer = Xml.newSerializer();
	    StringWriter writer = new StringWriter();
	    try {
	        serializer.setOutput(writer);
	        serializer.startDocument("UTF-8", true);
	        serializer.text("\n");
	        	              
	        for (IField field: fields){
	        	field.toXML(serializer);
	        }
	        serializer.endDocument();
	        serializer.flush();
	        return writer.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } 

	}

}
```

As you can see, the code is pretty straightforwared. The XMLWriter simply instantiates the XMLSerializer, gets a writer, sets the output, and delegates the writing to each Field. This allows us to include fields inside fields, since the rule is that every field is responsible of writing itself to the file.

**NOTE:** In the source code, there is a commented block. This block was supposed to add automatic identation to the XML files outputted, but enabling the feature crashes the Application, so either we don't use indentation or we do it ourselves inside each Field.


# The fun part #

This is where the magic begins. We need a field made up of many fields. So, what do we do?
We use the MultiField. MultiField implements IField, and holds a List of IFields. What we do is we add all the fields that we want, including another MultiField if we like, and when the writing needs to be done, our design does the trick:

```
public void toXML(XmlSerializer serializer) {
		try {
			serializer.startTag("", this.getFieldTag());
			serializer.text("\n");
			for (IField field : fields) {
				// NOTE: Each IField should indent according to depth
				serializer.text(IField.__IFIELD_IDENTATION__);
				field.toXML(serializer);
			}
			serializer.endTag("", this.getFieldTag());
			serializer.text("\n");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
```

Therefore, each class writes itself.

**NOTE:** Even though it looks like it, there is no indentation, only in the first line of every child IField. Although it looks good, it is not so important since a good XML Viewer will automatically indent according to the tags.