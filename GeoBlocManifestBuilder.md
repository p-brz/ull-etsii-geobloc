# Introduction #

With our XMLPackage, it's very easy to make an XML file on the fly. But, because the Manifest has a more difficult layout than the form.xml, and because it's mostly static (always built in the same way), we chose to build a class to do the work for us, and make our code look smoother.


# Code Example #

It is very straightforward, since it handles all the XML classes internally.

```

// initialization
manifestBuilder = new GeoBlocPackageManifestBuilder(title, description, 
    			schema, language, packageDataType, date);

// add files to the manifest 
manifestBuilder.addFile(filename, fileType);

// get the manifest as XML string
String xml = manifestBuilder.toXml();

```

Note that when adding files, we're not writing to the SD Card or anything, it's only managing IFields internally, and we get the XML without calling the IXMLWriter for ourselves. We will analyze its structure with an example:

```
<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>
<package>
   <pk-metadata>
   <field name="Title" value="geobloc_pk_9-12-2009_21-25-43/" />
   <field name="Description" value="GeoBloc Package" />
   <field name="Form Schema" value="static/1" />
   <field name="Language" value="es" />
   <field name="type" value="application/octet" />
   <field name="date" value="9-12-2009" />
</pk-metadata>
   <f-metadata>
   <field name="file-name" value="form.xml" />
</f-metadata>
</package>
```

Internally, it's a MultiField (package) with at least one MultiField (pk-metadata), which is fixed. For every file, we add a MultiField (f-metadata) which includes the filename and the file's type in MIME.