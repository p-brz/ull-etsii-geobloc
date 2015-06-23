# GeoBloc instances DTD #

Original file can be downloaded here: http://ull-etsii-geobloc.googlecode.com/files/GeoBlocInstancesDTD1.1.xml

**WARNING: I'm sure it's not 100% correct, it's my first DTD after all.**

```
<?xml version="1.0" encoding="UTF-8"?>
<!ELEMENT gb_instance (gb_scheme, gb_schemeFile, gb_device, gb_formId, gb_formVersion, gb_complete, gb_form, gb_page+)>

  <!ELEMENT gb_scheme (#PCDATA)>
  <!ELEMENT gb_schemeFile (#PCDATA)>
  <!ELEMENT gb_device (#PCDATA)>
  <!ELEMENT gb_formId(#PCDATA)>
  
  <!ELEMENT gb_complete (#PCDATA)>
  <!ELEMENT gb_formVersion (#PCDATA)>
  
  <!ELEMENT (#PCDATA)>
  <!ELEMENT (#PCDATA)>
  <!ELEMENT (#PCDATA)>

  <!ELEMENT id (#PCDATA)>
  
  <!ELEMENT gb_dataPage (id, gb_field|gb_singleChoiceList|gb_multipleChoiceList|gb_checkbox|gb_checkboxthree)*>
    
	<!ELEMENT gb_field (id, value)>
		<!ELEMENT value (#PCDATA)>
		
    <!ELEMENT gb_singleChoiceList (id, selected_value)>
      <!ELEMENT selected_value (#PCDATA)>
	  
    <!ELEMENT gb_multipleChoiceList (id, selected_values)>
      <!ELEMENT selected_values gb_listItem+>
        <!ELEMENT gb_listItem (id, value)>
		
    <!ELEMENT gb_checkbox (id, #PCDATA)>
    <!ELEMENT gb_checkboxthree (id, #PCDATA)>
	
  <!ELEMENT gb_photoPage (id, binary*)>
    <!ELEMENT gb_binary (#PCDATA)>
	
  <!ELEMENT gb_videoPage (id, binary*)>
  
  <!ELEMENT gb_audioPage (id, binary*)>
  
  <!ELEMENT gb_locationPage (id, gb_location)>
    <!ELEMENT gb_location (longitutde, latitude)>
      <!ELEMENT longitude (#PCDATA)>
      <!ELEMENT latitude (#PCDATA)>

```

Please commment so I can correct any mistakes.