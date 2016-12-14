package com.example.marines.mywidget;


import android.app.Activity;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNotas extends ArrayAdapter<Notas>{


	Activity context;
	ArrayList<Notas> listaNotas;

	// Le pasamos al constructor el contecto y la lista de Documentoss
   public AdaptadorNotas(Activity context, ArrayList<Notas> listaNotas) {
		
		super(context, R.layout.adaptador_notas, listaNotas);
		this.context = context;
		this.listaNotas = listaNotas;
	}
	
	public View getView(final int position, View view, ViewGroup parent) {
		// Rescatamos cada item del vista_listview y lo inflamos con nuestro layout
		view = context.getLayoutInflater().inflate(R.layout.adaptador_notas, null);
		
		final Notas c = listaNotas.get(position);
		// Definimos los elementos que tiene nuestro layout

		TextView nota = (TextView) view.findViewById(R.id.textAdapter);
		if(c.getRealizado()){
			nota.setPaintFlags(nota.getPaintFlags() |   Paint.STRIKE_THRU_TEXT_FLAG);
		}
		nota.setText(c.getNota());
		return view;
	}
	
	
	

}
