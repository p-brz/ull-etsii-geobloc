package com.geobloc.handlers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.geobloc.form.FormClass;
import com.geobloc.shared.Utilities;


/**
 * Form handler
 *  
 * @author Jorge Carballo (jelcaf@gmail.com)
 *
 */
public class FormHandler {
	
	private FormClass defForm;
	/** Llevar� el numero de "campo" por el que va en el formulario */
	private int index;
	
	private LinearLayout view;
	
	public FormHandler (FormClass form) {
		defForm = form;
		index = 0;
	}
	
	public int getNextData () {
		index++;
		return index;
	}
	
	public int getIndex () {
		return index;
	}
	
	public int getNumPages () {
		return defForm.getNumPages();
	}

	public String getNameForm () {
		return defForm.getNameForm();
	}
	
	public void setDescription (String desc) {
		defForm.setDescription(desc);
	}
	
	public String getDescription () {
		return defForm.getDescription();
	}
	
	/** M�todo que devolver� un layout de una p�gina del formulario */
	public LinearLayout getLayout(Context context, int page) {
		
		view = new LinearLayout(context);
		
		if (defForm == null)
			return null;
		
		if (page < defForm.getNumPages()) {
			view = defForm.getPage(page).getLayoutPage(context);
		}

		return view;
		//return (ViewGroup)view;
	}

}