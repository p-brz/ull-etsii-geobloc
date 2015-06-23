# GeoBloc XML Forms Definition #

## XMLF Forms DTD ##

You can download it from http://ull-etsii-geobloc.googlecode.com/files/GeoBlocFormsDTDv1.1.dtd

```

<?xml version="1.0" encoding="UTF-8"?>
<!-- Elements struct -->
<!ELEMENT gb_form (gb_name, gb_version, gb_date, gb_formDescription, (gb_dataPage, gb_photoPage, gb_videoPage, gb_audioPage, gb_locationPage)+)>
    <!ELEMENT gb_name (#PCDATA)>
    <!ELEMENT gb_version (#PCDATA)>
    <!ELEMENT gb_date (gb_dateDay, gb_dateMonth, gb_dateYear)>
        <!ELEMENT gb_dateDay (#PCDATA)>
        <!ELEMENT gb_dateMonth (#PCDATA)>
        <!ELEMENT gb_dateYear (#PCDATA)>
    <!ELEMENT gb_formDescription (#PCDATA)>

    <!ELEMENT gb_dataPage (gb_pageName,(gb_label|gb_field|gb_list|gb_checkbox|gb_checkboxthree)+)>
        <!ELEMENT gb_pageName (#PCDATA)>
        <!ELEMENT gb_label (gb_description?, gb_labelText)>
            <!ELEMENT gb_description (#PCDATA)>
            <!ELEMENT gb_labelText (#PCDATA)>
        <!ELEMENT gb_field (gb_description?, gb_fieldLabel, gb_fieldDefaultValue?)>
            <!-- <gb_description> -->
            <!ELEMENT gb_fieldLabel (#PCDATA)>
            <!ELEMENT gb_fieldDefaultValue (#PCDATA)>
        <!ELEMENT gb_checkbox (gb_description?, gb_checkboxText, gb_checkboxDefaultValue?)>
            <!-- <gb_description> -->
            <!ELEMENT gb_checkboxText (#PCDATA)>
            <!ELEMENT gb_checkboxDefaultValue (#PCDATA)>
            <!-- 0 or 1-->
        <!ELEMENT gb_checkboxthree (gb_description?, gb_checkboxthreeText, gb_checkboxthreeDefaultValue?)>
            <!-- <gb_description> -->
            <!ELEMENT gb_checkboxthreeText (#PCDATA)>
            <!ELEMENT gb_checkboxthreeDefaultValue (#PCDATA)>
            <!-- 0, 1 or 2-->
        <!ELEMENT gb_list (gb_description?, gb_listLabel, gb_listItem+)>
            <!-- <gb_description> -->
            <!ELEMENT gb_listLabel (#PCDATA)>
            <!ELEMENT gb_listItem (gb_listItemLabel, gb_listItemValue)>
                <!ELEMENT gb_listItemLabel (#PCDATA)>
                <!ELEMENT gb_listItemValue (#PCDATA)>
				
		
	<!ELEMENT gb_photoPage (gb_pageName, gb_description)>
	
	<!ELEMENT gb_videoPage (gb_pageName, gb_description)>
	
	<!ELEMENT gb_audioPage (gb_pageName, gb_description)>
	
	<!ELEMENT gb_locationPage (gb_pageName, gb_description)>
	

<!-- Attributes -->
<!ATTLIST gb_label
    id CDATA #REQUIRED
>

<!ATTLIST gb_dataPage
    id CDATA #REQUIRED
>

<!ATTLIST gb_photoPage
    id CDATA #REQUIRED
	isRequired (true|false) "false"
>

<!ATTLIST gb_videoPage
    id CDATA #REQUIRED
	isRequired (true|false) "false"
>

<!ATTLIST gb_audioPage
    id CDATA #REQUIRED
	isRequired (true|false) "false"
>

<!ATTLIST gb_locationPage
    id CDATA #REQUIRED
	isRequired (true|false) "false"
>

<!ATTLIST gb_field
    id CDATA #REQUIRED
    isRequired (true|false) "false"
    type (string|integer|float) #REQUIRED
    linesNumber CDATA "1"
>

<!ATTLIST gb_list
    id CDATA #REQUIRED
    isRequired (true|false) "false"
    type (single|multiple|combo) #REQUIRED
>

<!ATTLIST gb_multipleChoiceList
  isRequired (true|false) "false"
>

<!ATTLIST gb_listItem
    selected (true|false) "false"
>

<!ATTLIST gb_checkbox
    id CDATA #REQUIRED
    isRequired (true|false) "false"
>

<!ATTLIST gb_checkboxthree
    id CDATA #REQUIRED
    isRequired (true|false) "false"
>

<!ATTLIST gb_label
    id CDATA #REQUIRED
>

```

### Example 1 ###

A simple one page form example

```

<?xml version="1.0"?>
<!DOCTYPE gb_form SYSTEM "GeoBloc.dtd">

<gb_form id="form">
	<gb_name>Recogida Fresas</gb_name>
	<gb_description>Formulario utilizado para el recuento de la recogida de fresas en los meses de invierno</gb_description>
	<gb_version>1.0</gb_version>
	
	<gb_page id="photo1" type="photo">
		<gb_pageName>Pagina de Fotos</gb_pageName>
	
	</gb_page>
	
	<gb_page id="page1" type="data">
	
		<gb_pageName>Pagina 1</gb_pageName>

		<gb_label id="label1">
		<gb_labelText>Campo 1</gb_labelText>
		</gb_label>

		<gb_checkbox id="checkbox">
		<gb_checkboxText>Foto de Casa</gb_checkboxText>
		</gb_checkbox>

	
		<gb_label id="label2" isRequired="true">
		<gb_labelText>Campo 2</gb_labelText>
		</gb_label>

		
		<gb_checkboxthree id="checkbox3">
		<gb_checkboxthreeText>Marco 1 de 3</gb_checkboxthreeText>
		</gb_checkboxthree>

		<gb_field id="field1" isRequired="true" type="int" linesNumber="3">
		<gb_fieldLabel>Inserta num</gb_fieldLabel>
		</gb_field>

		<gb_label id="label1" isRequired="false">
		<gb_labelText>Campo 3</gb_labelText>
		</gb_label>

		<gb_field id="field2" linesNumber="2">
		<gb_fieldLabel>Inserta texto 2</gb_fieldLabel>
		<gb_fieldDefaultValue>Valor por defecto</gb_fieldDefaultValue>	
		</gb_field>

		
	</gb_page>

	<gb_page id="page2" type="data">
	
		<gb_pageName>Pagina 2</gb_pageName>

		<gb_label id="label1" isRequired="true">
		<gb_labelText>Campo 1 de 2</gb_labelText>
		</gb_label>

	
		<gb_label id="label2" isRequired="true">
		<gb_labelText>Campo 2 de 2</gb_labelText>
		</gb_label>
		
	</gb_page>

</gb_form>

```

### Example 2 ###

A 2 paged form example with various kinds of elements.

```

// cooming soon

```


## XML Forms Database Table ##
This section shows the table definition where the xml forms are saved. It's based on an Oracle 10g eXpress Edition database:

| **ID** | **FormID** | **Version** | **FormXML** |
|:-------|:-----------|:------------|:------------|
| NUMBER | VARCHAR(80) | NUMBER      | XMLType     |
| NOT NULL | NOT NULL   | NOT NULL    | NOT NULL    |
| (PK)   | UNIQUE     | UNIQUE      |             |
| Indice secuencial estándar | Identificador del esquema del formulario | Numero de version del formulario | Contenido XML del formulario |