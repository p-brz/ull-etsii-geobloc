# Introduction #

Using the XMLPackage, it is very easy to build our own form.xml without depending on any particular structure, since it can be built at run-time. We will showcase a simple example here.

# Tools #
From the XMLPackage, we'll be using the TextXMLWriter and FormTextField, MultiField for holding our data.


# Code Example #

Since the IXMLWriter requires a List of IFields, we will need one, even if we are actually only using one MultiField. Here's what we're going to do: The form.xml is usually a big MultiField with a "form" tag, so we'll add all our fields there, and then simply "feed" the List of IFields to the IXMLWriter.

```

// Initialization

List<IField> myFields = new ArrayList<IField>();
// re-usable variable
FormTextField field;
MultiField fields = new MultiField("fields");
// in case we forget, we add our MultiField to the List now.
myFields.add(fields);

// we add fields to our MultiField

// numForm
field = new FormTextField("field", "numForm", numForm.getText().toString());
fields.addField(field);
// inspector
field = new FormTextField("field", "inspector", inspector.getText().toString());
fields.addField(field);
// numVisita
field = new FormTextField("field", "numVisita", numVisita.getText().toString());
fields.addField(field);
// observaciones
field = new FormTextField("field", "observaciones", observaciones.getText().toString());
fields.addField(field);

// now, we simply ask a IXMLWriter to give us the fields as a XML String
IXMLWriter writer = new TextXMLWriter();
String xml = writer.WriteXML(myFields);

// add to the package
/*
   Code here
*/

```

Easy and simple.