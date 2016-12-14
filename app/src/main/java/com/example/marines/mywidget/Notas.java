package com.example.marines.mywidget;

import java.util.ArrayList;

/**
 * Created by Marines on 13/09/2016.
 */
public class Notas {
    public String nota;
    public boolean realizado;

    public Notas(){
        nota="";
        realizado=false;

    }

    public Notas(String nota, boolean realizado){
        this.nota=nota;
        this.realizado=realizado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }


    //Metodo para obtener las notas
    public  ArrayList<Notas> notas(){
        Notas notas;
        //Inicializamos el arrayList
        ArrayList<Notas> lista = new ArrayList<Notas>();
        //Metodo para agregar las imagenes
        String[] arrayNotas= new String[]{"Asistir al taller de mi primer Widget", "Aprender Android","Bienvenidos"};

        //Metodo para agregar si esta marcado o no
        boolean [] arrayTitulos=new boolean[]{false, true,false};

        try {
            //Recorremos los arreglos para agregarlos al objeto nota
            for (int i = 0; i <arrayNotas.length; i++) {
                //Obtenemos la notas y  el titulo
                String nota = arrayNotas[i];
                boolean titulos = arrayTitulos[i];

                //agregamos ambos al objeto notas
                notas = new Notas(nota, titulos);
                //Agregamos nota a nuestra lista
                lista.add(notas);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        //Retornamos la lista
        return lista;
    }


}
