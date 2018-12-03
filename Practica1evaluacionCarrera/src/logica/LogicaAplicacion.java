
package logica;

import java.io.File;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import modelo.Carrera;
import modelo.Corredor;
import modelo.Excepciones;
import modelo.Participante;
import modelo.Utils;

public class LogicaAplicacion implements Serializable
{
  private static LogicaAplicacion INSTANCE = cargarDatos();
    private transient Timer timer;
    private int minutosGuardado;
    private List<Corredor> listaCorredores;
    private List<Carrera> listaCarreras;
    private GestionArchivos gestionArchivos;

    private LogicaAplicacion() {
        this.gestionArchivos = new GestionArchivos();
        this.listaCorredores = new ArrayList<>();
        this.listaCarreras = new ArrayList<>();
        this.minutosGuardado = 10;
        this.guardarAutomaticamente();
        //this.gestionArchivos = GestionArchivos.getInsance();
    }

    public static LogicaAplicacion getInstance() {
        return INSTANCE;
    }

    public int getMinutosGuardado() {
        return minutosGuardado;
    }

    public void setMinutosGuardado(int minutosGuardado) {
        this.minutosGuardado = minutosGuardado;
        this.guardarAutomaticamente();
    }

    // METODOS  CORREDORES
    public Corredor getCorredor(String dni) throws ParseException {
        Corredor r = new Corredor(dni, "", "", "", Utils.sdf.parse("00/00/00"));
        return listaCorredores.get(listaCorredores.indexOf(r));
    }

    public boolean addCorredor(Corredor ccorredor) {
        return listaCorredores.add(ccorredor);
    }

    public boolean removeCorredor(Corredor corredor) throws Excepciones.CorredorRegistradoCarreras {
        // Corredor r = new Corredor(dni, "", "", "", Utils.sdf.parse("00/00/00"));
        for (Carrera carrera : listaCarreras) {
            if (carrera.getParticipantes().contains(corredor)) {
                throw new Excepciones.CorredorRegistradoCarreras("EL corredor "
                        + " no se puede elimiar, esta inscrito en alguna carrera");
            }
        }
//        Predicate<Corredor> corredorPredicate = c -> c.getDni().equals(dni);
//        return listaCorredores.removeIf(corredorPredicate);
        return listaCorredores.remove(corredor);
    }

    public boolean modCorredor(Corredor corredor) {
        listaCorredores.indexOf(corredor);
        listaCorredores.set(listaCorredores.indexOf(corredor), corredor);
        return false;
    }

    public List<Corredor> getListaCorredores() {
        return this.listaCorredores;
    }

    // METODOS  CARRERAS
    public boolean addCorredorToCarrera(Corredor corredor, Carrera carrera) throws Excepciones.NoSeAdmitenMasParticipantes, Excepciones.CorredorYaInscrito {
        int nunDorsal = carrera.getParticipantes().size() + 1;
        Participante participante = new Participante(corredor, nunDorsal);

        if (carrera.getMaxParticipante() <= carrera.getParticipantes().size()) {
            throw new Excepciones.NoSeAdmitenMasParticipantes("No se admiten mas participanres en la carrera");
        }

        if (carrera.getParticipantes().contains(participante)) {
            throw new Excepciones.CorredorYaInscrito("El corredor ya esta inscrito");
        }

        carrera.getParticipantes().add(participante);
        return true;
    }

    public boolean removePartipanteCarrera(Participante participante, Carrera carrera) {
        return carrera.getParticipantes().remove(participante);
    }

    public List<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    // METODOS APLICACION
    public static LogicaAplicacion cargarDatos() {
        LogicaAplicacion logicaAplicacion = null;

        if (!new File("gestion_corredores.dat").exists()) {
            return new LogicaAplicacion();
        }
        return GestionArchivos.cargarInstancia();

    }

    public void guardarDatos() {
        GestionArchivos.guardarInstancia(this);
    }

    private void guardarAutomaticamente() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                guardarDatos();
            }
        }, 0, minutosGuardado * 60 * 1000);

    }    
}
